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
import java.util.*;

public class TierOneCraftingTableRecipeBuilder implements RecipeBuilder {
    //handles intermediate crafting table recipes mapping this grid to the slots, -1 = not a real slot
    private static final int[] GRID_TO_SLOT = {
            -1, -1, 9,-1, -1,
            -1,  0, 1, 2, -1,
            10,  3, 4, 5, 11,
            -1,  6, 7, 8, -1,
            -1, -1,12,-1, -1
    };

    private final ItemStack result;
    private final List<String> rows = new ArrayList<>();
    private final Map<Character, Ingredient> key = new LinkedHashMap<>();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    private TierOneCraftingTableRecipeBuilder(ItemStack result) {
        this.result = result;
    }

    public static TierOneCraftingTableRecipeBuilder intermediate_recipe(ItemLike result) {
        return new TierOneCraftingTableRecipeBuilder(new ItemStack(result));
    }

    public static TierOneCraftingTableRecipeBuilder intermediate_recipe(ItemLike result, int count) {
        return new TierOneCraftingTableRecipeBuilder(new ItemStack(result, count));
    }

    public TierOneCraftingTableRecipeBuilder define(Character symbol, ItemLike item) {
        return define(symbol, Ingredient.of(item));
    }

    public TierOneCraftingTableRecipeBuilder define(Character symbol, TagKey<Item> tag) {
        return define(symbol, Ingredient.of(tag));
    }

    public TierOneCraftingTableRecipeBuilder define(Character symbol, Ingredient ingredient) {
        if (key.containsKey(symbol)) throw new IllegalArgumentException("Symbol '" + symbol + "' is already defined!");
        if (symbol == ' ') throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved");
        key.put(symbol, ingredient);
        return this;
    }

    //one row of the 5x5 pattern using ' ' for empty cells
    public TierOneCraftingTableRecipeBuilder pattern(String row) {
        if (row.length() != 5) throw new IllegalArgumentException("Each row must be exactly 5 characters wide!");
        if (rows.size() >= 5) throw new IllegalArgumentException("Pattern can only have 5 rows!");
        rows.add(row);
        return this;
    }

    @Override
    public TierOneCraftingTableRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }

    @Override
    public TierOneCraftingTableRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        if (rows.size() != 5) throw new IllegalStateException("Recipe " + id + " needs exactly 5 pattern rows");

        List<Ingredient> ingredients = new ArrayList<>(Collections.nCopies(13, Ingredient.EMPTY));
        Set<Character> unused = new HashSet<>(key.keySet());

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                char c = rows.get(y).charAt(x);
                if (c == ' ') continue;

                int slot = GRID_TO_SLOT[y * 5 + x];
                if (slot < 0)
                    throw new IllegalStateException("Recipe " + id + ": cell (" + x + "," + y + ") is outside the diamond shape of the crafting");
                Ingredient ing = key.get(c);
                if (ing == null)
                    throw new IllegalStateException("Recipe " + id + ": pattern uses undefined symbol '" + c + "'");

                ingredients.set(slot, ing);
                unused.remove(c);
            }
        }
        if (!unused.isEmpty())
            throw new IllegalStateException("Recipe " + id + ": unused symbols " + unused);

        TierOneCraftingTableRecipe recipe = new TierOneCraftingTableRecipe(ingredients, result);

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