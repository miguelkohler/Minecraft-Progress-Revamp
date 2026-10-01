package net.saitamaking.minecraftprogressrevamp.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class CobblestoneAnvilRecipe extends ShapedRecipe {
    final ShapedRecipePattern pattern;
    final ItemStack result;

    public CobblestoneAnvilRecipe(ShapedRecipePattern pattern, ItemStack result) {
        super("", CraftingBookCategory.MISC, pattern, result);
        this.pattern = pattern;
        this.result = result;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        return CobAnvilToolDurability.remainingItems(input);
    }

    @Override public RecipeSerializer<?> getSerializer() { return ModRecipeSerializers.COBBLESTONE_ANVIL_SERIALIZER.get(); }
    @Override public RecipeType<?> getType() { return ModRecipeSerializers.COBBLESTONE_ANVIL_TYPE.get(); }

    public static class Serializer implements RecipeSerializer<CobblestoneAnvilRecipe> {
        public static final MapCodec<CobblestoneAnvilRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                ShapedRecipePattern.MAP_CODEC.forGetter(r -> r.pattern),
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(r -> r.result)
        ).apply(i, CobblestoneAnvilRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, CobblestoneAnvilRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ShapedRecipePattern.STREAM_CODEC, r -> r.pattern,
                        ItemStack.STREAM_CODEC, r -> r.result,
                        CobblestoneAnvilRecipe::new);

        @Override public MapCodec<CobblestoneAnvilRecipe> codec() { return CODEC; }
        @Override public StreamCodec<RegistryFriendlyByteBuf, CobblestoneAnvilRecipe> streamCodec() { return STREAM_CODEC; }
    }
}