package com.talp1.talpsadditions.compat.vanilla;

import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;

public class ComposterCompat {

    public static void init(){
        registerCompostable(0.65F, ModItems.green_rose_item.get());
        registerCompostable(0.65F, ModItems.yellow_rose_item.get());
        registerCompostable(0.65F, ModItems.purple_rose_item.get());
        registerCompostable(0.65F, ModItems.orange_rose_item.get());
        registerCompostable(0.70F, ModItems.multicolor_rose_item.get());
        registerCompostable(0.3F, ModItems.blue_berries.get());
        registerCompostable(0.3F, ModItems.blue_hydrangea_sprout.get());
        registerCompostable(0.3F, ModItems.lilac_hydrangea_sprout.get());
        registerCompostable(0.3F, ModItems.pink_hydrangea_sprout.get());
        registerCompostable(0.3F, ModItems.red_hydrangea_sprout.get());
        registerCompostable(0.3F, ModItems.white_hydrangea_sprout.get());
        registerCompostable(0.3F, ModItems.bush_sprout.get());
        registerCompostable(0.70F, ModItems.floreal_decoration_item.get());
        registerCompostable(0.5F, ModItems.floreal_vines_item.get());
        registerCompostable(0.2F, ModItems.frosted_vines_item.get());
        registerCompostable(0.2F, ModItems.petal.get());
        registerCompostable(0.2F, ModItems.bush_leaf.get());
        registerCompostable(0.7F, ModItems.coconut_item.get());
        registerCompostable(0.2F, ModItems.piece_of_coconut.get());
        registerCompostable(0.65F, ModItems.flowery_water_lily_item.get());
        registerCompostable(0.65F, Items.GRASS_BLOCK);
    }

    private static void registerCompostable(float chance, IItemProvider itemIn) {
        ComposterBlock.CHANCES.put(itemIn.asItem(), chance);
    }

}
