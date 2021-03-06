package com.talp1.talpsadditions.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.container.GenLabContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.FurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GenLabScreen extends ContainerScreen<GenLabContainer> {

    private ResourceLocation GUI = new ResourceLocation(Main.MODID, "textures/gui/gen_lab_gui.png");

    public GenLabScreen(GenLabContainer container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack,mouseX, mouseY, partialTicks);
        if (this.getMinecraft().player.inventory.getItemStack().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.getHasStack()) {
            this.renderTooltip(matrixStack, this.hoveredSlot.getStack(), mouseX, mouseY);
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        super.drawString(matrixStack, Minecraft.getInstance().fontRenderer, "Energy: " + container.getEnergy() + " RF", 90, 120-60, 0xffffff);
        super.drawString(matrixStack, Minecraft.getInstance().fontRenderer, "Gene: ", 20, 15-60, 0xffffff);
        super.drawString(matrixStack, Minecraft.getInstance().fontRenderer, "Modifier: ", 68, 15-60, 0xffffff);
        super.drawString(matrixStack, Minecraft.getInstance().fontRenderer, "Base: ", 20, 39-60, 0xffffff);
        super.drawString(matrixStack, Minecraft.getInstance().fontRenderer, "Item to Inject: " , 75, 40-60, 0xffffff);
        super.drawString(matrixStack, Minecraft.getInstance().fontRenderer, "Item to Inject into: ", 5, 80-60, 0xffffff);
        super.drawString(matrixStack, Minecraft.getInstance().fontRenderer, "Output: ", 35, 145-60, 0xffffff);

        this.font.func_238422_b_(matrixStack, this.title.func_241878_f(), (float)this.titleX, (float)this.titleY-75, 0xFFFFFF);
        this.font.func_238422_b_(matrixStack, this.playerInventory.getDisplayName().func_241878_f(), (float)this.playerInventoryTitleX, (float)this.playerInventoryTitleY+25, 0xFFFFFF);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize)/2-60;

        //display bg gui
        this.blit(matrixStack,relX, relY, 0, 0, this.xSize, this.ySize+87);

        //display progress
        if (container.getProgress()>-1&&container.getTotal()>-1){
            if (container.getProgress()!=container.getTotal()){
                int completePerc=Math.round((100*((float)container.getTotal()-(float)container.getProgress()))/(float)container.getTotal());
                int toDisplay=Math.round(((float)107*(float)completePerc)/(float)100);
                //blit(matrixstack, centerx, centery, startFromTopX,startFromTopY,sizeX, sizeY)
                this.blit(matrixStack,relX+48,relY+27,178,0,78,toDisplay);
            }
        }
    }
}