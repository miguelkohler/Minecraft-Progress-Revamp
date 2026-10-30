package net.saitamaking.minecraftprogressrevamp.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.saitamaking.minecraftprogressrevamp.block.custom.BellowBlock;
import net.saitamaking.minecraftprogressrevamp.screen.custom.WoodenCrateMenu;
import org.jetbrains.annotations.Nullable;

public class BellowEntity extends BlockEntity {
    private static final int ANIM_TICKS = 30; //controla a velocidade em ticks
    private long animStart = -1000; // client-side
    private long animEndTick = -1;

    public BellowEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.BELLOW_BE.get(), pos, blockState);
    }

    // chama no server e faz todos os clientes darem play na animação
    public void pump() {
        if (level == null || level.isClientSide) return;
        if (level.getGameTime() < animEndTick) return; //ignora o click se ainda ta animando

        animEndTick = level.getGameTime() + ANIM_TICKS;
        level.blockEvent(getBlockPos(), getBlockState().getBlock(), 1, 0);

        level.playSound(null, getBlockPos(), SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS,
                0.4f, 1.2f + level.random.nextFloat() * 0.2f);

        if (level instanceof ServerLevel serverLevel) {
            Direction front = getBlockState().getValue(BellowBlock.FACING);
            Vec3 origin = getBlockPos().getCenter().relative(front, 0.55);

            for (int i = 0; i < 10; i++) {
                double randx = (level.random.nextDouble() - 0.5) * 0.3;
                double randz = (level.random.nextDouble() - 0.5) * 0.3;

                serverLevel.sendParticles(ParticleTypes.CLOUD,
                        origin.x + randx, origin.y, origin.z + randz,
                        0,  //count 0 é pq os 3 outros valores são a direção
                        front.getStepX(), front.getStepY(), front.getStepZ(),
                        0.1);
            }
        }
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            if (level != null && level.isClientSide) {
                if (level.getGameTime() - animStart >= ANIM_TICKS) {
                    animStart = level.getGameTime();
                }
            }
            return true;
        }
        return super.triggerEvent(id, type);
    }

    //0 = extendido, 1 = comprimido.
    public float getCompression(float partialTick) {
        if (level == null) return 0;
        float t = (level.getGameTime() + partialTick - animStart) / ANIM_TICKS;
        if (t < 0 || t > 1) return 0;
        return Mth.sin(t * Mth.PI);
    }
}