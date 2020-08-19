package com.talp1.talpsadditions.entity.ResourceSheep.wool.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.GoldSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.GoldResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.model.GoldSheepWoolModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GoldSheepWoolLayer extends LayerRenderer<GoldResourceSheep, GoldSheepModel<GoldResourceSheep>> {
    private final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID,"textures/entity/sheep_fur_gold.png");
    private final GoldSheepWoolModel<GoldResourceSheep> sheepModel = new GoldSheepWoolModel<>();

    public GoldSheepWoolLayer(IEntityRenderer<GoldResourceSheep, GoldSheepModel<GoldResourceSheep>> rendererIn) {
        super(rendererIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(GoldResourceSheep entityIn) {
        return super.getEntityTexture(entityIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, GoldResourceSheep entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entitylivingbaseIn.isSheared() && !entitylivingbaseIn.isInvisible()) {
            renderCopyCutoutModel(this.getEntityModel(), this.sheepModel, TEXTURE, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTicks, 1,1,1);
        }
    }
}