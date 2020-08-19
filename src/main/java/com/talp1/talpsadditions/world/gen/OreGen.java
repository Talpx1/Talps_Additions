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
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event){
        BlockClusterFeatureConfig SHINY_PEBBLE_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.shiny_pebble.get().getDefaultState()),new SimpleBlockPlacer()).tries(55).whitelist(ImmutableSet.of(Blocks.STONE.getBlock(),Blocks.ANDESITE.getBlock(),Blocks.DIORITE.getBlock(),Blocks.GRANITE.getBlock())).func_227317_b_().build();
        for (Biome biome : ForgeRegistries.BIOMES){
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), RegistryHandler.shiny_shard_ore.get().getDefaultState())).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FLOWER.withConfiguration(SHINY_PEBBLE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 16, 16, 64))));
        }
    }
}
