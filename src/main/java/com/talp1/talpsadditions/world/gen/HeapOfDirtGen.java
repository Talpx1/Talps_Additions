package com.talp1.talpsadditions.world.gen;

import com.google.common.collect.ImmutableSet;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HeapOfDirtGen {
        @SubscribeEvent
    public static void generateBushes(FMLLoadCompleteEvent event){
        BlockClusterFeatureConfig HEAP_OF_DIRT_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.heap_of_dirt.get().getDefaultState()),new SimpleBlockPlacer()).tries(4).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock(),Blocks.DIRT.getBlock(),Blocks.PODZOL.getBlock(),Blocks.COARSE_DIRT.getBlock())).func_227317_b_().build();
        for (Biome biome : ForgeRegistries.BIOMES){
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(HEAP_OF_DIRT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
        }
    }
}
