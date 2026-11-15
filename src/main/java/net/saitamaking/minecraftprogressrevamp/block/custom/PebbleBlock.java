package net.saitamaking.minecraftprogressrevamp.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.util.TriState;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PebbleBlock extends Block {
    public static final MapCodec<PebbleBlock> CODEC = simpleCodec(PebbleBlock::new);
    public static final DirectionProperty FACING;
    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    public MapCodec<PebbleBlock> codec() {
        return CODEC;
    }

    public PebbleBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        VoxelShape north = Shapes.or(
                Block.box(5, 0, 5, 10, 1, 10),
                Block.box(6, 1, 6, 10, 2, 9),
                Block.box(8, 1, 9, 10, 2, 10),
                Block.box(10, 0, 5, 11, 1, 11),
                Block.box(7, 0, 10, 10, 1, 11)
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

    protected boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    protected BlockState updateShape(BlockState p_304418_, Direction p_304475_, BlockState p_304669_, LevelAccessor p_304637_, BlockPos p_304633_, BlockPos p_304603_) {
        return p_304475_ == Direction.DOWN && !this.canSurvive(p_304418_, p_304637_, p_304633_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_304418_, p_304475_, p_304669_, p_304637_, p_304633_, p_304603_);
    }

    protected boolean canSurvive(BlockState p_304413_, LevelReader p_304885_, BlockPos p_304808_) {
        return canSupportCenter(p_304885_, p_304808_.below(), Direction.UP);
    }

    protected BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}