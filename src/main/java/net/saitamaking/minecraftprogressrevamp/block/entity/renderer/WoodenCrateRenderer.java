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
import net.saitamaking.minecraftprogressrevamp.block.custom.CobblestoneAnvilBlock;
import net.saitamaking.minecraftprogressrevamp.block.custom.WoodenCrateBlock;
import net.saitamaking.minecraftprogressrevamp.block.entity.WoodenCrateEntity;

import static net.saitamaking.minecraftprogressrevamp.block.custom.WoodenCrateBlock.FACING;

public class WoodenCrateRenderer implements BlockEntityRenderer<WoodenCrateEntity> {
    public static final ModelResourceLocation LID_MODEL = ModelResourceLocation.standalone(
            ResourceLocation.fromNamespaceAndPath("minecraftprogressrevamp", "block/wooden_crate_lid"));

    public WoodenCrateRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(WoodenCrateEntity be, float partialTick, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {
        BakedModel lid = Minecraft.getInstance().getModelManager().getModel(LID_MODEL);
        float open = be.getOpenNess(partialTick);
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        int itemLight = getLightLevel(be.getLevel(), be.getBlockPos());
        if (open > 0.3f) {
            float spin = be.getRenderingRotation();

            pose.pushPose();

            pose.translate(0.5, 0.5, 0.5);
            pose.mulPose(Axis.YP.rotationDegrees(-be.getBlockState().getValue(FACING).toYRot()));
            pose.translate(-0.5, -0.5, -0.5);

            for (int slot = 0; slot < 9; slot++) {
                ItemStack stack = be.inventory.getStackInSlot(slot);
                if (stack.isEmpty()) continue;

                float x = 0.75f - (slot % 3) * 0.25f;
                float z = 0.75f - (slot / 3) * 0.25f;

                pose.pushPose();
                pose.translate(x, 1.0f, z);
                pose.scale(0.25f, 0.25f, 0.25f);
                pose.mulPose(Axis.YP.rotationDegrees(spin));
                itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, itemLight,
                        OverlayTexture.NO_OVERLAY, pose, buffer, be.getLevel(), 1);
                pose.popPose();
            }

            pose.popPose();
        }

        pose.pushPose();

        pose.translate(0.5, 0.5, 0.5);
        pose.mulPose(Axis.YP.rotationDegrees(-be.getBlockState().getValue(FACING).toYRot()));
        pose.translate(-0.5, -0.5, -0.5);

        pose.translate(0, 14 / 16f, 1);
        pose.mulPose(Axis.XP.rotationDegrees(open * 90f));
        pose.translate(0, -14 / 16f, -1);

        Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
                pose.last(),
                buffer.getBuffer(RenderType.entityCutout(TextureAtlas.LOCATION_BLOCKS)),
                be.getBlockState(), lid, 1f, 1f, 1f, light, overlay);

        pose.popPose();

    }
    private int getLightLevel(Level level, BlockPos pos) {
        return LevelRenderer.getLightColor(level, pos.above());
    }
}