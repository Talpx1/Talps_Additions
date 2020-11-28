package com.talp1.talpsadditions.entity.YetiEntity;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.MoleEntity.MoleEntity;
import com.talp1.talpsadditions.entity.MoleEntity.MoleModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
public class YetiRenderer extends MobRenderer<YetiEntity, YetiModel<YetiEntity>> {
    public YetiRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new  YetiModel(), 0.2f);
    }

    @Override
    public ResourceLocation getEntityTexture(YetiEntity entity) {
        return new ResourceLocation(Main.MODID, "textures/entity/yeti_entity.png");
    }
}