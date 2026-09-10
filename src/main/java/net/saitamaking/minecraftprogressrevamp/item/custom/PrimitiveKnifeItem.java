package net.saitamaking.minecraftprogressrevamp.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

import java.util.List;
import java.util.Map;

public class PrimitiveKnifeItem extends DiggerItem {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG,
                    Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG,
                    Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG,
                    Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG,
                    Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG,
                    Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG,
                    Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG,
                    Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG,
                    Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM,
                    Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM
            );

    private static final Map<Block, Block> CHISEL_MAP2 =
            Map.of(
                    Blocks.SHORT_GRASS, Blocks.AIR,
                    Blocks.TALL_GRASS, Blocks.AIR
            );

    public PrimitiveKnifeItem(Tier tier, Properties properties) {
        super(tier, BlockTags.SWORD_EFFICIENT, properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        BlockPos pos = context.getClickedPos();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                Block.popResource(level, pos, new ItemStack(ModItems.TREEBARK.get(), 2));


                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.AXE_STRIP, SoundSource.BLOCKS);
            }
        }

        if(CHISEL_MAP2.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP2.get(clickedBlock).defaultBlockState());

                if(clickedBlock == Blocks.TALL_GRASS){
                    Block.popResource(level, pos, new ItemStack(ModItems.STRAW.get(), 2));
                } else {
                    Block.popResource(level, pos, new ItemStack(ModItems.STRAW.get()));
                }

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRASS_BREAK, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.primitive_knife.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.primitive_knife.not_shift_down"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
