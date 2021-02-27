package com.talp1.talpsadditions.item;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.registration.ModEnchants;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;

import java.util.Random;

public class MortarAndPestleItem extends ToolItem {

    private int tier;
    private int enchantability;

    public MortarAndPestleItem(int enchantability, int tier, Properties properties) {
        super(0,0,ItemTier.WOOD, ImmutableSet.of(),properties);
        this.tier=tier;
        this.enchantability=enchantability;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        if (itemStack.getDamage()>=itemStack.getMaxDamage()-1)
            return new ItemStack(null);
        else{
            ItemStack newItemStack=itemStack.copy();
            newItemStack.attemptDamageItem(1, new Random(),null);//this also consider unbreaking
            return newItemStack;
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if(this.tier==2){
            return enchantment.getName().equals(Enchantments.UNBREAKING.getName())||
                    enchantment.getName().equals(Enchantments.MENDING.getName())||
                    enchantment.equals(ModEnchants.fine_grinding_enchant.get());
        }
        if(this.tier==1){
            return enchantment.getName().equals(Enchantments.UNBREAKING.getName())||
                    enchantment.getName().equals(Enchantments.MENDING.getName());
        }else{return false;}
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        if(this.tier==2){
            return EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.UNBREAKING)||
                    EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.MENDING)||
                    EnchantmentHelper.getEnchantments(book).containsKey(ModEnchants.fine_grinding_enchant.get());
        }
        if(this.tier==1){
            return EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.UNBREAKING)||
                    EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.MENDING);
        }else {return false;}
    }



    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return this.enchantability;
    }

}
