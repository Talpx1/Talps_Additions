package com.talp1.talpsadditions.entity.ResourceSheep.renderer;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.ResourceSheep.model.NetheriteSheepModel;
import com.talp1.talpsadditions.entity.ResourceSheep.types.NetheriteResourceSheep;
import com.talp1.talpsadditions.entity.ResourceSheep.wool.layer.NetheriteSheepWoolLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NetheriteSheepRenderer extends MobRenderer<NetheriteResourceSheep, NetheriteSheepModel<NetheriteResourceSheep>> {
    private static final ResourceLocation SHEARED_RESOURCE_SHEEP_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/sheep_sheared.png");

    public NetheriteSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NetheriteSheepModel<>(), 0.7F);
        this.addLayer(new NetheriteSheepWoolLayer(this));
    }

    
    @Override
    public ResourceLocation getEntityTexture(NetheriteResourceSheep entity) {
        return SHEARED_RESOURCE_SHEEP_TEXTURES;
    }
}