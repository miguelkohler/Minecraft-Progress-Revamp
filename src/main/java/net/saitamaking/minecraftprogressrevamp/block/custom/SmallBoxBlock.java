package net.saitamaking.minecraftprogressrevamp.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.saitamaking.minecraftprogressrevamp.block.entity.ModBlockEntities;
import net.saitamaking.minecraftprogressrevamp.block.entity.SmallBoxEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.WoodenCrateEntity;
import org.jetbrains.annotations.Nullable;

public class SmallBoxBlock extends BaseEntityBlock implements SimpleWaterloggedBlock{
    public static final IntegerProperty ROTATION;
    public static final BooleanProperty WATERLOGGED;
    public static final MapCodec<SmallBoxBlock> CODEC = simpleCodec(SmallBoxBlock::new);

    public SmallBoxBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(ROTATION, 0)).setValue(WATERLOGGED, false));
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        ROTATION = BlockStateProperties.ROTATION_16;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{ROTATION, WATERLOGGED});
    }

    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return (BlockState)((BlockState)this.defaultBlockState().setValue(ROTATION, RotationSegment.convertToSegment(context.getRotation() + 180.0F))).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    public float getYRotationDegrees(BlockState state) {
        return RotationSegment.convertToDegrees((Integer)state.getValue(ROTATION));
    }

    protected BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue(ROTATION, rot.rotate((Integer)state.getValue(ROTATION), 16));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        return (BlockState)state.setValue(ROTATION, mirror.mirror((Integer)state.getValue(ROTATION), 16));
    }

    private static final VoxelShape[] SHAPES = new VoxelShape[16];

    static {
        for (int i = 0; i < 16; i++) {
            SHAPES[i] = makeShape(RotationSegment.convertToDegrees(i));
        }
    }

    private static VoxelShape makeShape(float yRotDeg) {
        double rad = Math.toRadians(yRotDeg);
        double c = Math.cos(rad), s = Math.sin(rad);
        final int n = 32; //makes resolution half a pixel
        final double cell = 16.0 / n;
        VoxelShape shape = Shapes.empty();

        for (int row = 0; row < n; row++) { //z
            int runStart = -1;
            for (int col = 0; col <= n; col++) { //x
                boolean inside = false;
                if (col < n) {
                    double x = (col + 0.5) * cell - 8;//gets the cell center relative to block center
                    double z = (row + 0.5) * cell - 8;
                    double lx = x * c + z * s;
                    double lz = -x * s + z * c;
                    inside = Math.abs(lx) <= 5 && Math.abs(lz) <= 4;// half-size of x and z
                }
                if (inside && runStart < 0) {
                    runStart = col;
                } else if (!inside && runStart >= 0) {
                    shape = Shapes.or(shape, Block.box(runStart * cell, 0, row * cell, col * cell, 8, (row + 1) * cell));
                    runStart = -1;
                }
            }
        }
        return shape.optimize();
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(ROTATION)];
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    //Block entity stuff
    @Override
    protected RenderShape getRenderShape(BlockState state) { return RenderShape.ENTITYBLOCK_ANIMATED; }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide
                ? createTickerHelper(type, ModBlockEntities.SMALLBOX_BE.get(), SmallBoxEntity::lidAnimateTick)
                : null;
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getBlockEntity(pos) instanceof SmallBoxEntity crate) crate.recheckOpen();
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SmallBoxEntity(blockPos, blockState);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        //drop items inside
        if (state.getBlock() != newState.getBlock()){
            if(level.getBlockEntity(pos) instanceof SmallBoxEntity smallBoxEntity){
                smallBoxEntity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {

        if(level.getBlockEntity(pos) instanceof SmallBoxEntity smallBoxEntity){
            if(!level.isClientSide()) {
                ((ServerPlayer) player).openMenu(new SimpleMenuProvider(smallBoxEntity, Component.literal("Small Box")), pos);
                return ItemInteractionResult.SUCCESS;
            }
        }

        return ItemInteractionResult.SUCCESS;
    }
}
