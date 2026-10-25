package net.saitamaking.minecraftprogressrevamp.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.recipe.CampfireWithCrucibleRecipe;
import net.saitamaking.minecraftprogressrevamp.recipe.CobblestoneAnvilRecipe;
import org.jetbrains.annotations.Nullable;

public class CobblestoneAnvilRecipeCategory implements IRecipeCategory<CobblestoneAnvilRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "cobblestone_anvil");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID,
            "textures/gui/cobblestoneanvil/cobblestone_anvil_gui.png");

    public static final RecipeType<CobblestoneAnvilRecipe> COBBLESTONE_ANVIL_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, CobblestoneAnvilRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CobblestoneAnvilRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 4 ,10, 146, 64);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COBBLESTONEANVIL));
    }

    @Override
    public RecipeType<CobblestoneAnvilRecipe> getRecipeType() {
        return COBBLESTONE_ANVIL_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.minecraftprogressrevamp.cobblestone_anvil");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    private static final int GRID_X = 4;
    private static final int GRID_Y = 3;
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CobblestoneAnvilRecipe recipe, IFocusGroup focuses) {
        NonNullList<Ingredient> ingredients = recipe.getIngredients();

        for (int y = 0; y < GRID_Y; y++) {
            for (int x = 0; x < GRID_X; x++) {
                IRecipeSlotBuilder slot = builder.addSlot(RecipeIngredientRole.INPUT, 8 + x * 18, 7 + y * 18);
                if (x < recipe.getWidth() && y < recipe.getHeight()) {
                    Ingredient ingredient = ingredients.get(y * recipe.getWidth() + x);
                    if (!ingredient.isEmpty()) {
                        slot.addIngredients(ingredient);
                    }
                }
            }
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 120, 25).addItemStack(recipe.getResultItem(null));
    }
}
