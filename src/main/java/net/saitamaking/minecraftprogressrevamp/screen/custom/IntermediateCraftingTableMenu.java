package net.saitamaking.minecraftprogressrevamp.screen.custom;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.block.entity.IntermediateCraftingTableEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.RudimentaryCraftingTableEntity;
import net.saitamaking.minecraftprogressrevamp.recipe.ModRecipeSerializers;
import net.saitamaking.minecraftprogressrevamp.recipe.TierOneCraftingTableInput;
import net.saitamaking.minecraftprogressrevamp.recipe.TierOneCraftingTableRecipe;
import net.saitamaking.minecraftprogressrevamp.screen.ModMenuTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class IntermediateCraftingTableMenu extends AbstractContainerMenu {
    private static final int VANILLA_SLOT_COUNT = 36;
    private static final int RESULT_SLOT_INDEX = 36;
    private static final int INPUT_FIRST_SLOT_INDEX = 37;
    private static final int INPUT_SLOT_COUNT = 13;
    private static final int INPUT_END_INDEX = INPUT_FIRST_SLOT_INDEX + INPUT_SLOT_COUNT;

    // onde cada slot do cai na grade 3x3:
    private static final int[] CORE_SLOTS  = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static final int[] EXTRA_SLOTS = {9, 10, 11, 12};

    private final ContainerLevelAccess access;
    private final Player player;
    private final Level level;
    private final ResultContainer resultSlots = new ResultContainer();
    public final IntermediateCraftingTableEntity blockEntity;
    private int lastChangeCount = -1;

    public IntermediateCraftingTableMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), ContainerLevelAccess.NULL);
    }

    public IntermediateCraftingTableMenu(int id, Inventory inv, BlockEntity entity, ContainerLevelAccess access) {
        super(ModMenuTypes.INTERMEDIATE_CRAFTING_TABLE_MENU.get(), id);
        this.access = access;
        this.player = inv.player;
        this.level = inv.player.level();
        this.blockEntity = (IntermediateCraftingTableEntity) entity;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        ItemStackHandler handler = blockEntity.getInventory();
        addSlot(new IntermediateResultSlot(resultSlots, 0, 142, 53));
        addSlot(new SlotItemHandler(handler, 0, 30, 35));
        addSlot(new SlotItemHandler(handler, 1, 48, 35));
        addSlot(new SlotItemHandler(handler, 2, 66, 35));
        addSlot(new SlotItemHandler(handler, 3, 30, 53));
        addSlot(new SlotItemHandler(handler, 4, 48, 53));
        addSlot(new SlotItemHandler(handler, 5, 66, 53));
        addSlot(new SlotItemHandler(handler, 6, 30, 71));
        addSlot(new SlotItemHandler(handler, 7, 48, 71));
        addSlot(new SlotItemHandler(handler, 8, 66, 71));
        addSlot(new SlotItemHandler(handler, 9, 48, 17));
        addSlot(new SlotItemHandler(handler, 10, 12, 53));
        addSlot(new SlotItemHandler(handler, 11, 84, 53));
        addSlot(new SlotItemHandler(handler, 12, 48, 89));
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 120 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 178));
        }
    }

    private boolean hasExtras() {
        for (int s : EXTRA_SLOTS) if (!blockEntity.getInventory().getStackInSlot(s).isEmpty()) return true;
        return false;
    }

    private CraftingInput.Positioned corePositioned() {
        List<ItemStack> grid = new ArrayList<>(9);
        for (int s : CORE_SLOTS) grid.add(blockEntity.getInventory().getStackInSlot(s));
        return CraftingInput.ofPositioned(3, 3, grid);
    }

    private TierOneCraftingTableInput extendedInput() {
        List<ItemStack> items = new ArrayList<>(13);
        for (int i = 0; i < 13; i++) items.add(blockEntity.getInventory().getStackInSlot(i));
        return new TierOneCraftingTableInput(items);
    }

    private static final org.slf4j.Logger LOGGER = com.mojang.logging.LogUtils.getLogger();

    private void refreshResult() {
        if (level.isClientSide) return;
        lastChangeCount = blockEntity.getChangeCount();
        ItemStack result = ItemStack.EMPTY;

        if (hasExtras()) {
            TierOneCraftingTableInput in = extendedInput();
            Optional<RecipeHolder<TierOneCraftingTableRecipe>> r =
                    level.getRecipeManager().getRecipeFor(ModRecipeSerializers.TIER_ONE_CRAFTING_TABLE_TYPE.get(), in, level);
            if (r.isPresent()) result = r.get().value().assemble(in, level.registryAccess());
        } else {
            CraftingInput input = corePositioned().input();
            if (!input.isEmpty()) {
                Optional<RecipeHolder<CraftingRecipe>> r =
                        level.getRecipeManager().getRecipeFor(RecipeType.CRAFTING, input, level);
                if (r.isPresent()) {
                    ItemStack assembled = r.get().value().assemble(input, level.registryAccess());
                    if (assembled.isItemEnabled(level.enabledFeatures())) result = assembled;
                }
            }
        }
        resultSlots.setItem(0, result);
    }

    @Override
    public void broadcastChanges() {
        if (!level.isClientSide && lastChangeCount != blockEntity.getChangeCount()) {
            refreshResult();
        }
        super.broadcastChanges();
    }

    private void consumeIngredients(Player p) {
        ItemStackHandler inv = blockEntity.getInventory();

        if (hasExtras()) {
            TierOneCraftingTableInput in = extendedInput();
            NonNullList<ItemStack> remaining = p.level().getRecipeManager()
                    .getRemainingItemsFor(ModRecipeSerializers.TIER_ONE_CRAFTING_TABLE_TYPE.get(), in, p.level());
            for (int slot = 0; slot < 13; slot++) consumeSlot(inv, slot, remaining.get(slot), p);
            return;
        }

        CraftingInput.Positioned positioned = corePositioned();
        CraftingInput input = positioned.input();
        CommonHooks.setCraftingPlayer(p);
        NonNullList<ItemStack> remaining =
                p.level().getRecipeManager().getRemainingItemsFor(RecipeType.CRAFTING, input, p.level());
        CommonHooks.setCraftingPlayer(null);

        for (int y = 0; y < input.height(); y++) {
            for (int x = 0; x < input.width(); x++) {
                int gridIndex = (y + positioned.top()) * 3 + (x + positioned.left());
                consumeSlot(inv, CORE_SLOTS[gridIndex], remaining.get(x + y * input.width()), p);
            }
        }
    }

    private void consumeSlot(ItemStackHandler inv, int slot, ItemStack rem, Player p) {
        ItemStack in = inv.getStackInSlot(slot);
        if (!in.isEmpty()) {
            inv.extractItem(slot, 1, false);
            in = inv.getStackInSlot(slot);
        }
        if (!rem.isEmpty()) {
            if (in.isEmpty()) inv.setStackInSlot(slot, rem);
            else if (ItemStack.isSameItemSameComponents(in, rem)) { rem.grow(in.getCount()); inv.setStackInSlot(slot, rem); }
            else if (!p.getInventory().add(rem)) p.drop(rem, false);
        }
    }

    private class IntermediateResultSlot extends Slot {
        private int removeCount;

        IntermediateResultSlot(Container container, int index, int x, int y) {
            super(container, index, x, y);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return false;
        }

        @Override
        public ItemStack remove(int amount) {
            if (hasItem()) removeCount += Math.min(amount, getItem().getCount());
            return super.remove(amount);
        }

        @Override
        protected void onQuickCraft(ItemStack stack, int amount) {
            removeCount += amount;
            checkTakeAchievements(stack);
        }

        @Override
        protected void checkTakeAchievements(ItemStack stack) {
            if (removeCount > 0) stack.onCraftedBy(player.level(), player, removeCount);
            removeCount = 0;
        }

        @Override
        public void onTake(Player p, ItemStack stack) {
            checkTakeAchievements(stack);
            consumeIngredients(p);
            refreshResult();
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.INTERMEDIATECRAFTINGTABLE.get());
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot slot = slots.get(index);
        if (slot == null || !slot.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = slot.getItem();
        ItemStack copy = stack.copy();

        if (index == RESULT_SLOT_INDEX) {
            stack.getItem().onCraftedBy(stack, level, playerIn);
            if (!moveItemStackTo(stack, 0, VANILLA_SLOT_COUNT, true)) return ItemStack.EMPTY;
            slot.onQuickCraft(stack, copy);
        } else if (index < VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(stack, INPUT_FIRST_SLOT_INDEX, INPUT_END_INDEX, false)) {
                if (index < 27) {
                    if (!moveItemStackTo(stack, 27, VANILLA_SLOT_COUNT, false)) return ItemStack.EMPTY;
                } else if (!moveItemStackTo(stack, 0, 27, false)) {
                    return ItemStack.EMPTY;
                }
            }
        } else if (index < INPUT_END_INDEX) {
            if (!moveItemStackTo(stack, 0, VANILLA_SLOT_COUNT, false)) return ItemStack.EMPTY;
        } else {
            return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) slot.setByPlayer(ItemStack.EMPTY);
        else slot.setChanged();

        if (stack.getCount() == copy.getCount()) return ItemStack.EMPTY;

        slot.onTake(playerIn, stack);
        if (index == RESULT_SLOT_INDEX) playerIn.drop(stack, false);
        return copy;
    }


}