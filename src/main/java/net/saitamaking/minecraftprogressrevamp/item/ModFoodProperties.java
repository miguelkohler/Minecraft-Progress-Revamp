package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SALT = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).alwaysEdible().build();
    public static final FoodProperties SALTEDBEEF = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4F).build();
    public static final FoodProperties SALTEDCOOKEDBEEF = new FoodProperties.Builder().nutrition(9).saturationModifier(0.8F).build();
}
