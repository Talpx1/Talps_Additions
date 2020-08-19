package com.talp1.talpsadditions.entity.ResourceSheep.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.GoldSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.GoldResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.layer.GoldSheepWoolLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GoldSheepRenderer extends MobRenderer<GoldResourceSheep, GoldSheepModel<GoldResourceSheep>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public GoldSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GoldSheepModel<>(), 0.7F);
        this.addLayer(new GoldSheepWoolLayer(this));
    }

    
    @Override
    public ResourceLocation getEntityTexture(GoldResourceSheep entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}