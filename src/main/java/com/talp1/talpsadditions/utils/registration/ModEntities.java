package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.MoleEntity.MoleEntity;
import com.talp1.talpsadditions.entity.ResourceChicken.ResourceChickenEntity;
import com.talp1.talpsadditions.entity.ResourceSheep.ResourceSheepEntity;
import com.talp1.talpsadditions.entity.WalkingFungus.WalkingFungusEntity;
import com.talp1.talpsadditions.entity.YetiEntity.YetiEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

    //DefReg per Entities
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);

    public static void init() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //registrazione entity
    //mole
    public static final EntityType<MoleEntity> moleBuilder = EntityType.Builder.create(MoleEntity::new, EntityClassification.CREATURE).size(0.65f,0.25f).build(new ResourceLocation(Main.MODID, "mole_entity").toString());
    public static final RegistryObject<EntityType<MoleEntity>> mole_entity = ENTITIES.register("mole_entity", () -> moleBuilder);
    //yeti
    public static final EntityType<YetiEntity> yetiBuilder = EntityType.Builder.create(YetiEntity::new, EntityClassification.CREATURE).size(1.5f,3f).build(new ResourceLocation(Main.MODID, "yeti_entity").toString());
    public static final RegistryObject<EntityType<YetiEntity>> yeti_entity = ENTITIES.register("yeti_entity", () -> yetiBuilder);
    //walking fungus
    public static final EntityType<WalkingFungusEntity> walkingFungusBuilder = EntityType.Builder.create(WalkingFungusEntity::new, EntityClassification.CREATURE).size(0.60f,0.6f).build(new ResourceLocation(Main.MODID, "walking_fungus_entity").toString());
    public static final RegistryObject<EntityType<WalkingFungusEntity>> walking_fungus_entity = ENTITIES.register("walking_fungus_entity", () -> walkingFungusBuilder);

    //----------------------------------------------------
    //resource Sheep
    //coal
    private static final EntityType.IFactory<ResourceSheepEntity> coalSheepFactoryInstance = (type, world)-> new ResourceSheepEntity(type, world, Items.COAL);
    public static final EntityType<ResourceSheepEntity> coalSheepBuilder = EntityType.Builder.create(coalSheepFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "coal_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<ResourceSheepEntity>> coal_resource_sheep_entity = ENTITIES.register("coal_resource_sheep_entity", () -> coalSheepBuilder);
    //diamond
    private static final EntityType.IFactory<ResourceSheepEntity> diamondSheepFactoryInstance = (type, world)-> new ResourceSheepEntity(type, world, Items.DIAMOND);
    public static final EntityType<ResourceSheepEntity> diamondSheepBuilder = EntityType.Builder.create(diamondSheepFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "diamond_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<ResourceSheepEntity>> diamond_resource_sheep_entity = ENTITIES.register("diamond_resource_sheep_entity", () -> diamondSheepBuilder);
    //emerald
    private static final EntityType.IFactory<ResourceSheepEntity> emeraldSheepFactoryInstance = (type, world)-> new ResourceSheepEntity(type, world, Items.EMERALD);
    public static final EntityType<ResourceSheepEntity> emeraldSheepBuilder = EntityType.Builder.create(emeraldSheepFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "emerald_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<ResourceSheepEntity>> emerald_resource_sheep_entity = ENTITIES.register("emerald_resource_sheep_entity", () -> emeraldSheepBuilder);
    //gold
    private static final EntityType.IFactory<ResourceSheepEntity> goldSheepFactoryInstance = (type, world)-> new ResourceSheepEntity(type, world, Items.GOLD_INGOT);
    public static final EntityType<ResourceSheepEntity> goldSheepBuilder = EntityType.Builder.create(goldSheepFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "gold_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<ResourceSheepEntity>> gold_resource_sheep_entity = ENTITIES.register("gold_resource_sheep_entity", () -> goldSheepBuilder);
    //iron
    private static final EntityType.IFactory<ResourceSheepEntity> ironSheepFactoryInstance = (type, world)-> new ResourceSheepEntity(type, world, Items.IRON_INGOT);
    public static final EntityType<ResourceSheepEntity> ironSheepBuilder = EntityType.Builder.create(ironSheepFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "iron_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<ResourceSheepEntity>> iron_resource_sheep_entity = ENTITIES.register("iron_resource_sheep_entity", () -> ironSheepBuilder);
    //lapis
    private static final EntityType.IFactory<ResourceSheepEntity> lapisSheepFactoryInstance = (type, world)-> new ResourceSheepEntity(type, world, Items.LAPIS_LAZULI);
    public static final EntityType<ResourceSheepEntity> lapisSheepBuilder = EntityType.Builder.create(lapisSheepFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "lapis_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<ResourceSheepEntity>> lapis_resource_sheep_entity = ENTITIES.register("lapis_resource_sheep_entity", () -> lapisSheepBuilder);
    //netherite
    private static final EntityType.IFactory<ResourceSheepEntity> netheriteSheepFactoryInstance = (type, world)-> new ResourceSheepEntity(type, world, Items.NETHERITE_INGOT);
    public static final EntityType<ResourceSheepEntity> netheriteSheepBuilder = EntityType.Builder.create(netheriteSheepFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "netherite_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<ResourceSheepEntity>> netherite_resource_sheep_entity = ENTITIES.register("netherite_resource_sheep_entity", () -> netheriteSheepBuilder);
    //quartz
    private static final EntityType.IFactory<ResourceSheepEntity> quartzSheepFactoryInstance = (type, world)-> new ResourceSheepEntity(type, world, Items.QUARTZ);
    public static final EntityType<ResourceSheepEntity> quartzSheepBuilder = EntityType.Builder.create(quartzSheepFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "quartz_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<ResourceSheepEntity>> quartz_resource_sheep_entity = ENTITIES.register("quartz_resource_sheep_entity", () -> quartzSheepBuilder);
    //redstone
    private static final EntityType.IFactory<ResourceSheepEntity> redstoneSheepFactoryInstance = (type, world)-> new ResourceSheepEntity(type, world, Items.REDSTONE);
    public static final EntityType<ResourceSheepEntity> redstoneSheepBuilder = EntityType.Builder.create(redstoneSheepFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "redstone_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<ResourceSheepEntity>> redstone_resource_sheep_entity = ENTITIES.register("redstone_resource_sheep_entity", () -> redstoneSheepBuilder);
    //---------------------------------------------------
    //resource Chickens
    //coal
    private static final EntityType.IFactory<ResourceChickenEntity> coalChickenFactoryInstance = (type, world)-> new ResourceChickenEntity(type, world, Items.COAL);
    public static final EntityType<ResourceChickenEntity> coalChickenBuilder = EntityType.Builder.create(coalChickenFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "coal_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<ResourceChickenEntity>> coal_resource_chicken_entity = ENTITIES.register("coal_resource_chicken_entity", () -> coalChickenBuilder);
    //diamond
    private static final EntityType.IFactory<ResourceChickenEntity> diamondChickenFactoryInstance = (type, world)-> new ResourceChickenEntity(type, world, Items.DIAMOND);
    public static final EntityType<ResourceChickenEntity> diamondChickenBuilder = EntityType.Builder.create(diamondChickenFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "diamond_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<ResourceChickenEntity>> diamond_resource_chicken_entity = ENTITIES.register("diamond_resource_chicken_entity", () -> diamondChickenBuilder);
    //emerald
    private static final EntityType.IFactory<ResourceChickenEntity> emeraldChickenFactoryInstance = (type, world)-> new ResourceChickenEntity(type, world, Items.EMERALD);
    public static final EntityType<ResourceChickenEntity> emeraldChickenBuilder = EntityType.Builder.create(emeraldChickenFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "emerald_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<ResourceChickenEntity>> emerald_resource_chicken_entity = ENTITIES.register("emerald_resource_chicken_entity", () -> emeraldChickenBuilder);
    //gold
    private static final EntityType.IFactory<ResourceChickenEntity> goldChickenFactoryInstance = (type, world)-> new ResourceChickenEntity(type, world, Items.GOLD_INGOT);
    public static final EntityType<ResourceChickenEntity> goldChickenBuilder = EntityType.Builder.create(goldChickenFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "gold_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<ResourceChickenEntity>> gold_resource_chicken_entity = ENTITIES.register("gold_resource_chicken_entity", () -> goldChickenBuilder);
    //iron
    private static final EntityType.IFactory<ResourceChickenEntity> ironChickenFactoryInstance = (type, world)-> new ResourceChickenEntity(type, world, Items.IRON_INGOT);
    public static final EntityType<ResourceChickenEntity> ironChickenBuilder = EntityType.Builder.create(ironChickenFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "iron_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<ResourceChickenEntity>> iron_resource_chicken_entity = ENTITIES.register("iron_resource_chicken_entity", () -> ironChickenBuilder);
    //lapis
    private static final EntityType.IFactory<ResourceChickenEntity> lapisChickenFactoryInstance = (type, world)-> new ResourceChickenEntity(type, world, Items.LAPIS_LAZULI);
    public static final EntityType<ResourceChickenEntity> lapisChickenBuilder = EntityType.Builder.create(lapisChickenFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "lapis_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<ResourceChickenEntity>> lapis_resource_chicken_entity = ENTITIES.register("lapis_resource_chicken_entity", () -> lapisChickenBuilder);
    //netherite
    private static final EntityType.IFactory<ResourceChickenEntity> netheriteChickenFactoryInstance = (type, world)-> new ResourceChickenEntity(type, world, Items.NETHERITE_INGOT);
    public static final EntityType<ResourceChickenEntity> netheriteChickenBuilder = EntityType.Builder.create(netheriteChickenFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "netherite_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<ResourceChickenEntity>> netherite_resource_chicken_entity = ENTITIES.register("netherite_resource_chicken_entity", () -> netheriteChickenBuilder);
    //quartz
    private static final EntityType.IFactory<ResourceChickenEntity> quartzChickenFactoryInstance = (type, world)-> new ResourceChickenEntity(type, world, Items.QUARTZ);
    public static final EntityType<ResourceChickenEntity> quartzChickenBuilder = EntityType.Builder.create(quartzChickenFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "quartz_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<ResourceChickenEntity>> quartz_resource_chicken_entity = ENTITIES.register("quartz_resource_chicken_entity", () -> quartzChickenBuilder);
    //redstone
    private static final EntityType.IFactory<ResourceChickenEntity> redstoneChickenFactoryInstance = (type, world)-> new ResourceChickenEntity(type, world, Items.REDSTONE);
    public static final EntityType<ResourceChickenEntity> redstoneChickenBuilder = EntityType.Builder.create(redstoneChickenFactoryInstance, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "redstone_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<ResourceChickenEntity>> redstone_resource_chicken_entity = ENTITIES.register("redstone_resource_chicken_entity", () -> redstoneChickenBuilder);

    //registrazione attributi entity
    @Mod.EventBusSubscriber(modid = Main.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEntitiesAttributes {
        @SubscribeEvent
        public static void registerAttributes(FMLCommonSetupEvent event) {
            //mole
            GlobalEntityTypeAttributes.put(mole_entity.get(), MoleEntity.setCustomAttributes().create());
            //yeti
            GlobalEntityTypeAttributes.put(yeti_entity.get(), YetiEntity.setCustomAttributes().create());
            //walking fungus
            GlobalEntityTypeAttributes.put(walking_fungus_entity.get(), WalkingFungusEntity.setCustomAttributes().create());
            //sheeps
            GlobalEntityTypeAttributes.put(coal_resource_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(diamond_resource_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(emerald_resource_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(gold_resource_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(iron_resource_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(lapis_resource_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(netherite_resource_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(quartz_resource_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(redstone_resource_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            //chickens
            GlobalEntityTypeAttributes.put(coal_resource_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(diamond_resource_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(emerald_resource_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(gold_resource_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(iron_resource_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(lapis_resource_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(netherite_resource_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(quartz_resource_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(redstone_resource_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
        }
    }
    
}
