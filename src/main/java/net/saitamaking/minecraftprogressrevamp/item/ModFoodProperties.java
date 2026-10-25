package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModFoodProperties {
    public static final FoodProperties SALT = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).alwaysEdible().build();
    public static final FoodProperties SALTEDBEEF = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4F).build();
    public static final FoodProperties SALTEDCOOKEDBEEF = new FoodProperties.Builder().nutrition(9).saturationModifier(0.8F).build();
    public static final FoodProperties SALTEDCHICKEN = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6F).build();
    public static final FoodProperties SALTEDCOOKEDCOD = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build();
    public static final FoodProperties SALTEDCOOKEDSALMON = new FoodProperties.Builder().nutrition(7).saturationModifier(0.8F).build();
    public static final FoodProperties SALTEDMUTTON = new FoodProperties.Builder().nutrition(7).saturationModifier(0.8F).build();
    public static final FoodProperties SALTEDPORKCHOPS = new FoodProperties.Builder().nutrition(9).saturationModifier(0.8F).build();
    public static final FoodProperties SALTEDRABBIT = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build();
    public static final FoodProperties RAWSALTEDCHICKEN = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
    public static final FoodProperties RAWSALTEDCOD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).build();
    public static final FoodProperties RAWSALTEDSALMON = new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).build();
    public static final FoodProperties RAWSALTEDMUTTON = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build();
    public static final FoodProperties RAWSALTEDPORKCHOPS = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build();
    public static final FoodProperties RAWSALTEDRABBIT = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build();
}
