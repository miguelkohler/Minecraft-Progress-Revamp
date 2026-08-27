package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
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
                .add(ModItems.PRIMITIVEAXE.get())
                .add(ModItems.PRIMITIVEHAMMER.get())
                .add(ModItems.PRIMITIVESAW.get())
                .add(ModItems.PRIMITIVEPICKAXE.get())
                .add(ModItems.STARTERTOOLBOX.get())
                .add(ModItems.PRIMITIVESHEARS.get());
    }
}
