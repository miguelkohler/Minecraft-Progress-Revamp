package net.saitamaking.minecraftprogressrevamp.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, ProgressRevamp.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, ProgressRevamp.MODID);


    public static final DeferredHolder<RecipeSerializer<?>, ModCustomCraftingShaped.Serializer> DURABILITY_SHAPED =
            RECIPE_SERIALIZERS.register("durability_shaped", ModCustomCraftingShaped.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, ModCustomCraftingShapeless.Serializer> DURABILITY_SHAPELESS =
            RECIPE_SERIALIZERS.register("durability_shapeless", ModCustomCraftingShapeless.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, CampfireWithCrucibleRecipe.Serializer> CAMPFIRE_WITH_CRUCIBLE_SERIALIZER =
            RECIPE_SERIALIZERS.register("campfire_with_crucible", CampfireWithCrucibleRecipe.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, RudimentaryAlloyFurnaceRecipe.Serializer> RUDIMENTARY_ALLOY_FURNACE_SERIALIZER =
            RECIPE_SERIALIZERS.register("rudimentary_alloy_furnace", RudimentaryAlloyFurnaceRecipe.Serializer::new);
    public static final Supplier<RecipeSerializer<CobblestoneAnvilRecipe>> COBBLESTONE_ANVIL_SERIALIZER =
            RECIPE_SERIALIZERS.register("cobblestone_anvil", CobblestoneAnvilRecipe.Serializer::new);
    public static final Supplier<RecipeSerializer<TierOneCraftingTableRecipe>> TIER_ONE_CRAFTING_TABLE_SERIALIZER =
            RECIPE_SERIALIZERS.register("intermediate_crafting_table", TierOneCraftingTableRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<CampfireWithCrucibleRecipe>> CAMPFIRE_WITH_CRUCIBLE_TYPE =
            TYPES.register("campfire_with_crucible", () -> new RecipeType<CampfireWithCrucibleRecipe>() {
                @Override
                public String toString() {
                    return "campfire_with_crucible";
                }
            });
    public static final Supplier<RecipeType<RudimentaryAlloyFurnaceRecipe>> RUDIMENTARY_ALLOY_FURNACE_TYPE =
            TYPES.register("rudimentary_alloy_furnace", () -> RecipeType.simple(
                    ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "rudimentary_alloy_furnace")));
    public static final Supplier<RecipeType<CobblestoneAnvilRecipe>> COBBLESTONE_ANVIL_TYPE =
            TYPES.register("cobblestone_anvil", () -> RecipeType.simple(
                    ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "cobblestone_anvil")));

    public static final Supplier<RecipeType<TierOneCraftingTableRecipe>> TIER_ONE_CRAFTING_TABLE_TYPE =
            TYPES.register("intermediate_crafting_table", () -> RecipeType.simple(
                    ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "intermediate_crafting_table")));
}
