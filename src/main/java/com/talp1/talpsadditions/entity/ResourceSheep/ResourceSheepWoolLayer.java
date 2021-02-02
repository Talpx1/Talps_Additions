package com.talp1.talpsadditions.entity.ResourceSheep;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.talp1.talpsadditions.Main;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ResourceSheepWoolLayer extends LayerRenderer<ResourceSheepEntity, ResourceSheepModel<ResourceSheepEntity>> {
    private ResourceLocation TEXTURE;
    private final ResourceSheepWoolModel<ResourceSheepEntity> sheepModel = new ResourceSheepWoolModel<>();

    public ResourceSheepWoolLayer(IEntityRenderer<ResourceSheepEntity, ResourceSheepModel<ResourceSheepEntity>> rendererIn, Item resourceType) {
        super(rendererIn);
        this.TEXTURE= new ResourceLocation(Main.MODID,"textures/entity/resource_sheep/sheep_fur_"+resourceType.toString()+".png");
    }

    @Override
    protected ResourceLocation getEntityTexture(ResourceSheepEntity entityIn) {
        return super.getEntityTexture(entityIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, ResourceSheepEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entitylivingbaseIn.getSheared() && !entitylivingbaseIn.isInvisible()) {
            renderCopyCutoutModel(this.getEntityModel(), this.sheepModel, TEXTURE, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTicks, 1,1,1);
        }
    }
}