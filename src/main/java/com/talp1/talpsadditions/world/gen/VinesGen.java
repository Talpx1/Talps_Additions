package com.talp1.talpsadditions.world.gen;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.registration.ModFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VinesGen {

    @SubscribeEvent
    public static void generateVines(BiomeLoadingEvent biome){
        if (biome.getCategory()== Biome.Category.SWAMP||biome.getName().equals(Biomes.FLOWER_FOREST.getLocation())|| biome.getCategory() == Biome.Category.JUNGLE){
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.floreal_vine_feature.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).square().func_242731_b(150));
        }
        if (biome.getCategory()== Biome.Category.ICY){
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.frosted_vine_feature.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).square().func_242731_b(80));
        }
    }
}
