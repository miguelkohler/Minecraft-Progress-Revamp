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

public class CobblestoneAnvilRecipeBuilder implements RecipeBuilder {
    private final ItemStack result;
    private final List<String> rows = new ArrayList<>();
    private final Map<Character, Ingredient> key = new LinkedHashMap<>();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    private CobblestoneAnvilRecipeBuilder(ItemStack result) {
        this.result = result;
    }

    public static CobblestoneAnvilRecipeBuilder anvil(ItemLike result) {
        return new CobblestoneAnvilRecipeBuilder(new ItemStack(result));
    }

    public static CobblestoneAnvilRecipeBuilder anvil(ItemLike result, int count) {
        return new CobblestoneAnvilRecipeBuilder(new ItemStack(result, count));
    }

    public CobblestoneAnvilRecipeBuilder define(Character symbol, ItemLike item) {
        return define(symbol, Ingredient.of(item));
    }

    public CobblestoneAnvilRecipeBuilder define(Character symbol, TagKey<Item> tag) {
        return define(symbol, Ingredient.of(tag));
    }

    public CobblestoneAnvilRecipeBuilder define(Character symbol, Ingredient ingredient) {
        if (key.containsKey(symbol)) throw new IllegalArgumentException("Symbol '" + symbol + "' is already defined!");
        if (symbol == ' ') throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
        key.put(symbol, ingredient);
        return this;
    }

    public CobblestoneAnvilRecipeBuilder pattern(String row) {
        if (!rows.isEmpty() && row.length() != rows.get(0).length()) {
            throw new IllegalArgumentException("Pattern rows must all be the same width!");
        }
        rows.add(row);
        return this;
    }

    @Override
    public CobblestoneAnvilRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }

    @Override
    public CobblestoneAnvilRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        ShapedRecipePattern pattern = ShapedRecipePattern.of(key, rows);
        CobblestoneAnvilRecipe recipe = new CobblestoneAnvilRecipe(pattern, result);

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