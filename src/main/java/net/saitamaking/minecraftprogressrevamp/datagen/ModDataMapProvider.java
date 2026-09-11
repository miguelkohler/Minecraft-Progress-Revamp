package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModBlocks.PRIMITIVECRAFTINGTABLE.getId(), new FurnaceFuel(300), false)
                .add(ModBlocks.RUDIMENTARYCRAFTINGTABLE.getId(), new FurnaceFuel(300), false)
                .add(ModItems.COALPOWDER.getId(), new FurnaceFuel(1600), false)
                .add(ModItems.WOODENHANDLE.getId(), new FurnaceFuel(200), false)
                .add(ModItems.TREEBARK.getId(), new FurnaceFuel(100), false)
                .add(ModItems.STRAW.getId(), new FurnaceFuel(30), false)
                .add(ModItems.STRAWSTRING.getId(), new FurnaceFuel(100), false)
                .add(ModBlocks.CHARCOALBLOCK.getId(), new FurnaceFuel(14400), false);
        super.gather(provider);
    }
}
