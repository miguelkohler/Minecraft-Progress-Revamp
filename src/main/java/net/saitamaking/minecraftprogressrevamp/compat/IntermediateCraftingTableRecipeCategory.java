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
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.recipe.CobblestoneAnvilRecipe;
import net.saitamaking.minecraftprogressrevamp.recipe.TierOneCraftingTableRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IntermediateCraftingTableRecipeCategory implements IRecipeCategory<TierOneCraftingTableRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "intermediate_crafting_table");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID,
            "textures/gui/craftingtables/intermediate_crafting_table_gui.png");

    public static final RecipeType<TierOneCraftingTableRecipe> INTERMEDIATE_CRAFTING_TABLE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, TierOneCraftingTableRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public IntermediateCraftingTableRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 4 ,10, 160, 104);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.INTERMEDIATECRAFTINGTABLE));
    }

    @Override
    public RecipeType<TierOneCraftingTableRecipe> getRecipeType() {
        return INTERMEDIATE_CRAFTING_TABLE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.minecraftprogressrevamp.intermediate_crafting_table");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    private static final int[][] SLOT_POS = {
            {30, 35}, {48, 35}, {66, 35},   //slots:0-2
            {30, 53}, {48, 53}, {66, 53},   //slots:3-5
            {30, 71}, {48, 71}, {66, 71},   //slots:6-8
            {48, 17},                       //slot 9  top extra
            {12, 53},                       //slot 10 left extra
            {84, 53},                       //slot 11 right extra
            {48, 89}                        //slot 12 bottom extra
    };
    private static final int RESULT_X = 142, RESULT_Y = 53;
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TierOneCraftingTableRecipe recipe, IFocusGroup focuses) {
        List<Ingredient> ingredients = recipe.getIngredients();

        for (int i = 0; i < SLOT_POS.length; i++) {
            IRecipeSlotBuilder slot = builder.addSlot(RecipeIngredientRole.INPUT,
                    SLOT_POS[i][0] - 4, SLOT_POS[i][1] - 10);
            Ingredient ingredient = ingredients.get(i);
            if (!ingredient.isEmpty()) {
                slot.addIngredients(ingredient);
            }
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, RESULT_X - 4, RESULT_Y - 10)
                .addItemStack(recipe.getResultItem(RegistryAccess.EMPTY));
    }
}
