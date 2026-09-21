package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ProgressRevamp.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.COPPERBARBLOCK.get(),
                        ModBlocks.COBBLESTONEANVIL.get(),
                        ModBlocks.CHARCOALBLOCK.get()
                );
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(
                        ModBlocks.FIRECLAY.get(),
                        ModBlocks.MELTEDCOPPERBLOCK.get()
                );
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                        ModBlocks.RUDIMENTARYCRAFTINGTABLE.get(),
                        ModBlocks.STEELCUTTER.get(),
                        ModBlocks.WOODENCRATE.get()
                );
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.STEELCUTTER.get())
                .add(Blocks.CRAFTING_TABLE)
                .add(Blocks.COAL_ORE)
                .add(
                        ModBlocks.CHARCOALBLOCK.get()
                );
        tag(ModTags.Blocks.NEEDS_PRIMAL_TOOLS)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .remove(
                        BlockTags.SAPLINGS,
                        BlockTags.WOODEN_BUTTONS,
                        BlockTags.SIGNS
                        )
                .remove(
                        Blocks.CRAFTING_TABLE,
                        Blocks.WHEAT,
                        Blocks.WEEPING_VINES_PLANT,
                        Blocks.WEEPING_VINES,
                        Blocks.WARPED_FUNGUS,
                        Blocks.VINE,
                        Blocks.TWISTING_VINES_PLANT,
                        Blocks.TWISTING_VINES,
                        Blocks.TALL_GRASS,
                        Blocks.SMALL_DRIPLEAF,
                        Blocks.SCAFFOLDING,
                        Blocks.RED_MUSHROOM,
                        Blocks.PUMPKIN_STEM,
                        Blocks.POTATOES,
                        Blocks.NETHER_WART,
                        Blocks.MELON_STEM,
                        Blocks.LILY_PAD,
                        Blocks.LARGE_FERN,
                        Blocks.LADDER,
                        Blocks.JACK_O_LANTERN,
                        Blocks.SHORT_GRASS,
                        Blocks.GLOW_LICHEN,
                        Blocks.FERN,
                        Blocks.DEAD_BUSH,
                        Blocks.CARROTS,
                        Blocks.CARVED_PUMPKIN,
                        Blocks.BIG_DRIPLEAF_STEM,
                        Blocks.BIG_DRIPLEAF,
                        Blocks.BEETROOTS,
                        Blocks.ATTACHED_PUMPKIN_STEM,
                        Blocks.ATTACHED_MELON_STEM
                )
                .add(
                        ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                        ModBlocks.WOODENCRATE.get(),
                        ModBlocks.COBBLESTONEANVIL.get(),
                        ModBlocks.RUDIMENTARYCRAFTINGTABLE.get()
                );
        tag(ModTags.Blocks.INCORRECT_FOR_PRIMAL_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks.CRAFTING_TABLE)
                .remove(ModTags.Blocks.NEEDS_PRIMAL_TOOLS);

        tag(ModTags.Blocks.STRIPPEDLOGS)
                .add(Blocks.STRIPPED_ACACIA_LOG)
                .add(Blocks.STRIPPED_BIRCH_LOG)
                .add(Blocks.STRIPPED_SPRUCE_LOG)
                .add(Blocks.STRIPPED_OAK_LOG)
                .add(Blocks.STRIPPED_DARK_OAK_LOG)
                .add(Blocks.STRIPPED_MANGROVE_LOG)
                .add(Blocks.STRIPPED_CHERRY_LOG)
                .add(Blocks.STRIPPED_JUNGLE_LOG)
                .add(Blocks.STRIPPED_WARPED_STEM)
                .add(Blocks.STRIPPED_CRIMSON_STEM);

        tag(ModTags.Blocks.ALLTHELOGS)
                .addTag(ModTags.Blocks.STRIPPEDLOGS)
                .addTag(BlockTags.LOGS);

        tag(ModTags.Blocks.ALLTHEWOOD)
                .addTag(BlockTags.ACACIA_LOGS)
                .addTag(BlockTags.BIRCH_LOGS)
                .addTag(BlockTags.SPRUCE_LOGS)
                .addTag(BlockTags.DARK_OAK_LOGS)
                .addTag(BlockTags.MANGROVE_LOGS)
                .addTag(BlockTags.CHERRY_LOGS)
                .addTag(BlockTags.JUNGLE_LOGS)
                .addTag(BlockTags.WARPED_STEMS)
                .addTag(BlockTags.CRIMSON_STEMS)
                .addTag(BlockTags.OAK_LOGS);
    }
}
