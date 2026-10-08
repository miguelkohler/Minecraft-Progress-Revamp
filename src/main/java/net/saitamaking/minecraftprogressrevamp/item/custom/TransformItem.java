package net.saitamaking.minecraftprogressrevamp.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Supplier;

public class TransformItem extends Item {

    private final ResourceLocation targetBlockId;
    private final Supplier<? extends Item> result;

    private static final ResourceLocation GRINDSTONE = ResourceLocation.withDefaultNamespace("grindstone");

    public TransformItem(String blockKey, Supplier<? extends Item> result, Properties properties) {
        super(properties);
        this.targetBlockId = ResourceLocation.parse(blockKey.contains(":") ? blockKey : "minecraft:" + blockKey);
        this.result = result;
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();

        ResourceLocation clickedId = BuiltInRegistries.BLOCK.getKey(level.getBlockState(pos).getBlock());
        if (player == null || !clickedId.equals(targetBlockId)) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide()) {

            if (state.getBlock() instanceof LayeredCauldronBlock) {
                LayeredCauldronBlock.lowerFillLevel(state, level, pos);
            }

            transform(player, context.getHand(), stack);
            playTransformSound(level, pos);
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    private void transform(Player player, InteractionHand hand, ItemStack stack) {
        ItemStack newStack = new ItemStack(result.get());

        if (stack.getCount() == 1) {
            player.setItemInHand(hand, newStack);
        } else {
            stack.shrink(1);
            if (!player.getInventory().add(newStack)) {
                player.drop(newStack, false);
            }
        }
    }

    private void playTransformSound(Level level, BlockPos pos) {
        SoundEvent sound;
        float pitch;

        if (targetBlockId.equals(GRINDSTONE)) {
            sound = SoundEvents.GRINDSTONE_USE;
            pitch = 0.8F + (level.random.nextFloat() - 0.5F) * 0.2F;
        } else if (targetBlockId.getPath().endsWith("cauldron")) {
            sound = SoundEvents.FIRE_EXTINGUISH;
            pitch = 1.0F + (level.random.nextFloat() - 0.5F) * 0.2F;
        } else {
            sound = SoundEvents.PLAYER_LEVELUP;
            pitch = 0.8F;
        }

        level.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0F, pitch);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(targetBlockId.equals(GRINDSTONE)){
            if (Screen.hasShiftDown()) {
                tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.dull_item.shift_down"));
            } else {
                tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.dull_item.not_shift_down"));
            }
        } else if(targetBlockId.getPath().endsWith("cauldron")){
            if (Screen.hasShiftDown()) {
                tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.hot_item.shift_down"));
            } else {
                tooltipComponents.add(Component.translatable("tooltip.minecraftprogressrevamp.hot_item.not_shift_down"));
            }
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}