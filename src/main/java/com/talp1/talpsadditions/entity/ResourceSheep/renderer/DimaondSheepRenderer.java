package com.talp1.talpsadditions.entity.ResourceSheep.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.DiamondSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.DiamondResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.layer.DiamondSheepWoolLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DimaondSheepRenderer extends MobRenderer<DiamondResourceSheep, DiamondSheepModel<DiamondResourceSheep>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public DimaondSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new DiamondSheepModel<>(), 0.7F);
        this.addLayer(new DiamondSheepWoolLayer(this));
    }

    
    @Override
    public ResourceLocation getEntityTexture(DiamondResourceSheep entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}