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
import net.saitamaking.minecraftprogressrevamp.block.entity.PrimitiveCraftingTableEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.RudimentaryCraftingTableEntity;
import org.jetbrains.annotations.Nullable;

public class RudimentaryCraftingTableBlock extends BaseEntityBlock {

    public static final MapCodec<RudimentaryCraftingTableBlock> CODEC = simpleCodec(RudimentaryCraftingTableBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("block.minecraftprogressrevamp.rudimentary_crafting_table");

    public MapCodec<? extends RudimentaryCraftingTableBlock> codec() {
        return CODEC;
    }

    public RudimentaryCraftingTableBlock(Properties properties) {
        super(properties);
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

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hit) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer
                && level.getBlockEntity(pos) instanceof RudimentaryCraftingTableEntity be) {
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

        return new RudimentaryCraftingTableEntity(blockPos, blockState);
    }
}