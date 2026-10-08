package net.saitamaking.minecraftprogressrevamp.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.neoforged.neoforge.common.CommonHooks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;
import net.saitamaking.minecraftprogressrevamp.util.ModTags;

import java.util.List;

public class CobAnvilToolDurability {
    private CobAnvilToolDurability() {}

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

    public static NonNullList<ItemStack> remainingItems(CraftingInput input) {
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

    private static ItemStack damage(ItemStack stack) {
        Player player = CommonHooks.getCraftingPlayer();
        if (player != null && player.level() instanceof ServerLevel serverLevel) {
            stack.hurtAndBreak(4, serverLevel,
                    player instanceof ServerPlayer sp ? sp : null,
                    item -> stack.setCount(0));
        }
        return stack;
    }
}
