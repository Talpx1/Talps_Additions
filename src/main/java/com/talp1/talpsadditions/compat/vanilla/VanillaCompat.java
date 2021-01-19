package com.talp1.talpsadditions.compat.vanilla;

import com.talp1.talpsadditions.Main;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class VanillaCompat {

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event){
        ComposterCompat.init();
    }

}
