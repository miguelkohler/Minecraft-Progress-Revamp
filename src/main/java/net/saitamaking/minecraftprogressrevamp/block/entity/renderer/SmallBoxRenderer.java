package net.saitamaking.minecraftprogressrevamp.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
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
import net.minecraft.world.level.block.state.BlockState;
import net.saitamaking.minecraftprogressrevamp.block.custom.SmallBoxBlock;
import net.saitamaking.minecraftprogressrevamp.block.entity.SmallBoxEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.WoodenCrateEntity;

import static net.saitamaking.minecraftprogressrevamp.block.custom.WoodenCrateBlock.FACING;

public class SmallBoxRenderer implements BlockEntityRenderer<SmallBoxEntity> {
    public static final ModelResourceLocation LID_MODEL = ModelResourceLocation.standalone(
            ResourceLocation.fromNamespaceAndPath("minecraftprogressrevamp", "block/small_box_lid"));

    public SmallBoxRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(SmallBoxEntity be, float partialTick, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {
        BlockState state = be.getBlockState();
        float yRot = ((SmallBoxBlock) state.getBlock()).getYRotationDegrees(state);
        float open = be.getOpenNess(partialTick);

        BakedModel base = Minecraft.getInstance().getBlockRenderer().getBlockModel(state);
        BakedModel lid = Minecraft.getInstance().getModelManager().getModel(LID_MODEL);
        VertexConsumer vc = buffer.getBuffer(RenderType.entityCutout(TextureAtlas.LOCATION_BLOCKS));
        ModelBlockRenderer modelRenderer = Minecraft.getInstance().getBlockRenderer().getModelRenderer();

        if (open > 0.3f) {
            ItemStack stack = be.inventory.getStackInSlot(0);
            pose.pushPose();
            pose.translate(0.5, 0.5, 0.5);
            pose.mulPose(Axis.YP.rotationDegrees(-yRot));
            pose.translate(-0.5, -0.5, -0.5);

            pose.pushPose();
            pose.translate(0.5f, 0.5f, 0.5f);
            pose.scale(0.25f, 0.25f, 0.25f);
            pose.mulPose(Axis.YP.rotationDegrees(be.getRenderingRotation()));
            Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.FIXED,
                    getLightLevel(be.getLevel(), be.getBlockPos()), OverlayTexture.NO_OVERLAY,
                    pose, buffer, be.getLevel(), 1);
            pose.popPose();
            pose.popPose();
        }

        pose.pushPose();
        pose.translate(0.5, 0, 0.5);
        pose.mulPose(Axis.YP.rotationDegrees(-yRot));
        pose.translate(-0.5, 0, -0.5);

        modelRenderer.renderModel(pose.last(), vc, state, base, 1f, 1f, 1f, light, overlay);

        pose.pushPose();
        pose.translate(0, 6 / 16f, 4 / 16f);
        pose.mulPose(Axis.XP.rotationDegrees(-open * 90f));
        pose.translate(0, -6 / 16f, -4 / 16f);
        modelRenderer.renderModel(pose.last(), vc, state, lid, 1f, 1f, 1f, light, overlay);
        pose.popPose();

        pose.popPose();
    }
    private int getLightLevel(Level level, BlockPos pos) {
        return LevelRenderer.getLightColor(level, pos.above());
    }
}