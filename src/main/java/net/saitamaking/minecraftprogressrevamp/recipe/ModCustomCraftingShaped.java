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
            } else {
                remaining.set(i, CommonHooks.getCraftingRemainingItem(stack));
            }
        }
        return remaining;
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
