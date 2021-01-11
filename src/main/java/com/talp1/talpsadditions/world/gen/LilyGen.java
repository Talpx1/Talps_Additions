package com.talp1.talpsadditions.world.gen;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LilyGen {

    @SubscribeEvent
    public static void generateLily(BiomeLoadingEvent biome){

        BlockClusterFeatureConfig FLOWERY_WATER_LILY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.flowery_water_lily.get().getDefaultState()), SimpleBlockPlacer.PLACER)).tries(10).build();
        if (biome.getCategory() == Biome.Category.JUNGLE || biome.getCategory() == Biome.Category.SWAMP || biome.getName().equals(Biomes.FLOWER_FOREST.getLocation())){
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(FLOWERY_WATER_LILY_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(4));
        }
    }
}
