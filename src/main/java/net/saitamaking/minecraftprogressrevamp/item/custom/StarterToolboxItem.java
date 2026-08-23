package net.saitamaking.minecraftprogressrevamp.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;

import java.util.Map;

public class StarterToolboxItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS,
                    Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS,
                    Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS,
                    Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES,
                    Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS,
                    Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG,
                    Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG,
                    Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG,
                    Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG,
                    Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG

            );

    private static final Map<Block, Block> CHISEL_MAP2 =
            Map.of(
                    Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG,
                    Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG,
                    Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG,
                    Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM,
                    Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM
            );

    private static final Map<Block, Block> INSTABREAK_MAP =
            Map.of(
                ModBlocks.RUDIMENTARYCRAFTINGTABLE.get(), Blocks.CRAFTING_TABLE
            );

    public StarterToolboxItem(Properties properties) {
        super(properties);
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

                level.playSound(null, context.getClickedPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS);
            }
        }

        if(CHISEL_MAP2.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP2.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS);
            }
        }

        if(INSTABREAK_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), INSTABREAK_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(9999999, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
