package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModSpawnEggs {
    //registrazione spawnEggs
    //mole
    public static SpawnEggItem moleSpawnEgg = new SpawnEggItem(ModEntities.moleBuilder, 0x2B2B2B, 0x463125, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    //yeti
    public static SpawnEggItem yetiSpawnEgg = new SpawnEggItem(ModEntities.yetiBuilder, 0xf5fffe, 0x084d46, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    //sheeps
    public static SpawnEggItem coalSheepSpawnEgg = new SpawnEggItem(ModEntities.coalSheepBuilder, 0xfff4cf, 0x292929, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem diamondSheepSpawnEgg = new SpawnEggItem(ModEntities.diamondSheepBuilder, 0xfff4cf, 0x19ffe0, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem emeraldSheepSpawnEgg = new SpawnEggItem(ModEntities.emeraldSheepBuilder, 0xfff4cf, 0x19ff3b, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem goldSheepSpawnEgg = new SpawnEggItem(ModEntities.goldSheepBuilder, 0xfff4cf, 0xffe229, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem ironSheepSpawnEgg = new SpawnEggItem(ModEntities.ironSheepBuilder, 0xfff4cf, 0xd1d1d1, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem lapisSheepSpawnEgg = new SpawnEggItem(ModEntities.lapisSheepBuilder, 0xfff4cf, 0x2462ff, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem netheriteSheepSpawnEgg = new SpawnEggItem(ModEntities.netheriteSheepBuilder, 0xfff4cf, 0x3b2a28, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem quartzSheepSpawnEgg = new SpawnEggItem(ModEntities.quartzSheepBuilder, 0xfff4cf, 0xebead8, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem redstoneSheepSpawnEgg = new SpawnEggItem(ModEntities.redstoneSheepBuilder, 0xfff4cf, 0xd60000, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    //chickens
    public static SpawnEggItem coalChickenSpawnEgg = new SpawnEggItem(ModEntities.coalChickenBuilder, 0x4d4d4d, 0x292929, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem diamondChickenSpawnEgg = new SpawnEggItem(ModEntities.diamondChickenBuilder, 0x4d4d4d, 0x19ffe0, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem emeraldChickenSpawnEgg = new SpawnEggItem(ModEntities.emeraldChickenBuilder, 0x4d4d4d, 0x19ff3b, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem goldChickenSpawnEgg = new SpawnEggItem(ModEntities.goldChickenBuilder, 0x4d4d4d, 0xffe229, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem ironChickenSpawnEgg = new SpawnEggItem(ModEntities.ironChickenBuilder, 0x4d4d4d, 0xd1d1d1, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem lapisChickenSpawnEgg = new SpawnEggItem(ModEntities.lapisChickenBuilder, 0x4d4d4d, 0x2462ff, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem netheriteChickenSpawnEgg = new SpawnEggItem(ModEntities.netheriteChickenBuilder, 0x4d4d4d, 0x3b2a28, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem quartzChickenSpawnEgg = new SpawnEggItem(ModEntities.quartzChickenBuilder, 0x4d4d4d, 0xebead8, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    public static SpawnEggItem redstoneChickenSpawnEgg = new SpawnEggItem(ModEntities.redstoneChickenBuilder, 0x4d4d4d, 0xd60000, new SpawnEggItem.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                //mole
                moleSpawnEgg.setRegistryName("mole_spawn_egg"),
                //yeti
                yetiSpawnEgg.setRegistryName("yeti_spawn_egg"),
                //sheeps
                coalSheepSpawnEgg.setRegistryName("coal_sheep_spawn_egg"),
                diamondSheepSpawnEgg.setRegistryName("diamond_sheep_spawn_egg"),
                emeraldSheepSpawnEgg.setRegistryName("emerald_sheep_spawn_egg"),
                goldSheepSpawnEgg.setRegistryName("gold_sheep_spawn_egg"),
                ironSheepSpawnEgg.setRegistryName("iron_sheep_spawn_egg"),
                lapisSheepSpawnEgg.setRegistryName("lapis_sheep_spawn_egg"),
                netheriteSheepSpawnEgg.setRegistryName("netherite_sheep_spawn_egg"),
                quartzSheepSpawnEgg.setRegistryName("quartz_sheep_spawn_egg"),
                redstoneSheepSpawnEgg.setRegistryName("redstone_sheep_spawn_egg"),
                //chickens
                coalChickenSpawnEgg.setRegistryName("coal_chicken_spawn_egg"),
                diamondChickenSpawnEgg.setRegistryName("diamond_chicken_spawn_egg"),
                emeraldChickenSpawnEgg.setRegistryName("emerald_chicken_spawn_egg"),
                goldChickenSpawnEgg.setRegistryName("gold_chicken_spawn_egg"),
                ironChickenSpawnEgg.setRegistryName("iron_chicken_spawn_egg"),
                lapisChickenSpawnEgg.setRegistryName("lapis_chicken_spawn_egg"),
                netheriteChickenSpawnEgg.setRegistryName("netherite_chicken_spawn_egg"),
                quartzChickenSpawnEgg.setRegistryName("quartz_chicken_spawn_egg"),
                redstoneChickenSpawnEgg.setRegistryName("redstone_chicken_spawn_egg")
        );
    }
}
