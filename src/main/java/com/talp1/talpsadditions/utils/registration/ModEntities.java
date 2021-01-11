package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.entity.MoleEntity.MoleEntity;
import com.talp1.talpsadditions.entity.ResourceChicken.ResourceChickenEntity;
import com.talp1.talpsadditions.entity.ResourceChicken.type.*;
import com.talp1.talpsadditions.entity.ResourceSheep.ResourceSheepEntity;
import com.talp1.talpsadditions.entity.ResourceSheep.types.*;
import com.talp1.talpsadditions.entity.YetiEntity.YetiEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
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
    //----------------------------------------------------
    //resource Sheeps
    //coal
    public static final EntityType<CoalResourceSheep> coalSheepBuilder =EntityType.Builder.create(CoalResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "coal_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<CoalResourceSheep>> coal_sheep_entity = ENTITIES.register("coal_resource_sheep_entity", () -> coalSheepBuilder);
    //diamond
    public static final EntityType<DiamondResourceSheep> diamondSheepBuilder =EntityType.Builder.create(DiamondResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "diamond_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<DiamondResourceSheep>> diamond_sheep_entity = ENTITIES.register("diamond_resource_sheep_entity", () ->diamondSheepBuilder);
    //emerald
    public static final EntityType<EmeraldResourceSheep> emeraldSheepBuilder =EntityType.Builder.create(EmeraldResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "emerald_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<EmeraldResourceSheep>> emerald_sheep_entity = ENTITIES.register("emerald_resource_sheep_entity", () -> emeraldSheepBuilder);
    //gold
    public static final EntityType<GoldResourceSheep> goldSheepBuilder =EntityType.Builder.create(GoldResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "gold_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<GoldResourceSheep>> gold_sheep_entity = ENTITIES.register("gold_resource_sheep_entity", () -> goldSheepBuilder);
    //iron
    public static final EntityType<IronResourceSheep> ironSheepBuilder =EntityType.Builder.create(IronResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "iron_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<IronResourceSheep>> iron_sheep_entity = ENTITIES.register("iron_resource_sheep_entity", () -> ironSheepBuilder);
    //lapis
    public static final EntityType<LapisResourceSheep> lapisSheepBuilder =EntityType.Builder.create(LapisResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "lapis_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<LapisResourceSheep>> lapis_sheep_entity = ENTITIES.register("lapis_resource_sheep_entity", () -> lapisSheepBuilder);
    //netherite
    public static final EntityType<NetheriteResourceSheep> netheriteSheepBuilder =EntityType.Builder.create(NetheriteResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "netherite_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<NetheriteResourceSheep>> netherite_sheep_entity = ENTITIES.register("netherite_resource_sheep_entity", () -> netheriteSheepBuilder);
    //quartz
    public static final EntityType<QuartzResourceSheep> quartzSheepBuilder =EntityType.Builder.create(QuartzResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "quartz_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<QuartzResourceSheep>> quartz_sheep_entity = ENTITIES.register("quartz_resource_sheep_entity", () -> quartzSheepBuilder);
    //redstone
    public static final EntityType<RedstoneResourceSheep> redstoneSheepBuilder =EntityType.Builder.create(RedstoneResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "redstone_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<RedstoneResourceSheep>> redstone_sheep_entity = ENTITIES.register("redstone_resource_sheep_entity", () -> redstoneSheepBuilder);
    //---------------------------------------------------
    //resource Chickens
    //coal
    public static final EntityType<CoalResourceChicken> coalChickenBuilder =EntityType.Builder.create(CoalResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "coal_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<CoalResourceChicken>> coal_chicken_entity = ENTITIES.register("coal_resource_chicken_entity", () -> coalChickenBuilder);
    //diamond
    public static final EntityType<DiamondResourceChicken> diamondChickenBuilder =EntityType.Builder.create(DiamondResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "diamond_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<DiamondResourceChicken>> diamond_chicken_entity = ENTITIES.register("diamond_resource_chicken_entity", () ->diamondChickenBuilder);
    //emerald
    public static final EntityType<EmeraldResourceChicken> emeraldChickenBuilder =EntityType.Builder.create(EmeraldResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "emerald_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<EmeraldResourceChicken>> emerald_chicken_entity = ENTITIES.register("emerald_resource_chicken_entity", () -> emeraldChickenBuilder);
    //gold
    public static final EntityType<GoldResourceChicken> goldChickenBuilder =EntityType.Builder.create(GoldResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "gold_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<GoldResourceChicken>> gold_chicken_entity = ENTITIES.register("gold_resource_chicken_entity", () -> goldChickenBuilder);
    //iron
    public static final EntityType<IronResourceChicken> ironChickenBuilder =EntityType.Builder.create(IronResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "iron_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<IronResourceChicken>> iron_chicken_entity = ENTITIES.register("iron_resource_chicken_entity", () -> ironChickenBuilder);
    //lapis
    public static final EntityType<LapisResourceChicken> lapisChickenBuilder =EntityType.Builder.create(LapisResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "lapis_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<LapisResourceChicken>> lapis_chicken_entity = ENTITIES.register("lapis_resource_chicken_entity", () -> lapisChickenBuilder);
    //netherite
    public static final EntityType<NetheriteResourceChicken> netheriteChickenBuilder =EntityType.Builder.create(NetheriteResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "netherite_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<NetheriteResourceChicken>> netherite_chicken_entity = ENTITIES.register("netherite_resource_chicken_entity", () -> netheriteChickenBuilder);
    //quartz
    public static final EntityType<QuartzResourceChicken> quartzChickenBuilder =EntityType.Builder.create(QuartzResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "quartz_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<QuartzResourceChicken>> quartz_chicken_entity = ENTITIES.register("quartz_resource_chicken_entity", () -> quartzChickenBuilder);
    //redstone
    public static final EntityType<RedstoneResourceChicken> redstoneChickenBuilder =EntityType.Builder.create(RedstoneResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "redstone_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<RedstoneResourceChicken>> redstone_chicken_entity = ENTITIES.register("redstone_resource_chicken_entity", () -> redstoneChickenBuilder);

    //registrazione attributi entity
    @Mod.EventBusSubscriber(modid = Main.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEntitiesAttributes {
        @SubscribeEvent
        public static void registerAttributes(FMLCommonSetupEvent event) {
            //mole
            GlobalEntityTypeAttributes.put(mole_entity.get(), MoleEntity.setCustomAttributes().create());
            //yeti
            GlobalEntityTypeAttributes.put(yeti_entity.get(), YetiEntity.setCustomAttributes().create());
            //sheeps
            GlobalEntityTypeAttributes.put(coal_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(diamond_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(emerald_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(gold_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(iron_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(lapis_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(netherite_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(quartz_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(redstone_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            //chickens
            GlobalEntityTypeAttributes.put(coal_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(diamond_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(emerald_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(gold_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(iron_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(lapis_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(netherite_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(quartz_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(redstone_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
        }
    }
    
}
