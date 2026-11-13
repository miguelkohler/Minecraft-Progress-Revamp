package net.saitamaking.minecraftprogressrevamp.compat;

import mezz.jei.api.constants.Tags;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.ITypedIngredient;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.crafting.IngredientType;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.block.entity.RudimentaryAlloyFurnaceEntity;
import net.saitamaking.minecraftprogressrevamp.recipe.CampfireWithCrucibleRecipe;
import net.saitamaking.minecraftprogressrevamp.recipe.RudimentaryAlloyFurnaceRecipe;
import net.saitamaking.minecraftprogressrevamp.recipe.TierOneCraftingTableRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RudimentaryAlloyFurnaceRecipeCategory implements IRecipeCategory<RudimentaryAlloyFurnaceRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "rudimentary_alloy_furnace");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID,
            "textures/gui/furnacelike/alloy_smelter_gui.png");

    public static final RecipeType<RudimentaryAlloyFurnaceRecipe> RUDIMENTARY_ALLOY_FURNACE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, RudimentaryAlloyFurnaceRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public RudimentaryAlloyFurnaceRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 49 ,10, 80, 72);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.RUDIMENTARYALLOYFURNACE));
    }

    @Override
    public RecipeType<RudimentaryAlloyFurnaceRecipe> getRecipeType() {
        return RUDIMENTARY_ALLOY_FURNACE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.minecraftprogressrevamp.rudimentary_alloy_furnace");
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
    public void setRecipe(IRecipeLayoutBuilder builder, RudimentaryAlloyFurnaceRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 7, 7).addIngredients(recipe.ingredientA());
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 7).addIngredients(recipe.ingredientB());

        List<ItemStack> fuels = RudimentaryAlloyFurnaceEntity.getFuel().keySet().stream()
                .map(ItemStack::new).toList();
        builder.addSlot(RecipeIngredientRole.CATALYST, 7, 43).addItemStacks(fuels);
        builder.addSlot(RecipeIngredientRole.CATALYST, 55, 43).addItemStacks(fuels);

        builder.addSlot(RecipeIngredientRole.OUTPUT, 31, 47).addItemStack(recipe.getResultItem(null));
    }
}
