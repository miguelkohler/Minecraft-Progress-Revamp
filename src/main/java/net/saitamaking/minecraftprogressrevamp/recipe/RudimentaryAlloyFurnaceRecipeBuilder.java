package net.saitamaking.minecraftprogressrevamp.recipe;

import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

public class RudimentaryAlloyFurnaceRecipeBuilder implements RecipeBuilder {
    private final Ingredient ingredientA;
    private final Ingredient ingredientB;
    private final ItemStack result;
    private final int cookingTime;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    private RudimentaryAlloyFurnaceRecipeBuilder(Ingredient ingredientA, Ingredient ingredientB,ItemStack result, int cookingTime) {
        this.ingredientA = ingredientA;
        this.ingredientB = ingredientB;
        this.result = result;
        this.cookingTime = cookingTime;
    }

    public static RudimentaryAlloyFurnaceRecipeBuilder alloy(Ingredient ingredientA, Ingredient ingredientB,ItemLike result, int count, int cookingTime) {
        return new RudimentaryAlloyFurnaceRecipeBuilder(ingredientA, ingredientB, new ItemStack(result, count), cookingTime);
    }

    public static RudimentaryAlloyFurnaceRecipeBuilder alloy(ItemLike ingredientA, Ingredient ingredientB, ItemLike result, int cookingTime) {
        return alloy(Ingredient.of(ingredientA), ingredientB, result, 1, cookingTime);
    }

    public static RudimentaryAlloyFurnaceRecipeBuilder alloy(TagKey<Item> ingredientA, Ingredient ingredientB, ItemLike result, int cookingTime) {
        return alloy(Ingredient.of(ingredientA), ingredientB, result, 1, cookingTime);
    }

    public static RudimentaryAlloyFurnaceRecipeBuilder alloy(ItemLike ingredientA, ItemLike ingredientB, ItemLike result, int cookingTime) {
        return alloy(Ingredient.of(ingredientA), Ingredient.of(ingredientB), result, 1, cookingTime);
    }

    public static RudimentaryAlloyFurnaceRecipeBuilder alloy(Ingredient ingredientA, ItemLike ingredientB, ItemLike result, int cookingTime) {
        return alloy(ingredientA, Ingredient.of(ingredientB), result, 1, cookingTime);
    }

    public static RudimentaryAlloyFurnaceRecipeBuilder alloy(TagKey<Item> ingredientA, ItemLike ingredientB, ItemLike result, int cookingTime) {
        return alloy(Ingredient.of(ingredientA), Ingredient.of(ingredientB), result, 1, cookingTime);
    }

    public static RudimentaryAlloyFurnaceRecipeBuilder alloy(TagKey<Item> ingredientA, TagKey<Item> ingredientB, ItemLike result, int cookingTime) {
        return alloy(Ingredient.of(ingredientA), Ingredient.of(ingredientB), result, 1, cookingTime);
    }

    public static RudimentaryAlloyFurnaceRecipeBuilder alloy(Ingredient ingredientA, TagKey<Item> ingredientB, ItemLike result, int cookingTime) {
        return alloy(ingredientA, Ingredient.of(ingredientB), result, 1, cookingTime);
    }

    public static RudimentaryAlloyFurnaceRecipeBuilder alloy(ItemLike ingredientA, TagKey<Item> ingredientB, ItemLike result, int cookingTime) {
        return alloy(Ingredient.of(ingredientA), Ingredient.of(ingredientB), result, 1, cookingTime);
    }

    @Override
    public RudimentaryAlloyFurnaceRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }

    @Override
    public RudimentaryAlloyFurnaceRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        RudimentaryAlloyFurnaceRecipe recipe = new RudimentaryAlloyFurnaceRecipe(ingredientA, ingredientB, result, cookingTime);

        AdvancementHolder advancement = null;
        if (!criteria.isEmpty()) {
            Advancement.Builder builder = output.advancement()
                    .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                    .rewards(AdvancementRewards.Builder.recipe(id))
                    .requirements(AdvancementRequirements.Strategy.OR);
            criteria.forEach(builder::addCriterion);
            advancement = builder.build(id.withPrefix("recipes/"));
        }

        output.accept(id, recipe, advancement);
    }
}