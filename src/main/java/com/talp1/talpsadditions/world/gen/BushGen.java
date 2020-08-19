package com.talp1.talpsadditions.world.gen;

import com.google.common.collect.ImmutableSet;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.block.BlueBerryBushBlock;
import com.talp1.talpsadditions.block.NormalBushBlock;
import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
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
public class BushGen {

    @SubscribeEvent
    public static void generateBushes(FMLLoadCompleteEvent event){
        BlockClusterFeatureConfig BLUE_BERRY_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.blue_berry_bush.get().getDefaultState().with(BlueBerryBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig NORMAL_BUSH_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.normal_bush.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig WHITE_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.white_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig RED_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.red_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig LILAC_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.lilac_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig PINK_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.pink_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig BLUE_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.blue_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig ORANGE_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.orange_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig YELLOW_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.yellow_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig GREEN_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.green_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig MULTICOLOR_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.multicolor_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig PURPLE_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.purple_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        for (Biome biome : ForgeRegistries.BIOMES) {
            //BLUE_BERRY_BUSH
            if (biome.getCategory() == Biome.Category.EXTREME_HILLS || biome.getCategory() == Biome.Category.FOREST || biome.getCategory() == Biome.Category.TAIGA || biome.getCategory() == Biome.Category.RIVER || biome.getCategory() == Biome.Category.SWAMP)
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BLUE_BERRY_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
            //NORMAL_BUSH
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.BEACH && biome.getCategory() != Biome.Category.DESERT && biome.getCategory() != Biome.Category.ICY && biome.getCategory() != Biome.Category.MESA && biome.getCategory() != Biome.Category.MUSHROOM && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.THEEND)
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NORMAL_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
            //HYDRANGEA_BUSHES
            if (biome.getCategory() == Biome.Category.RIVER || biome == Biomes.FLOWER_FOREST) {
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(WHITE_HYDRANGEA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_HYDRANGEA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PINK_HYDRANGEA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BLUE_HYDRANGEA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LILAC_HYDRANGEA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));

            }
            //ROSES
           if (biome.getCategory() == Biome.Category.RIVER || biome.getCategory() == Biome.Category.FOREST){
               biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ORANGE_ROSE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
               biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(YELLOW_ROSE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
               biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GREEN_ROSE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
               biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(MULTICOLOR_ROSE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
               biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PURPLE_ROSE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
           }
        }
    }
}
