package net.saitamaking.minecraftprogressrevamp.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record RudimentaryAlloyFurnaceRecipe(Ingredient ingredientA, Ingredient ingredientB,ItemStack output, int cookingTime) implements Recipe<RudimentaryAlloyFurnaceRecipeInput> {
    // input and output are read from JSON file, RecipeInput reads inventory of the block

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(ingredientA);
        list.add(ingredientB);
        return list;
    }

    @Override
    public boolean matches(RudimentaryAlloyFurnaceRecipeInput in, Level level) {
        if (level.isClientSide()) return false;
        return (ingredientA.test(in.a()) && ingredientB.test(in.b()))
                || (ingredientA.test(in.b()) && ingredientB.test(in.a()));
    }

    @Override
    public ItemStack assemble(RudimentaryAlloyFurnaceRecipeInput rudimentaryAlloyFurnaceRecipeInput, HolderLookup.Provider provider) {
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
        return ModRecipeSerializers.RUDIMENTARY_ALLOY_FURNACE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeSerializers.RUDIMENTARY_ALLOY_FURNACE_TYPE.get();
    }

    public static final MapCodec<RudimentaryAlloyFurnaceRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient_a").forGetter(RudimentaryAlloyFurnaceRecipe::ingredientA),
            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient_b").forGetter(RudimentaryAlloyFurnaceRecipe::ingredientB),
            ItemStack.CODEC.fieldOf("result").forGetter(RudimentaryAlloyFurnaceRecipe::output),
            Codec.INT.optionalFieldOf("cooking_time", 200).forGetter(RudimentaryAlloyFurnaceRecipe::cookingTime)
    ).apply(inst, RudimentaryAlloyFurnaceRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, RudimentaryAlloyFurnaceRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC, RudimentaryAlloyFurnaceRecipe::ingredientA,
                    Ingredient.CONTENTS_STREAM_CODEC, RudimentaryAlloyFurnaceRecipe::ingredientB,
                    ItemStack.STREAM_CODEC,           RudimentaryAlloyFurnaceRecipe::output,
                    ByteBufCodecs.VAR_INT,            RudimentaryAlloyFurnaceRecipe::cookingTime,
                    RudimentaryAlloyFurnaceRecipe::new
            );


    public static class Serializer implements RecipeSerializer<RudimentaryAlloyFurnaceRecipe> {
        @Override
        public MapCodec<RudimentaryAlloyFurnaceRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, RudimentaryAlloyFurnaceRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
