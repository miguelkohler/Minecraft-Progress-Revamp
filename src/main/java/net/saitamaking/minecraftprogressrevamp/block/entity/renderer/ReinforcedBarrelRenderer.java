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
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.saitamaking.minecraftprogressrevamp.block.custom.ReinforcedBarrelBlock;
import net.saitamaking.minecraftprogressrevamp.block.entity.CopperCrateEntity;
import net.saitamaking.minecraftprogressrevamp.block.entity.ReinforcedBarrelEntity;

import static net.saitamaking.minecraftprogressrevamp.block.custom.ReinforcedBarrelBlock.FACING;
import static net.saitamaking.minecraftprogressrevamp.block.custom.ReinforcedBarrelBlock.OPEN;


public class ReinforcedBarrelRenderer implements BlockEntityRenderer<ReinforcedBarrelEntity> {

    public ReinforcedBarrelRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(ReinforcedBarrelEntity be, float partialTick, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        Direction facing = be.getBlockState().getValue(ReinforcedBarrelBlock.FACING);
        int itemLight = getLightLevel(be.getLevel(), be.getBlockPos(), facing);
        float spin = be.getRenderingRotation();

        pose.pushPose();

        pose.translate(0.5, 0.5, 0.5);
        switch (facing) {
            case UP -> {}
            case DOWN  -> pose.mulPose(Axis.XP.rotationDegrees(180));
            case NORTH -> pose.mulPose(Axis.XP.rotationDegrees(-90));
            case SOUTH -> pose.mulPose(Axis.XP.rotationDegrees(90));
            case EAST  -> pose.mulPose(Axis.ZP.rotationDegrees(-90));
            case WEST  -> pose.mulPose(Axis.ZP.rotationDegrees(90));
        }
        pose.translate(-0.5, -0.5, -0.5);

        for (int slot = 0; slot < 54; slot++) {
            if(be.getBlockState().getValue(ReinforcedBarrelBlock.OPEN)) {
                ItemStack stack = be.inventory.getStackInSlot(slot);
                if (stack.isEmpty()) continue;

                float x = 0.80f - (slot % 9) * 0.08f;
                float z = 0.80f - (slot / 9) * 0.125f;

                pose.pushPose();
                pose.translate(x, 1.15f, z);
                pose.scale(0.1f, 0.1f, 0.1f);
                pose.mulPose(Axis.YP.rotationDegrees(spin));
                itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, itemLight,
                        OverlayTexture.NO_OVERLAY, pose, buffer, be.getLevel(), 1);
                pose.popPose();
            }
        }

        pose.popPose();

    }
    private int getLightLevel(Level level, BlockPos pos, Direction facing) {
        return LevelRenderer.getLightColor(level, pos.relative(facing));
    }
}