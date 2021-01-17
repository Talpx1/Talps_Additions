package com.talp1.talpsadditions.item;

import net.minecraft.enchantment.IVanishable;
import net.minecraft.item.FishingRodItem;

public class ModFishingRodItem extends FishingRodItem implements IVanishable {

    private int enchantability;

    public ModFishingRodItem(Properties builder, int enchantability) {
        super(builder);
        this.enchantability=enchantability;
    }

    public int getItemEnchantability() {
        return enchantability;
    }
}
