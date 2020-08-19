package com.talp1.talpsadditions.entity.ResourceSheep.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.IronSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.IronResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.layer.IronSheepWoolLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IronSheepRenderer extends MobRenderer<IronResourceSheep, IronSheepModel<IronResourceSheep>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public IronSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new IronSheepModel<>(), 0.7F);
        this.addLayer(new IronSheepWoolLayer(this));
    }


    @Override
    public ResourceLocation getEntityTexture(IronResourceSheep entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}