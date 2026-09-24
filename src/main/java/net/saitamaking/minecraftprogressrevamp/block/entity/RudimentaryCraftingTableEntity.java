package net.saitamaking.minecraftprogressrevamp.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.saitamaking.minecraftprogressrevamp.screen.custom.PrimitiveCraftingTableMenu;
import net.saitamaking.minecraftprogressrevamp.screen.custom.RudimentaryCraftingTableMenu;

public class RudimentaryCraftingTableEntity extends BlockEntity implements MenuProvider {
    public static final int SLOTS = 7;
    private int changeCount = 0;

    private final ItemStackHandler inventory = new ItemStackHandler(SLOTS) {
        @Override
        protected void onContentsChanged(int slot) {
            changeCount++;
            setChanged();
        }

        @Override
        public void setSize(int size) {
            super.setSize(SLOTS);
        }
    };

    public RudimentaryCraftingTableEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RUDIMENTARYCRAFTINGTABLE_BE.get(), pos, state);
    }

    public ItemStackHandler getInventory() { return inventory; }
    public int getChangeCount() { return changeCount; }

    public void dropContents() {
        if (level == null) return;
        for (int i = 0; i < inventory.getSlots(); i++) {
            Containers.dropItemStack(level, worldPosition.getX(), worldPosition.getY(),
                    worldPosition.getZ(), inventory.getStackInSlot(i));
        }
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
        return Component.translatable("block.minecraftprogressrevamp.rudimentary_crafting_table");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new RudimentaryCraftingTableMenu(id, inv, this, ContainerLevelAccess.create(level, worldPosition));
    }
}
