package net.saitamaking.minecraftprogressrevamp.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MeltedMetalBlock extends FallingBlock {
    public static final MapCodec<MeltedMetalBlock> CODEC = RecordCodecBuilder.mapCodec(
            metal1 -> metal1.group(BuiltInRegistries.BLOCK.byNameCodec().fieldOf("melted").forGetter(metal2 -> metal2.metalBlock), propertiesCodec())
                    .apply(metal1, MeltedMetalBlock::new)
    );

    public MeltedMetalBlock(Block metalBlock, BlockBehaviour.Properties properties) {
        super(properties);
        this.metalBlock = metalBlock;
    }
    public MapCodec<MeltedMetalBlock> codec() {
        return CODEC;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().hotFloor(), 1.5F);
        }

        super.stepOn(level, pos, state, entity);
    }

    private final Block metalBlock;

    @Override
    public void onLand(Level level, BlockPos pos, BlockState state, BlockState replaceableState, FallingBlockEntity fallingBlock) {
        if (shouldSolidify(level, pos, state, replaceableState.getFluidState())) {
            level.setBlock(pos, this.metalBlock.defaultBlockState(), 3);

            level.playSound(
                    null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F,
                    2.6F + (level.getRandom().nextFloat() - level.getRandom().nextFloat()) * 0.8F
            );
            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.LARGE_SMOKE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 8, 0.3, 0.3, 0.3, 0.0);
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if (shouldSolidify(level, pos, state)) {
            level.playSound(
                    context.getPlayer(), pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F,
                    2.6F + (level.getRandom().nextFloat() - level.getRandom().nextFloat()) * 0.8F
            );
            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.LARGE_SMOKE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 8, 0.3, 0.3, 0.3, 0.0);
            }
            return this.metalBlock.defaultBlockState();
        }

        return super.getStateForPlacement(context);
    }

    private static boolean shouldSolidify(BlockGetter level, BlockPos pos, BlockState state, net.minecraft.world.level.material.FluidState fluidState) {
        return state.canBeHydrated(level, pos, fluidState, pos) || touchesLiquid(level, pos, state);
    }

    private static boolean shouldSolidify(BlockGetter level, BlockPos pos, BlockState state) {
        return shouldSolidify(level, pos, state, level.getFluidState(pos));
    }

    private static boolean touchesLiquid(BlockGetter level, BlockPos pos, BlockState state) {
        boolean flag = false;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for (Direction direction : Direction.values()) {
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (direction != Direction.DOWN || state.canBeHydrated(level, pos, blockstate.getFluidState(), blockpos$mutableblockpos)) {
                blockpos$mutableblockpos.setWithOffset(pos, direction);
                blockstate = level.getBlockState(blockpos$mutableblockpos);
                if (state.canBeHydrated(level, pos, blockstate.getFluidState(), blockpos$mutableblockpos) && !blockstate.isFaceSturdy(level, pos, direction.getOpposite())) {
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }

    private static boolean canSolidify(BlockState state) {
        return state.getFluidState().is(FluidTags.WATER);
    }

    protected BlockState updateShape(Player player, BlockPos pos, BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (touchesLiquid(level, currentPos, state)) {
            if (level instanceof Level realLevel) {
                realLevel.playSound(
                        player, currentPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F,
                        2.6F + (realLevel.getRandom().nextFloat() - realLevel.getRandom().nextFloat()) * 0.8F
                );
                if (realLevel instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.LARGE_SMOKE, currentPos.getX() + 0.5, currentPos.getY() + 0.5, currentPos.getZ() + 0.5, 8, 0.3, 0.3, 0.3, 0.0);
                }
            }
            return this.metalBlock.defaultBlockState();
        }

        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
}
