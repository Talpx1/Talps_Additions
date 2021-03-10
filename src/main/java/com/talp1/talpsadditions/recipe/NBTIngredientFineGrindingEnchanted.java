package com.talp1.talpsadditions.recipe;

import com.google.gson.JsonObject;
import com.talp1.talpsadditions.utils.registration.ModEnchants;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IIngredientSerializer;
import net.minecraftforge.common.crafting.NBTIngredient;

import javax.annotation.Nullable;

public class NBTIngredientFineGrindingEnchanted extends NBTIngredient {
    private final ItemStack stack;

    protected NBTIngredientFineGrindingEnchanted(ItemStack stack) {
        super(stack);
        this.stack = stack;
    }

    @Override
    public boolean test(@Nullable ItemStack input)
    {
        if (input == null)
            return false;
        return this.stack.getItem() == input.getItem() && EnchantmentHelper.getEnchantments(input).containsKey(ModEnchants.fine_grinding_enchant.get()) && EnchantmentHelper.getEnchantmentLevel(ModEnchants.fine_grinding_enchant.get(),input)==EnchantmentHelper.getEnchantmentLevel(ModEnchants.fine_grinding_enchant.get(),this.stack);
    }

    public static class Serializer implements IIngredientSerializer<NBTIngredientFineGrindingEnchanted>
    {
        public static final NBTIngredientFineGrindingEnchanted.Serializer INSTANCE = new NBTIngredientFineGrindingEnchanted.Serializer();

        @Override
        public NBTIngredientFineGrindingEnchanted parse(PacketBuffer buffer) {
            return new NBTIngredientFineGrindingEnchanted(buffer.readItemStack());
        }

        @Override
        public NBTIngredientFineGrindingEnchanted parse(JsonObject json) {
            return new NBTIngredientFineGrindingEnchanted(CraftingHelper.getItemStack(json, true));
        }

        @Override
        public void write(PacketBuffer buffer, NBTIngredientFineGrindingEnchanted ingredient) {
            buffer.writeItemStack(ingredient.stack);
        }
    }

}
