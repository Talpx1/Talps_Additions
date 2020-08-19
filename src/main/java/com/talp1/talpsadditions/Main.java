package com.talp1.talpsadditions;

import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "talpsadditions";

    public Main() {
        MinecraftForge.EVENT_BUS.register(this);
        //chiamata al metodo per la registrazione dei DefReg nella classe RegistryHandler nel bus eventi
        RegistryHandler.init();
    }
}
