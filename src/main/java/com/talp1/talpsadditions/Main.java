package com.talp1.talpsadditions;

import com.talp1.talpsadditions.config.CommonConfig;
import com.talp1.talpsadditions.gui.CustomItemGroup;
import com.talp1.talpsadditions.utils.registration.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "talpsadditions";
    public static final CustomItemGroup CUSTOM_ITEM_GROUP = new CustomItemGroup("talpsadditions", "item_search.png");
    public static final CommonConfig COMMON_CONFIG = new CommonConfig();

    public Main() {
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_CONFIG.getSpec());

        ModItems.init();
        ModPotions.init();
        ModEffects.init();
        ModBlocks.init();
        ModContainers.init();
        ModTiles.init();
        ModEntities.init();
        ModFeatures.init();
        ModSounds.init();
        ModEnchants.init();
    }
}
