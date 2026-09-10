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
        public static final TagKey<Item> ALLTHEWOODITEM = createTag("all_the_wood_item");
        public static final TagKey<Item> WATERCONTAINERS = createTag("water_containers");

        private static TagKey<Item> createTag(String name){

            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, name));
        }
    }
}
