package net.saitamaking.minecraftprogressrevamp.block;

import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.util.ModTags;

@EventBusSubscriber(modid = ProgressRevamp.MODID)
public class ModBlockEvents {
    @SubscribeEvent
    public static void onBlockDrops(BlockDropsEvent event) {
        BlockState state = event.getState();
        net.minecraft.world.entity.Entity breaker = event.getBreaker();

        if (!(breaker instanceof Player player)) {
            return;
        }

        if (player.isCreative()) return;

        ItemStack heldItem = player.getMainHandItem();

        if (state.is(ModTags.Blocks.NEEDS_PRIMAL_TOOLS)) {
            if (heldItem.isEmpty() || !hasCorrectToolAction(heldItem, state)) {
                event.getDrops().clear();
                return;
            }
        }

        if (state.is(BlockTags.NEEDS_STONE_TOOL)) {
            if (heldItem.isEmpty() || !hasCorrectToolAction(heldItem, state)) {
                event.getDrops().clear();
            }
        }

        if (state.is(BlockTags.NEEDS_IRON_TOOL)) {
            if (heldItem.isEmpty() || !hasCorrectToolAction(heldItem, state)) {
                event.getDrops().clear();
            }
        }

        if (state.is(BlockTags.NEEDS_DIAMOND_TOOL)) {
            if (heldItem.isEmpty() || !hasCorrectToolAction(heldItem, state)) {
                event.getDrops().clear();
            }
        }
    }

    private static boolean hasCorrectToolAction(ItemStack stack, BlockState state) {
        Tool toolComponent = stack.get(DataComponents.TOOL);
        if (toolComponent != null) {
            return toolComponent.isCorrectForDrops(state);
        }
        return false;
    }
}
