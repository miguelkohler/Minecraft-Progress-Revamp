package net.saitamaking.minecraftprogressrevamp.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.neoforged.neoforge.items.ItemStackHandler;
import net.saitamaking.minecraftprogressrevamp.screen.custom.SmallBoxMenu;
import net.saitamaking.minecraftprogressrevamp.screen.custom.WoodenCrateMenu;
import org.jetbrains.annotations.Nullable;

public class SmallBoxEntity extends BlockEntity implements MenuProvider, LidBlockEntity {
    private final ChestLidController lidController = new ChestLidController();

    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(Level level, BlockPos pos, BlockState state) {
            level.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    SoundEvents.CHEST_OPEN, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 1.6F);
        }

        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state) {
            level.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    SoundEvents.CHEST_CLOSE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 1.6F);
        }

        @Override
        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int oldCount, int newCount) {
            level.blockEvent(pos, state.getBlock(), 1, newCount);
        }

        @Override
        protected boolean isOwnContainer(Player player) {
            return player.containerMenu instanceof SmallBoxMenu menu && menu.blockEntity == SmallBoxEntity.this;
        }
    };

    public void startOpen(Player player) {
        if (level != null && !level.isClientSide && !remove && !player.isSpectator())
            openersCounter.incrementOpeners(player, level, getBlockPos(), getBlockState());
    }

    public void stopOpen(Player player) {
        if (level != null && !level.isClientSide && !remove && !player.isSpectator())
            openersCounter.decrementOpeners(player, level, getBlockPos(), getBlockState());
    }

    public void recheckOpen() {
        if (level != null && !remove)
            openersCounter.recheckOpeners(level, getBlockPos(), getBlockState());
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            lidController.shouldBeOpen(type > 0);
            return true;
        }
        return super.triggerEvent(id, type);
    }

    public static void lidAnimateTick(Level level, BlockPos pos, BlockState state, SmallBoxEntity be) {
        be.lidController.tickLid();
    }

    @Override
    public float getOpenNess(float partialTicks) {
        return lidController.getOpenness(partialTicks);
    }
    private float rotation;
    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }


    public final ItemStackHandler inventory = new ItemStackHandler(9) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 64;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public SmallBoxEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.SMALLBOX_BE.get(), pos, blockState);
    }

    public void clearContents(){
        inventory.setStackInSlot(0, ItemStack.EMPTY);
    }

    public void drops(){
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for(int i = 0; i < inventory.getSlots(); i++) {
            inv.setItem(i, inventory.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.minecraftprogressrevamp.small_oak_box");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SmallBoxMenu(i, inventory, this);
    }

    @Override
    @Nullable
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }
}
