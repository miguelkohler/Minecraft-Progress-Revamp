package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
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

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> SALTED_BEEF_INGREDIENT = List.of(
                ModItems.SALTEDBEEF
        );

        List<ItemLike> CERAMIC_BUCKET_INGREDIENTS = List.of(
                ModItems.UNFIREDCLAYBUCKET
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

        /*ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVEAXE.get())
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

         */

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

        /*ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PRIMITIVESAW.get())
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

         */

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

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HIDEVEST.get())
                .pattern("SS#")
                .pattern("S##")
                .pattern("###")
                .define('#', ModItems.ANIMALHIDE)
                .define('S', ModItems.STRAWSTRING)
                .unlockedBy("has_animal_hide", has(ModItems.ANIMALHIDE))
                .unlockedBy("has_straw_string", has(ModItems.STRAWSTRING))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HIDESHORTS.get())
                .pattern("S S")
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.ANIMALHIDE)
                .define('S', ModItems.STRAWSTRING)
                .unlockedBy("has_animal_hide", has(ModItems.ANIMALHIDE))
                .unlockedBy("has_straw_string", has(ModItems.STRAWSTRING))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HIDEBOOTS.get())
                .pattern("   ")
                .pattern("WSW")
                .pattern("#S#")
                .define('W', ItemTags.WOOL)
                .define('#', ModItems.ANIMALHIDE)
                .define('S', ModItems.STRAWSTRING)
                .unlockedBy("has_animal_hide", has(ModItems.ANIMALHIDE))
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .unlockedBy("has_straw_string", has(ModItems.STRAWSTRING))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNFIREDCLAYBUCKET.get())
                .pattern("   ")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STRAWSTRING.get())
                .pattern("  #")
                .pattern("# #")
                .pattern(" # ")
                .define('#', ModItems.STRAW)
                .unlockedBy("has_straw", has(ModItems.STRAW))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNREFINEDCRUCIBLE.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("###")
                .define('#', ModItems.FIRECLAYBALL)
                .unlockedBy("has_fireclay_ball", has(ModItems.FIRECLAYBALL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 2)
                .pattern("#  ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ItemTags.PLANKS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.CRAFTING_TABLE)
                .requires(ModBlocks.RUDIMENTARYCRAFTINGTABLE)
                .requires(ModItems.STARTERTOOLBOX)
                .unlockedBy("has_rudimentary_crafting_table", has(ModBlocks.RUDIMENTARYCRAFTINGTABLE))
                .unlockedBy("has_starter_toolbox", has(ModItems.STARTERTOOLBOX))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.OAK_PLANKS, 2)
                .requires(ItemTags.OAK_LOGS)
                .unlockedBy("has_oak_logs", has(ItemTags.OAK_LOGS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_PLANKS, 2)
                .requires(ItemTags.DARK_OAK_LOGS)
                .unlockedBy("has_dark_oak_logs", has(ItemTags.DARK_OAK_LOGS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_PLANKS, 2)
                .requires(ItemTags.ACACIA_LOGS)
                .unlockedBy("has_acacia_logs", has(ItemTags.ACACIA_LOGS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_PLANKS, 2)
                .requires(ItemTags.SPRUCE_LOGS)
                .unlockedBy("has_spruce_logs", has(ItemTags.SPRUCE_LOGS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_PLANKS, 2)
                .requires(ItemTags.BIRCH_LOGS)
                .unlockedBy("has_birch_logs", has(ItemTags.BIRCH_LOGS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_PLANKS, 2)
                .requires(ItemTags.JUNGLE_LOGS)
                .unlockedBy("has_jungle_logs", has(ItemTags.JUNGLE_LOGS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_PLANKS, 2)
                .requires(ItemTags.MANGROVE_LOGS)
                .unlockedBy("has_mangrove_logs", has(ItemTags.MANGROVE_LOGS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_PLANKS, 2)
                .requires(ItemTags.CHERRY_LOGS)
                .unlockedBy("has_cherry_logs", has(ItemTags.CHERRY_LOGS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_PLANKS, 2)
                .requires(ItemTags.CRIMSON_STEMS)
                .unlockedBy("has_crimson_stems", has(ItemTags.CRIMSON_STEMS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_PLANKS, 2)
                .requires(ItemTags.WARPED_STEMS)
                .unlockedBy("has_warped_stems", has(ItemTags.WARPED_STEMS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_PLANKS)
                .requires(ItemTags.BAMBOO_BLOCKS)
                .unlockedBy("has_bamboo_blocks", has(ItemTags.BAMBOO_BLOCKS))
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LEATHER)
                .requires(ModItems.SCRAPEDANIMALHIDE)
                .requires(ModItems.TREEBARK)
                .requires(ModTags.Items.WATERCONTAINERS)
                .unlockedBy("has_scraped_animal_hide", has(ModItems.SCRAPEDANIMALHIDE))
                .unlockedBy("has_tree_bark", has(ModItems.TREEBARK))
                .unlockedBy("has_water_container", has(ModTags.Items.WATERCONTAINERS))
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
                        .addCriterion("has_log", RecipeProvider.has(ModTags.Items.ALLTHEWOODITEM))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern2 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ItemTags.PLANKS),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        "#  ",
                        "#V ",
                        "   "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe2 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern2,
                new ItemStack(Items.STICK, 4)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw"),
                Mod_shaped_recipe2,
                recipeOutput.advancement()
                        .addCriterion("has_planks", RecipeProvider.has(ItemTags.PLANKS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw").withPrefix("recipes/"))
        );


        List<Ingredient> Mod_shapeless_ingredients1 = List.of(
                Ingredient.of(Items.COAL),
                Ingredient.of(ModTags.Items.HAMMERS)
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

        List<Ingredient> Mod_shapeless_ingredients2 = List.of(
                Ingredient.of(Items.CHARCOAL),
                Ingredient.of(ModTags.Items.HAMMERS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe2 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.COALPOWDER.get(), 2),
                Mod_shapeless_ingredients2
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "coal_powder1"),
                Mod_shapeless_recipe2,
                recipeOutput.advancement()
                        .addCriterion("has_charcoal", RecipeProvider.has(Items.CHARCOAL))
                        .addCriterion("has_primitive_hammer", RecipeProvider.has(ModItems.PRIMITIVEHAMMER.get()))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "coal_powder1").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients3 = List.of(
                Ingredient.of(Items.OAK_LOG),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe3 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_OAK_LOG),
                Mod_shapeless_ingredients3
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_oak_log"),
                Mod_shapeless_recipe3,
                recipeOutput.advancement()
                        .addCriterion("has_oak_log", RecipeProvider.has(Items.OAK_LOG))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_oak_log").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients4 = List.of(
                Ingredient.of(Items.DARK_OAK_LOG),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe4 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_DARK_OAK_LOG),
                Mod_shapeless_ingredients4
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_dark_oak_log"),
                Mod_shapeless_recipe4,
                recipeOutput.advancement()
                        .addCriterion("has_dark_oak_log", RecipeProvider.has(Items.DARK_OAK_LOG))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_dark_oak_log").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients5 = List.of(
                Ingredient.of(Items.SPRUCE_LOG),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe5 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_SPRUCE_LOG),
                Mod_shapeless_ingredients5
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_spruce_log"),
                Mod_shapeless_recipe5,
                recipeOutput.advancement()
                        .addCriterion("has_spruce_log", RecipeProvider.has(Items.SPRUCE_LOG))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_spruce_log").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients6 = List.of(
                Ingredient.of(Items.BIRCH_LOG),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe6 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_BIRCH_LOG),
                Mod_shapeless_ingredients6
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_birch_log"),
                Mod_shapeless_recipe6,
                recipeOutput.advancement()
                        .addCriterion("has_birch_log", RecipeProvider.has(Items.BIRCH_LOG))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_birch_log").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients7 = List.of(
                Ingredient.of(Items.JUNGLE_LOG),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe7 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_JUNGLE_LOG),
                Mod_shapeless_ingredients7
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_jungle_log"),
                Mod_shapeless_recipe7,
                recipeOutput.advancement()
                        .addCriterion("has_jungle_log", RecipeProvider.has(Items.JUNGLE_LOG))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_jungle_log").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients8 = List.of(
                Ingredient.of(Items.ACACIA_LOG),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe8 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_ACACIA_LOG),
                Mod_shapeless_ingredients8
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_acacia_log"),
                Mod_shapeless_recipe8,
                recipeOutput.advancement()
                        .addCriterion("has_acacia_log", RecipeProvider.has(Items.ACACIA_LOG))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_acacia_log").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients9 = List.of(
                Ingredient.of(Items.MANGROVE_LOG),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe9 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_MANGROVE_LOG),
                Mod_shapeless_ingredients9
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_mangrove_log"),
                Mod_shapeless_recipe9,
                recipeOutput.advancement()
                        .addCriterion("has_mangrove_log", RecipeProvider.has(Items.MANGROVE_LOG))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_mangrove_log").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients10 = List.of(
                Ingredient.of(Items.CHERRY_LOG),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe10 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_CHERRY_LOG),
                Mod_shapeless_ingredients10
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_cherry_log"),
                Mod_shapeless_recipe10,
                recipeOutput.advancement()
                        .addCriterion("has_cherry_log", RecipeProvider.has(Items.CHERRY_LOG))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_cherry_log").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients11 = List.of(
                Ingredient.of(Items.CRIMSON_STEM),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe11 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_CRIMSON_STEM),
                Mod_shapeless_ingredients11
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_crimson_stem"),
                Mod_shapeless_recipe11,
                recipeOutput.advancement()
                        .addCriterion("has_crimson_stem", RecipeProvider.has(Items.CRIMSON_STEM))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_crimson_stem").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients12 = List.of(
                Ingredient.of(Items.WARPED_STEM),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe12 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_WARPED_STEM),
                Mod_shapeless_ingredients12
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_warped_stem"),
                Mod_shapeless_recipe12,
                recipeOutput.advancement()
                        .addCriterion("has_warped_stem", RecipeProvider.has(Items.WARPED_STEM))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_warped_stem").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients13 = List.of(
                Ingredient.of(Items.OAK_WOOD),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe13 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_OAK_WOOD),
                Mod_shapeless_ingredients13
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_oak_wood"),
                Mod_shapeless_recipe13,
                recipeOutput.advancement()
                        .addCriterion("has_oak_wood", RecipeProvider.has(Items.OAK_WOOD))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_oak_wood").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients14 = List.of(
                Ingredient.of(Items.DARK_OAK_WOOD),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe14 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_DARK_OAK_WOOD),
                Mod_shapeless_ingredients14
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_dark_oak_wood"),
                Mod_shapeless_recipe14,
                recipeOutput.advancement()
                        .addCriterion("has_dark_oak_wood", RecipeProvider.has(Items.DARK_OAK_WOOD))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_dark_oak_wood").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients15 = List.of(
                Ingredient.of(Items.SPRUCE_WOOD),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe15 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_SPRUCE_WOOD),
                Mod_shapeless_ingredients15
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_spruce_wood"),
                Mod_shapeless_recipe15,
                recipeOutput.advancement()
                        .addCriterion("has_spruce_wood", RecipeProvider.has(Items.SPRUCE_WOOD))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_spruce_wood").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients16 = List.of(
                Ingredient.of(Items.BIRCH_WOOD),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe16 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_BIRCH_WOOD),
                Mod_shapeless_ingredients16
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_birch_wood"),
                Mod_shapeless_recipe16,
                recipeOutput.advancement()
                        .addCriterion("has_birch_wood", RecipeProvider.has(Items.BIRCH_WOOD))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_birch_wood").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients17 = List.of(
                Ingredient.of(Items.JUNGLE_WOOD),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe17 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_JUNGLE_WOOD),
                Mod_shapeless_ingredients17
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_jungle_wood"),
                Mod_shapeless_recipe17,
                recipeOutput.advancement()
                        .addCriterion("has_jungle_wood", RecipeProvider.has(Items.JUNGLE_WOOD))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_jungle_wood").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients18 = List.of(
                Ingredient.of(Items.ACACIA_WOOD),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe18 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_ACACIA_WOOD),
                Mod_shapeless_ingredients18
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_acacia_wood"),
                Mod_shapeless_recipe18,
                recipeOutput.advancement()
                        .addCriterion("has_acacia_wood", RecipeProvider.has(Items.ACACIA_WOOD))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_acacia_wood").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients19 = List.of(
                Ingredient.of(Items.MANGROVE_WOOD),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe19 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_MANGROVE_WOOD),
                Mod_shapeless_ingredients19
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_mangrove_wood"),
                Mod_shapeless_recipe19,
                recipeOutput.advancement()
                        .addCriterion("has_mangrove_wood", RecipeProvider.has(Items.MANGROVE_WOOD))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_mangrove_wood").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients20 = List.of(
                Ingredient.of(Items.CHERRY_WOOD),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe20 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_CHERRY_WOOD),
                Mod_shapeless_ingredients20
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_cherry_wood"),
                Mod_shapeless_recipe20,
                recipeOutput.advancement()
                        .addCriterion("has_cherry_wood", RecipeProvider.has(Items.CHERRY_WOOD))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_cherry_wood").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients21 = List.of(
                Ingredient.of(Items.CRIMSON_HYPHAE),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe21 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_CRIMSON_HYPHAE),
                Mod_shapeless_ingredients21
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_crimson_hyphae"),
                Mod_shapeless_recipe21,
                recipeOutput.advancement()
                        .addCriterion("has_crimson_hyphae", RecipeProvider.has(Items.CRIMSON_HYPHAE))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_crimson_hyphae").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients22 = List.of(
                Ingredient.of(Items.WARPED_HYPHAE),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe22 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.STRIPPED_WARPED_HYPHAE),
                Mod_shapeless_ingredients22
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_warped_hyphae"),
                Mod_shapeless_recipe22,
                recipeOutput.advancement()
                        .addCriterion("has_warped_hyphae", RecipeProvider.has(Items.WARPED_HYPHAE))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "stripped_warped_hyphae").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients23 = List.of(
                Ingredient.of(ModItems.ANIMALHIDE),
                Ingredient.of(ModTags.Items.KNIVES)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe23 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.SCRAPEDANIMALHIDE.get()),
                Mod_shapeless_ingredients23
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "scraped_animal_hide"),
                Mod_shapeless_recipe23,
                recipeOutput.advancement()
                        .addCriterion("has_animal_hide", RecipeProvider.has(ModItems.ANIMALHIDE))
                        .addCriterion("has_knife", RecipeProvider.has(ModTags.Items.KNIVES))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "scraped_animal_hide").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients24 = List.of(
                Ingredient.of(ItemTags.OAK_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe24 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.OAK_PLANKS, 4),
                Mod_shapeless_ingredients24
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "oak_planks_saw"),
                Mod_shapeless_recipe24,
                recipeOutput.advancement()
                        .addCriterion("has_oak_logs", RecipeProvider.has(ItemTags.OAK_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "oak_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients25 = List.of(
                Ingredient.of(ItemTags.DARK_OAK_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe25 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.DARK_OAK_PLANKS, 4),
                Mod_shapeless_ingredients25
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "dark_oak_planks_saw"),
                Mod_shapeless_recipe25,
                recipeOutput.advancement()
                        .addCriterion("has_dark_oak_logs", RecipeProvider.has(ItemTags.DARK_OAK_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "dark_oak_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients26 = List.of(
                Ingredient.of(ItemTags.SPRUCE_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe26 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.BIRCH_PLANKS, 4),
                Mod_shapeless_ingredients26
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "birch_planks_saw"),
                Mod_shapeless_recipe26,
                recipeOutput.advancement()
                        .addCriterion("has_birch_logs", RecipeProvider.has(ItemTags.BIRCH_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "birch_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients27 = List.of(
                Ingredient.of(ItemTags.JUNGLE_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe27 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.JUNGLE_PLANKS, 4),
                Mod_shapeless_ingredients27
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "jungle_planks_saw"),
                Mod_shapeless_recipe27,
                recipeOutput.advancement()
                        .addCriterion("has_jungle_logs", RecipeProvider.has(ItemTags.JUNGLE_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "jungle_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients28 = List.of(
                Ingredient.of(ItemTags.ACACIA_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe28 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.ACACIA_PLANKS, 4),
                Mod_shapeless_ingredients28
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "acacia_planks_saw"),
                Mod_shapeless_recipe28,
                recipeOutput.advancement()
                        .addCriterion("has_acacia_logs", RecipeProvider.has(ItemTags.ACACIA_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "acacia_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients29 = List.of(
                Ingredient.of(ItemTags.MANGROVE_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe29 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.MANGROVE_PLANKS, 4),
                Mod_shapeless_ingredients29
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "mangrove_planks_saw"),
                Mod_shapeless_recipe29,
                recipeOutput.advancement()
                        .addCriterion("has_mangrove_logs", RecipeProvider.has(ItemTags.MANGROVE_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "mangrove_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients30 = List.of(
                Ingredient.of(ItemTags.CHERRY_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe30 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.CHERRY_PLANKS, 4),
                Mod_shapeless_ingredients30
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "cherry_planks_saw"),
                Mod_shapeless_recipe30,
                recipeOutput.advancement()
                        .addCriterion("has_cherry_logs", RecipeProvider.has(ItemTags.CHERRY_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "cherry_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients31 = List.of(
                Ingredient.of(ItemTags.CRIMSON_STEMS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe31 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.CRIMSON_PLANKS, 4),
                Mod_shapeless_ingredients31
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "crimson_planks_saw"),
                Mod_shapeless_recipe31,
                recipeOutput.advancement()
                        .addCriterion("has_crimson_stem", RecipeProvider.has(ItemTags.CRIMSON_STEMS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "crimson_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients32 = List.of(
                Ingredient.of(ItemTags.WARPED_STEMS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe32 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.WARPED_PLANKS, 4),
                Mod_shapeless_ingredients32
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "warped_planks_saw"),
                Mod_shapeless_recipe32,
                recipeOutput.advancement()
                        .addCriterion("has_warped_stem", RecipeProvider.has(ItemTags.WARPED_STEMS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "warped_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients33 = List.of(
                Ingredient.of(ItemTags.BAMBOO_BLOCKS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe33 = new ModCustomCraftingShapeless(
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.BAMBOO_PLANKS, 2),
                Mod_shapeless_ingredients33
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath("minecraft", "bamboo_planks_saw"),
                Mod_shapeless_recipe33,
                recipeOutput.advancement()
                        .addCriterion("has_bamboo_block", RecipeProvider.has(ItemTags.BAMBOO_BLOCKS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath("minecraft", "bamboo_planks_saw").withPrefix("recipes/"))
        );

        oreSmelting(recipeOutput, SALTED_BEEF_INGREDIENT, RecipeCategory.FOOD, ModItems.SALTEDCOOKEDBEEF.get(), 0.4f, 200, "salted_cooked_beef");

        campfireCooking(recipeOutput, SALTED_BEEF_INGREDIENT,RecipeCategory.FOOD, ModItems.SALTEDCOOKEDBEEF.get(), 0.4f, 600, "salted_cooked_beef");

        oreSmelting(recipeOutput, CERAMIC_BUCKET_INGREDIENTS, RecipeCategory.MISC, ModItems.CERAMICBUCKET.get(), 0.5f, 300, "ceramic_bucket");

        campfireCooking(recipeOutput, CERAMIC_BUCKET_INGREDIENTS,RecipeCategory.MISC, ModItems.CERAMICBUCKET.get(), 0.5f, 900, "ceramic_bucket");

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
