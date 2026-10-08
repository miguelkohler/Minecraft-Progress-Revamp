package net.saitamaking.minecraftprogressrevamp.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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

    private static List<TagKey<Item>> tools() {
        return List.of(
                ModTags.Items.SAWS,
                ModTags.Items.SHEARS,
                ModTags.Items.HAMMERS,
                ItemTags.AXES,
                ModTags.Items.KNIVES
        );
    }

    private static boolean isDamageableTool(ItemStack stack) {
        if (stack.isEmpty() || !stack.isDamageableItem()) {return false;}
        for (TagKey<Item> tag : tools()) {
            if (stack.is(tag)) return true;
        }
        return false;
    }

    private static ItemStack damage(ItemStack stack) {
        Player player = CommonHooks.getCraftingPlayer();
        if (player != null && player.level() instanceof ServerLevel serverLevel) {
            stack.hurtAndBreak(1, serverLevel,
                    player instanceof ServerPlayer sp ? sp : null,
                    item -> stack.setCount(0));
        }
        return stack;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(final CraftingInput input) {
        NonNullList<ItemStack> remaining = NonNullList.withSize(input.size(), ItemStack.EMPTY);

        for (int i = 0; i < remaining.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (isDamageableTool(stack)) {
                remaining.set(i, damage(stack.copy()));
            } else if (!stack.isEmpty() && stack.is(ModTags.Items.INGOTSHAPED)) {
                remaining.set(i, stack.copyWithCount(1));
            } else {
                remaining.set(i, CommonHooks.getCraftingRemainingItem(stack));
            }
        }
        return remaining;
    }

    @Override
    public RecipeSerializer<ModCustomCraftingShapeless> getSerializer() { return ModRecipeSerializers.DURABILITY_SHAPELESS.get();}

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