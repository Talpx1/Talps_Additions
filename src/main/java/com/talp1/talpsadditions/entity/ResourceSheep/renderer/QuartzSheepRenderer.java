package com.talp1.talpsadditions.entity.ResourceSheep.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.QuartzSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.QuartzResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.layer.QuartzSheepWoolLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QuartzSheepRenderer extends MobRenderer<QuartzResourceSheep, QuartzSheepModel<QuartzResourceSheep>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public QuartzSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new QuartzSheepModel<>(), 0.7F);
        this.addLayer(new QuartzSheepWoolLayer(this));
    }

    
    @Override
    public ResourceLocation getEntityTexture(QuartzResourceSheep entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}