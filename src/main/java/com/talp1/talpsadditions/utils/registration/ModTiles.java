package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.tile_entity.GenLabTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTiles {
    //DefReg per Tile Entities
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Main.MODID);

    public static void init() {
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //tile entities
    public static final RegistryObject<TileEntityType<GenLabTE>> gen_lab_te = TILE_ENTITIES.register("gen_lab_te", () -> TileEntityType.Builder.create(GenLabTE::new, ModBlocks.gen_lab_block.get()).build(null));

}
