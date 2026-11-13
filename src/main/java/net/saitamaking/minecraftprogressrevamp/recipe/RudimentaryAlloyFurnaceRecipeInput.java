package net.saitamaking.minecraftprogressrevamp.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record RudimentaryAlloyFurnaceRecipeInput(ItemStack a, ItemStack b) implements RecipeInput {
    @Override
    public ItemStack getItem(int index) {
        return switch (index) {
            case 0 -> a;
            case 1 -> b;
            default -> throw new IllegalArgumentException("No item for index " + index);
        };
    }

    @Override
    public int size() { return 2; }
}
