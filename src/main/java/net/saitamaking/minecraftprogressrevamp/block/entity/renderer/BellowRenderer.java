package net.saitamaking.minecraftprogressrevamp.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
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
import net.saitamaking.minecraftprogressrevamp.block.custom.BellowBlock;
import net.saitamaking.minecraftprogressrevamp.block.entity.BellowEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.WoodenCrateEntity;

import static net.saitamaking.minecraftprogressrevamp.block.custom.WoodenCrateBlock.FACING;

public class BellowRenderer implements BlockEntityRenderer<BellowEntity> {
    public static final ModelResourceLocation BELLOW_MIDDLE = ModelResourceLocation.standalone(
            ResourceLocation.fromNamespaceAndPath("minecraftprogressrevamp", "block/bellow_middle"));
    public static final ModelResourceLocation BELLOW_BACK = ModelResourceLocation.standalone(
            ResourceLocation.fromNamespaceAndPath("minecraftprogressrevamp", "block/bellow_back"));

    public BellowRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(BellowEntity be, float partialTick, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {
        float c = be.getCompression(partialTick);
        renderPart(be, BELLOW_MIDDLE, c * 3 / 16f, pose, buffer, light, overlay); // meio move 2px
        renderPart(be, BELLOW_BACK,   c * 7 / 16f, pose, buffer, light, overlay); // atrás mexe 4px
    }

    //simplificado em um metodo comum pra usar nos dois
    private void renderPart(BellowEntity be, ModelResourceLocation loc, float shift,
                            PoseStack pose, MultiBufferSource buffer, int light, int overlay) {
        BakedModel model = Minecraft.getInstance().getModelManager().getModel(loc);

        pose.pushPose();
        pose.translate(0.5, 0.5, 0.5);
        pose.mulPose(Axis.YP.rotationDegrees(180f-be.getBlockState().getValue(BellowBlock.FACING).toYRot()));
        pose.translate(-0.5, -0.5, -0.5);

        pose.translate(0, 0, -shift); // frente é z=0, lembrar pra depois

        Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
                pose.last(),
                buffer.getBuffer(RenderType.entityCutout(TextureAtlas.LOCATION_BLOCKS)),
                be.getBlockState(), model, 1f, 1f, 1f, light, overlay);
        pose.popPose();
    }
}