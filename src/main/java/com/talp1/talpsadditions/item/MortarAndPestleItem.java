package com.talp1.talpsadditions.item;

import net.minecraft.enchantment.*;
import net.minecraft.item.*;

public class MortarAndPestleItem extends Item {

    public MortarAndPestleItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        if (itemStack.getDamage()>=itemStack.getMaxDamage()-1)
            return new ItemStack(null);
        else{
            ItemStack newItemStack=itemStack.copy();
            newItemStack.setDamage(itemStack.getDamage()+1);
            return newItemStack;
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.getName().equals(Enchantments.UNBREAKING.getName())|| enchantment.getName().equals(Enchantments.MENDING.getName());
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.UNBREAKING)||EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.MENDING);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return 1;
    }

}
