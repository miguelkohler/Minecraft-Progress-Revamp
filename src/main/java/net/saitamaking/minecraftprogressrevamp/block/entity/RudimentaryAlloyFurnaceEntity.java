package net.saitamaking.minecraftprogressrevamp.block.entity;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Either;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.block.custom.RudimentaryAlloySmelterBlock;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;
import net.saitamaking.minecraftprogressrevamp.recipe.*;
import net.saitamaking.minecraftprogressrevamp.screen.custom.CampfireWithCrucibleMenu;
import net.saitamaking.minecraftprogressrevamp.screen.custom.RudimentaryAlloyFurnaceMenu;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.function.ObjIntConsumer;

public class RudimentaryAlloyFurnaceEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(4) {
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

    private static final int INPUT_SLOT1 = 0;
    private static final int INPUT_SLOT2 = 1;
    private static final int FUEL_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;
    public static final int DATA_LIT_TIME = 0;
    public static final int DATA_LIT_DURATION = 1;
    public static final int BURN_COOL_SPEED = 2;

    @Nullable
    private static volatile Map<Item, Integer> fuelCache;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 1200;
    int litTime;
    int litDuration;

    public RudimentaryAlloyFurnaceEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.RUDIMENTARYALLOYFURNACE_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> {
                        if (RudimentaryAlloyFurnaceEntity.this.litDuration > 32767) {
                            yield Mth.floor((double) RudimentaryAlloyFurnaceEntity.this.litTime / (double) RudimentaryAlloyFurnaceEntity.this.litDuration * (double) 32767.0F);
                        }

                        yield RudimentaryAlloyFurnaceEntity.this.litTime;
                    }
                    case 1 -> Math.min(RudimentaryAlloyFurnaceEntity.this.litDuration, 32767);
                    case 2 -> RudimentaryAlloyFurnaceEntity.this.progress;
                    case 3 -> RudimentaryAlloyFurnaceEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i){
                    case 0 -> RudimentaryAlloyFurnaceEntity.this.litTime = value;
                    case 1 -> RudimentaryAlloyFurnaceEntity.this.litDuration = value;
                    case 2 -> RudimentaryAlloyFurnaceEntity.this.progress = value;
                    case 3 -> RudimentaryAlloyFurnaceEntity.this.maxProgress = value;
                };
            }

            @Override
            //variables to save, aka progress and maxProgress
            public int getCount() {
                return 4;
            }
        };
    }

    @Deprecated
    public static Map<Item, Integer> getFuel() {
        Map<Item, Integer> map = fuelCache;
        if (map != null) {
            return map;
        } else {
            Map<Item, Integer> map1 = Maps.newLinkedHashMap();
            buildFuels((e, time) -> e.ifRight((tag) -> add(map1, tag, time)).ifLeft((item) -> add(map1, item, time)));
            fuelCache = map1;
            return map1;
        }
    }

    private static void add(ObjIntConsumer<Either<Item, TagKey<Item>>> consumer, ItemLike item, int time) {
        consumer.accept(Either.left(item.asItem()), time);
    }

    private static void add(ObjIntConsumer<Either<Item, TagKey<Item>>> consumer, TagKey<Item> tag, int time) {
        consumer.accept(Either.right(tag), time);
    }

    @ApiStatus.Internal
    public static void buildFuels(ObjIntConsumer<Either<Item, TagKey<Item>>> map1) {
        add(map1, Items.LAVA_BUCKET, 20000);
        add(map1, Blocks.COAL_BLOCK, 16000);
        add(map1, ModBlocks.CHARCOALBLOCK, 14400);
        add(map1, Items.BLAZE_ROD, 2400);
        add(map1, Items.COAL, 1600);
        add(map1, ModItems.COALPOWDER, 800);
        add(map1, Items.CHARCOAL, 1600);
        add(map1, (TagKey) ItemTags.LOGS, 300);
        add(map1, (TagKey)ItemTags.BAMBOO_BLOCKS, 300);
        add(map1, (TagKey)ItemTags.PLANKS, 300);
        add(map1, Blocks.BAMBOO_MOSAIC, 300);
        add(map1, (TagKey)ItemTags.WOODEN_STAIRS, 300);
        add(map1, Blocks.BAMBOO_MOSAIC_STAIRS, 300);
        add(map1, (TagKey)ItemTags.WOODEN_SLABS, 150);
        add(map1, Blocks.BAMBOO_MOSAIC_SLAB, 150);
        add(map1, (TagKey)ItemTags.WOODEN_TRAPDOORS, 300);
        add(map1, (TagKey)ItemTags.WOODEN_PRESSURE_PLATES, 300);
        add(map1, (TagKey)ItemTags.WOODEN_FENCES, 300);
        add(map1, (TagKey)ItemTags.FENCE_GATES, 300);
        add(map1, Blocks.NOTE_BLOCK, 300);
        add(map1, Blocks.BOOKSHELF, 300);
        add(map1, Blocks.CHISELED_BOOKSHELF, 300);
        add(map1, Blocks.LECTERN, 300);
        add(map1, Blocks.JUKEBOX, 300);
        add(map1, Blocks.CHEST, 300);
        add(map1, Blocks.TRAPPED_CHEST, 300);
        add(map1, Blocks.CRAFTING_TABLE, 300);
        add(map1, ModBlocks.PRIMITIVECRAFTINGTABLE, 300);
        add(map1, ModBlocks.RUDIMENTARYCRAFTINGTABLE, 300);
        add(map1, ModBlocks.INTERMEDIATECRAFTINGTABLE, 300);
        add(map1, Blocks.DAYLIGHT_DETECTOR, 300);
        add(map1, (TagKey)ItemTags.BANNERS, 300);
        add(map1, Items.BOW, 300);
        add(map1, Items.FISHING_ROD, 300);
        add(map1, Blocks.LADDER, 300);
        add(map1, (TagKey)ItemTags.SIGNS, 200);
        add(map1, (TagKey)ItemTags.HANGING_SIGNS, 800);
        add(map1, Items.WOODEN_SHOVEL, 200);
        add(map1, Items.WOODEN_SWORD, 200);
        add(map1, Items.WOODEN_HOE, 200);
        add(map1, Items.WOODEN_AXE, 200);
        add(map1, Items.WOODEN_PICKAXE, 200);
        add(map1, (TagKey)ItemTags.WOODEN_DOORS, 200);
        add(map1, (TagKey)ItemTags.BOATS, 1200);
        add(map1, (TagKey)ItemTags.WOOL, 100);
        add(map1, (TagKey)ItemTags.WOODEN_BUTTONS, 100);
        add(map1, Items.STICK, 100);
        add(map1, ModItems.STRAW, 30);
        add(map1, ModItems.STRAWSTRING, 100);
        add(map1, ModItems.TREEBARK, 100);
        add(map1, ModItems.WOODENHANDLE, 200);
        add(map1, (TagKey)ItemTags.SAPLINGS, 100);
        add(map1, Items.BOWL, 100);
        add(map1, (TagKey)ItemTags.WOOL_CARPETS, 67);
        add(map1, Blocks.DRIED_KELP_BLOCK, 4001);
        add(map1, Items.CROSSBOW, 300);
        add(map1, Blocks.BAMBOO, 50);
        add(map1, Blocks.DEAD_BUSH, 100);
        add(map1, Blocks.SCAFFOLDING, 50);
        add(map1, Blocks.LOOM, 300);
        add(map1, Blocks.BARREL, 300);
        add(map1, Blocks.CARTOGRAPHY_TABLE, 300);
        add(map1, Blocks.FLETCHING_TABLE, 300);
        add(map1, Blocks.SMITHING_TABLE, 300);
        add(map1, Blocks.COMPOSTER, 300);
        add(map1, Blocks.AZALEA, 100);
        add(map1, Blocks.FLOWERING_AZALEA, 100);
        add(map1, Blocks.MANGROVE_ROOTS, 300);
    }

    private static boolean isNeverAFurnaceFuel(Item item) {
        return item.builtInRegistryHolder().is(ItemTags.NON_FLAMMABLE_WOOD);
    }

    private static void add(Map<Item, Integer> map, TagKey<Item> itemTag, int burnTime) {
        for(Holder<Item> holder : BuiltInRegistries.ITEM.getTagOrEmpty(itemTag)) {
            if (!isNeverAFurnaceFuel((Item)holder.value())) {
                map.put((Item)holder.value(), burnTime);
            }
        }

    }

    private static void add(Map<Item, Integer> map, ItemLike p_item, int burnTime) {
        Item item = p_item.asItem();
        if (isNeverAFurnaceFuel(item)) {
            if (SharedConstants.IS_RUNNING_IN_IDE) {
                throw (IllegalStateException) Util.pauseInIde(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item.getName((ItemStack)null).getString() + " a furnace fuel. That will not work!"));
            }
        } else {
            map.put(item, burnTime);
        }

    }

    private boolean isLit() {
        return this.litTime > 0;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.minecraftprogressrevamp.rudimentary_alloy_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new RudimentaryAlloyFurnaceMenu(i, inventory, this, this.data);
    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("rudimentary_alloy_smelter.progress", progress);
        tag.putInt("rudimentary_alloy_smelter.max_progress", maxProgress);
        tag.putInt("rudimentary_alloy_smelter.lit_time", litTime);
        tag.putInt("rudimentary_alloy_smelter.lit_duration", litDuration);

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        progress = tag.getInt("rudimentary_alloy_smelter.progress");
        maxProgress = tag.getInt("rudimentary_alloy_smelter.max_progress");
        litTime = tag.getInt("rudimentary_alloy_smelter.lit_time");
        litDuration = tag.getInt("rudimentary_alloy_smelter.lit_duration");
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

    public static void serverTick(Level level, BlockPos pos, BlockState state, RudimentaryAlloyFurnaceEntity be) {
        boolean wasLit = be.isLit();
        boolean changed = false;

        if (be.isLit()) be.litTime--;

        Optional<RecipeHolder<RudimentaryAlloyFurnaceRecipe>> recipe = be.getCurrentRecipe();
        boolean canWork = be.hasRecipe(recipe);

        if (!be.isLit() && canWork) {
            ItemStack fuel = be.itemHandler.getStackInSlot(FUEL_SLOT);
            int burn = getBurnTime(fuel);
            if (burn > 0) {
                be.litTime = burn;
                be.litDuration = burn;
                ItemStack remainder = fuel.getCraftingRemainingItem();
                be.itemHandler.extractItem(FUEL_SLOT, 1, false);
                if (!remainder.isEmpty() && be.itemHandler.getStackInSlot(FUEL_SLOT).isEmpty()) {
                    be.itemHandler.setStackInSlot(FUEL_SLOT, remainder);
                }
                changed = true;
            }
        }

        if (be.isLit() && canWork) {
            be.maxProgress = recipe.get().value().cookingTime();
            be.progress++;
            if (be.progress >= be.maxProgress) {
                be.craftItem(recipe.get().value());
                be.progress = 0;
            }
            changed = true;
        } else if (be.progress > 0) {
            be.progress = Mth.clamp(be.progress - 2, 0, be.maxProgress);
            changed = true;
        }

        if (wasLit != be.isLit()) {
            state = state.setValue(RudimentaryAlloySmelterBlock.LIT, be.isLit());
            level.setBlock(pos, state, 3);
            changed = true;
        }
        if (changed) setChanged(level, pos, state);
    }

    private static int getBurnTime(ItemStack stack) {
        return stack.isEmpty() ? 0 : getFuel().getOrDefault(stack.getItem(), 0);
    }

    private void craftItem(RudimentaryAlloyFurnaceRecipe recipe) {
        ItemStack output = recipe.output().copy();
        itemHandler.extractItem(INPUT_SLOT1, 1, false);
        itemHandler.extractItem(INPUT_SLOT2, 1, false);
        itemHandler.insertItem(OUTPUT_SLOT, output, false);
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 1200;
    }

    private float rotation;
    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe(Optional<RecipeHolder<RudimentaryAlloyFurnaceRecipe>> recipe) {
        if (recipe.isEmpty()) return false;
        ItemStack output = recipe.get().value().output();
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeHolder<RudimentaryAlloyFurnaceRecipe>> getCurrentRecipe() {
        return level.getRecipeManager().getRecipeFor(
                ModRecipeSerializers.RUDIMENTARY_ALLOY_FURNACE_TYPE.get(),
                new RudimentaryAlloyFurnaceRecipeInput(itemHandler.getStackInSlot(INPUT_SLOT1), itemHandler.getStackInSlot(INPUT_SLOT2)),
                level);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ? 64 : itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = itemHandler.getStackInSlot(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT).getItem() == output.getItem();
    }
}
