package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.config.CommonConfig;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPotions {
    //DefReg per Potions
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Main.MODID);

    public static void init() {
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //registrazione potions
    public static final RegistryObject<Potion> luck_potion = POTIONS.register("luck_potion", () -> new Potion(new EffectInstance(Effects.LUCK, CommonConfig.luckPotionDuration.get(),CommonConfig.luckPotionAmplifier.get())));
    public static final RegistryObject<Potion> senses_potion = POTIONS.register("senses_potion", () -> new Potion(new EffectInstance(Effects.HASTE, CommonConfig.sensesPotionHasteDuration.get(), CommonConfig.sensesPotionHasteAmplifier.get()),new EffectInstance(Effects.BLINDNESS, CommonConfig.sensesPotionBlindnessDuration.get(), CommonConfig.sensesPotionBlindnessAmplifier.get()),new EffectInstance(ModEffects.senses_effect.get(), CommonConfig.sensesPotionSensesDuration.get())));
    public static final RegistryObject<Potion> dolphins_grace_potion = POTIONS.register("dolphins_grace_potion", () -> new Potion(new EffectInstance(Effects.DOLPHINS_GRACE, CommonConfig.dolphinGraceDuration.get(), CommonConfig.dolphinGraceAmplifier.get())));

}
