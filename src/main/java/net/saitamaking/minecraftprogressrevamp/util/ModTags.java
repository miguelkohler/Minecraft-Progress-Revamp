package net.saitamaking.minecraftprogressrevamp.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;

public class ModTags {
    public static class Blocks {
        public static TagKey<Block> NEEDS_PRIMAL_TOOLS = createTag("needs_primal_tools");
        public static TagKey<Block> INCORRECT_FOR_PRIMAL_TOOL = createTag("incorrect_for_primal_tool");
        public static TagKey<Block> NEEDS_COPPER_TOOLS = createTag("needs_copper_tools");
        public static TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");
        public static TagKey<Block> STRIPPEDLOGS = createTag("stripped_logs");
        public static TagKey<Block> ALLTHELOGS = createTag("all_the_logs");
        public static TagKey<Block> ALLTHEWOOD = createTag("all_the_wood");

        private static TagKey<Block> createTag(String name){

            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> LOOSE_PEBBLES = createTag("loose_pebbles");
        public static final TagKey<Item> PRIMITIVE_TOOLS = createTag("primitive_tools");
        public static final TagKey<Item> SAWS = createTag("saws");
        public static final TagKey<Item> HAMMERS = createTag("hammers");
        public static final TagKey<Item> KNIVES = createTag("knives");
        public static final TagKey<Item> SHEARS = createTag("shears");
        public static final TagKey<Item> CHISELS = createTag("chisels");
        public static final TagKey<Item> ALLTHEWOODITEM = createTag("all_the_wood_item");
        public static final TagKey<Item> WATERCONTAINERS = createTag("water_containers");
        public static final TagKey<Item> SANDMOLDS = createTag("sand_molds");
        public static final TagKey<Item> GOLDMOLDS = createTag("gold_molds");
        public static final TagKey<Item> INGOTSHAPED = createTag("ingot_shaped");
        public static final TagKey<Item> NUGGETSHAPED = createTag("nugget_shaped");
        public static final TagKey<Item> NAILSHAPED = createTag("nail_shaped");
        public static final TagKey<Item> COPPERTOOLS = createTag("copper_tools");
        public static final TagKey<Item> COPPERARMOR = createTag("copper_armor");
        public static final TagKey<Item> COPPERTOOLPARTS = createTag("copper_tool_parts");
        public static final TagKey<Item> COPPERPLATES = createTag("copper_plates");
        public static final TagKey<Item> GOLDPLATES = createTag("gold_plates");
        public static final TagKey<Item> IRONPLATES = createTag("iron_plates");
        public static final TagKey<Item> COALBLOCKS = createTag("coal_blocks");
        public static final TagKey<Item> COPPERBLOBMELTABLES = createTag("copper_blob_meltables");
        public static final TagKey<Item> GOLDBLOBMELTABLES = createTag("gold_blob_meltables");
        public static final TagKey<Item> ROSEGOLDBLOBMELTABLES = createTag("rose_gold_blob_meltables");
        public static final TagKey<Item> IRONBLOBMELTABLES = createTag("iron_blob_meltables");
        public static final TagKey<Item> FIRESTARTERS = createTag("firestarters");
        public static final TagKey<Item> STONESLABCRAFTINGMATERIAL = createTag("stone_slab_crafting_material");
        public static final TagKey<Item> SMALLCOPPERBLOBMELTABLES = createTag("small_copper_blob_meltables");
        public static final TagKey<Item> SMALLGOLDBLOBMELTABLES = createTag("small_gold_blob_meltables");
        public static final TagKey<Item> SMALLROSEGOLDBLOBMELTABLES = createTag("small_rose_gold_blob_meltables");
        public static final TagKey<Item> SMALLIRONBLOBMELTABLES = createTag("small_iron_blob_meltables");
        public static final TagKey<Item> COPPERBLOCKMELTABLES = createTag("copper_block_meltables");
        public static final TagKey<Item> GOLDBLOCKMELTABLES = createTag("gold_block_meltables");
        public static final TagKey<Item> IRONBLOCKMELTABLES = createTag("iron_block_meltables");

        private static TagKey<Item> createTag(String name){

            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, name));
        }
    }
}
