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
                .add(ModBlocks.CHARCOALBLOCK.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.FIRECLAY.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.PRIMITIVECRAFTINGTABLE.get())
                .add(ModBlocks.RUDIMENTARYCRAFTINGTABLE.get())
                .add(ModBlocks.STEELCUTTER.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.STEELCUTTER.get())
                .add(Blocks.CRAFTING_TABLE)
                .add(ModBlocks.CHARCOALBLOCK.get());
        tag(ModTags.Blocks.NEEDS_PRIMAL_TOOLS)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.PLANKS)
                .addTag(BlockTags.LOGS)
                .addTag(BlockTags.ALL_SIGNS)
                .addTag(BlockTags.WOODEN_DOORS)
                .addTag(BlockTags.WOODEN_FENCES)
                .addTag(BlockTags.WOODEN_SLABS)
                .addTag(BlockTags.WOODEN_STAIRS)
                .addTag(BlockTags.WOODEN_TRAPDOORS)
                .remove(Blocks.CRAFTING_TABLE)
                .add(
                        ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                        ModBlocks.RUDIMENTARYCRAFTINGTABLE.get()
                );
        tag(ModTags.Blocks.INCORRECT_FOR_PRIMAL_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks.CRAFTING_TABLE)
                .remove(ModTags.Blocks.NEEDS_PRIMAL_TOOLS);
    }
}
