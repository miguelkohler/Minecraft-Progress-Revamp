package net.saitamaking.minecraftprogressrevamp.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.recipe.CampfireWithCrucibleRecipe;
import org.jetbrains.annotations.Nullable;

public class CampfireWithCrucibleRecipeCategory implements IRecipeCategory<CampfireWithCrucibleRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "campfire_with_crucible");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID,
            "textures/gui/furnacelike/campfire_with_crucible_gui.png");

    public static final RecipeType<CampfireWithCrucibleRecipe> CAMPFIRE_WITH_CRUCIBLE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, CampfireWithCrucibleRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CampfireWithCrucibleRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 42 ,26, 106, 42);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CAMPFIREWITHCRUCIBLE));
    }

    @Override
    public RecipeType<CampfireWithCrucibleRecipe> getRecipeType() {
        return CAMPFIRE_WITH_CRUCIBLE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.minecraftprogressrevamp.campfire_with_crucible_recipe");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CampfireWithCrucibleRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 14, 8).addIngredients(recipe.inputItem());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 74, 8).addItemStack(recipe.getResultItem(null));
    }
}
