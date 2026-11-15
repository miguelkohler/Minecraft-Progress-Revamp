package net.saitamaking.minecraftprogressrevamp.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;

public class ModConfiguredFeatures {
    //Config -> Placed -> Biome
    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int tries) {
        return FeatureUtils.simpleRandomPatchConfiguration(
                tries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider))
        );
    }

    public static final ResourceKey<ConfiguredFeature<?, ?>> PEBBLE_KEY = registerKey("pebble_key");
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, PEBBLE_KEY, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocks.PEBBLE.get()), 20));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
