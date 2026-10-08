package net.saitamaking.minecraftprogressrevamp.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

public class ChiselItem extends DiggerItem {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.COPPER_BLOCK, Blocks.CHISELED_COPPER,
                    Blocks.DEEPSLATE, Blocks.CHISELED_DEEPSLATE,
                    Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS,
                    Blocks.TUFF, Blocks.CHISELED_TUFF,
                    Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK,
                    Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE,
                    Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS,
                    Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE,
                    Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS,
                    Blocks.POLISHED_BLACKSTONE, Blocks.CHISELED_POLISHED_BLACKSTONE
            );

    private static final Map<Block, Block> CHISEL_MAP2 =
            Map.of(
                    Blocks.EXPOSED_COPPER, Blocks.EXPOSED_CHISELED_COPPER,
                    Blocks.OXIDIZED_COPPER, Blocks.OXIDIZED_CHISELED_COPPER,
                    Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_CHISELED_COPPER,
                    Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_EXPOSED_CHISELED_COPPER,
                    Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_CHISELED_COPPER,
                    Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_WEATHERED_CHISELED_COPPER,
                    Blocks.WEATHERED_COPPER, Blocks.WEATHERED_CHISELED_COPPER,
                    Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_CHISELED_STONE_BRICKS
            );

    public ChiselItem(Tier tier, Properties properties) {
        super(tier, BlockTags.SWORD_EFFICIENT, properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS);
            }
        }

        if(CHISEL_MAP2.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP2.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.chisel.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.chisel.not_shift_down"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
