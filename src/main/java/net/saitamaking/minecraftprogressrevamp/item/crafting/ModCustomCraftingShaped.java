package net.saitamaking.minecraftprogressrevamp.item.crafting;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.neoforged.neoforge.common.CommonHooks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

import java.util.List;

public class ModCustomCraftingShaped extends ShapedRecipe {

    private final String group;
    private final CraftingBookCategory category;
    private final ShapedRecipePattern pattern;
    private final ItemStack result;

    public ModCustomCraftingShaped(
            final String group,
            final CraftingBookCategory category,
            final ShapedRecipePattern pattern,
            final ItemStack result
    ) {
        super(group, category, pattern, result);
        this.group = group;
        this.category = category;
        this.pattern = pattern;
        this.result = result;
    }

    private static final List<Item> CORRECT_TOOL = List.of(
            ModItems.PRIMITIVESAW.get(),
            ModItems.PRIMITIVESHEARS.get(),
            ModItems.PRIMITIVEHAMMER.get(),
            ModItems.PRIMITIVEAXE.get(),
            ModItems.PRIMITIVESAW.get()
    );

    @SuppressWarnings("UnstableApiUsage")
    private ItemStack damageItem(final ItemStack stack) {
        final var craftingPlayer = CommonHooks.getCraftingPlayer();

        if (craftingPlayer.level() instanceof final ServerLevel serverLevel) {
            stack.hurtAndBreak(
                    1,
                    serverLevel,
                    craftingPlayer instanceof final ServerPlayer serverPlayer ? serverPlayer : null,
                    item -> stack.setCount(0)
            );
        }

        return stack;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(final CraftingInput input) {
        final var remainingItems = NonNullList.withSize(input.size(), ItemStack.EMPTY);

        for (var i = 0; i < remainingItems.size(); ++i) {
            final var stack = input.getItem(i);

            if (!stack.isEmpty() && CORRECT_TOOL.contains(stack.getItem())) {
                remainingItems.set(i, damageItem(stack.copy()));
            } else {
                remainingItems.set(i, CommonHooks.getCraftingRemainingItem(stack));
            }
        }

        return remainingItems;
    }

    @Override
    public RecipeSerializer<ModCustomCraftingShaped> getSerializer() {
        return ModRecipeSerializers.DURABILITY_SHAPED.get();
    }

    public static final MapCodec<ModCustomCraftingShaped> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    com.mojang.serialization.Codec.STRING.optionalFieldOf("group", "").forGetter(r -> r.group),
                    CraftingBookCategory.CODEC.optionalFieldOf("category", CraftingBookCategory.MISC).forGetter(r -> r.category),
                    ShapedRecipePattern.MAP_CODEC.forGetter(r -> r.pattern),
                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(r -> r.result)
            ).apply(instance, ModCustomCraftingShaped::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ModCustomCraftingShaped> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, r -> r.group,
            CraftingBookCategory.STREAM_CODEC, r -> r.category,
            ShapedRecipePattern.STREAM_CODEC, r -> r.pattern,
            ItemStack.STREAM_CODEC, r -> r.result,
            ModCustomCraftingShaped::new
    );

    public static class Serializer implements RecipeSerializer<ModCustomCraftingShaped> {
        @Override
        public MapCodec<ModCustomCraftingShaped> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ModCustomCraftingShaped> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
