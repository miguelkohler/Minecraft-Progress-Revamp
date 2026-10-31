package net.saitamaking.minecraftprogressrevamp.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.recipe.CampfireWithCrucibleRecipe;
import net.saitamaking.minecraftprogressrevamp.recipe.CobblestoneAnvilRecipe;
import net.saitamaking.minecraftprogressrevamp.recipe.ModRecipeSerializers;
import net.saitamaking.minecraftprogressrevamp.recipe.TierOneCraftingTableRecipe;
import net.saitamaking.minecraftprogressrevamp.screen.ModMenuTypes;
import net.saitamaking.minecraftprogressrevamp.screen.custom.*;

import java.util.List;

@JeiPlugin
public class JEIMinecraftProgressRevampPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CampfireWithCrucibleRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CobblestoneAnvilRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new IntermediateCraftingTableRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<CampfireWithCrucibleRecipe> campfireWithCrucibleRecipes = recipeManager.getAllRecipesFor(
                ModRecipeSerializers.CAMPFIRE_WITH_CRUCIBLE_TYPE.get()).stream().map(RecipeHolder::value).toList();

        registration.addRecipes(CampfireWithCrucibleRecipeCategory.CAMPFIRE_WITH_CRUCIBLE_RECIPE_RECIPE_TYPE, campfireWithCrucibleRecipes);

        List<CobblestoneAnvilRecipe> cobblestoneAnvilRecipes = recipeManager.getAllRecipesFor(
                ModRecipeSerializers.COBBLESTONE_ANVIL_TYPE.get()).stream().map(RecipeHolder::value).toList();

        registration.addRecipes(CobblestoneAnvilRecipeCategory.COBBLESTONE_ANVIL_RECIPE_RECIPE_TYPE, cobblestoneAnvilRecipes);

        List<TierOneCraftingTableRecipe> tierOneCraftingTableRecipes = recipeManager.getAllRecipesFor(
                ModRecipeSerializers.TIER_ONE_CRAFTING_TABLE_TYPE.get()).stream().map(RecipeHolder::value).toList();

        registration.addRecipes(IntermediateCraftingTableRecipeCategory.INTERMEDIATE_CRAFTING_TABLE_RECIPE_RECIPE_TYPE, tierOneCraftingTableRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CampfireWithCrucibleScreen.class, 80, 32, 24, 18,
                CampfireWithCrucibleRecipeCategory.CAMPFIRE_WITH_CRUCIBLE_RECIPE_RECIPE_TYPE);
        registration.addRecipeClickArea(CobblestoneAnvilScreen.class, 90, 32, 24, 18,
                CobblestoneAnvilRecipeCategory.COBBLESTONE_ANVIL_RECIPE_RECIPE_TYPE);
        registration.addRecipeClickArea(PrimitiveCraftingTableScreen.class, 90, 32, 24, 18,
                RecipeTypes.CRAFTING);
        registration.addRecipeClickArea(RudimentaryCraftingTableScreen.class, 90, 32, 24, 18,
                RecipeTypes.CRAFTING);
        registration.addRecipeClickArea(IntermediateCraftingTableScreen.class, 108, 50, 24, 18,
                IntermediateCraftingTableRecipeCategory.INTERMEDIATE_CRAFTING_TABLE_RECIPE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CAMPFIREWITHCRUCIBLE.asItem()),
                CampfireWithCrucibleRecipeCategory.CAMPFIRE_WITH_CRUCIBLE_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.COBBLESTONEANVIL.asItem()),
                CobblestoneAnvilRecipeCategory.COBBLESTONE_ANVIL_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.INTERMEDIATECRAFTINGTABLE.asItem()),
                IntermediateCraftingTableRecipeCategory.INTERMEDIATE_CRAFTING_TABLE_RECIPE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(
                CobblestoneAnvilMenu.class,
                ModMenuTypes.COBBLESTONE_ANVIL_MENU.get(),
                CobblestoneAnvilRecipeCategory.COBBLESTONE_ANVIL_RECIPE_RECIPE_TYPE, 37, 12, 0, 36
        );
        registration.addRecipeTransferHandler(
                CampfireWithCrucibleMenu.class,
                ModMenuTypes.CAMPFIRE_WITH_CRUCIBLE_MENU.get(),
                CampfireWithCrucibleRecipeCategory.CAMPFIRE_WITH_CRUCIBLE_RECIPE_RECIPE_TYPE, 36, 1, 0, 36
        );
        registration.addRecipeTransferHandler(
                IntermediateCraftingTableMenu.class,
                ModMenuTypes.INTERMEDIATE_CRAFTING_TABLE_MENU.get(),
                IntermediateCraftingTableRecipeCategory.INTERMEDIATE_CRAFTING_TABLE_RECIPE_RECIPE_TYPE, 37, 13, 0, 36
        );
        registration.addRecipeTransferHandler(
                IntermediateCraftingTableMenu.class,
                ModMenuTypes.INTERMEDIATE_CRAFTING_TABLE_MENU.get(),
                RecipeTypes.CRAFTING, 37, 9, 0, 36
        );
    }
}
