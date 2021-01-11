package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    //DefReg per Sounds
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MODID);

    public static void init() {
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //sounds
    public static final RegistryObject<SoundEvent> shiny_ores_sound = SOUNDS.register("shiny_ores", ()->new SoundEvent(new ResourceLocation(Main.MODID, "shiny_ores")));

}
