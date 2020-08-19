package com.talp1.talpsadditions.entity.MoleEntity;

import com.talp1.talpsadditions.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MoleRenderer extends MobRenderer<MoleEntity, MoleModel<MoleEntity>> {
    public MoleRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new  MoleModel(), 0.2f);
    }

    @Override
    public ResourceLocation getEntityTexture(MoleEntity entity) {
        return new ResourceLocation(Main.MODID, "textures/entity/mole_entity.png");
    }
}
