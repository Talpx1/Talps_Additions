package com.talp1.talpsadditions.config;

import com.talp1.talpsadditions.Main;
import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    /*
    CLIENT = loaded on physical client startup, only on client, not synced to server
    COMMON = loaded on both sides startup, not synced to other side
    SERVER = loaded on dedi-server startup/world load on client, synced to the logical client

    SERVER side should probably be used for the truly configurable stuff that can change on servers (because it's synced from them on join), COMMON can be used for the "this happens everywhere and it doesn't matter if a server has it different" and CLIENT is the rendering and client-specific stuff.
    common appears to load before configs and resource packs, so that should be taken into account if you're doing configurable features
     */

    public static ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec spec;

    //mole spawning
    public static ForgeConfigSpec.IntValue moleSpawnWeight;
    public static ForgeConfigSpec.IntValue moleSpawnMax;
    public static ForgeConfigSpec.IntValue moleSpawnMin;
    //mole attr
    public static ForgeConfigSpec.DoubleValue moleMovementSpeed;
    public static ForgeConfigSpec.DoubleValue moleMaxHealth;
    //yeti spawning
    public static ForgeConfigSpec.IntValue yetiSpawnWeight;
    public static ForgeConfigSpec.IntValue yetiSpawnMax;
    public static ForgeConfigSpec.IntValue yetiSpawnMin;
    //yeti attr
    public static ForgeConfigSpec.DoubleValue yetiMaxHealth;
    public static ForgeConfigSpec.DoubleValue yetiFollowRange;
    public static ForgeConfigSpec.DoubleValue yetiMovementSpeed;
    public static ForgeConfigSpec.DoubleValue yetiAttackDamage;
    //walking fungus spawning
    public static ForgeConfigSpec.IntValue walkingFungusSpawnWeight;
    public static ForgeConfigSpec.IntValue walkingFungusSpawnMax;
    public static ForgeConfigSpec.IntValue walkingFungusSpawnMin;
    //walking fungus attr
    public static ForgeConfigSpec.DoubleValue walkingFungusMovementSpeed;
    public static ForgeConfigSpec.DoubleValue walkingFungusMaxHealth;
    //dolphin fin drop chance (1 out of x)
    public static ForgeConfigSpec.IntValue dolphinFinDropChance;
    //bat eardrum drop chance (1 out of x)
    public static ForgeConfigSpec.IntValue batEarDrumDropChance;
    //earth worm drop chance (1 out of x)
    public static ForgeConfigSpec.IntValue earthWormDropChance;
    //Gen-lab energy use per tick
    public static ForgeConfigSpec.IntValue genLabEnergyPerTick;
    //Gen-lab max energy capacity
    public static ForgeConfigSpec.IntValue genLabEnergyMaxCapacity;
    //Drink acid damage amount
    public static ForgeConfigSpec.IntValue drinkAcidDamageAmount;
    //Senses effect detect radius
    public static ForgeConfigSpec.IntValue sensesEffectDetectRadius;
    //Gen lab powering: block falling multiplier
    public static ForgeConfigSpec.IntValue fallingBlockMultiplier;
    //Shiny Shard Ore light emit
    public static ForgeConfigSpec.IntValue lightValShinyShardOre;
    //Shiny Shard block light emit
    public static ForgeConfigSpec.IntValue lightValShinyShardBlock;
    //luck potion duration
    public static ForgeConfigSpec.IntValue luckPotionDuration;
    //luck potion amplifier
    public static ForgeConfigSpec.IntValue luckPotionAmplifier;
    //senses potion blindness duration
    public static ForgeConfigSpec.IntValue sensesPotionBlindnessDuration;
    //senses potion blindness amplifier
    public static ForgeConfigSpec.IntValue sensesPotionBlindnessAmplifier;
    //senses potion haste duration
    public static ForgeConfigSpec.IntValue sensesPotionHasteDuration;
    //senses potion haste amplifier
    public static ForgeConfigSpec.IntValue sensesPotionHasteAmplifier;
    //senses potion sensesEff duration
    public static ForgeConfigSpec.IntValue sensesPotionSensesDuration;
    //dolphins grace potion duration
    public static ForgeConfigSpec.IntValue dolphinGraceDuration;
    //dolphins grace potion amplifier
    public static ForgeConfigSpec.IntValue dolphinGraceAmplifier;

    public CommonConfig() {
        builder.push(Main.MODID);
        //moles spawning
        moleSpawnWeight = builder.comment("The spawning weight for moles").defineInRange("moleSpawnWeight", 8,1,64);
        moleSpawnMin = builder.comment("The minimum number of moles in a spawn group").defineInRange("moleSpawnMin", 1, 1, 16);
        moleSpawnMax = builder.comment("The maximum number of moles in a spawn group").defineInRange("moleSpawnMax", 4,1,32);
        //mole atts
        moleMaxHealth = builder.comment("The maximum amount of health for the mole").defineInRange("moleMaxHealth", 5.0D,1.0D,12.0D);
        moleMovementSpeed = builder.comment("The movement speed of the mole").defineInRange("moleMovementSpeed", 0.25D, 0.10D, 1.0D);
        //yeti spawning
        yetiSpawnWeight = builder.comment("The spawning weight for yetis").defineInRange("yetiSpawnWeight", 3,1,12);
        yetiSpawnMin = builder.comment("The minimum number of yetis in a spawn group").defineInRange("yetiSpawnMin", 1, 1, 5);
        yetiSpawnMax = builder.comment("The maximum number of yetis in a spawn group").defineInRange("yetiSpawnMax", 1,1,12);
        //yeti atts
        yetiMaxHealth = builder.comment("The maximum amount of health for the yeti").defineInRange("yetiMaxHealth", 30.0D,5.0D,75.0D);
        yetiFollowRange = builder.comment("The maximum distance the yeti will follow its target").defineInRange("yetiFollowRange", 20.0D,5.0D,40.0D);
        yetiMovementSpeed = builder.comment("The movement speed of the yeti").defineInRange("yetiMovementSpeed", 0.25D, 0.10D, 1.0D);
        yetiAttackDamage = builder.comment("The damage the yeti will cause on attack").defineInRange("yetiAttackDamage", 6.0D, 1.0D, 15.0D);
        //walking fungus spawning
        walkingFungusSpawnWeight = builder.comment("The spawning weight for the walking fungus").defineInRange("walkingFungusSpawnWeight", 5,1,48);
        walkingFungusSpawnMin = builder.comment("The minimum number of walking fungus in a spawn group").defineInRange("walkingFungusSpawnMin", 1, 1, 16);
        walkingFungusSpawnMax = builder.comment("The maximum number of walking fungus in a spawn group").defineInRange("walkingFungusSpawnMax", 2,1,48);
        //walking fungus atts
        walkingFungusMaxHealth = builder.comment("The maximum amount of health for the walking fungus").defineInRange("walkingFungusMaxHealth", 9.0D,1.0D,18.0D);
        walkingFungusMovementSpeed = builder.comment("The movement speed of the walking fungus").defineInRange("walkingFungusMovementSpeed", 0.25D, 0.10D, 1.0D);

        //event handler drops settings
        dolphinFinDropChance = builder.comment("The chance out of X that when killing a dolphin it will drop a Dolpin Fin (you are setting the X here, so the smaller the more likely the drop happens)").defineInRange("dolphinFinDropChance",3,1,100);
        batEarDrumDropChance = builder.comment("The chance out of X that when killing a bat it will drop a Bat Eardrum (you are setting the X here, so the smaller the more likely the drop happens)").defineInRange("batEarDrumDropChance",6,1,100);
        earthWormDropChance = builder.comment("The chance out of X that when hoeing it will drop a Earth Worm (you are setting the X here, so the smaller the more likely the drop happens)").defineInRange("earthWormDropChance",3,1,100);
        //gen lab settings
        genLabEnergyPerTick = builder.comment("The amount of energy per tick used by the Gen-Lab").defineInRange("genLabEnergyPerTick",50,1,5000);
        genLabEnergyMaxCapacity = builder.comment("The amount of energy that the Gen-Lab can store").defineInRange("genLabEnergyMaxCapacity",200000,10000,500000);
        fallingBlockMultiplier =builder.comment("The multiplier for the Gen-Lab falling block powering mechanic").defineInRange("fallingBlockMultiplier",1000,100,10000);
        //events settings
        drinkAcidDamageAmount = builder.comment("The amount damage that drinking acid will cause").defineInRange("drinkAcidDamageAmount",9999,5,9999);
        //blocks settings
        lightValShinyShardOre = builder.comment("The amount of light that a Shiny Shard Ore will emit").defineInRange("lightValShinyShardOre",6,1,15);
        lightValShinyShardBlock = builder.comment("The amount of light that a Shiny Shard Block will emit").defineInRange("lightValShinyShardBlock",8,1,15);
        //potions settings
        luckPotionDuration = builder.comment("The duration of the luck potion").defineInRange("luckPotionDuration",6000,300,12000);
        luckPotionAmplifier = builder.comment("The amplifier that will be applied to the luck effect when drinking a luck potion").defineInRange("luckPotionAmplifier",2,0,5);
        sensesPotionBlindnessDuration = builder.comment("The duration of the blindness effect of a senses potion").defineInRange("sensesPotionBlindnessDuration",6000,300,12000);
        sensesPotionBlindnessAmplifier = builder.comment("The amplifier that will be applied to the blindness effect when drinking a senses potion").defineInRange("sensesPotionBlindnessAmplifier",3,0,5);
        sensesPotionHasteDuration = builder.comment("The duration of the haste effect of a senses potion").defineInRange("sensesPotionHasteDuration",6000,300,12000);
        sensesPotionHasteAmplifier = builder.comment("The amplifier that will be applied to the haste effect when drinking a senses potion").defineInRange("sensesPotionHasteAmplifier",0,0,5);
        sensesPotionSensesDuration = builder.comment("The duration of the senses effect of a senses potion").defineInRange("sensesPotionSensesDuration",6000,300,12000);
        dolphinGraceDuration = builder.comment("The duration of the dolphins grace potion").defineInRange("dolphinGraceDuration",6000,300,12000);
        dolphinGraceAmplifier = builder.comment("The amplifier that will be applied to the dolphins grace effect when drinking a dolphins grace potion").defineInRange("dolphinGraceAmplifier",1,0,5);
        //effects settings
        sensesEffectDetectRadius = builder.comment("The radius where the senses effect will look for Shiny Shards Ore").defineInRange("sensesEffectDetectRadius",5,2,15);

        builder.pop();

        spec = builder.build();
    }

    public ForgeConfigSpec getSpec() {
        return spec;
    }

}
