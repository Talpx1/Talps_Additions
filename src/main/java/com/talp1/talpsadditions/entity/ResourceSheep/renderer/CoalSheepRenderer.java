package com.talp1.talpsadditions.entity.ResourceSheep.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.CoalSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.CoalResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.layer.CoalSheepWoolLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.client.renderer.entity.layers.SheepWoolLayer;
import net.minecraft.client.renderer.entity.model.SheepModel;
import net.minecraft.client.renderer.entity.model.SheepWoolModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CoalSheepRenderer extends MobRenderer<CoalResourceSheep, CoalSheepModel<CoalResourceSheep>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public CoalSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CoalSheepModel<>(), 0.7F);
        this.addLayer(new CoalSheepWoolLayer(this));
    }


    @Override
    public ResourceLocation getEntityTexture(CoalResourceSheep entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}