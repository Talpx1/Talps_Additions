package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.MoleEntity.MoleRenderer;
import com.talp1.talpsadditions.entity.ResourceChicken.ResourceChickenRenderer;
import com.talp1.talpsadditions.entity.ResourceSheep.ResourceSheepRenderer;
import com.talp1.talpsadditions.entity.WalkingFungus.WalkingFungusRenderer;
import com.talp1.talpsadditions.entity.YetiEntity.YetiRenderer;
import com.talp1.talpsadditions.gui.GenLabScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Items;
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
        //walking fungus Renderer Registration
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.walking_fungus_entity.get(), WalkingFungusRenderer::new);

        //Sheep Renderer Registration
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.coal_resource_sheep_entity.get(), (manager)->new ResourceSheepRenderer(manager, Items.COAL));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.diamond_resource_sheep_entity.get(), (manager)->new ResourceSheepRenderer(manager, Items.DIAMOND));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.emerald_resource_sheep_entity.get(), (manager)->new ResourceSheepRenderer(manager, Items.EMERALD));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.gold_resource_sheep_entity.get(), (manager)->new ResourceSheepRenderer(manager, Items.GOLD_INGOT));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.iron_resource_sheep_entity.get(), (manager)->new ResourceSheepRenderer(manager, Items.IRON_INGOT));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.lapis_resource_sheep_entity.get(), (manager)->new ResourceSheepRenderer(manager, Items.LAPIS_LAZULI));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.quartz_resource_sheep_entity.get(), (manager)->new ResourceSheepRenderer(manager, Items.QUARTZ));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.netherite_resource_sheep_entity.get(), (manager)->new ResourceSheepRenderer(manager, Items.NETHERITE_INGOT));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.redstone_resource_sheep_entity.get(), (manager)->new ResourceSheepRenderer(manager, Items.REDSTONE));
        //Chickens Renderer Registration
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.coal_resource_chicken_entity.get(), (manager)->new ResourceChickenRenderer(manager, Items.COAL));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.diamond_resource_chicken_entity.get(), (manager)->new ResourceChickenRenderer(manager, Items.DIAMOND));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.emerald_resource_chicken_entity.get(), (manager)->new ResourceChickenRenderer(manager, Items.EMERALD));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.gold_resource_chicken_entity.get(), (manager)->new ResourceChickenRenderer(manager, Items.GOLD_INGOT));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.iron_resource_chicken_entity.get(), (manager)->new ResourceChickenRenderer(manager, Items.IRON_INGOT));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.lapis_resource_chicken_entity.get(), (manager)->new ResourceChickenRenderer(manager, Items.LAPIS_LAZULI));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.quartz_resource_chicken_entity.get(), (manager)->new ResourceChickenRenderer(manager, Items.QUARTZ));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.netherite_resource_chicken_entity.get(), (manager)->new ResourceChickenRenderer(manager, Items.NETHERITE_INGOT));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.redstone_resource_chicken_entity.get(), (manager)->new ResourceChickenRenderer(manager, Items.REDSTONE));

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
