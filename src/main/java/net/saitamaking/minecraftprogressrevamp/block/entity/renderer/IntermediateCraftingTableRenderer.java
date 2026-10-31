package net.saitamaking.minecraftprogressrevamp.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.saitamaking.minecraftprogressrevamp.block.entity.IntermediateCraftingTableEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.RudimentaryCraftingTableEntity;

import java.lang.reflect.Array;
import java.util.List;

import static net.saitamaking.minecraftprogressrevamp.block.custom.WoodenCrateBlock.FACING;

public class IntermediateCraftingTableRenderer implements BlockEntityRenderer<IntermediateCraftingTableEntity> {

    public IntermediateCraftingTableRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(IntermediateCraftingTableEntity be, float partialTick, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        int itemLight = getLightLevel(be.getLevel(), be.getBlockPos());
        float spin = be.getRenderingRotation();

        pose.pushPose();

        pose.translate(0.5, 0.5, 0.5);
        pose.mulPose(Axis.YP.rotationDegrees(-be.getBlockState().getValue(FACING).toYRot()));
        pose.translate(-0.5, -0.5, -0.5);

        for (int slot = 0; slot < 13; slot++) {
            ItemStack stack = be.getInventory().getStackInSlot(slot);
            if (stack.isEmpty()) continue;

            float x;
            float z;

            //+x = <-
            if (slot % 3 == 0 && slot < 8) {
                x = 0.62f;
            } else if(slot == 9 || slot == 1 || slot == 4 || slot == 7 || slot == 12){
                x = 0.5f;
            } else if(slot == 2 || slot == 5 || slot == 8){
                x = 0.38f;
            } else if(slot == 10){
                x = 0.74f;
            } else {
                x = 0.26f;
            }

            //+z = ^
            if (slot < 3) {
                z = 0.62f;
            } else if(slot == 10 || slot == 3 || slot == 4 || slot == 5 || slot == 11){
                z = 0.5f;
            } else if(slot > 5 && slot < 9){
                z = 0.38f;
            } else if(slot == 9){
                z = 0.74f;
            } else {
                z = 0.26f;
            }

            pose.pushPose();
            pose.translate(x, 1.20f, z);
            pose.scale(0.15f, 0.15f, 0.15f);
            pose.mulPose(Axis.YP.rotationDegrees(spin));
            itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, itemLight,
                    OverlayTexture.NO_OVERLAY, pose, buffer, be.getLevel(), 1);
            pose.popPose();
        }
        pose.popPose();
    }
    private int getLightLevel(Level level, BlockPos pos) {
        return LevelRenderer.getLightColor(level, pos.above());
    }
}