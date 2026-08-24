package net.saitamaking.minecraftprogressrevamp.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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

import java.util.List;
import java.util.Map;

public class StarterToolboxItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS,
                    Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS,
                    Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS,
                    Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES,
                    Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS
            );

    private static final Map<Block, Block> CHISEL_MAP2 =
            Map.of(
                    Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG,
                    Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG,
                    Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG,
                    Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG,
                    Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG,
                    Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG,
                    Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG,
                    Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG,
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
        BlockPos blockpos = context.getClickedPos();
        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_HIT, SoundSource.BLOCKS);
            }
        }

        if(CHISEL_MAP2.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP2.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.AXE_STRIP, SoundSource.BLOCKS);
            }
        }

        if(INSTABREAK_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), INSTABREAK_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(9999999, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.SMITHING_TABLE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Tool.Rule.overrideSpeed(BlockTags.LEAVES, 15.0F), Tool.Rule.overrideSpeed(BlockTags.WOOL, 5.0F), Tool.Rule.overrideSpeed(List.of(Blocks.VINE, Blocks.GLOW_LICHEN), 2.0F)), 1.0F, 1);
    }

    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!level.isClientSide && !state.is(BlockTags.FIRE)) {
            stack.hurtAndBreak(1, entityLiving, EquipmentSlot.MAINHAND);
        }

        return state.is(BlockTags.LEAVES) || state.is(Blocks.COBWEB) || state.is(Blocks.SHORT_GRASS) || state.is(Blocks.FERN) || state.is(Blocks.DEAD_BUSH) || state.is(Blocks.HANGING_ROOTS) || state.is(Blocks.VINE) || state.is(Blocks.TRIPWIRE) || state.is(BlockTags.WOOL);
    }

    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity instanceof IShearable target) {
            BlockPos pos = entity.blockPosition();
            boolean isClient = entity.level().isClientSide();
            if (target.isShearable(player, stack, entity.level(), pos)) {
                List<ItemStack> drops = target.onSheared(player, stack, entity.level(), pos);
                if (!isClient) {
                    for(ItemStack drop : drops) {
                        target.spawnShearedDrop(entity.level(), pos, drop);
                    }
                }

                entity.gameEvent(GameEvent.SHEAR, player);
                if (!isClient) {
                    stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                }

                return InteractionResult.sidedSuccess(isClient);
            }
        }

        return InteractionResult.PASS;
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_SHEARS_ACTIONS.contains(itemAbility);
    }
}
