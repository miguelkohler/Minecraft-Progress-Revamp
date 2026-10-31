package net.saitamaking.minecraftprogressrevamp.recipe;

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

import java.util.List;

public class TierOneCraftingTableRecipe implements Recipe<TierOneCraftingTableInput> {
    private final List<Ingredient> ingredients;
    private final ItemStack result;

    public TierOneCraftingTableRecipe(List<Ingredient> ingredients, ItemStack result) {
        this.ingredients = ingredients;
        this.result = result;
    }

    @Override
    public boolean matches(TierOneCraftingTableInput input, Level level) {
        for (int i = 0; i < 13; i++) {
            if (!ingredients.get(i).test(input.getItem(i))) return false;
        }
        return true;
    }

    @Override public ItemStack assemble(TierOneCraftingTableInput input, HolderLookup.Provider regs) { return result.copy(); }
    @Override public boolean canCraftInDimensions(int w, int h) { return true; }
    @Override public ItemStack getResultItem(HolderLookup.Provider regs) { return result; }
    @Override public RecipeSerializer<?> getSerializer() { return ModRecipeSerializers.TIER_ONE_CRAFTING_TABLE_SERIALIZER.get(); }
    @Override public RecipeType<?> getType() { return ModRecipeSerializers.TIER_ONE_CRAFTING_TABLE_TYPE.get(); }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(ingredients);
        return list;
    }

    public static class Serializer implements RecipeSerializer<TierOneCraftingTableRecipe> {
        public static final MapCodec<TierOneCraftingTableRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(r -> r.ingredients),
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(r -> r.result)
        ).apply(i, TierOneCraftingTableRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, TierOneCraftingTableRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), r -> r.ingredients,
                        ItemStack.STREAM_CODEC, r -> r.result,
                        TierOneCraftingTableRecipe::new);

        @Override public MapCodec<TierOneCraftingTableRecipe> codec() { return CODEC; }
        @Override public StreamCodec<RegistryFriendlyByteBuf, TierOneCraftingTableRecipe> streamCodec() { return STREAM_CODEC; }
    }
}