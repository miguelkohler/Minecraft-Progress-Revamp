package net.saitamaking.minecraftprogressrevamp.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.saitamaking.minecraftprogressrevamp.block.entity.CampfireWithCrucibleEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.CobblestoneAnvilEntity;
import org.jetbrains.annotations.Nullable;

public class CobblestoneAnvilBlock extends BaseEntityBlock {

    public static final MapCodec<CobblestoneAnvilBlock> CODEC = simpleCodec(CobblestoneAnvilBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("block.minecraftprogressrevamp.cobblestone_anvil");

    public MapCodec<? extends CobblestoneAnvilBlock> codec() {
        return CODEC;
    }

    public static final DirectionProperty FACING;

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
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