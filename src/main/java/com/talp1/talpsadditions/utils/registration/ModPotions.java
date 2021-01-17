package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
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
    public static final RegistryObject<Potion> luck_potion = POTIONS.register("luck_potion", () -> new Potion(new EffectInstance(Effects.LUCK, 6000,2)));
    public static final RegistryObject<Potion> senses_potion = POTIONS.register("senses_potion", () -> new Potion(new EffectInstance(Effects.HASTE, 6000, 0),new EffectInstance(Effects.BLINDNESS, 6000, 3),new EffectInstance(ModEffects.senses_effect.get(), 6000)));
    public static final RegistryObject<Potion> dolphins_grace_potion = POTIONS.register("dolphins_grace_potion", () -> new Potion(new EffectInstance(Effects.DOLPHINS_GRACE, 6000, 1)));

}
