package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.world.features.ModVineFeature;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Arrays;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Main.MODID);

    public static void init() {
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //vars for predicates
    private static final ArrayList<Block> FROSTED_VINES_VALID_BLOCKS = new ArrayList<>(Arrays.asList(Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE));

    //features
    public static final RegistryObject<Feature<NoFeatureConfig>> floreal_vine_feature = FEATURES.register("floreal_vine_feature", ()->new ModVineFeature(NoFeatureConfig.field_236558_a_, ModBlocks.floreal_vines.get(), 3, (block)-> block instanceof LeavesBlock));
    public static final RegistryObject<Feature<NoFeatureConfig>> frosted_vine_feature = FEATURES.register("frosted_vine_feature", ()->new ModVineFeature(NoFeatureConfig.field_236558_a_, ModBlocks.frosted_vines.get(), 11, (block)->FROSTED_VINES_VALID_BLOCKS.contains(block)));

}
