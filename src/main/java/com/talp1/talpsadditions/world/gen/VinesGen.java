package com.talp1.talpsadditions.world.gen;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VinesGen {

    @SubscribeEvent
    public static void generateVines(FMLLoadCompleteEvent event){
        for (Biome biome : ForgeRegistries.BIOMES){
            if (biome.getCategory()== Biome.Category.SWAMP||biome== Biomes.FLOWER_FOREST||biome.getCategory()== Biome.Category.JUNGLE){
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, RegistryHandler.floreal_vine_feature.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(600))));
            }
        }
    }
}
