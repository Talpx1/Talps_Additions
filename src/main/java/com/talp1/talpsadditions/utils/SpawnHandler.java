package com.talp1.talpsadditions.utils;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.MoleEntity.MoleEntity;
import com.talp1.talpsadditions.entity.YetiEntity.YetiEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SpawnHandler {

    @SubscribeEvent
    public static void spawnInWorld (BiomeLoadingEvent biome) {
        //mole
        if (biome.getCategory() == Biome.Category.EXTREME_HILLS || biome.getCategory() == Biome.Category.SWAMP || biome.getCategory() == Biome.Category.TAIGA || biome.getCategory() == Biome.Category.FOREST || biome.getCategory() == Biome.Category.PLAINS || biome.getCategory() == Biome.Category.SAVANNA) {
            biome.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.mole_entity.get(), 7, 1, 4));
        }

        //yeti
        if(biome.getCategory()== Biome.Category.ICY){
            biome.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.yeti_entity.get(),5,1,1));
        }
    }

    @SubscribeEvent
    public static void registerEntitySpawnPlacements(FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(RegistryHandler.mole_entity.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MoleEntity::canSpawn);
        EntitySpawnPlacementRegistry.register(RegistryHandler.yeti_entity.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, YetiEntity::canSpawn);
    }
}
