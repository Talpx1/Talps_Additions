package com.talp1.talpsadditions.entity.WalkingFungus;

import com.talp1.talpsadditions.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WalkingFungusRenderer extends MobRenderer<WalkingFungusEntity, WalkingFungusModel<WalkingFungusEntity>> {
    public WalkingFungusRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new WalkingFungusModel(), 0.35f);
    }

    @Override
    public ResourceLocation getEntityTexture(WalkingFungusEntity entity) {
        return new ResourceLocation(Main.MODID, "textures/entity/walking_fungus_entity.png");
    }
}

