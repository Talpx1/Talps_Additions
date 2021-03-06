package com.talp1.talpsadditions.utils;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.MoleEntity.MoleEntity;
import com.talp1.talpsadditions.entity.WalkingFungus.WalkingFungusEntity;
import com.talp1.talpsadditions.entity.YetiEntity.YetiEntity;
import com.talp1.talpsadditions.utils.registration.ModEffects;
import com.talp1.talpsadditions.utils.registration.ModEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnHandler {

    @SubscribeEvent
    public static void registerEntitySpawnPlacements(FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(ModEntities.mole_entity.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MoleEntity::canSpawn);
        EntitySpawnPlacementRegistry.register(ModEntities.yeti_entity.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, YetiEntity::canSpawn);
        EntitySpawnPlacementRegistry.register(ModEntities.walking_fungus_entity.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WalkingFungusEntity::canSpawn);
    }
}
