package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;
import net.saitamaking.minecraftprogressrevamp.item.crafting.ModCustomCraftingShaped;
import net.saitamaking.minecraftprogressrevamp.item.crafting.ModCustomCraftingShapeless;
import net.saitamaking.minecraftprogressrevamp.util.ModTags;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> SALTED_BEEF_INGREDIENT = List.of(
                ModItems.SALTEDBEEF
        );

        List<ItemLike> UNREFINED_CRUCIBLES = List.of(
                ModItems.UNREFINEDCRUCIBLE
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHARCOALBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.CHARCOAL)
                .unlockedBy("has_charcoal", has(Items.CHARCOAL))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.SHARPPEBBLE.get())
                .requires(ModItems.LOOSEPEBBLE, 2)
                .unlockedBy("has_loose_pebble", has(ModItems.LOOSEPEBBLE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVEAXE.get())
                .pattern(" O ")
                .pattern("X/ ")
                .pattern(" / ")
                .define('O', ModItems.LOOSEPEBBLE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_loose_pebble", has(ModItems.LOOSEPEBBLE))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput, "minecraftprogressrevamp:primitive_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVEAXE.get())
                .pattern(" O ")
                .pattern(" /X")
                .pattern(" / ")
                .define('O', ModItems.LOOSEPEBBLE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_loose_pebble", has(ModItems.LOOSEPEBBLE))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput, "minecraftprogressrevamp:primitive_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FIRECLAY.get())
                .pattern("## ")
                .pattern("## ")
                .pattern("   ")
                .define('#', ModItems.FIRECLAYBALL)
                .unlockedBy("has_fireclay_ball", has(ModItems.FIRECLAYBALL))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FIRECLAYBALL.get())
                .requires(ModItems.COALPOWDER)
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_coal_powder", has(ModItems.COALPOWDER))
                .save(recipeOutput);

        /*ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COALPOWDER.get())
                .requires(Items.COAL)
                .requires(ModItems.PRIMITIVEHAMMER)
                .unlockedBy("has_coal", has(Items.COAL))
                .unlockedBy("has_primitive_hammer", has(ModItems.PRIMITIVEHAMMER))
                .save(recipeOutput, "minecraftprogressrevamp:coal_powder_1");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COALPOWDER.get())
                .requires(Items.CHARCOAL)
                .requires(ModItems.PRIMITIVEHAMMER)
                .unlockedBy("has_charcoal", has(Items.CHARCOAL))
                .unlockedBy("has_primitive_hammer", has(ModItems.PRIMITIVEHAMMER))
                .save(recipeOutput, "minecraftprogressrevamp:coal_powder_2");
        */
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVEHAMMER.get())
                .pattern("#O#")
                .pattern("#/#")
                .pattern(" / ")
                .define('#', Items.COBBLESTONE)
                .define('/', Items.STICK)
                .define('O', ModItems.LOOSEPEBBLE)
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .unlockedBy("has_loose_pebble", has(ModItems.LOOSEPEBBLE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVEPICKAXE.get())
                .pattern("XOX")
                .pattern(" / ")
                .pattern(" / ")
                .define('X', ModItems.SHARPPEBBLE)
                .define('O', ModItems.LOOSEPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_loose_pebble", has(ModItems.LOOSEPEBBLE))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVESAW.get())
                .pattern("X/ ")
                .pattern("X/ ")
                .pattern(" O ")
                .define('O', ModItems.WOODENHANDLE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_wooden_handle", has(ModItems.WOODENHANDLE))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput, "minecraftprogressrevamp:primitive_saw_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVESAW.get())
                .pattern(" /X")
                .pattern(" /X")
                .pattern(" O ")
                .define('O', ModItems.WOODENHANDLE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_wooden_handle", has(ModItems.WOODENHANDLE))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput, "minecraftprogressrevamp:primitive_saw_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVESHEARS.get())
                .pattern("O/ ")
                .pattern("/ X")
                .pattern(" X ")
                .define('O', ModItems.WOODENHANDLE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_wooden_handle", has(ModItems.WOODENHANDLE))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput, "minecraftprogressrevamp:primitive_shears_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVESHEARS.get())
                .pattern(" /O")
                .pattern("X /")
                .pattern(" X ")
                .define('O', ModItems.WOODENHANDLE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_wooden_handle", has(ModItems.WOODENHANDLE))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput, "minecraftprogressrevamp:primitive_shears_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVESHEARS.get())
                .pattern(" X ")
                .pattern("/ X")
                .pattern("O/ ")
                .define('O', ModItems.WOODENHANDLE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_wooden_handle", has(ModItems.WOODENHANDLE))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput, "minecraftprogressrevamp:primitive_shears_3");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVESHEARS.get())
                .pattern(" X ")
                .pattern("X /")
                .pattern(" /O")
                .define('O', ModItems.WOODENHANDLE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_wooden_handle", has(ModItems.WOODENHANDLE))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput, "minecraftprogressrevamp:primitive_shears_4");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNREFINEDCRUCIBLE.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("###")
                .define('#', ModItems.FIRECLAYBALL)
                .unlockedBy("has_fireclay_ball", has(ModItems.FIRECLAYBALL))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALTEDBEEF.get())
                .requires(Items.BEEF)
                .requires(ModItems.SALT)
                .unlockedBy("has_beef", has(Items.BEEF))
                .unlockedBy("has_salt", has(ModItems.SALT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STARTERTOOLBOX.get())
                .pattern("S S")
                .pattern("X#H")
                .pattern(" U ")
                .define('S', Items.STRING)
                .define('#', Items.LEATHER)
                .define('X', ModItems.PRIMITIVESAW)
                .define('U', ModItems.PRIMITIVESHEARS)
                .define('H', ModItems.PRIMITIVEHAMMER)
                .unlockedBy("has_string", has(Items.STRING))
                .unlockedBy("has_leather", has(Items.LEATHER))
                .unlockedBy("has_primitive_saw", has(ModItems.PRIMITIVESAW))
                .unlockedBy("has_primitive_shears", has(ModItems.PRIMITIVESHEARS))
                .unlockedBy("has_primitive_hammer", has(ModItems.PRIMITIVEHAMMER))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PEBBLE.get())
                .requires(ModItems.LOOSEPEBBLE)
                .unlockedBy("has_loose_pebble", has(ModItems.LOOSEPEBBLE))
                .save(recipeOutput);

        ShapedRecipePattern Mod_shaped_pattern1 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModTags.Items.ALLTHEWOODITEM),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        "#  ",
                        "#V ",
                        "   "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe1 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern1,
                new ItemStack(Items.STICK, 16)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw"),
                Mod_shaped_recipe1,
                recipeOutput.advancement()
                        .addCriterion("has_oak_log", RecipeProvider.has(Items.OAK_LOG))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients1 = List.of(
                Ingredient.of(Items.COAL),
                Ingredient.of(ModItems.PRIMITIVEHAMMER.get())
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe1 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.COALPOWDER.get(), 2),
                Mod_shapeless_ingredients1
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "coal_powder"),
                Mod_shapeless_recipe1,
                recipeOutput.advancement()
                        .addCriterion("has_coal", RecipeProvider.has(Items.COAL))
                        .addCriterion("has_primitive_hammer", RecipeProvider.has(ModItems.PRIMITIVEHAMMER.get()))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "coal_powder").withPrefix("recipes/"))
        );

        oreSmelting(recipeOutput, SALTED_BEEF_INGREDIENT, RecipeCategory.FOOD, ModItems.SALTEDCOOKEDBEEF.get(), 0.4f, 200, "salted_cooked_beef");

        campfireCooking(recipeOutput, SALTED_BEEF_INGREDIENT,RecipeCategory.FOOD, ModItems.SALTEDCOOKEDBEEF.get(), 0.4f, 600, "salted_cooked_beef");

        campfireCooking(recipeOutput, UNREFINED_CRUCIBLES,RecipeCategory.MISC, ModItems.REFINEDCRUCIBLE.get(), 0.5f, 1200, "refined_crucible");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void campfireCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_campfire_cooking");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer,
                                                                       AbstractCookingRecipe.Factory<T> factory, List<ItemLike> pIngredients,
                                                                       RecipeCategory pCategory, ItemLike pResult,
                                                                       float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup)
                    .unlockedBy(getHasName(itemLike), has(itemLike)).save(recipeOutput, ProgressRevamp.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
