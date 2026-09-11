package net.saitamaking.minecraftprogressrevamp.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;

import java.util.List;
import java.util.Map;

public class SharpRockItem extends DiggerItem {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.OAK_LOG, ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                    Blocks.ACACIA_LOG, ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                    Blocks.DARK_OAK_LOG, ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                    Blocks.JUNGLE_LOG, ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                    Blocks.BIRCH_LOG, ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                    Blocks.CHERRY_LOG, ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                    Blocks.MANGROVE_LOG, ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                    Blocks.SPRUCE_LOG, ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                    Blocks.CRIMSON_STEM, ModBlocks.PRIMITIVECRAFTINGTABLE.get(),
                    Blocks.WARPED_STEM, ModBlocks.PRIMITIVECRAFTINGTABLE.get()
            );

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(16, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.AXE_STRIP, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    public SharpRockItem(Tier p_40521_, Item.Properties p_40524_) {
        super(p_40521_, BlockTags.SWORD_EFFICIENT, p_40524_);
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.0F)), 1.0F, 2);
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
        return createAttributes(tier, (float)attackDamage, attackSpeed);
    }

    public static ItemAttributeModifiers createAttributes(Tier p_330371_, float p_331976_, float p_332104_) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)(p_331976_ + p_330371_.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)p_332104_, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }
}
