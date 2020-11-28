package com.talp1.talpsadditions.world.spawns;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddEntityToBiome {
    @SubscribeEvent
    public static void spawnYeti(FMLLoadCompleteEvent event){
        for(Biome biome : ForgeRegistries.BIOMES){
            if(biome.getCategory()== Biome.Category.ICY){
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(RegistryHandler.yeti_entity.get(), 5, 1, 1));
            }
        }
    }
}
