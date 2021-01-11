package com.talp1.talpsadditions.world.gen;

import com.google.common.collect.ImmutableSet;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.block.BlueBerryBushBlock;
import com.talp1.talpsadditions.block.NormalBushBlock;
import com.talp1.talpsadditions.entity.YetiEntity.YetiEntity;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BushGen {

    @SubscribeEvent
    public static void generateBushes(BiomeLoadingEvent biome){
        //configs
        BlockClusterFeatureConfig BLUE_BERRY_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.blue_berry_bush.get().getDefaultState().with(BlueBerryBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig NORMAL_BUSH_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.normal_bush.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig WHITE_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.white_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig RED_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.red_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig LILAC_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.lilac_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig PINK_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.pink_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig BLUE_HYDRANGEA_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.blue_hydrangea.get().getDefaultState().with(NormalBushBlock.AGE,3)),new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig ORANGE_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.orange_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(12).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig YELLOW_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.yellow_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(12).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig GREEN_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.green_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(12).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig MULTICOLOR_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.multicolor_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(12).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig PURPLE_ROSE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.purple_rose.get().getDefaultState()),new DoublePlantBlockPlacer()).tries(12).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
        BlockClusterFeatureConfig COCONUT_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.coconut_block.get().getDefaultState()),new SimpleBlockPlacer()).tries(8).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock(),Blocks.DIRT.getBlock(),Blocks.SAND.getBlock(),Blocks.RED_SAND.getBlock())).func_227317_b_().build();

        //BLUE_BERRY_BUSH
        if (biome.getCategory() == Biome.Category.EXTREME_HILLS || biome.getCategory() == Biome.Category.FOREST || biome.getCategory() == Biome.Category.TAIGA || biome.getCategory() == Biome.Category.RIVER || biome.getCategory() == Biome.Category.SWAMP)
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BLUE_BERRY_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).chance(48));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BLUE_BERRY_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT));
        //NORMAL_BUSH
        if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.BEACH && biome.getCategory() != Biome.Category.DESERT && biome.getCategory() != Biome.Category.ICY && biome.getCategory() != Biome.Category.MESA && biome.getCategory() != Biome.Category.MUSHROOM && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.THEEND)
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NORMAL_BUSH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).chance(32));
        biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NORMAL_BUSH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT));
        //HYDRANGEA_BUSHES
        if (biome.getCategory() == Biome.Category.RIVER || biome.getName().equals(Biomes.FLOWER_FOREST.getLocation())) {
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(WHITE_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).chance(12));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).chance(12));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PINK_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).chance(12));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BLUE_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).chance(12));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LILAC_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).chance(12));

            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(WHITE_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PINK_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BLUE_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LILAC_HYDRANGEA_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT));

        }
        //ROSES
        if (biome.getCategory() == Biome.Category.RIVER || biome.getCategory() == Biome.Category.FOREST) {
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ORANGE_ROSE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(8));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(YELLOW_ROSE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(8));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GREEN_ROSE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(8));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(MULTICOLOR_ROSE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(8));
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PURPLE_ROSE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(8));
        }
        //COCONUT
        if (biome.getCategory() == Biome.Category.BEACH) {
            biome.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(COCONUT_CONFIG).withPlacement(Placement.HEIGHTMAP.configure(NoPlacementConfig.INSTANCE)));
        }
    }
}
