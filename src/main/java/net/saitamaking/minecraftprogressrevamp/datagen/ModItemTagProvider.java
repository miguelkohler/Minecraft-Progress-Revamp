package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;
import net.saitamaking.minecraftprogressrevamp.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ProgressRevamp.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.LOOSE_PEBBLES)
                .add(ModItems.LOOSEPEBBLE.get());
        tag(ModTags.Items.PRIMITIVE_TOOLS)
                .add(ModItems.SHARPPEBBLE.get())
                .add(ModItems.PRIMITIVEAXE.get())
                .add(ModItems.PRIMITIVEHAMMER.get())
                .add(ModItems.PRIMITIVESAW.get())
                .add(ModItems.PRIMITIVEPICKAXE.get())
                .add(ModItems.STARTERTOOLBOX.get())
                .add(ModItems.PRIMITIVEKNIFE.get())
                .add(ModItems.CERAMICBUCKET.get())
                .add(ModItems.WATER_CERAMICBUCKET.get())
                .add(ModItems.PRIMITIVESHEARS.get());
        tag(ItemTags.AXES)
                .add(ModItems.PRIMITIVEAXE.get())
                .add(ModItems.PRIMITIVESAW.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.PRIMITIVEPICKAXE.get());
        tag(ModTags.Items.SAWS)
                .add(ModItems.PRIMITIVESAW.get());
        tag(ModTags.Items.HAMMERS)
                .add(ModItems.PRIMITIVEHAMMER.get());
        tag(ModTags.Items.KNIVES)
                .add(ModItems.PRIMITIVEKNIFE.get());
        tag(ModTags.Items.WATERCONTAINERS)
                .add(Items.WATER_BUCKET)
                .add(ModItems.WATER_CERAMICBUCKET.get());
        tag(ModTags.Items.SANDMOLDS)
                .add(ModItems.EMPTYSANDMOLD.get())
                .add(ModItems.INGOTSANDMOLD.get());
        tag(ModTags.Items.INGOTSHAPED)
                .add(Items.BRICK)
                .add(Items.NETHER_BRICK)
                .add(Items.COPPER_INGOT)
                .add(Items.IRON_INGOT)
                .add(Items.GOLD_INGOT)
                .add(Items.NETHERITE_INGOT);
        tag(ModTags.Items.ALLTHEWOODITEM)
                .addTag(ItemTags.ACACIA_LOGS)
                .addTag(ItemTags.BIRCH_LOGS)
                .addTag(ItemTags.SPRUCE_LOGS)
                .addTag(ItemTags.DARK_OAK_LOGS)
                .addTag(ItemTags.MANGROVE_LOGS)
                .addTag(ItemTags.CHERRY_LOGS)
                .addTag(ItemTags.JUNGLE_LOGS)
                .addTag(ItemTags.WARPED_STEMS)
                .addTag(ItemTags.CRIMSON_STEMS)
                .addTag(ItemTags.OAK_LOGS);

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.HIDEVEST.get())
                .add(ModItems.HIDEBOOTS.get())
                .add(ModItems.HIDESHORTS.get());

    }
}
