package com.talp1.talpsadditions;

import com.talp1.talpsadditions.gui.CustomItemGroup;
import com.talp1.talpsadditions.utils.registration.*;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "talpsadditions";
    //Mod Item Group Instance
    public static final CustomItemGroup CUSTOM_ITEM_GROUP = new CustomItemGroup("talpsadditions", "item_search.png");


    public Main() {
        MinecraftForge.EVENT_BUS.register(this);

        //chiamata al metodo per la registrazione dei DefReg nella classe RegistryHandler nel bus eventi
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
