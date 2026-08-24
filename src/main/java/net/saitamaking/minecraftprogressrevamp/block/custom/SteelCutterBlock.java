package net.saitamaking.minecraftprogressrevamp.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

public class SteelCutterBlock extends Block {
    public static final MapCodec<SteelCutterBlock> CODEC = simpleCodec(SteelCutterBlock::new);
    public static final DirectionProperty FACING;
    protected static final VoxelShape SHAPE;

    public MapCodec<SteelCutterBlock> codec() {
        return CODEC;
    }

    public SteelCutterBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
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

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        SHAPE = Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)9.0F, (double)16.0F);
    }
    
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().generic(), 2.0F);
        }

        if(entity instanceof ItemEntity itemEntity){
            if(itemEntity.getItem().getItem() == ModItems.LOOSEPEBBLE.get()){
                itemEntity.setItem(new ItemStack(ModItems.SHARPPEBBLE.get(), itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.OAK_LOG){
                itemEntity.setItem(new ItemStack(Items.OAK_PLANKS, itemEntity.getItem().getCount()*6));
            }
            if(itemEntity.getItem().getItem() == Items.SPRUCE_LOG){
                itemEntity.setItem(new ItemStack(Items.SPRUCE_PLANKS, itemEntity.getItem().getCount()*6));
            }
            if(itemEntity.getItem().getItem() == Items.BIRCH_LOG){
                itemEntity.setItem(new ItemStack(Items.BIRCH_PLANKS, itemEntity.getItem().getCount()*6));
            }
            if(itemEntity.getItem().getItem() == Items.JUNGLE_LOG){
                itemEntity.setItem(new ItemStack(Items.JUNGLE_PLANKS, itemEntity.getItem().getCount()*6));
            }
            if(itemEntity.getItem().getItem() == Items.ACACIA_LOG){
                itemEntity.setItem(new ItemStack(Items.ACACIA_PLANKS, itemEntity.getItem().getCount()*6));
            }
            if(itemEntity.getItem().getItem() == Items.DARK_OAK_LOG){
                itemEntity.setItem(new ItemStack(Items.DARK_OAK_PLANKS, itemEntity.getItem().getCount()*6));
            }
            if(itemEntity.getItem().getItem() == Items.MANGROVE_LOG){
                itemEntity.setItem(new ItemStack(Items.MANGROVE_PLANKS, itemEntity.getItem().getCount()*6));
            }
            if(itemEntity.getItem().getItem() == Items.CHERRY_LOG){
                itemEntity.setItem(new ItemStack(Items.CHERRY_PLANKS, itemEntity.getItem().getCount()*6));
            }
            if(itemEntity.getItem().getItem() == Items.CRIMSON_STEM){
                itemEntity.setItem(new ItemStack(Items.CRIMSON_PLANKS, itemEntity.getItem().getCount()*6));
            }
            if(itemEntity.getItem().getItem() == Items.WARPED_STEM){
                itemEntity.setItem(new ItemStack(Items.WARPED_PLANKS, itemEntity.getItem().getCount()*6));
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}
