package com.talp1.talpsadditions.world.gen;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.config.CommonConfig;
import com.talp1.talpsadditions.utils.registration.ModEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SpawnMobs {

    @SubscribeEvent
    public static void spawnInWorld (BiomeLoadingEvent biome) {

        //mole
        if (biome.getCategory() == Biome.Category.EXTREME_HILLS || biome.getCategory() == Biome.Category.SWAMP || biome.getCategory() == Biome.Category.TAIGA || biome.getCategory() == Biome.Category.FOREST || biome.getCategory() == Biome.Category.PLAINS || biome.getCategory() == Biome.Category.SAVANNA) {
            biome.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntities.mole_entity.get(), CommonConfig.moleSpawnWeight.get(), CommonConfig.moleSpawnMin.get(), CommonConfig.moleSpawnMax.get()));
        }

        //yeti
        if (biome.getCategory()== Biome.Category.ICY){
            biome.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntities.yeti_entity.get(),CommonConfig.yetiSpawnWeight.get(),CommonConfig.yetiSpawnMin.get(),CommonConfig.yetiSpawnMax.get()));
        }

        //walking fungus
        if (biome.getCategory()== Biome.Category.MUSHROOM || biome.getName().equals(Biomes.DARK_FOREST.getLocation()) || biome.getName().equals(Biomes.DARK_FOREST_HILLS.getLocation())){
            biome.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntities.walking_fungus_entity.get(),CommonConfig.walkingFungusSpawnWeight.get(),CommonConfig.walkingFungusSpawnMin.get(),CommonConfig.walkingFungusSpawnMax.get()));
        }
    }
}
