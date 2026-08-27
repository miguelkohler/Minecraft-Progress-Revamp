package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
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
                .add(ModBlocks.CHARCOALBLOCK.get());
    }
}
