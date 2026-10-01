package net.saitamaking.minecraftprogressrevamp.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.neoforged.neoforge.common.CommonHooks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

import java.util.List;

public class CobAnvilToolDurability {
    private CobAnvilToolDurability() {}

    private static List<Item> tools() {
        return List.of(
                ModItems.PRIMITIVESAW.get(),
                ModItems.PRIMITIVESHEARS.get(),
                ModItems.PRIMITIVEHAMMER.get(),
                ModItems.PRIMITIVEAXE.get(),
                ModItems.PRIMITIVEKNIFE.get()
        );
    }

    public static NonNullList<ItemStack> remainingItems(CraftingInput input) {
        List<Item> tools = tools();
        NonNullList<ItemStack> remaining = NonNullList.withSize(input.size(), ItemStack.EMPTY);

        for (int i = 0; i < remaining.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (!stack.isEmpty() && tools.contains(stack.getItem())) {
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
            stack.hurtAndBreak(8, serverLevel,
                    player instanceof ServerPlayer sp ? sp : null,
                    item -> stack.setCount(0));
        }
        return stack;
    }
}
