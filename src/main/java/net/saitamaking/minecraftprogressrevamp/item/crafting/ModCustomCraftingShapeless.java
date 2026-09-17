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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.neoforged.neoforge.common.CommonHooks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;
import net.saitamaking.minecraftprogressrevamp.util.ModTags;

import java.util.ArrayList;
import java.util.List;

public class ModCustomCraftingShapeless extends ShapelessRecipe {

    private final String group;
    private final CraftingBookCategory category;
    private final List<Ingredient> ingredients;
    private final ItemStack result;

    public ModCustomCraftingShapeless(
            final String group,
            final CraftingBookCategory category,
            final ItemStack result,
            final List<Ingredient> ingredients
    ) {
        super(group, category, result, (NonNullList<Ingredient>) NonNullList.of(Ingredient.EMPTY, ingredients.toArray(new Ingredient[0])));
        this.group = group;
        this.category = category;
        this.ingredients = ingredients;
        this.result = result;
    }

    private static final List<Item> CORRECT_TOOL = List.of(
            ModItems.PRIMITIVESAW.get(),
            ModItems.PRIMITIVESHEARS.get(),
            ModItems.PRIMITIVEHAMMER.get(),
            ModItems.PRIMITIVEAXE.get(),
            ModItems.PRIMITIVEKNIFE.get()
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
            } else if (!stack.isEmpty() && stack.is(ModTags.Items.INGOTSHAPED)) {
                remainingItems.set(i, stack.copyWithCount(stack.getCount()));
            } else {
                remainingItems.set(i, CommonHooks.getCraftingRemainingItem(stack));
            }
        }

        return remainingItems;
    }

    @Override
    public RecipeSerializer<ModCustomCraftingShapeless> getSerializer() {
        return ModRecipeSerializers.DURABILITY_SHAPELESS.get();
    }

    public static final MapCodec<ModCustomCraftingShapeless> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    com.mojang.serialization.Codec.STRING.optionalFieldOf("group", "").forGetter(r -> r.group),
                    CraftingBookCategory.CODEC.optionalFieldOf("category", CraftingBookCategory.MISC).forGetter(r -> r.category),
                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(r -> r.result),
                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(r -> r.ingredients)
            ).apply(instance, ModCustomCraftingShapeless::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ModCustomCraftingShapeless> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, r -> r.group,
            CraftingBookCategory.STREAM_CODEC, r -> r.category,
            ItemStack.STREAM_CODEC, r -> r.result,
            ByteBufCodecs.collection(ArrayList::new, Ingredient.CONTENTS_STREAM_CODEC), r -> r.ingredients,
            ModCustomCraftingShapeless::new
    );

    public static class Serializer implements RecipeSerializer<ModCustomCraftingShapeless> {
        @Override
        public MapCodec<ModCustomCraftingShapeless> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ModCustomCraftingShapeless> streamCodec() {
            return STREAM_CODEC;
        }
    }
}