package net.saitamaking.minecraftprogressrevamp.item.crafting;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;

public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, ProgressRevamp.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, ModCustomCraftingShaped.Serializer> DURABILITY_SHAPED =
            RECIPE_SERIALIZERS.register("durability_shaped", ModCustomCraftingShaped.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, ModCustomCraftingShapeless.Serializer> DURABILITY_SHAPELESS =
            RECIPE_SERIALIZERS.register("durability_shapeless", ModCustomCraftingShapeless.Serializer::new);
}
