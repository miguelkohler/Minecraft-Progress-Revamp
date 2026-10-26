package net.saitamaking.minecraftprogressrevamp.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.saitamaking.minecraftprogressrevamp.block.entity.PrimitiveCraftingTableEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.WoodenCrateEntity;

import static net.saitamaking.minecraftprogressrevamp.block.custom.WoodenCrateBlock.FACING;

public class PrimitiveCraftingTableRenderer implements BlockEntityRenderer<PrimitiveCraftingTableEntity> {

    public PrimitiveCraftingTableRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(PrimitiveCraftingTableEntity be, float partialTick, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        int itemLight = getLightLevel(be.getLevel(), be.getBlockPos());
        float spin = be.getRenderingRotation();

        pose.pushPose();

        pose.translate(0.5, 0.5, 0.5);
        pose.mulPose(Axis.YP.rotationDegrees(-be.getBlockState().getValue(FACING).toYRot()));
        pose.translate(-0.5, -0.5, -0.5);

        for (int slot = 0; slot < 5; slot++) {
            ItemStack stack = be.getInventory().getStackInSlot(slot);
            if (stack.isEmpty()) continue;

            float x;
            float z;

            if (slot == 0 || slot == 4) {
                x = 0.5f;
            } else {
                x = 0.75f - (slot - 1) * 0.25f;
            }

            if (slot == 0) {
                z = 0.75f;
            } else if (slot == 4) {
                z = 0.25f;
            } else {
                z = 0.5f;
            }

            pose.pushPose();
            pose.translate(x, 1.25f, z);
            pose.scale(0.25f, 0.25f, 0.25f);
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