package net.saitamaking.minecraftprogressrevamp.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.saitamaking.minecraftprogressrevamp.block.entity.CampfireWithCrucibleEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.CobblestoneAnvilEntity;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Map;

public class CobblestoneAnvilBlock extends BaseEntityBlock {

    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);
    public static final MapCodec<CobblestoneAnvilBlock> CODEC = simpleCodec(CobblestoneAnvilBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("block.minecraftprogressrevamp.cobblestone_anvil");

    public MapCodec<? extends CobblestoneAnvilBlock> codec() {
        return CODEC;
    }

    public static final DirectionProperty FACING;

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        VoxelShape north = Shapes.or(
                Block.box(1, 0, 2, 14, 2, 14),
                Block.box(2, 2, 4, 13, 4, 12),
                Block.box(4, 2, 6, 11, 10, 10),
                Block.box(3, 9, 5, 12, 10, 11),
                Block.box(0, 12, 3, 14, 16, 13),
                Block.box(14, 13, 3, 16, 16, 13),
                Block.box(2, 10, 4, 13, 12, 12)
        );
        SHAPES.put(Direction.NORTH, north);
        SHAPES.put(Direction.EAST,  rotateY(north, 1));
        SHAPES.put(Direction.SOUTH, rotateY(north, 2));
        SHAPES.put(Direction.WEST,  rotateY(north, 3));
    }

    private static VoxelShape rotateY(VoxelShape shape, int times) {
        VoxelShape[] buffer = { shape, Shapes.empty() };
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) ->
                    buffer[1] = Shapes.or(buffer[1],
                            Shapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }
        return buffer[0];
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(HorizontalDirectionalBlock.FACING));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    protected BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    public CobblestoneAnvilBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        //drop items inside
        if (state.getBlock() != newState.getBlock()){
            if(level.getBlockEntity(pos) instanceof CobblestoneAnvilEntity cobblestoneAnvilEntity){
                cobblestoneAnvilEntity.dropContents();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hit) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer
                && level.getBlockEntity(pos) instanceof CobblestoneAnvilEntity be) {
            serverPlayer.openMenu(be, pos);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {

        return new CobblestoneAnvilEntity(blockPos, blockState);
    }
}