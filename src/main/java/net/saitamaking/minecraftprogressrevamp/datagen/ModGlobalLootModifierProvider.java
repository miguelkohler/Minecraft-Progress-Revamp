package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;
import net.saitamaking.minecraftprogressrevamp.loot.AddItemModifier;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, ProgressRevamp.MODID);
    }

    @Override
    protected void start() {
        /*

        Blocks -> this.add("radish_seeds_to_short_grass",
                new AddItemModifier(new LootItemCondition[] {
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build() }, ModItems.RADISH_SEEDS.get()));

        Structures -> this.add("chisel_from_jungle_temple",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build()
                }, ModItems.CHISEL.get()));

        Entities -> this.add("berry_from_creeper",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper")).build()
                }, ModItems.GOJI_BERRIES.get()));

         */

        this.add("hide_from_cow",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/cow")).build()
                }, ModItems.ANIMALHIDE.get()));

        this.add("hide_from_horse",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/horse")).build(),
                        LootItemRandomChanceCondition.randomChance(2.0f).build()
                }, ModItems.ANIMALHIDE.get()));

        this.add("hide_from_sheep",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/sheep")).build(),
                        LootItemRandomChanceCondition.randomChance(0.35f).build()
                }, ModItems.ANIMALHIDE.get()));

        this.add("hide_from_pig",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/cow")).build(),
                        LootItemRandomChanceCondition.randomChance(0.2f).build()
                }, ModItems.ANIMALHIDE.get()));

    }
}
