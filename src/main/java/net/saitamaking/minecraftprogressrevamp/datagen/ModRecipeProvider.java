package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;
import net.saitamaking.minecraftprogressrevamp.recipe.*;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHARCOALBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.CHARCOAL)
                .unlockedBy("has_charcoal", has(Items.CHARCOAL))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.SHARPPEBBLE.get())
                .requires(ModItems.LOOSEPEBBLE)
                .requires(ModItems.LOOSEPEBBLE)
                .unlockedBy("has_loose_pebble", has(ModItems.LOOSEPEBBLE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.FIRESTARTER.get())
                .requires(ModItems.STRAW)
                .requires(Items.STICK)
                .unlockedBy("has_straw", has(ModItems.STRAW))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CHEST)
                .pattern("#O#")
                .pattern("X X")
                .pattern("#X#")
                .define('#', ModTags.Items.ALLTHEWOODITEM)
                .define('X', ModBlocks.WOODENCRATE)
                .define('O', Items.IRON_INGOT)
                .unlockedBy("has_logs", has(ModTags.Items.ALLTHEWOODITEM))
                .unlockedBy("has_wooden_crate", has(ModBlocks.WOODENCRATE))
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.BARREL)
                .pattern("#E#")
                .pattern("#O#")
                .pattern("#E#")
                .define('#', ItemTags.PLANKS)
                .define('E', ItemTags.WOODEN_SLABS)
                .define('O', Items.CHEST)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .unlockedBy("has_wooden_slabs", has(ItemTags.WOODEN_SLABS))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COPPERBARBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GOLDBARBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.GOLD_INGOT)
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRONBARBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSEGOLDBARBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.ROSEGOLDINGOT)
                .unlockedBy("has_rose_gold_ingot", has(ModItems.ROSEGOLDINGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHERITEBARBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.NETHERITE_INGOT)
                .unlockedBy("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBBLESTONEANVIL.get())
                .pattern("---")
                .pattern(" # ")
                .pattern("###")
                .define('#', Items.COBBLESTONE)
                .define('-', Items.COBBLESTONE_SLAB)
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .unlockedBy("has_cobblestone_slab", has(Items.COBBLESTONE_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPERNAIL.get())
                .pattern(" #X")
                .pattern(" ##")
                .pattern("#  ")
                .define('#', ModItems.SMALLMELTEDCOPPERBLOB.get())
                .define('X', ModItems.NAILSANDMOLD.get())
                .unlockedBy("has_small_melted_copper_blob", has(ModItems.SMALLMELTEDCOPPERBLOB))
                .unlockedBy("has_nail_sand_mold", has(ModItems.NAILSANDMOLD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPERNAIL.get())
                .pattern("#  ")
                .pattern(" ##")
                .pattern(" #X")
                .define('#', ModItems.SMALLMELTEDCOPPERBLOB.get())
                .define('X', ModItems.NAILSANDMOLD.get())
                .unlockedBy("has_small_melted_copper_blob", has(ModItems.SMALLMELTEDCOPPERBLOB))
                .unlockedBy("has_nail_sand_mold", has(ModItems.NAILSANDMOLD))
                .save(recipeOutput, "copper_nail1");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRONNAIL.get())
                .pattern(" #X")
                .pattern(" ##")
                .pattern("#  ")
                .define('#', ModItems.SMALLMELTEDIRONBLOB.get())
                .define('X', ModItems.NAILSANDMOLD.get())
                .unlockedBy("has_small_melted_iron_blob", has(ModItems.SMALLMELTEDIRONBLOB))
                .unlockedBy("has_nail_sand_mold", has(ModItems.NAILSANDMOLD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRONNAIL.get())
                .pattern("#  ")
                .pattern(" ##")
                .pattern(" #X")
                .define('#', ModItems.SMALLMELTEDIRONBLOB.get())
                .define('X', ModItems.NAILSANDMOLD.get())
                .unlockedBy("has_small_melted_iron_blob", has(ModItems.SMALLMELTEDIRONBLOB))
                .unlockedBy("has_nail_sand_mold", has(ModItems.NAILSANDMOLD))
                .save(recipeOutput, "iron_nail1");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WOODENCRATE.get())
                .pattern("---")
                .pattern("# #")
                .pattern("###")
                .define('#', ItemTags.PLANKS)
                .define('-', ItemTags.WOODEN_SLABS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .unlockedBy("has_wooden_slabs", has(ItemTags.WOODEN_SLABS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COPPERCRATE.get())
                .pattern("T#T")
                .pattern("#X#")
                .pattern("T#T")
                .define('#', ModTags.Items.COPPERPLATES)
                .define('T', ModItems.COPPERNAIL)
                .define('X', ModBlocks.WOODENCRATE)
                .unlockedBy("has_copper_plates", has(ModTags.Items.COPPERPLATES))
                .unlockedBy("has_wooden_crate", has(ModBlocks.WOODENCRATE))
                .unlockedBy("has_copper_nail", has(ModItems.COPPERNAIL))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 9)
                .requires(ModBlocks.COPPERBARBLOCK)
                .unlockedBy("has_copper_bar_block", has(ModBlocks.COPPERBARBLOCK))
                .save(recipeOutput, "minecraftprogressrevamp:copper_bar_block_to_ingots");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_INGOT, 9)
                .requires(ModBlocks.GOLDBARBLOCK)
                .unlockedBy("has_gold_bar_block", has(ModBlocks.GOLDBARBLOCK))
                .save(recipeOutput, "minecraftprogressrevamp:gold_bar_block_to_ingots");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_INGOT, 9)
                .requires(ModBlocks.IRONBARBLOCK)
                .unlockedBy("has_iron_bar_block", has(ModBlocks.IRONBARBLOCK))
                .save(recipeOutput, "minecraftprogressrevamp:iron_bar_block_to_ingots");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROSEGOLDINGOT, 9)
                .requires(ModBlocks.ROSEGOLDBARBLOCK)
                .unlockedBy("has_rose_gold_bar_block", has(ModBlocks.ROSEGOLDBARBLOCK))
                .save(recipeOutput, "minecraftprogressrevamp:rose_gold_bar_block_to_ingots");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHERITE_INGOT, 9)
                .requires(ModBlocks.NETHERITEBARBLOCK)
                .unlockedBy("has_netherite_bar_block", has(ModBlocks.NETHERITEBARBLOCK))
                .save(recipeOutput, "minecraftprogressrevamp:netherite_bar_block_to_ingots");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NAILSANDMOLD.get())
                .requires(ModItems.EMPTYSANDMOLD)
                .requires(Items.STICK)
                .unlockedBy("has_empty_sand_mold", has(ModItems.EMPTYSANDMOLD))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT)
                .requires(ModItems.INGOTSANDMOLD)
                .requires(ModItems.MELTEDCOPPERBLOB)
                .unlockedBy("has_ingot_sand_mold", has(ModItems.INGOTSANDMOLD))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_INGOT)
                .requires(ModItems.INGOTSANDMOLD)
                .requires(ModItems.MELTEDGOLDBLOB)
                .unlockedBy("has_ingot_sand_mold", has(ModItems.INGOTSANDMOLD))
                .unlockedBy("has_melted_gold_blob", has(ModItems.MELTEDGOLDBLOB))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_INGOT)
                .requires(ModItems.INGOTSANDMOLD)
                .requires(ModItems.MELTEDIRONBLOB)
                .unlockedBy("has_ingot_sand_mold", has(ModItems.INGOTSANDMOLD))
                .unlockedBy("has_melted_iron_blob", has(ModItems.MELTEDIRONBLOB))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROSEGOLDINGOT)
                .requires(ModItems.INGOTSANDMOLD)
                .requires(ModItems.MELTEDROSEGOLDBLOB)
                .unlockedBy("has_ingot_sand_mold", has(ModItems.INGOTSANDMOLD))
                .unlockedBy("has_melted_rose_gold_blob", has(ModItems.MELTEDROSEGOLDBLOB))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPERNUGGET)
                .requires(ModItems.NUGGETSANDMOLD)
                .requires(ModItems.SMALLMELTEDCOPPERBLOB)
                .unlockedBy("has_nugget_sand_mold", has(ModItems.NUGGETSANDMOLD))
                .unlockedBy("has_small_melted_copper_blob", has(ModItems.SMALLMELTEDCOPPERBLOB))
                .save(recipeOutput,"coppper_nugget_sand_mold");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_NUGGET)
                .requires(ModItems.NUGGETSANDMOLD)
                .requires(ModItems.SMALLMELTEDGOLDBLOB)
                .unlockedBy("has_nugget_sand_mold", has(ModItems.NUGGETSANDMOLD))
                .unlockedBy("has_small_melted_gold_blob", has(ModItems.SMALLMELTEDGOLDBLOB))
                .save(recipeOutput,"gold_nugget_sand_mold");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_NUGGET)
                .requires(ModItems.NUGGETSANDMOLD)
                .requires(ModItems.SMALLMELTEDIRONBLOB)
                .unlockedBy("has_nugget_sand_mold", has(ModItems.NUGGETSANDMOLD))
                .unlockedBy("has_small_melted_iron_blob", has(ModItems.SMALLMELTEDIRONBLOB))
                .save(recipeOutput,"iron_nugget_sand_mold");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROSEGOLDNUGGET)
                .requires(ModItems.NUGGETSANDMOLD)
                .requires(ModItems.SMALLMELTEDROSEGOLDBLOB)
                .unlockedBy("has_nugget_sand_mold", has(ModItems.NUGGETSANDMOLD))
                .unlockedBy("has_small_melted_rose_gold_blob", has(ModItems.SMALLMELTEDROSEGOLDBLOB))
                .save(recipeOutput,"rose_gold_nugget_sand_mold");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MELTEDCOPPERBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.MELTEDCOPPERBLOB)
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MELTEDGOLDBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.MELTEDGOLDBLOB)
                .unlockedBy("has_melted_gold_blob", has(ModItems.MELTEDGOLDBLOB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MELTEDIRONBLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.MELTEDIRONBLOB)
                .unlockedBy("has_melted_iron_blob", has(ModItems.MELTEDIRONBLOB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MELTEDCOPPERBLOB.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SMALLMELTEDCOPPERBLOB)
                .unlockedBy("has_small_melted_copper_blob", has(ModItems.SMALLMELTEDCOPPERBLOB))
                .save(recipeOutput, "melted_copper_blob_compacting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MELTEDGOLDBLOB.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SMALLMELTEDGOLDBLOB)
                .unlockedBy("has_small_melted_gold_blob", has(ModItems.SMALLMELTEDGOLDBLOB))
                .save(recipeOutput, "melted_gold_blob_compacting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MELTEDIRONBLOB.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SMALLMELTEDIRONBLOB)
                .unlockedBy("has_small_melted_iron_blob", has(ModItems.SMALLMELTEDIRONBLOB))
                .save(recipeOutput, "melted_iron_blob_compacting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MELTEDROSEGOLDBLOB.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SMALLMELTEDROSEGOLDBLOB)
                .unlockedBy("has_small_melted_rose_gold_blob", has(ModItems.SMALLMELTEDROSEGOLDBLOB))
                .save(recipeOutput, "melted_rose_gold_blob_compacting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SMALLMELTEDCOPPERBLOB.get(), 9)
                .requires(ModItems.MELTEDCOPPERBLOB)
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MELTEDCOPPERBLOB.get(), 9)
                .requires(ModBlocks.MELTEDCOPPERBLOCK)
                .unlockedBy("has_melted_copper_block", has(ModBlocks.MELTEDCOPPERBLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SMALLMELTEDGOLDBLOB.get(), 9)
                .requires(ModItems.MELTEDGOLDBLOB)
                .unlockedBy("has_melted_gold_blob", has(ModItems.MELTEDGOLDBLOB))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SMALLMELTEDROSEGOLDBLOB.get(), 9)
                .requires(ModItems.MELTEDROSEGOLDBLOB)
                .unlockedBy("has_melted_rose_gold_blob", has(ModItems.MELTEDROSEGOLDBLOB))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MELTEDGOLDBLOB.get(), 9)
                .requires(ModBlocks.MELTEDGOLDBLOCK)
                .unlockedBy("has_melted_gold_block", has(ModBlocks.MELTEDGOLDBLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SMALLMELTEDIRONBLOB.get(), 9)
                .requires(ModItems.MELTEDIRONBLOB)
                .unlockedBy("has_melted_iron_blob", has(ModItems.MELTEDIRONBLOB))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MELTEDIRONBLOB.get(), 9)
                .requires(ModBlocks.MELTEDIRONBLOCK)
                .unlockedBy("has_melted_iron_block", has(ModBlocks.MELTEDIRONBLOCK))
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ABRASIVEDUST.get(), 2)
                .requires(Items.SAND)
                .requires(ModItems.CERAMICDUST)
                .unlockedBy("has_sand", has(Items.SAND))
                .unlockedBy("has_ceramic_dust", has(ModItems.CERAMICDUST))
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LEATHERSTICK.get())
                .pattern(" # ")
                .pattern(" / ")
                .pattern(" # ")
                .define('#', Items.LEATHER)
                .define('/', Items.STICK)
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_leather", has(Items.LEATHER))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CAMPFIRE)
                .pattern("XXX")
                .pattern("/O/")
                .pattern(" / ")
                .define('O', ItemTags.COALS)
                .define('X', ItemTags.LOGS)
                .define('/', Items.STICK)
                .unlockedBy("has_coals", has(ItemTags.COALS))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_logs", has(ItemTags.LOGS))
                .save(recipeOutput, "campfire_upside_down");

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
                .pattern(" X ")
                .pattern("/ X")
                .pattern("O/ ")
                .define('O', ModItems.WOODENHANDLE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('/', Items.STICK)
                .unlockedBy("has_wooden_handle", has(ModItems.WOODENHANDLE))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput, "minecraftprogressrevamp:primitive_shears_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PRIMITIVEKNIFE.get())
                .pattern("X  ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', Items.STICK)
                .define('X', ModItems.SHARPPEBBLE)
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .save(recipeOutput);

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CLAYBRICK.get(),4)
                .pattern("   ")
                .pattern("###")
                .pattern("   ")
                .define('#', Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOODENHANDLE.get())
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Items.STICK)
                .unlockedBy("has_stick", has(Items.STICK))
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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERAXE)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERAXEHEAD)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_axe_head", has(ModItems.COPPERAXEHEAD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERPICKAXE)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERPICKAXEHEAD)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_pickaxe_head", has(ModItems.COPPERPICKAXEHEAD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERHOE)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERHOEHEAD)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_hoe_head", has(ModItems.COPPERHOEHEAD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERSHOVEL)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERSHOVELHEAD)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_shovel_head", has(ModItems.COPPERSHOVELHEAD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPERSWORD)
                .pattern("  /")
                .pattern(" X ")
                .pattern("#  ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERCROSSGUARD)
                .define('/', ModItems.COPPERSWORDHEAD)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_cross_guard", has(ModItems.COPPERCROSSGUARD))
                .unlockedBy("has_copper_sword_head", has(ModItems.COPPERSWORDHEAD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERSAW)
                .pattern("  X")
                .pattern(" # ")
                .pattern("O  ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERSAWBLADE)
                .define('O', ModItems.WOODENHANDLE)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_saw_blade", has(ModItems.COPPERSAWBLADE))
                .unlockedBy("has_wooden_handle", has(ModItems.WOODENHANDLE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERHAMMER)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERHAMMERHEAD)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_hammer_head", has(ModItems.COPPERHAMMERHEAD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERCHISEL)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERCHISELBLADE)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_chisel_blade", has(ModItems.COPPERCHISELBLADE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERKNIFE)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERSMALLBLADE)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_small_blade", has(ModItems.COPPERSMALLBLADE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERKNIFE)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.COPPERKNIFE)
                .define('X', ModItems.COPPERSMALLBLADE)
                .unlockedBy("has_copper_knife", has(ModItems.COPPERKNIFE))
                .unlockedBy("has_copper_small_blade", has(ModItems.COPPERSMALLBLADE))
                .save(recipeOutput,"copper_knife_blade_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERSAW)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.COPPERSAW)
                .define('X', ModItems.COPPERSAWBLADE)
                .unlockedBy("has_copper_saw", has(ModItems.COPPERSAW))
                .unlockedBy("has_copper_saw_blade", has(ModItems.COPPERSAWBLADE))
                .save(recipeOutput,"copper_saw_blade_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERHAMMER)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.COPPERHAMMER)
                .define('X', ModItems.COPPERHAMMERHEAD)
                .unlockedBy("has_copper_hammer", has(ModItems.COPPERHAMMER))
                .unlockedBy("has_copper_hammer_head", has(ModItems.COPPERHAMMERHEAD))
                .save(recipeOutput,"copper_hammer_head_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERCHISEL)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.COPPERCHISEL)
                .define('X', ModItems.COPPERCHISELBLADE)
                .unlockedBy("has_copper_chisel", has(ModItems.COPPERCHISEL))
                .unlockedBy("has_copper_chisel_blade", has(ModItems.COPPERCHISELBLADE))
                .save(recipeOutput,"copper_chisel_blade_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERSHEARS)
                .pattern("X  ")
                .pattern("#X ")
                .pattern("   ")
                .define('#', ModItems.COPPERSHEARS)
                .define('X', ModItems.COPPERSMALLBLADE)
                .unlockedBy("has_copper_shears", has(ModItems.COPPERSHEARS))
                .unlockedBy("has_copper_small_blade", has(ModItems.COPPERSMALLBLADE))
                .save(recipeOutput,"copper_shears_blade_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERPICKAXE)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.COPPERPICKAXE)
                .define('X', ModItems.COPPERPICKAXEHEAD)
                .unlockedBy("has_copper_pickaxe", has(ModItems.COPPERPICKAXE))
                .unlockedBy("has_copper_pickaxe_head", has(ModItems.COPPERPICKAXEHEAD))
                .save(recipeOutput,"copper_pickaxe_head_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERAXE)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.COPPERAXE)
                .define('X', ModItems.COPPERAXEHEAD)
                .unlockedBy("has_copper_axe", has(ModItems.COPPERAXE))
                .unlockedBy("has_copper_axe_head", has(ModItems.COPPERAXEHEAD))
                .save(recipeOutput,"copper_axe_head_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERSHOVEL)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.COPPERSHOVEL)
                .define('X', ModItems.COPPERSHOVELHEAD)
                .unlockedBy("has_copper_shovel", has(ModItems.COPPERSHOVEL))
                .unlockedBy("has_copper_shovel_head", has(ModItems.COPPERSHOVELHEAD))
                .save(recipeOutput,"copper_shovel_head_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERHOE)
                .pattern(" X ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', ModItems.COPPERHOE)
                .define('X', ModItems.COPPERHOEHEAD)
                .unlockedBy("has_copper_hoe", has(ModItems.COPPERHOE))
                .unlockedBy("has_copper_hoe_head", has(ModItems.COPPERHOEHEAD))
                .save(recipeOutput,"copper_hoe_head_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERSWORD)
                .pattern("  /")
                .pattern(" X ")
                .pattern("#  ")
                .define('#', ModItems.COPPERSWORD)
                .define('X', ModItems.COPPERCROSSGUARD)
                .define('/', ModItems.COPPERSWORDHEAD)
                .unlockedBy("has_copper_sword", has(ModItems.COPPERSWORD))
                .unlockedBy("has_copper_sword_head", has(ModItems.COPPERSWORDHEAD))
                .unlockedBy("has_copper_crossguard", has(ModItems.COPPERCROSSGUARD))
                .save(recipeOutput,"copper_sword_head_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPERSHEARS)
                .pattern(" X ")
                .pattern("# X")
                .pattern("O# ")
                .define('#', ModItems.LEATHERSTICK)
                .define('X', ModItems.COPPERSMALLBLADE)
                .define('O', ModItems.WOODENHANDLE)
                .unlockedBy("has_leather_stick", has(ModItems.LEATHERSTICK))
                .unlockedBy("has_copper_small_blade", has(ModItems.COPPERSMALLBLADE))
                .unlockedBy("has_wooden_handle", has(ModItems.WOODENHANDLE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STARTERTOOLBOX)
                .pattern("X#X")
                .pattern("#O#")
                .pattern("X#X")
                .define('#', Items.COBBLESTONE)
                .define('X', ModItems.SHARPPEBBLE)
                .define('O', ModItems.STARTERTOOLBOX)
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .unlockedBy("has_starter_toolbox", has(ModItems.STARTERTOOLBOX))
                .save(recipeOutput,"starter_toolbox_tool_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.INTERMEDIATETOOLBOX)
                .pattern("X X")
                .pattern("KOT")
                .pattern(" Y ")
                .define('K', ModItems.COPPERSAWBLADE)
                .define('Y', ModItems.COPPERCHISELBLADE)
                .define('T', ModItems.COPPERHAMMERHEAD)
                .define('X', ModItems.COPPERSMALLBLADE)
                .define('O', ModItems.INTERMEDIATETOOLBOX)
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .unlockedBy("has_sharp_pebble", has(ModItems.SHARPPEBBLE))
                .unlockedBy("has_intermediate_toolbox", has(ModItems.INTERMEDIATETOOLBOX))
                .save(recipeOutput,"intermediate_toolbox_tool_replacing");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CRANIUMSMITHINGTEMPLATE, 2)
                .pattern("OXO")
                .pattern("O#O")
                .pattern("OOO")
                .define('#', Items.DEEPSLATE)
                .define('X', ModItems.CRANIUMSMITHINGTEMPLATE)
                .define('O', Items.DIAMOND)
                .unlockedBy("has_cranium_smithing_template", has(ModItems.CRANIUMSMITHINGTEMPLATE))
                .unlockedBy("has_deepslate", has(Items.DEEPSLATE))
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.RUDIMENTARYCRAFTINGTABLE)
                .requires(ModBlocks.PRIMITIVECRAFTINGTABLE)
                .requires(ModItems.PRIMITIVEAXE)
                .unlockedBy("has_primitive_crafting_table", has(ModBlocks.PRIMITIVECRAFTINGTABLE))
                .unlockedBy("has_primitive_axe", has(ModItems.PRIMITIVEAXE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CRAFTING_TABLE)
                .requires(ModBlocks.RUDIMENTARYCRAFTINGTABLE)
                .requires(ModItems.STARTERTOOLBOX)
                .unlockedBy("has_rudimentary_crafting_table", has(ModBlocks.RUDIMENTARYCRAFTINGTABLE))
                .unlockedBy("has_starter_toolbox", has(ModItems.STARTERTOOLBOX))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.INTERMEDIATECRAFTINGTABLE)
                .requires(Blocks.CRAFTING_TABLE)
                .requires(ModItems.INTERMEDIATETOOLBOX)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .unlockedBy("has_intermediate_toolbox", has(ModItems.INTERMEDIATETOOLBOX))
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAWSALTEDCHICKEN.get())
                .requires(Items.CHICKEN)
                .requires(ModItems.SALT)
                .unlockedBy("has_chicken", has(Items.CHICKEN))
                .unlockedBy("has_salt", has(ModItems.SALT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAWSALTEDPORKCHOPS.get())
                .requires(Items.PORKCHOP)
                .requires(ModItems.SALT)
                .unlockedBy("has_porkchop", has(Items.PORKCHOP))
                .unlockedBy("has_salt", has(ModItems.SALT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAWSALTEDMUTTON.get())
                .requires(Items.MUTTON)
                .requires(ModItems.SALT)
                .unlockedBy("has_mutton", has(Items.MUTTON))
                .unlockedBy("has_salt", has(ModItems.SALT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAWSALTEDRABBIT.get())
                .requires(Items.RABBIT)
                .requires(ModItems.SALT)
                .unlockedBy("has_rabbit", has(Items.RABBIT))
                .unlockedBy("has_salt", has(ModItems.SALT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAWSALTEDCOD.get())
                .requires(Items.COD)
                .requires(ModItems.SALT)
                .unlockedBy("has_cod", has(Items.COD))
                .unlockedBy("has_salt", has(ModItems.SALT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAWSALTEDSALMON.get())
                .requires(Items.SALMON)
                .requires(ModItems.SALT)
                .unlockedBy("has_salmon", has(Items.SALMON))
                .unlockedBy("has_salt", has(ModItems.SALT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CAMPFIREWITHCRUCIBLE.get())
                .requires(Items.CAMPFIRE)
                .requires(ModItems.REFINEDCRUCIBLE)
                .unlockedBy("has_campfire", has(Items.CAMPFIRE))
                .unlockedBy("has_refined_crucible", has(ModItems.REFINEDCRUCIBLE))
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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.INTERMEDIATETOOLBOX.get())
                .pattern("TYT")
                .pattern("F#P")
                .pattern("TUT")
                .define('F', ModItems.COPPERSAW)
                .define('U', ModItems.COPPERSHEARS)
                .define('Y', ModItems.COPPERCHISEL)
                .define('P', ModItems.COPPERHAMMER)
                .define('T', ModItems.COPPERNAIL)
                .define('#', ModBlocks.SMALLOAKBOX)
                .unlockedBy("has_copper_hammer", has(ModItems.COPPERHAMMER))
                .unlockedBy("has_copper_chisel", has(ModItems.COPPERCHISEL))
                .unlockedBy("has_copper_saw", has(ModItems.COPPERSAW))
                .unlockedBy("has_copper_shears", has(ModItems.COPPERSHEARS))
                .unlockedBy("has_copper_nail", has(ModItems.COPPERNAIL))
                .unlockedBy("has_small_oak_box", has(ModBlocks.SMALLOAKBOX))
                .save(recipeOutput, "intermediate_toolbox");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STARTERTOOLBOX.get())
                .pattern("S S")
                .pattern("X#H")
                .pattern(" U ")
                .define('S', ModItems.STRAWSTRING)
                .define('#', Items.LEATHER)
                .define('X', ModItems.PRIMITIVESAW)
                .define('U', ModItems.PRIMITIVESHEARS)
                .define('H', ModItems.PRIMITIVEHAMMER)
                .unlockedBy("has_straw_string", has(ModItems.STRAWSTRING))
                .unlockedBy("has_leather", has(Items.LEATHER))
                .unlockedBy("has_primitive_saw", has(ModItems.PRIMITIVESAW))
                .unlockedBy("has_primitive_shears", has(ModItems.PRIMITIVESHEARS))
                .unlockedBy("has_primitive_hammer", has(ModItems.PRIMITIVEHAMMER))
                .save(recipeOutput, "starter_toolbox1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.FISHING_ROD)
                .define('#', Items.STICK)
                .define('X', ModItems.STRAWSTRING)
                .pattern("  #")
                .pattern(" #X")
                .pattern("# X")
                .unlockedBy("has_straw_string", has(ModItems.STRAWSTRING))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput, "fishing_rod1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.LEAD)
                .define('~', ModItems.STRAWSTRING)
                .define('O', Items.SLIME_BALL)
                .pattern("~~ ")
                .pattern("~O ")
                .pattern("  ~")
                .unlockedBy("has_slime_ball", has(Items.SLIME_BALL))
                .unlockedBy("has_straw_string", has(ModItems.STRAWSTRING))
                .save(recipeOutput, "lead_straw");

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

        ShapedRecipePattern Mod_shaped_pattern8 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModTags.Items.ALLTHEWOODITEM),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        "V# ",
                        " # ",
                        "   "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe8 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern8,
                new ItemStack(Items.STICK, 16)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw2"),
                Mod_shaped_recipe8,
                recipeOutput.advancement()
                        .addCriterion("has_log", RecipeProvider.has(ModTags.Items.ALLTHEWOODITEM))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw2").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern9 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModTags.Items.ALLTHEWOODITEM),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        " # ",
                        " # ",
                        " V "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe9 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern9,
                new ItemStack(Items.STICK, 16)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw3"),
                Mod_shaped_recipe9,
                recipeOutput.advancement()
                        .addCriterion("has_log", RecipeProvider.has(ModTags.Items.ALLTHEWOODITEM))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw3").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern10 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModTags.Items.ALLTHEWOODITEM),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        " V ",
                        " # ",
                        " # "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe10 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern10,
                new ItemStack(Items.STICK, 16)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw4"),
                Mod_shaped_recipe10,
                recipeOutput.advancement()
                        .addCriterion("has_log", RecipeProvider.has(ModTags.Items.ALLTHEWOODITEM))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw4").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern11 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModTags.Items.ALLTHEWOODITEM),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        "V  ",
                        " # ",
                        " # "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe11 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern11,
                new ItemStack(Items.STICK, 16)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw5"),
                Mod_shaped_recipe11,
                recipeOutput.advancement()
                        .addCriterion("has_log", RecipeProvider.has(ModTags.Items.ALLTHEWOODITEM))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw5").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern12 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModTags.Items.ALLTHEWOODITEM),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        " # ",
                        " # ",
                        "V  "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe12 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern12,
                new ItemStack(Items.STICK, 16)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw6"),
                Mod_shaped_recipe12,
                recipeOutput.advancement()
                        .addCriterion("has_log", RecipeProvider.has(ModTags.Items.ALLTHEWOODITEM))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "logs_to_sticks_with_saw6").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern13 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ItemTags.PLANKS),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        "V# ",
                        " # ",
                        "   "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe13 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern13,
                new ItemStack(Items.STICK, 4)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw2"),
                Mod_shaped_recipe13,
                recipeOutput.advancement()
                        .addCriterion("has_planks", RecipeProvider.has(ItemTags.PLANKS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw2").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern14 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ItemTags.PLANKS),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        " V ",
                        " # ",
                        " # "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe14 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern14,
                new ItemStack(Items.STICK, 4)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw3"),
                Mod_shaped_recipe14,
                recipeOutput.advancement()
                        .addCriterion("has_planks", RecipeProvider.has(ItemTags.PLANKS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw3").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern15 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ItemTags.PLANKS),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        " # ",
                        " # ",
                        " V "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe15 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern15,
                new ItemStack(Items.STICK, 4)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw4"),
                Mod_shaped_recipe15,
                recipeOutput.advancement()
                        .addCriterion("has_planks", RecipeProvider.has(ItemTags.PLANKS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw4").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern16 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ItemTags.PLANKS),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        "V  ",
                        " # ",
                        " # "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe16 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern16,
                new ItemStack(Items.STICK, 4)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw5"),
                Mod_shaped_recipe16,
                recipeOutput.advancement()
                        .addCriterion("has_planks", RecipeProvider.has(ItemTags.PLANKS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw5").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern17 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ItemTags.PLANKS),
                        'V', Ingredient.of(ModTags.Items.SAWS)
                ),
                List.of(
                        " # ",
                        " # ",
                        "V  "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe17 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern17,
                new ItemStack(Items.STICK, 4)
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw6"),
                Mod_shaped_recipe17,
                recipeOutput.advancement()
                        .addCriterion("has_planks", RecipeProvider.has(ItemTags.PLANKS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "planks_to_sticks_with_saw6").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern18 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ItemTags.PLANKS),
                        '-', Ingredient.of(ItemTags.WOODEN_SLABS),
                        'T', Ingredient.of(ModTags.Items.CHISELS)
                ),
                List.of(
                        " - ",
                        " T ",
                        " # "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe18 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern18,
                new ItemStack(ModBlocks.SMALLOAKBOX.get())
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "small_box"),
                Mod_shaped_recipe18,
                recipeOutput.advancement()
                        .addCriterion("has_planks", RecipeProvider.has(ItemTags.PLANKS))
                        .addCriterion("has_wooden_slabs", RecipeProvider.has(ItemTags.WOODEN_SLABS))
                        .addCriterion("has_chisel", RecipeProvider.has(ModTags.Items.CHISELS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "small_box").withPrefix("recipes/"))
        );


        ShapedRecipePattern Mod_shaped_pattern19 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModItems.NAILGOLDMOLD),
                        'O', Ingredient.of(ModItems.SMALLMELTEDCOPPERBLOB)
                ),
                List.of(
                        " O#",
                        " OO",
                        "O  "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe19 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern19,
                new ItemStack(ModItems.COPPERNAIL.get())
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "copper_nail_gold_mold1"),
                Mod_shaped_recipe19,
                recipeOutput.advancement()
                        .addCriterion("has_nail_gold_mold", RecipeProvider.has(ModItems.NAILGOLDMOLD))
                        .addCriterion("has_small_melted_copper_blob", RecipeProvider.has(ModItems.SMALLMELTEDCOPPERBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "copper_nail_gold_mold1").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern20 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModItems.NAILGOLDMOLD),
                        'O', Ingredient.of(ModItems.SMALLMELTEDCOPPERBLOB)
                ),
                List.of(
                        "O  ",
                        " OO",
                        " O#"
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe20 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern20,
                new ItemStack(ModItems.COPPERNAIL.get())
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "copper_nail_gold_mold2"),
                Mod_shaped_recipe20,
                recipeOutput.advancement()
                        .addCriterion("has_nail_gold_mold", RecipeProvider.has(ModItems.NAILGOLDMOLD))
                        .addCriterion("has_small_melted_copper_blob", RecipeProvider.has(ModItems.SMALLMELTEDCOPPERBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "copper_nail_gold_mold2").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern21 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModItems.NAILGOLDMOLD),
                        'O', Ingredient.of(ModItems.SMALLMELTEDIRONBLOB)
                ),
                List.of(
                        " O#",
                        " OO",
                        "O  "
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe21 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern21,
                new ItemStack(ModItems.IRONNAIL.get())
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "iron_nail_gold_mold1"),
                Mod_shaped_recipe21,
                recipeOutput.advancement()
                        .addCriterion("has_nail_gold_mold", RecipeProvider.has(ModItems.NAILGOLDMOLD))
                        .addCriterion("has_small_melted_iron_blob", RecipeProvider.has(ModItems.SMALLMELTEDIRONBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "iron_nail_gold_mold1").withPrefix("recipes/"))
        );

        ShapedRecipePattern Mod_shaped_pattern22 = ShapedRecipePattern.of(
                Map.of(
                        '#', Ingredient.of(ModItems.NAILGOLDMOLD),
                        'O', Ingredient.of(ModItems.SMALLMELTEDIRONBLOB)
                ),
                List.of(
                        "O  ",
                        " OO",
                        " O#"
                )
        );

        ModCustomCraftingShaped Mod_shaped_recipe22 = new ModCustomCraftingShaped(
                "",
                CraftingBookCategory.MISC,
                Mod_shaped_pattern22,
                new ItemStack(ModItems.IRONNAIL.get())
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "iron_nail_gold_mold2"),
                Mod_shaped_recipe22,
                recipeOutput.advancement()
                        .addCriterion("has_nail_gold_mold", RecipeProvider.has(ModItems.NAILGOLDMOLD))
                        .addCriterion("has_small_melted_iron_blob", RecipeProvider.has(ModItems.SMALLMELTEDIRONBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "iron_nail_gold_mold2").withPrefix("recipes/"))
        );


        List<Ingredient> Mod_shapeless_ingredients1 = List.of(
                Ingredient.of(Items.COAL),
                Ingredient.of(ModTags.Items.HAMMERS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe1 = new ModCustomCraftingShapeless(
                1,
                true,
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
                        .addCriterion("has_hammer", RecipeProvider.has(ModTags.Items.HAMMERS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "coal_powder").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients2 = List.of(
                Ingredient.of(Items.CHARCOAL),
                Ingredient.of(ModTags.Items.HAMMERS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe2 = new ModCustomCraftingShapeless(
                1,
                true,
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
                        .addCriterion("has_hammer", RecipeProvider.has(ModTags.Items.HAMMERS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "coal_powder1").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients3 = List.of(
                Ingredient.of(Items.OAK_LOG),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe3 = new ModCustomCraftingShapeless(
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
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
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.OAK_PLANKS, 4),
                Mod_shapeless_ingredients24
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "oak_planks_saw"),
                Mod_shapeless_recipe24,
                recipeOutput.advancement()
                        .addCriterion("has_oak_logs", RecipeProvider.has(ItemTags.OAK_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "oak_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients25 = List.of(
                Ingredient.of(ItemTags.DARK_OAK_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe25 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.DARK_OAK_PLANKS, 4),
                Mod_shapeless_ingredients25
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "dark_oak_planks_saw"),
                Mod_shapeless_recipe25,
                recipeOutput.advancement()
                        .addCriterion("has_dark_oak_logs", RecipeProvider.has(ItemTags.DARK_OAK_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "dark_oak_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients26 = List.of(
                Ingredient.of(ItemTags.BIRCH_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe26 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.BIRCH_PLANKS, 4),
                Mod_shapeless_ingredients26
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "birch_planks_saw"),
                Mod_shapeless_recipe26,
                recipeOutput.advancement()
                        .addCriterion("has_birch_logs", RecipeProvider.has(ItemTags.BIRCH_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "birch_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients27 = List.of(
                Ingredient.of(ItemTags.JUNGLE_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe27 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.JUNGLE_PLANKS, 4),
                Mod_shapeless_ingredients27
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "jungle_planks_saw"),
                Mod_shapeless_recipe27,
                recipeOutput.advancement()
                        .addCriterion("has_jungle_logs", RecipeProvider.has(ItemTags.JUNGLE_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "jungle_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients28 = List.of(
                Ingredient.of(ItemTags.ACACIA_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe28 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.ACACIA_PLANKS, 4),
                Mod_shapeless_ingredients28
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "acacia_planks_saw"),
                Mod_shapeless_recipe28,
                recipeOutput.advancement()
                        .addCriterion("has_acacia_logs", RecipeProvider.has(ItemTags.ACACIA_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "acacia_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients29 = List.of(
                Ingredient.of(ItemTags.MANGROVE_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe29 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.MANGROVE_PLANKS, 4),
                Mod_shapeless_ingredients29
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "mangrove_planks_saw"),
                Mod_shapeless_recipe29,
                recipeOutput.advancement()
                        .addCriterion("has_mangrove_logs", RecipeProvider.has(ItemTags.MANGROVE_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "mangrove_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients30 = List.of(
                Ingredient.of(ItemTags.CHERRY_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe30 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.CHERRY_PLANKS, 4),
                Mod_shapeless_ingredients30
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "cherry_planks_saw"),
                Mod_shapeless_recipe30,
                recipeOutput.advancement()
                        .addCriterion("has_cherry_logs", RecipeProvider.has(ItemTags.CHERRY_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "cherry_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients31 = List.of(
                Ingredient.of(ItemTags.CRIMSON_STEMS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe31 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.CRIMSON_PLANKS, 4),
                Mod_shapeless_ingredients31
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crimson_planks_saw"),
                Mod_shapeless_recipe31,
                recipeOutput.advancement()
                        .addCriterion("has_crimson_stem", RecipeProvider.has(ItemTags.CRIMSON_STEMS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crimson_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients32 = List.of(
                Ingredient.of(ItemTags.WARPED_STEMS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe32 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.WARPED_PLANKS, 4),
                Mod_shapeless_ingredients32
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "warped_planks_saw"),
                Mod_shapeless_recipe32,
                recipeOutput.advancement()
                        .addCriterion("has_warped_stem", RecipeProvider.has(ItemTags.WARPED_STEMS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "warped_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients33 = List.of(
                Ingredient.of(ItemTags.BAMBOO_BLOCKS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe33 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.BAMBOO_PLANKS, 2),
                Mod_shapeless_ingredients33
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "bamboo_planks_saw"),
                Mod_shapeless_recipe33,
                recipeOutput.advancement()
                        .addCriterion("has_bamboo_block", RecipeProvider.has(ItemTags.BAMBOO_BLOCKS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "bamboo_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients34 = List.of(
                Ingredient.of(ItemTags.SPRUCE_LOGS),
                Ingredient.of(ModTags.Items.SAWS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe34 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.SPRUCE_PLANKS, 4),
                Mod_shapeless_ingredients34
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "spruce_planks_saw"),
                Mod_shapeless_recipe34,
                recipeOutput.advancement()
                        .addCriterion("has_spruce_logs", RecipeProvider.has(ItemTags.SPRUCE_LOGS))
                        .addCriterion("has_saw", RecipeProvider.has(ModTags.Items.SAWS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "spruce_planks_saw").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients35 = List.of(
                Ingredient.of(Items.SAND),
                Ingredient.of(ModTags.Items.KNIVES)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe35 = new ModCustomCraftingShapeless(
                0,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.EMPTYSANDMOLD.get(), 4),
                Mod_shapeless_ingredients35
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "empty_sand_mold"),
                Mod_shapeless_recipe35,
                recipeOutput.advancement()
                        .addCriterion("has_sand", RecipeProvider.has(Items.SAND))
                        .addCriterion("has_knife", RecipeProvider.has(ModTags.Items.KNIVES))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "empty_sand_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients36 = List.of(
                Ingredient.of(ModTags.Items.INGOTSHAPED),
                Ingredient.of(ModItems.EMPTYSANDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe36 = new ModCustomCraftingShapeless(
                0,
                false,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.INGOTSANDMOLD.get()),
                Mod_shapeless_ingredients36
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "ingot_sand_mold"),
                Mod_shapeless_recipe36,
                recipeOutput.advancement()
                        .addCriterion("has_empty_sand_mold", RecipeProvider.has(ModItems.EMPTYSANDMOLD))
                        .addCriterion("has_ingot_shaped", RecipeProvider.has(ModTags.Items.INGOTSHAPED))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "ingot_sand_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients37 = List.of(
                Ingredient.of(Items.BRICK),
                Ingredient.of(ModTags.Items.HAMMERS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe37 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.CERAMICDUST.get()),
                Mod_shapeless_ingredients37
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "ceramic_dust"),
                Mod_shapeless_recipe37,
                recipeOutput.advancement()
                        .addCriterion("has_brick", RecipeProvider.has(Items.BRICK))
                        .addCriterion("has_hammer", RecipeProvider.has(ModTags.Items.HAMMERS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "ceramic_dust").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients38 = List.of(
                Ingredient.of(ModTags.Items.COALBLOCKS),
                Ingredient.of(ModTags.Items.HAMMERS)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe38 = new ModCustomCraftingShapeless(
                9,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.COALPOWDER.get(), 18),
                Mod_shapeless_ingredients38
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "coal_powder_from_block"),
                Mod_shapeless_recipe38,
                recipeOutput.advancement()
                        .addCriterion("has_coal_blocks", RecipeProvider.has(ModTags.Items.COALBLOCKS))
                        .addCriterion("has_hammer", RecipeProvider.has(ModTags.Items.HAMMERS))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "coal_powder_from_block").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients39 = List.of(
                Ingredient.of(ModTags.Items.NUGGETSHAPED),
                Ingredient.of(ModItems.EMPTYSANDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe39 = new ModCustomCraftingShapeless(
                0,
                false,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.NUGGETSANDMOLD.get()),
                Mod_shapeless_ingredients39
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "nugget_sand_mold"),
                Mod_shapeless_recipe39,
                recipeOutput.advancement()
                        .addCriterion("has_empty_sand_mold", RecipeProvider.has(ModItems.EMPTYSANDMOLD))
                        .addCriterion("has_nugget_shaped", RecipeProvider.has(ModTags.Items.NUGGETSHAPED))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "nugget_sand_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients40 = List.of(
                Ingredient.of(ModTags.Items.NUGGETSHAPED),
                Ingredient.of(ModItems.MELTEDEMPTYGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe40 = new ModCustomCraftingShapeless(
                0,
                false,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.MELTEDNUGGETGOLDMOLD.get()),
                Mod_shapeless_ingredients40
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "melted_nugget_gold_mold"),
                Mod_shapeless_recipe40,
                recipeOutput.advancement()
                        .addCriterion("has_melted_empty_gold_mold", RecipeProvider.has(ModItems.MELTEDEMPTYGOLDMOLD))
                        .addCriterion("has_nugget_shaped", RecipeProvider.has(ModTags.Items.NUGGETSHAPED))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "melted_nugget_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients41 = List.of(
                Ingredient.of(ModTags.Items.INGOTSHAPED),
                Ingredient.of(ModItems.MELTEDEMPTYGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe41 = new ModCustomCraftingShapeless(
                0,
                false,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.MELTEDINGOTGOLDMOLD.get()),
                Mod_shapeless_ingredients41
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "melted_ingot_gold_mold"),
                Mod_shapeless_recipe41,
                recipeOutput.advancement()
                        .addCriterion("has_melted_empty_gold_mold", RecipeProvider.has(ModItems.MELTEDEMPTYGOLDMOLD))
                        .addCriterion("has_ingot_shaped", RecipeProvider.has(ModTags.Items.INGOTSHAPED))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "melted_ingot_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients42 = List.of(
                Ingredient.of(ModTags.Items.NAILSHAPED),
                Ingredient.of(ModItems.MELTEDEMPTYGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe42 = new ModCustomCraftingShapeless(
                0,
                false,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.MELTEDNAILGOLDMOLD.get()),
                Mod_shapeless_ingredients42
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "melted_nail_gold_mold"),
                Mod_shapeless_recipe42,
                recipeOutput.advancement()
                        .addCriterion("has_melted_empty_gold_mold", RecipeProvider.has(ModItems.MELTEDEMPTYGOLDMOLD))
                        .addCriterion("has_nail_shaped", RecipeProvider.has(ModTags.Items.NAILSHAPED))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "melted_nail_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients43 = List.of(
                Ingredient.of(ModItems.MELTEDCOPPERBLOB),
                Ingredient.of(ModItems.INGOTGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe43 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.COPPER_INGOT),
                Mod_shapeless_ingredients43
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "copper_ingot_gold_mold"),
                Mod_shapeless_recipe43,
                recipeOutput.advancement()
                        .addCriterion("has_ingot_gold_mold", RecipeProvider.has(ModItems.INGOTGOLDMOLD))
                        .addCriterion("has_melted_copper_blob", RecipeProvider.has(ModItems.MELTEDCOPPERBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "copper_ingot_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients44 = List.of(
                Ingredient.of(ModItems.MELTEDGOLDBLOB),
                Ingredient.of(ModItems.INGOTGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe44 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.GOLD_INGOT),
                Mod_shapeless_ingredients44
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "gold_ingot_gold_mold"),
                Mod_shapeless_recipe44,
                recipeOutput.advancement()
                        .addCriterion("has_ingot_gold_mold", RecipeProvider.has(ModItems.INGOTGOLDMOLD))
                        .addCriterion("has_melted_gold_blob", RecipeProvider.has(ModItems.MELTEDGOLDBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "gold_ingot_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients45 = List.of(
                Ingredient.of(ModItems.MELTEDIRONBLOB),
                Ingredient.of(ModItems.INGOTGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe45 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.IRON_INGOT),
                Mod_shapeless_ingredients45
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "iron_ingot_gold_mold"),
                Mod_shapeless_recipe45,
                recipeOutput.advancement()
                        .addCriterion("has_ingot_gold_mold", RecipeProvider.has(ModItems.INGOTGOLDMOLD))
                        .addCriterion("has_melted_iron_blob", RecipeProvider.has(ModItems.MELTEDIRONBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "iron_ingot_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients46 = List.of(
                Ingredient.of(ModItems.SMALLMELTEDCOPPERBLOB),
                Ingredient.of(ModItems.NUGGETGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe46 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.COPPERNUGGET.get()),
                Mod_shapeless_ingredients46
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "copper_nugget_gold_mold"),
                Mod_shapeless_recipe46,
                recipeOutput.advancement()
                        .addCriterion("has_nugget_gold_mold", RecipeProvider.has(ModItems.NUGGETGOLDMOLD))
                        .addCriterion("has_small_melted_copper_blob", RecipeProvider.has(ModItems.SMALLMELTEDCOPPERBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "copper_nugget_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients47 = List.of(
                Ingredient.of(ModItems.SMALLMELTEDIRONBLOB),
                Ingredient.of(ModItems.NUGGETGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe47 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.IRON_NUGGET),
                Mod_shapeless_ingredients47
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "iron_nugget_gold_mold"),
                Mod_shapeless_recipe47,
                recipeOutput.advancement()
                        .addCriterion("has_nugget_gold_mold", RecipeProvider.has(ModItems.NUGGETGOLDMOLD))
                        .addCriterion("has_small_melted_iron_blob", RecipeProvider.has(ModItems.SMALLMELTEDIRONBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "iron_nugget_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients48 = List.of(
                Ingredient.of(ModItems.SMALLMELTEDGOLDBLOB),
                Ingredient.of(ModItems.NUGGETGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe48 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(Items.GOLD_NUGGET),
                Mod_shapeless_ingredients48
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "gold_nugget_gold_mold"),
                Mod_shapeless_recipe48,
                recipeOutput.advancement()
                        .addCriterion("has_nugget_gold_mold", RecipeProvider.has(ModItems.NUGGETGOLDMOLD))
                        .addCriterion("has_small_melted_gold_blob", RecipeProvider.has(ModItems.SMALLMELTEDGOLDBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "gold_nugget_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients49 = List.of(
                Ingredient.of(ModItems.EMPTYSANDMOLD),
                Ingredient.of(ModTags.Items.NAILSHAPED)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe49 = new ModCustomCraftingShapeless(
                0,
                false,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.NAILSANDMOLD.get()),
                Mod_shapeless_ingredients49
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "nail_sand_mold_from_nail"),
                Mod_shapeless_recipe49,
                recipeOutput.advancement()
                        .addCriterion("has_empty_sand_mold", RecipeProvider.has(ModItems.EMPTYSANDMOLD))
                        .addCriterion("has_nail_shaped", RecipeProvider.has(ModTags.Items.NAILSHAPED))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "nail_sand_mold_from_nail").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients50 = List.of(
                Ingredient.of(ModItems.MELTEDROSEGOLDBLOB),
                Ingredient.of(ModItems.INGOTGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe50 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.ROSEGOLDINGOT.get()),
                Mod_shapeless_ingredients50
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "rose_gold_ingot_gold_mold"),
                Mod_shapeless_recipe50,
                recipeOutput.advancement()
                        .addCriterion("has_ingot_gold_mold", RecipeProvider.has(ModItems.INGOTGOLDMOLD))
                        .addCriterion("has_melted_rose_gold_blob", RecipeProvider.has(ModItems.MELTEDROSEGOLDBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "rose_gold_ingot_gold_mold").withPrefix("recipes/"))
        );

        List<Ingredient> Mod_shapeless_ingredients51 = List.of(
                Ingredient.of(ModItems.SMALLMELTEDROSEGOLDBLOB),
                Ingredient.of(ModItems.NUGGETGOLDMOLD)
        );

        ModCustomCraftingShapeless Mod_shapeless_recipe51 = new ModCustomCraftingShapeless(
                1,
                true,
                "",
                CraftingBookCategory.MISC,
                new ItemStack(ModItems.ROSEGOLDNUGGET.get()),
                Mod_shapeless_ingredients51
        );

        recipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "rose_gold_nugget_gold_mold"),
                Mod_shapeless_recipe51,
                recipeOutput.advancement()
                        .addCriterion("has_nugget_gold_mold", RecipeProvider.has(ModItems.NUGGETGOLDMOLD))
                        .addCriterion("has_small_melted_rose_gold_blob", RecipeProvider.has(ModItems.SMALLMELTEDROSEGOLDBLOB))
                        .build(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "rose_gold_nugget_gold_mold").withPrefix("recipes/"))
        );

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDCOPPERPLATE)
                .pattern(" #  ")
                .pattern(" OO ")
                .pattern("    ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_copper_plate_1"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDCOPPERPLATE)
                .pattern("    ")
                .pattern(" OO ")
                .pattern("  # ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_copper_plate_2"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDCOPPERPLATE)
                .pattern("    ")
                .pattern("#OO ")
                .pattern("    ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_copper_plate_3"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDIRONPLATE)
                .pattern(" #  ")
                .pattern(" OO ")
                .pattern("    ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDIRONBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_iron_blob", has(ModItems.MELTEDIRONBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_iron_plate_1"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDIRONPLATE)
                .pattern("    ")
                .pattern(" OO ")
                .pattern("  # ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDIRONBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_iron_blob", has(ModItems.MELTEDIRONBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_iron_plate_2"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDIRONPLATE)
                .pattern("    ")
                .pattern("#OO ")
                .pattern("    ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDIRONBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_iron_blob", has(ModItems.MELTEDIRONBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_iron_plate_3"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDGOLDPLATE)
                .pattern(" #  ")
                .pattern(" OO ")
                .pattern("    ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDGOLDBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_gold_blob", has(ModItems.MELTEDGOLDBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_gold_plate_1"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDGOLDPLATE)
                .pattern("    ")
                .pattern(" OO ")
                .pattern("  # ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDGOLDBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_gold_blob", has(ModItems.MELTEDGOLDBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_gold_plate_2"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDGOLDPLATE)
                .pattern("    ")
                .pattern("#OO ")
                .pattern("    ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDGOLDBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_gold_blob", has(ModItems.MELTEDGOLDBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_gold_plate_3"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDEMPTYGOLDMOLD)
                .pattern("##  ")
                .pattern("##O ")
                .pattern("    ")
                .define('O', ModTags.Items.HAMMERS)
                .define('#', ModItems.MELTEDGOLDPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_gold_plate", has(ModItems.MELTEDGOLDPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_empty_gold_mold_1"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDEMPTYGOLDMOLD)
                .pattern("##O ")
                .pattern("##  ")
                .pattern("    ")
                .define('O', ModTags.Items.HAMMERS)
                .define('#', ModItems.MELTEDGOLDPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_gold_plate", has(ModItems.MELTEDGOLDPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_empty_gold_mold_2"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDEMPTYGOLDMOLD)
                .pattern("  O ")
                .pattern(" ## ")
                .pattern(" ## ")
                .define('O', ModTags.Items.HAMMERS)
                .define('#', ModItems.MELTEDGOLDPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_gold_plate", has(ModItems.MELTEDGOLDPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_empty_gold_mold_3"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.MELTEDEMPTYGOLDMOLD)
                .pattern(" ## ")
                .pattern(" ## ")
                .pattern("  O ")
                .define('O', ModTags.Items.HAMMERS)
                .define('#', ModItems.MELTEDGOLDPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_gold_plate", has(ModItems.MELTEDGOLDPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "melted_empty_gold_mold_4"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERHELMETHOT)
                .pattern(" OUO")
                .pattern(" U#U")
                .pattern("    ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .define('U', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_helmet_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERHELMETHOT)
                .pattern("  UO")
                .pattern("  #U")
                .pattern("  UO")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .define('U', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_helmet_hot2"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERCHESTPLATEHOT)
                .pattern("UOUO")
                .pattern("OUO#")
                .pattern("UOUO")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .define('U', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_chestplate_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERLEGGINGSHOT)
                .pattern("UOUO")
                .pattern("  #U")
                .pattern("UOUO")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .define('U', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_leggings_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERBOOTSHOT)
                .pattern(" UO ")
                .pattern("  # ")
                .pattern(" UO ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .define('U', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_boots_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERBOOTSHOT)
                .pattern(" O#O")
                .pattern(" U U")
                .pattern("    ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .define('U', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_boots_hot2"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERBOOTSHOT)
                .pattern(" UO ")
                .pattern(" #  ")
                .pattern(" UO ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .define('U', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_boots_hot3"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERBOOTSHOT)
                .pattern(" O O")
                .pattern(" U#U")
                .pattern("    ")
                .define('#', ModTags.Items.HAMMERS)
                .define('O', ModItems.MELTEDCOPPERBLOB)
                .define('U', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_boots_hot4"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERAXEHEADHOT)
                .pattern(" ## ")
                .pattern(" #HH")
                .pattern("  T ")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.MELTEDCOPPERBLOB)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_axe_head_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERPICKAXEHEADHOT)
                .pattern(" HHT")
                .pattern("  HH")
                .pattern("   H")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.MELTEDCOPPERBLOB)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_pickaxe_head_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERHOEHEADHOT)
                .pattern("##H ")
                .pattern("  T ")
                .pattern("    ")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.MELTEDCOPPERBLOB)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_hoe_head_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERSWORDHEADHOT)
                .pattern("T   ")
                .pattern("H###")
                .pattern("    ")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.MELTEDCOPPERBLOB)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_sword_head_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERCROSSGUARDHOT)
                .pattern(" H  ")
                .pattern(" #H ")
                .pattern(" T#H")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.MELTEDCOPPERBLOB)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_cross_guard_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERSHOVELHEADHOT)
                .pattern("  HH")
                .pattern(" H#H")
                .pattern(" TH ")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.SMALLMELTEDCOPPERBLOB)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_small_melted_copper_blob", has(ModItems.SMALLMELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_shovel_head_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERHAMMERHEADHOT)
                .pattern("   #")
                .pattern("   X")
                .pattern("   X")
                .define('X', ModItems.MELTEDCOPPERBLOB)
                .define('#', ModBlocks.MELTEDCOPPERBLOCK)
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_block", has(ModBlocks.MELTEDCOPPERBLOCK))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_hammer_head_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERHAMMERHEADHOT)
                .pattern("    ")
                .pattern(" #XX")
                .pattern("    ")
                .define('X', ModItems.MELTEDCOPPERBLOB)
                .define('#', ModBlocks.MELTEDCOPPERBLOCK)
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_block", has(ModBlocks.MELTEDCOPPERBLOCK))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_hammer_head_hot2"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERSMALLBLADEHOT)
                .pattern("  T ")
                .pattern(" H# ")
                .pattern("    ")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.SMALLMELTEDCOPPERBLOB)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_small_melted_copper_blob", has(ModItems.SMALLMELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_small_blade_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERSMALLBLADEHOT)
                .pattern(" T  ")
                .pattern(" H# ")
                .pattern("    ")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.SMALLMELTEDCOPPERBLOB)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_small_melted_copper_blob", has(ModItems.SMALLMELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_small_blade_hot2"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERSAWBLADEHOT)
                .pattern(" X# ")
                .pattern(" X#T")
                .pattern("    ")
                .define('T', ModTags.Items.HAMMERS)
                .define('X', ModItems.COPPERSMALLBLADEHOT)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_copper_small_blade_hot", has(ModItems.COPPERSMALLBLADEHOT))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_saw_blade_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERSAWBLADEHOT)
                .pattern(" X#T")
                .pattern(" X# ")
                .pattern("    ")
                .define('T', ModTags.Items.HAMMERS)
                .define('X', ModItems.COPPERSMALLBLADEHOT)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_copper_small_blade_hot", has(ModItems.COPPERSMALLBLADEHOT))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_saw_blade_hot2"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERCHISELBLADEHOT)
                .pattern("  T ")
                .pattern(" H# ")
                .pattern("    ")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.MELTEDCOPPERBLOB)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_chisel_blade_hot"));

        CobblestoneAnvilRecipeBuilder.anvil(ModItems.COPPERCHISELBLADEHOT)
                .pattern(" T  ")
                .pattern(" H# ")
                .pattern("    ")
                .define('T', ModTags.Items.HAMMERS)
                .define('H', ModItems.MELTEDCOPPERBLOB)
                .define('#', ModItems.MELTEDCOPPERPLATE)
                .unlockedBy("has_hammer", has(ModTags.Items.HAMMERS))
                .unlockedBy("has_melted_copper_blob", has(ModItems.MELTEDCOPPERBLOB))
                .unlockedBy("has_melted_copper_plate", has(ModItems.MELTEDCOPPERPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                        ProgressRevamp.MODID, "copper_chisel_blade_hot2"));



        TierOneCraftingTableRecipeBuilder.intermediate_recipe(ModBlocks.BELLOW.get())
                .pattern("     ")
                .pattern(" ##H ")
                .pattern("/H   ")
                .pattern(" ##H ")
                .pattern("     ")
                .define('#', Items.LEATHER)
                .define('H', ItemTags.PLANKS)
                .define('/', Items.STICK)
                .unlockedBy("has_leather", has(Items.LEATHER))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "bellow"));


        TierOneCraftingTableRecipeBuilder.intermediate_recipe(Blocks.FURNACE)
                .pattern("     ")
                .pattern(" ### ")
                .pattern("H - H")
                .pattern(" #X# ")
                .pattern("  W  ")
                .define('#', ItemTags.STONE_CRAFTING_MATERIALS)
                .define('H', ModBlocks.BELLOW)
                .define('-', ModTags.Items.STONESLABCRAFTINGMATERIAL)
                .define('X', ModTags.Items.FIRESTARTERS)
                .define('W', ModTags.Items.COALBLOCKS)
                .unlockedBy("has_stone_crafting_material", has(ItemTags.STONE_CRAFTING_MATERIALS))
                .unlockedBy("has_bellow", has(ModBlocks.BELLOW))
                .unlockedBy("has_stone_slab_crafting_material", has(ModTags.Items.STONESLABCRAFTINGMATERIAL))
                .unlockedBy("has_firestarter", has(ModTags.Items.FIRESTARTERS))
                .unlockedBy("has_coal_blocks", has(ModTags.Items.COALBLOCKS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("minecraft", "furnace"));

        TierOneCraftingTableRecipeBuilder.intermediate_recipe(ModBlocks.REINFORCEDBARREL)
                .pattern("  T  ")
                .pattern(" EEE ")
                .pattern("TE#ET")
                .pattern(" EEE ")
                .pattern("  T  ")
                .define('E', ModTags.Items.IRONPLATES)
                .define('#', Blocks.BARREL)
                .define('T', ModItems.IRONNAIL)
                .unlockedBy("has_iron_plates", has(ModTags.Items.IRONPLATES))
                .unlockedBy("has_barrel", has(Blocks.BARREL))
                .unlockedBy("has_iron_nail", has(ModItems.IRONNAIL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "reinforced_barrel"));

        CampfireWithCrucibleRecipeBuilder.crucible(ModTags.Items.COPPERBLOBMELTABLES, ModItems.MELTEDCOPPERBLOB, 1200)
                .unlockedBy("has_copper_blob_meltables", has(ModTags.Items.COPPERBLOBMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crucible_melted_copper_blob"));

        CampfireWithCrucibleRecipeBuilder.crucible(ModTags.Items.GOLDBLOBMELTABLES, ModItems.MELTEDGOLDBLOB, 1200)
                .unlockedBy("has_gold_blob_meltables", has(ModTags.Items.GOLDBLOBMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crucible_melted_gold_blob"));

        CampfireWithCrucibleRecipeBuilder.crucible(ModTags.Items.ROSEGOLDBLOBMELTABLES, ModItems.MELTEDROSEGOLDBLOB, 1200)
                .unlockedBy("has_rose_gold_blob_meltables", has(ModTags.Items.ROSEGOLDBLOBMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crucible_melted_rose_gold_blob"));

        CampfireWithCrucibleRecipeBuilder.crucible(ModTags.Items.SMALLCOPPERBLOBMELTABLES, ModItems.SMALLMELTEDCOPPERBLOB, 180)
                .unlockedBy("has_small_copper_blob_meltables", has(ModTags.Items.SMALLCOPPERBLOBMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crucible_small_melted_copper_blob"));

        CampfireWithCrucibleRecipeBuilder.crucible(ModTags.Items.SMALLGOLDBLOBMELTABLES, ModItems.SMALLMELTEDGOLDBLOB, 180)
                .unlockedBy("has_small_gold_blob_meltables", has(ModTags.Items.SMALLGOLDBLOBMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crucible_small_melted_gold_blob"));

        CampfireWithCrucibleRecipeBuilder.crucible(ModTags.Items.SMALLROSEGOLDBLOBMELTABLES, ModItems.SMALLMELTEDROSEGOLDBLOB, 180)
                .unlockedBy("has_small_rose_gold_blob_meltables", has(ModTags.Items.SMALLROSEGOLDBLOBMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crucible_small_melted_rose_gold_blob"));

        CampfireWithCrucibleRecipeBuilder.crucible(ModTags.Items.COPPERBLOCKMELTABLES, ModBlocks.MELTEDCOPPERBLOCK, 10800)
                .unlockedBy("has_copper_block_meltables", has(ModTags.Items.COPPERBLOCKMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crucible_melted_copper_block"));

        CampfireWithCrucibleRecipeBuilder.crucible(ModTags.Items.GOLDBLOCKMELTABLES, ModBlocks.MELTEDGOLDBLOCK, 10800)
                .unlockedBy("has_gold_block_meltables", has(ModTags.Items.GOLDBLOCKMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "crucible_melted_gold_block"));

        CampfireWithCrucibleRecipeBuilder.crucible(ModItems.EMPTYGOLDMOLD, ModItems.MELTEDEMPTYGOLDMOLD, 4800)
                .unlockedBy("has_empty_gold_mold", has(ModItems.EMPTYGOLDMOLD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "melted_empty_gold_mold_campfire_with_crucible"));



        RudimentaryAlloyFurnaceRecipeBuilder.alloy(ModTags.Items.GOLDBLOBMELTABLES, ModTags.Items.COPPERBLOBMELTABLES, ModItems.MELTEDROSEGOLDBLOB,200)
                .unlockedBy("has_gold_blob_meltables", has(ModTags.Items.GOLDBLOBMELTABLES))
                .unlockedBy("has_copper_blob_meltables", has(ModTags.Items.COPPERBLOBMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "melted_rose_gold_blob_alloying"));

        RudimentaryAlloyFurnaceRecipeBuilder.alloy(ModTags.Items.SMALLGOLDBLOBMELTABLES, ModTags.Items.SMALLCOPPERBLOBMELTABLES, ModItems.SMALLMELTEDROSEGOLDBLOB,200)
                .unlockedBy("has_small_gold_blob_meltables", has(ModTags.Items.SMALLGOLDBLOBMELTABLES))
                .unlockedBy("has_small_copper_blob_meltables", has(ModTags.Items.SMALLCOPPERBLOBMELTABLES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "small_melted_rose_gold_blob_alloying"));

        List<ItemLike> SALTED_BEEF_INGREDIENT = List.of( ModItems.SALTEDBEEF );
        List<ItemLike> SALTED_CHICKEN_INGREDIENT = List.of( ModItems.RAWSALTEDCHICKEN );
        List<ItemLike> SALTED_PORKCHOPS_INGREDIENT = List.of( ModItems.RAWSALTEDPORKCHOPS );
        List<ItemLike> SALTED_MUTTON_INGREDIENT = List.of( ModItems.RAWSALTEDMUTTON );
        List<ItemLike> SALTED_RABBIT_INGREDIENT = List.of( ModItems.RAWSALTEDRABBIT );
        List<ItemLike> SALTED_COD_INGREDIENT = List.of( ModItems.RAWSALTEDCOD );
        List<ItemLike> SALTED_SALMON_INGREDIENT = List.of( ModItems.RAWSALTEDSALMON );
        List<ItemLike> CERAMIC_BUCKET_INGREDIENTS = List.of( ModItems.UNFIREDCLAYBUCKET );
        List<ItemLike> UNREFINED_CRUCIBLES = List.of( ModItems.UNREFINEDCRUCIBLE );
        List<ItemLike> CLAY_BRICK_INGREDIENT = List.of( ModItems.CLAYBRICK );
        List<ItemLike> TERRACOTTA_INGREDIENT = List.of( Blocks.CLAY );
        List<ItemLike> COPPER_BLOB_INGREDIENT = List.of(
                Items.COPPER_ORE,
                Items.COPPER_INGOT,
                Items.RAW_COPPER,
                Items.DEEPSLATE_COPPER_ORE
        );
        List<ItemLike> GOLD_BLOB_INGREDIENT = List.of(
                Items.GOLD_ORE,
                Items.GOLD_INGOT,
                Items.RAW_GOLD,
                Items.DEEPSLATE_GOLD_ORE,
                Items.NETHER_GOLD_ORE
        );
        List<ItemLike> IRON_BLOB_INGREDIENT = List.of(
                Items.IRON_ORE,
                Items.IRON_INGOT,
                Items.RAW_IRON,
                Items.DEEPSLATE_IRON_ORE
        );

        List<ItemLike> ROSE_GOLD_BLOB_INGREDIENT = List.of(
                ModItems.ROSEGOLDINGOT
        );

        List<ItemLike> SMALL_IRON_BLOB_INGREDIENT = List.of(
                Items.IRON_NUGGET
        );

        List<ItemLike> SMALL_COPPER_BLOB_INGREDIENT = List.of(
                ModItems.COPPERNUGGET
        );

        List<ItemLike> SMALL_GOLD_BLOB_INGREDIENT = List.of(
                Items.GOLD_NUGGET
        );

        List<ItemLike> SMALL_ROSE_GOLD_BLOB_INGREDIENT = List.of(
                ModItems.ROSEGOLDNUGGET
        );

        List<ItemLike> IRON_BLOCK_INGREDIENT = List.of(
                Items.IRON_BLOCK,
                Items.RAW_IRON_BLOCK,
                ModBlocks.IRONBARBLOCK
        );

        List<ItemLike> GOLD_BLOCK_INGREDIENT = List.of(
                Items.GOLD_BLOCK,
                Items.RAW_GOLD_BLOCK,
                ModBlocks.GOLDBARBLOCK
        );

        List<ItemLike> COPPER_BLOCK_INGREDIENT = List.of(
                Items.COPPER_BLOCK,
                Items.RAW_COPPER_BLOCK,
                ModBlocks.COPPERBARBLOCK
        );

        oreSmelting(recipeOutput, SALTED_BEEF_INGREDIENT, RecipeCategory.FOOD, ModItems.SALTEDCOOKEDBEEF.get(), 0.4f, 200, "salted_cooked_beef");

        campfireCooking(recipeOutput, SALTED_BEEF_INGREDIENT,RecipeCategory.FOOD, ModItems.SALTEDCOOKEDBEEF.get(), 0.4f, 600, "salted_cooked_beef");

        oreSmelting(recipeOutput, SALTED_CHICKEN_INGREDIENT, RecipeCategory.FOOD, ModItems.SALTEDCHICKEN.get(), 0.4f, 200, "salted_chicken");

        campfireCooking(recipeOutput, SALTED_CHICKEN_INGREDIENT,RecipeCategory.FOOD, ModItems.SALTEDCHICKEN.get(), 0.4f, 600, "salted_chicken");

        oreSmelting(recipeOutput, SALTED_PORKCHOPS_INGREDIENT, RecipeCategory.FOOD, ModItems.SALTEDPORKCHOPS.get(), 0.4f, 200, "salted_porkchops");

        campfireCooking(recipeOutput, SALTED_PORKCHOPS_INGREDIENT,RecipeCategory.FOOD, ModItems.SALTEDPORKCHOPS.get(), 0.4f, 600, "salted_porkchops");

        oreSmelting(recipeOutput, SALTED_MUTTON_INGREDIENT, RecipeCategory.FOOD, ModItems.SALTEDMUTTON.get(), 0.4f, 200, "salted_mutton");

        campfireCooking(recipeOutput, SALTED_MUTTON_INGREDIENT,RecipeCategory.FOOD, ModItems.SALTEDMUTTON.get(), 0.4f, 600, "salted_mutton");

        oreSmelting(recipeOutput, SALTED_RABBIT_INGREDIENT, RecipeCategory.FOOD, ModItems.SALTEDRABBIT.get(), 0.4f, 200, "salted_rabbit");

        campfireCooking(recipeOutput, SALTED_RABBIT_INGREDIENT,RecipeCategory.FOOD, ModItems.SALTEDRABBIT.get(), 0.4f, 600, "salted_rabbit");

        oreSmelting(recipeOutput, SALTED_COD_INGREDIENT, RecipeCategory.FOOD, ModItems.SALTEDCOOKEDCOD.get(), 0.4f, 200, "salted_cooked_cod");

        campfireCooking(recipeOutput, SALTED_COD_INGREDIENT,RecipeCategory.FOOD, ModItems.SALTEDCOOKEDCOD.get(), 0.4f, 600, "salted_cooked_cod");

        oreSmelting(recipeOutput, SALTED_SALMON_INGREDIENT, RecipeCategory.FOOD, ModItems.SALTEDCOOKEDSALMON.get(), 0.4f, 200, "salted_cooked_salmon");

        campfireCooking(recipeOutput, SALTED_SALMON_INGREDIENT,RecipeCategory.FOOD, ModItems.SALTEDCOOKEDSALMON.get(), 0.4f, 600, "salted_cooked_salmon");

        oreSmelting(recipeOutput, CLAY_BRICK_INGREDIENT, RecipeCategory.MISC, Items.BRICK, 0.1f, 200, "brick");

        campfireCooking(recipeOutput, CLAY_BRICK_INGREDIENT,RecipeCategory.MISC, Items.BRICK, 0.1f, 600, "brick");

        campfireCooking(recipeOutput, TERRACOTTA_INGREDIENT,RecipeCategory.MISC, Items.TERRACOTTA, 0.2f, 800, "terracotta");

        oreSmelting(recipeOutput, CERAMIC_BUCKET_INGREDIENTS, RecipeCategory.MISC, ModItems.CERAMICBUCKET.get(), 0.5f, 300, "ceramic_bucket");

        campfireCooking(recipeOutput, CERAMIC_BUCKET_INGREDIENTS,RecipeCategory.MISC, ModItems.CERAMICBUCKET.get(), 0.5f, 900, "ceramic_bucket");

        campfireCooking(recipeOutput, UNREFINED_CRUCIBLES,RecipeCategory.MISC, ModItems.REFINEDCRUCIBLE.get(), 0.5f, 1200, "refined_crucible");

        oreSmelting(recipeOutput, GOLD_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.MELTEDGOLDBLOB.get(), 0.4f, 200, "melted_gold_blob");

        oreSmelting(recipeOutput, IRON_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.MELTEDIRONBLOB.get(), 0.4f, 200, "melted_iron_blob");

        oreBlasting(recipeOutput, GOLD_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.MELTEDGOLDBLOB.get(), 0.4f, 100, "melted_gold_blob");

        oreBlasting(recipeOutput, IRON_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.MELTEDIRONBLOB.get(), 0.4f, 100, "melted_iron_blob");

        oreSmelting(recipeOutput, COPPER_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.MELTEDCOPPERBLOB.get(), 0.4f, 200, "melted_copper_blob");

        oreBlasting(recipeOutput, COPPER_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.MELTEDCOPPERBLOB.get(), 0.4f, 100, "melted_copper_blob");

        oreSmelting(recipeOutput, ROSE_GOLD_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.MELTEDROSEGOLDBLOB.get(), 0.4f, 200, "melted_rose_gold_blob");

        oreBlasting(recipeOutput, ROSE_GOLD_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.MELTEDROSEGOLDBLOB.get(), 0.4f, 100, "melted_rose_gold_blob");

        oreSmelting(recipeOutput, SMALL_IRON_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.SMALLMELTEDIRONBLOB.get(), 0.04f, 25, "small_melted_iron_blob");

        oreBlasting(recipeOutput, SMALL_IRON_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.SMALLMELTEDIRONBLOB.get(), 0.04f, 12, "small_melted_iron_blob");

        oreSmelting(recipeOutput, SMALL_COPPER_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.SMALLMELTEDCOPPERBLOB.get(), 0.04f, 25, "small_melted_copper_blob");

        oreBlasting(recipeOutput, SMALL_COPPER_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.SMALLMELTEDCOPPERBLOB.get(), 0.04f, 12, "small_melted_copper_blob");

        oreSmelting(recipeOutput, SMALL_GOLD_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.SMALLMELTEDGOLDBLOB.get(), 0.04f, 25, "small_melted_gold_blob");

        oreBlasting(recipeOutput, SMALL_GOLD_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.SMALLMELTEDGOLDBLOB.get(), 0.04f, 12, "small_melted_gold_blob");

        oreSmelting(recipeOutput, SMALL_ROSE_GOLD_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.SMALLMELTEDROSEGOLDBLOB.get(), 0.04f, 25, "small_melted_rose_gold_blob");

        oreBlasting(recipeOutput, SMALL_ROSE_GOLD_BLOB_INGREDIENT, RecipeCategory.MISC, ModItems.SMALLMELTEDROSEGOLDBLOB.get(), 0.04f, 12, "small_melted_rose_gold_blob");

        oreSmelting(recipeOutput, IRON_BLOCK_INGREDIENT, RecipeCategory.MISC, ModBlocks.MELTEDIRONBLOCK.get(), 3.6f, 1800, "melted_iron_block");

        oreBlasting(recipeOutput, IRON_BLOCK_INGREDIENT, RecipeCategory.MISC, ModBlocks.MELTEDIRONBLOCK.get(), 3.6f, 900, "melted_iron_block");

        oreSmelting(recipeOutput, COPPER_BLOCK_INGREDIENT, RecipeCategory.MISC, ModBlocks.MELTEDCOPPERBLOCK.get(), 3.6f, 1800, "melted_copper_block");

        oreBlasting(recipeOutput, COPPER_BLOCK_INGREDIENT, RecipeCategory.MISC, ModBlocks.MELTEDCOPPERBLOCK.get(), 3.6f, 900, "melted_copper_block");

        oreSmelting(recipeOutput, GOLD_BLOCK_INGREDIENT, RecipeCategory.MISC, ModBlocks.MELTEDGOLDBLOCK.get(), 3.6f, 1800, "melted_gold_block");

        oreBlasting(recipeOutput, GOLD_BLOCK_INGREDIENT, RecipeCategory.MISC, ModBlocks.MELTEDGOLDBLOCK.get(), 3.6f, 900, "melted_gold_block");

        trimSmithing(recipeOutput, ModItems.CRANIUMSMITHINGTEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "cranium"));

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
