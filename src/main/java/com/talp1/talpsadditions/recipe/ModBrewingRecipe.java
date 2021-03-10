package com.talp1.talpsadditions.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipe;

//credits to Cyclic

public class ModBrewingRecipe extends BrewingRecipe {

    private ItemStack inputStack;

    public ModBrewingRecipe(ItemStack inputStack, Ingredient ingredient, ItemStack output) {
        super(Ingredient.fromStacks(inputStack), ingredient, output);
        this.inputStack = inputStack;
    }

    @Override
    public boolean isInput(ItemStack stack) {
        return super.isInput(stack) && PotionUtils.getPotionFromItem(stack) == PotionUtils.getPotionFromItem(inputStack);
    }
}
