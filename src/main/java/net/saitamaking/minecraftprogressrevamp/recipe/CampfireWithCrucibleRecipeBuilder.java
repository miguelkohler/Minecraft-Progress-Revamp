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
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CampfireWithCrucibleRecipeBuilder implements RecipeBuilder {
    private final Ingredient input;
    private final ItemStack result;
    private final int cookingTime;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    private CampfireWithCrucibleRecipeBuilder(Ingredient input, ItemStack result, int cookingTime) {
        this.input = input;
        this.result = result;
        this.cookingTime = cookingTime;
    }

    public static CampfireWithCrucibleRecipeBuilder crucible(Ingredient input, ItemLike result, int count, int cookingTime) {
        return new CampfireWithCrucibleRecipeBuilder(input, new ItemStack(result, count), cookingTime);
    }

    public static CampfireWithCrucibleRecipeBuilder crucible(ItemLike input, ItemLike result, int cookingTime) {
        return crucible(Ingredient.of(input), result, 1, cookingTime);
    }

    public static CampfireWithCrucibleRecipeBuilder crucible(TagKey<Item> input, ItemLike result, int cookingTime) {
        return crucible(Ingredient.of(input), result, 1, cookingTime);
    }

    @Override
    public CampfireWithCrucibleRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }

    @Override
    public CampfireWithCrucibleRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        CampfireWithCrucibleRecipe recipe = new CampfireWithCrucibleRecipe(input, result, cookingTime);

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