package net.saitamaking.minecraftprogressrevamp.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.IShearable;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.component.ModDataComponents;

import java.util.List;
import java.util.Map;

public class MagnifyingGlassItem extends Item {

    public MagnifyingGlassItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack,UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState state = level.getBlockState(blockpos);
        if(!level.isClientSide()){
            level.playSound(null, context.getClickedPos(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER, SoundSource.BLOCKS);

            stack.set(ModDataComponents.BLOCKNAME.get(), state.getBlock());

            Block block = stack.get(ModDataComponents.BLOCKNAME.get());
            Player player = context.getPlayer();
            if (block != null && player != null) {
                Component name = block.getName();
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.magnifying_glass.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.magnifying_glass.not_shift_down"));
        }

        Block saved = stack.get(ModDataComponents.BLOCKNAME.get());
        if (saved != null) {
            tooltipComponents.add(Component.literal("Block: ").append(saved.getName()));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
