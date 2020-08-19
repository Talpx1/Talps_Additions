package com.talp1.talpsadditions.entity.ResourceChicken.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceChicken.ResourceChickenModel;
import com.talp1.talpsadditions.entity.ResourceChicken.type.CoalResourceChicken;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CoalResourceChickenRenderer extends MobRenderer<CoalResourceChicken, ResourceChickenModel<CoalResourceChicken>> {
    private static final ResourceLocation CHICKEN_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/chicken_coal.png");

    public CoalResourceChickenRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ResourceChickenModel<>(), 0.3F);
    }

    @Override
    public ResourceLocation getEntityTexture(CoalResourceChicken entity)  {
        return CHICKEN_TEXTURES;
    }


    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(ChickenEntity livingBase, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}