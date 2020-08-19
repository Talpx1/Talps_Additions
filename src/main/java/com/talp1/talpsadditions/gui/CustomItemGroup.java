package com.talp1.talpsadditions.gui;

import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CustomItemGroup extends ItemGroup {
    public CustomItemGroup(String unlocalizedName, String texture) {
        super(unlocalizedName);
        setBackgroundImageName(texture);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(RegistryHandler.shiny_shard.get());
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public ItemGroup setBackgroundImageName(String texture) {
        return super.setBackgroundImageName(texture);
    }
}
