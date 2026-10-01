package net.saitamaking.minecraftprogressrevamp.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public record CampfireWithCrucibleRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CampfireWithCrucibleRecipeInput> {
    // input and output are read from JSON file, RecipeInput reads inventory of the block

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return Recipe.super.getIngredients();
    }

    @Override
    public boolean matches(CampfireWithCrucibleRecipeInput campfireWithCrucibleRecipeInput, Level level) {
        if(level.isClientSide()) {
            return false;
        }

        return inputItem.test(campfireWithCrucibleRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(CampfireWithCrucibleRecipeInput campfireWithCrucibleRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.CAMPFIRE_WITH_CRUCIBLE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeSerializers.CAMPFIRE_WITH_CRUCIBLE_TYPE.get();
    }

    public static final MapCodec<CampfireWithCrucibleRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(CampfireWithCrucibleRecipe::inputItem),
            ItemStack.CODEC.fieldOf("result").forGetter(CampfireWithCrucibleRecipe::output)
    ).apply(inst, CampfireWithCrucibleRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CampfireWithCrucibleRecipe> STREAM_CODEC =
            StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, r -> r.inputItem,
                ItemStack.STREAM_CODEC, r -> r.output,
                CampfireWithCrucibleRecipe::new
            );


    public static class Serializer implements RecipeSerializer<CampfireWithCrucibleRecipe> {
        @Override
        public MapCodec<CampfireWithCrucibleRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CampfireWithCrucibleRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
