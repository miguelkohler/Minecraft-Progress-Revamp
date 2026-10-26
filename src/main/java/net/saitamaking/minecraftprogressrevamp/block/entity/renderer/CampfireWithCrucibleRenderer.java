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
import net.saitamaking.minecraftprogressrevamp.block.entity.CampfireWithCrucibleEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.PrimitiveCraftingTableEntity;

import static net.saitamaking.minecraftprogressrevamp.block.custom.WoodenCrateBlock.FACING;

public class CampfireWithCrucibleRenderer implements BlockEntityRenderer<CampfireWithCrucibleEntity> {

    public CampfireWithCrucibleRenderer(BlockEntityRendererProvider.Context context) {}

    private static final float[][] SLOT_POS = {
            {0.5f, 0.65f, 0.5f},
            {0.5f, 0.55f, 0.5f},
    };
    @Override
    public void render(CampfireWithCrucibleEntity be, float partialTick, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        int itemLight = getLightLevel(be.getLevel(), be.getBlockPos());

        pose.pushPose();

        pose.translate(0.5, 0.5, 0.5);
        pose.mulPose(Axis.YP.rotationDegrees(-be.getBlockState().getValue(FACING).toYRot()));
        pose.translate(-0.5, -0.5, -0.5f);

        for (int slot = 0; slot < 2; slot++) {
            ItemStack stack = be.itemHandler.getStackInSlot(slot);
            if (stack.isEmpty()) continue;

            pose.pushPose();
            pose.translate(SLOT_POS[slot][0], SLOT_POS[slot][1], SLOT_POS[slot][2]);
            pose.scale(0.3f, 0.3f, 0.3f);
            pose.mulPose(Axis.XN.rotationDegrees(-90));
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