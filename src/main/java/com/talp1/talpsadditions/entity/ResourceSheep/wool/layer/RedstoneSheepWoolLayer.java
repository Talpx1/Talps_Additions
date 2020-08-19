package com.talp1.talpsadditions.entity.ResourceSheep.wool.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.RedstoneSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.RedstoneResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.model.RedstoneSheepWoolModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedstoneSheepWoolLayer extends LayerRenderer<RedstoneResourceSheep, RedstoneSheepModel<RedstoneResourceSheep>> {
    private final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID,"textures/entity/sheep_fur_redstone.png");
    private final RedstoneSheepWoolModel<RedstoneResourceSheep> sheepModel = new RedstoneSheepWoolModel<>();

    public RedstoneSheepWoolLayer(IEntityRenderer<RedstoneResourceSheep, RedstoneSheepModel<RedstoneResourceSheep>> rendererIn) {
        super(rendererIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(RedstoneResourceSheep entityIn) {
        return super.getEntityTexture(entityIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, RedstoneResourceSheep entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entitylivingbaseIn.isSheared() && !entitylivingbaseIn.isInvisible()) {
            renderCopyCutoutModel(this.getEntityModel(), this.sheepModel, TEXTURE, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTicks, 1,1,1);
        }
    }
}