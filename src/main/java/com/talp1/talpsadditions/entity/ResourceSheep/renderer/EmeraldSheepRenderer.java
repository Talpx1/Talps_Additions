package com.talp1.talpsadditions.entity.ResourceSheep.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.EmeraldSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.EmeraldResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.layer.EmeraldSheepWoolLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EmeraldSheepRenderer extends MobRenderer<EmeraldResourceSheep, EmeraldSheepModel<EmeraldResourceSheep>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public EmeraldSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EmeraldSheepModel<>(), 0.7F);
        this.addLayer(new EmeraldSheepWoolLayer(this));
    }

    
    @Override
    public ResourceLocation getEntityTexture(EmeraldResourceSheep entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}