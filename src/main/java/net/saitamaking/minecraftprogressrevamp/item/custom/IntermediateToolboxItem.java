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
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

import java.util.List;
import java.util.Map;

public class IntermediateToolboxItem extends Item {
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

    private static final Map<Block, Block> CHISEL_MAP3 =
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

    private static final Map<Block, Block> CHISEL_MAP4 =
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

    private static final Map<Block, Block> INSTABREAK_MAP =
            Map.of(
                Blocks.CRAFTING_TABLE, ModBlocks.INTERMEDIATECRAFTINGTABLE.get()
            );

    public IntermediateToolboxItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        BlockPos blockpos = context.getClickedPos();
        if(Screen.hasShiftDown()){
            if(CHISEL_MAP3.containsKey(clickedBlock)) {
                if(!level.isClientSide()){
                    level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP3.get(clickedBlock).defaultBlockState());

                    context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                    level.playSound(null, context.getClickedPos(), SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS);

                    return InteractionResult.SUCCESS;
                }
            }

            if(CHISEL_MAP4.containsKey(clickedBlock)) {
                if(!level.isClientSide()){
                    level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP4.get(clickedBlock).defaultBlockState());

                    context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                    level.playSound(null, context.getClickedPos(), SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS);

                    return InteractionResult.SUCCESS;
                }
            }

            if(Screen.hasShiftDown()){
                if(INSTABREAK_MAP.containsKey(clickedBlock)) {
                    if(!level.isClientSide()){
                        if(context.getItemInHand().is(ModItems.INTERMEDIATETOOLBOX)){
                            level.setBlockAndUpdate(context.getClickedPos(), INSTABREAK_MAP.get(clickedBlock).defaultBlockState());

                            context.getItemInHand().shrink(1);

                            level.playSound(null, context.getClickedPos(), SoundEvents.SMITHING_TABLE_USE, SoundSource.BLOCKS);
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
            }
        } else{
            if(CHISEL_MAP.containsKey(clickedBlock)) {
                if(!level.isClientSide()){
                    level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                    context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                    level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_BREAK, SoundSource.BLOCKS);

                    return InteractionResult.SUCCESS;
                }
            }

            if(CHISEL_MAP2.containsKey(clickedBlock)) {
                if(!level.isClientSide()){
                    level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP2.get(clickedBlock).defaultBlockState());

                    context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                    level.playSound(null, context.getClickedPos(), SoundEvents.AXE_STRIP, SoundSource.BLOCKS);

                    return InteractionResult.SUCCESS;
                }
            }

            if(INSTABREAK_MAP.containsKey(clickedBlock)) {
                if(!level.isClientSide()){
                    if(context.getItemInHand().is(ModItems.INTERMEDIATETOOLBOX)){
                        level.setBlockAndUpdate(context.getClickedPos(), INSTABREAK_MAP.get(clickedBlock).defaultBlockState());

                        context.getItemInHand().shrink(1);

                        level.playSound(null, context.getClickedPos(), SoundEvents.SMITHING_TABLE_USE, SoundSource.BLOCKS);
                        return InteractionResult.SUCCESS;
                    }
                }
            }

            return InteractionResult.SUCCESS_NO_ITEM_USED;
        }

        return InteractionResult.SUCCESS_NO_ITEM_USED;
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

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.intermediate_toolbox.shift_down")
                    .append(Component.literal(" ")));
            tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.crafting_table_transform_item"));
            tooltipComponents.add(Component.translatable("block.minecraft.crafting_table")
                    .append(Component.literal(" into a "))
                    .append(Component.translatable("block.minecraftprogressrevamp.intermediate_crafting_table")));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.starter_toolbox.not_shift_down"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
