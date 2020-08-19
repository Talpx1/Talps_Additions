package com.talp1.talpsadditions.entity.ResourceSheep.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.RedstoneSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.RedstoneResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.layer.RedstoneSheepWoolLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedstoneSheepRenderer extends MobRenderer<RedstoneResourceSheep, RedstoneSheepModel<RedstoneResourceSheep>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public RedstoneSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedstoneSheepModel<>(), 0.7F);
        this.addLayer(new RedstoneSheepWoolLayer(this));
    }

    
    @Override
    public ResourceLocation getEntityTexture(RedstoneResourceSheep entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}