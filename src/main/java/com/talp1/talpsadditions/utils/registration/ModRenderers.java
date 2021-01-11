package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.MoleEntity.MoleRenderer;
import com.talp1.talpsadditions.entity.ResourceChicken.renderer.*;
import com.talp1.talpsadditions.entity.ResourceSheep.renderer.*;
import com.talp1.talpsadditions.entity.YetiEntity.YetiRenderer;
import com.talp1.talpsadditions.gui.GenLabScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MODID, bus=Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModRenderers {
    @SubscribeEvent
    public static void registerRenderer(FMLClientSetupEvent event) {
        //mole Renderer Registration
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.mole_entity.get(), MoleRenderer::new);
        //yeti Renderer Registration
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.yeti_entity.get(), YetiRenderer::new);
        //Sheeps Renderer Registration
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.coal_sheep_entity.get(), CoalSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.diamond_sheep_entity.get(), DimaondSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.emerald_sheep_entity.get(), EmeraldSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.gold_sheep_entity.get(), GoldSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.iron_sheep_entity.get(), IronSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.lapis_sheep_entity.get(), LapisSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.quartz_sheep_entity.get(), QuartzSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.netherite_sheep_entity.get(), NetheriteSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.redstone_sheep_entity.get(), RedstoneSheepRenderer::new);
        //Chickens Renderer Registration
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.coal_chicken_entity.get(), CoalResourceChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.diamond_chicken_entity.get(), DiamondResourceChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.emerald_chicken_entity.get(), EmeraldResourceChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.gold_chicken_entity.get(), GoldResourceChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.iron_chicken_entity.get(), IronResourceChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.lapis_chicken_entity.get(), LapisResourceChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.quartz_chicken_entity.get(), QuartzResourceChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.netherite_chicken_entity.get(), NetheriteResourceChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.redstone_chicken_entity.get(), RedstoneResourceChickenRenderer::new);
        //cutout renderer for blue berries bush
        RenderTypeLookup.setRenderLayer(ModBlocks.blue_berry_bush.get(), RenderType.getCutout());
        //cutout renderer for floreal_vines
        RenderTypeLookup.setRenderLayer(ModBlocks.floreal_vines.get(), RenderType.getCutout());
        //cutout renderer for floreal_decoration
        RenderTypeLookup.setRenderLayer(ModBlocks.floreal_decoration.get(), RenderType.getCutout());
        //cutout renderer for frosted_vines
        RenderTypeLookup.setRenderLayer(ModBlocks.frosted_vines.get(), RenderType.getCutout());
        //cutout renderer for normal_bush
        RenderTypeLookup.setRenderLayer(ModBlocks.normal_bush.get(), RenderType.getCutout());
        //cutout renderer for hydrangea bushes
        RenderTypeLookup.setRenderLayer(ModBlocks.white_hydrangea.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.red_hydrangea.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.lilac_hydrangea.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.blue_hydrangea.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.pink_hydrangea.get(), RenderType.getCutout());
        //cutout renderer for Roses
        RenderTypeLookup.setRenderLayer(ModBlocks.orange_rose.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.yellow_rose.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.green_rose.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.multicolor_rose.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.purple_rose.get(), RenderType.getCutout());
        //cutout renderer for flowery water lily
        RenderTypeLookup.setRenderLayer(ModBlocks.flowery_water_lily.get(), RenderType.getCutout());
        //renderer GUI genLab
        ScreenManager.registerFactory(ModContainers.gen_lab_container.get(), GenLabScreen::new);
    }
}
