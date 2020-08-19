package com.talp1.talpsadditions.entity.ResourceSheep.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.LapisSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.LapisResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.layer.LapisSheepWoolLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LapisSheepRenderer extends MobRenderer<LapisResourceSheep, LapisSheepModel<LapisResourceSheep>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public LapisSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new LapisSheepModel<>(), 0.7F);
        this.addLayer(new LapisSheepWoolLayer(this));
    }

    
    @Override
    public ResourceLocation getEntityTexture(LapisResourceSheep entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}