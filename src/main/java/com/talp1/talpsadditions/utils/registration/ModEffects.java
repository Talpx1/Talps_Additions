package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.effect.SensesEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {

    //DefReg per Effects
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Main.MODID);

    public static void init() {
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //registrazione effects
    public static final RegistryObject<SensesEffect> senses_effect = EFFECTS.register("senses_effect",()->new SensesEffect(EffectType.NEUTRAL, 0x572e19));

}
