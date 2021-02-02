package com.talp1.talpsadditions.entity.ResourceChicken;

import com.talp1.talpsadditions.Main;
import net.minecraft.client.renderer.entity.ChickenRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ResourceChickenRenderer extends MobRenderer<ResourceChickenEntity, ChickenModel<ResourceChickenEntity>> {
    private ResourceLocation CHICKEN_TEXTURES;

    public ResourceChickenRenderer(EntityRendererManager renderManagerIn, Item resourceType) {
        super(renderManagerIn, new ChickenModel<>(), 0.3F);
        this.CHICKEN_TEXTURES=new ResourceLocation(Main.MODID,"textures/entity/resource_chickens/chicken_"+resourceType.toString()+".png");
    }

    @Override
    public ResourceLocation getEntityTexture(ResourceChickenEntity entity) {
        return this.CHICKEN_TEXTURES;
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(ResourceChickenEntity livingBase, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}