package net.saitamaking.minecraftprogressrevamp.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;

public class RudimentaryAlloyFurnaceScreen extends AbstractContainerScreen<RudimentaryAlloyFurnaceMenu> {

    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "textures/gui/furnacelike/alloy_smelter_gui.png");
    private static final ResourceLocation ARROW_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "textures/gui/otherguitextures/alloy_arrow_progress.png");
    private static final ResourceLocation LIT_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "textures/gui/otherguitextures/lit_progress.png");

    public RudimentaryAlloyFurnaceScreen(RudimentaryAlloyFurnaceMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        renderProgressArrow(guiGraphics, x, y);
        renderBurnTime(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y){
        if(menu.isCrafting()) {
            guiGraphics.blit(ARROW_TEXTURE, x + 76, y + 25, 0, 0, 24, menu.getScaledArrowProgress(), 24, 27);
        }
    }

    private void renderBurnTime(GuiGraphics guiGraphics, int x, int y){
        if(menu.isBurning()) {
            int k = menu.getScaledBurnProgress();
            if (k > 0) {
                guiGraphics.blit(LIT_TEXTURE,
                        x + 104, y + 37 + 14 - k, //moves down as k shrinks
                        0, 14 - k, //texture position starts lower in the sprite
                        14, k, //size of the area drawn
                        14, 14); //total texture size
                guiGraphics.blit(LIT_TEXTURE,
                        x + 56, y + 37 + 14 - k,
                        0, 14 - k,
                        14, k,
                        14, 14);
            }
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
