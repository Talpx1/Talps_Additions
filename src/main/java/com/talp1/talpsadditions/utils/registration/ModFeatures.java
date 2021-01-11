package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.world.features.FlorealVineFeature;
import com.talp1.talpsadditions.world.features.FrostedVineFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
    //DefReg per Features
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Main.MODID);

    public static void init() {
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //registrazione features
    public static final RegistryObject<Feature<NoFeatureConfig>> floreal_vine_feature = FEATURES.register("floreal_vine_feature", ()->new FlorealVineFeature(NoFeatureConfig.field_236558_a_));
    public static final RegistryObject<Feature<NoFeatureConfig>> frosted_vine_feature = FEATURES.register("frosted_vine_feature", ()->new FrostedVineFeature(NoFeatureConfig.field_236558_a_));

}
