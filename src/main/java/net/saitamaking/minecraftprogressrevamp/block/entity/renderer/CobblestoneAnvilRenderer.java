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
import net.saitamaking.minecraftprogressrevamp.block.entity.CobblestoneAnvilEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.RudimentaryCraftingTableEntity;

import static net.saitamaking.minecraftprogressrevamp.block.custom.CobblestoneAnvilBlock.FACING;

public class CobblestoneAnvilRenderer implements BlockEntityRenderer<CobblestoneAnvilEntity> {

    public CobblestoneAnvilRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(CobblestoneAnvilEntity be, float partialTick, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        int itemLight = getLightLevel(be.getLevel(), be.getBlockPos());
        float spin = be.getRenderingRotation();

        pose.pushPose();

        pose.translate(0.5, 0.5, 0.5);
        pose.mulPose(Axis.YP.rotationDegrees(-be.getBlockState().getValue(FACING).toYRot()));
        pose.translate(-0.5, -0.5, -0.5);

        for (int slot = 0; slot < 12; slot++) {
            ItemStack stack = be.getInventory().getStackInSlot(slot);
            if (stack.isEmpty()) continue;

            float x = 0.8f - (slot % 4) * 0.2f;
            float z = 0.7f - (slot / 4) * 0.2f;

            pose.pushPose();
            pose.translate(x, 1.15f, z);
            pose.scale(0.2f, 0.2f, 0.2f);
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