package com.talp1.talpsadditions.entity.ResourceSheep;

import com.talp1.talpsadditions.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ResourceSheepRenderer extends MobRenderer<ResourceSheepEntity, ResourceSheepModel<ResourceSheepEntity>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public ResourceSheepRenderer(EntityRendererManager renderManagerIn, Item resourceType) {
        super(renderManagerIn, new ResourceSheepModel<>(), 0.7F);
        this.addLayer(new ResourceSheepWoolLayer(this, resourceType ));
    }

    @Override
    public ResourceLocation getEntityTexture(ResourceSheepEntity entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}