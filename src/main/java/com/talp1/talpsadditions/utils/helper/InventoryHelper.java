package com.talp1.talpsadditions.utils.helper;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventoryHelper {

    public static int findItemSlotInInventory(Item item, PlayerInventory plyerInv){
        for (int i=0; i<plyerInv.getSizeInventory(); i++){
            if (plyerInv.getStackInSlot(i).getItem()==item){
                return i;
            }
        }
        return -1;
    }

    public static int findPotionSlotInInventory(ItemStack item, PlayerInventory plyerInv){
        for (int i=0; i<plyerInv.getSizeInventory(); i++){
            if (plyerInv.getStackInSlot(i).getItem()==item.getItem()){
                if (plyerInv.getStackInSlot(i).getTag().getString("Potion").equals(item.getTag().getString("Potion"))){
                    return i;
                }
            }
        }
        return -1;
    }


}
