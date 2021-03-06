package com.talp1.talpsadditions.utils;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.recipe.ModBrewingRecipe;
import com.talp1.talpsadditions.utils.registration.ModItems;
import com.talp1.talpsadditions.utils.registration.ModPotions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


//credits to Cyclic

@Mod.EventBusSubscriber(modid = Main.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class BrewingHandler {

    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent event) {
        ItemStack AWKWARD = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.AWKWARD);
        //luck recipes
        basicBrewing(AWKWARD.copy(), ModPotions.luck_potion.get(), ModItems.shiny_shard_dust.get());
        splashBrewing(ModPotions.luck_potion.get(), ModItems.shiny_shard_dust.get());
        lingerBrewing(ModPotions.luck_potion.get(), ModItems.shiny_shard_dust.get());
        //senses recipes
        basicBrewing(AWKWARD.copy(), ModPotions.senses_potion.get(), ModItems.mysterious_sensory_organ.get());
        splashBrewing(ModPotions.senses_potion.get(), ModItems.mysterious_sensory_organ.get());
        lingerBrewing(ModPotions.senses_potion.get(), ModItems.mysterious_sensory_organ.get());
        //dolphins grace
        basicBrewing(AWKWARD.copy(), ModPotions.dolphins_grace_potion.get(), ModItems.dolphin_fin.get());
        splashBrewing(ModPotions.dolphins_grace_potion.get(), ModItems.dolphin_fin.get());
        lingerBrewing(ModPotions.dolphins_grace_potion.get(), ModItems.dolphin_fin.get());
    }

    private static void basicBrewing(ItemStack AWKWARD, Potion pot, Item item) {
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(AWKWARD, Ingredient.fromItems(item),
                PotionUtils.addPotionToItemStack(
                        new ItemStack(Items.POTION), pot)));
    }

    private static void splashBrewing(Potion pot, Item item) {
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.addPotionToItemStack(
                new ItemStack(Items.SPLASH_POTION), Potions.AWKWARD),
                Ingredient.fromStacks(new ItemStack(item)),
                PotionUtils.addPotionToItemStack(
                        new ItemStack(Items.SPLASH_POTION), pot)));
    }

    private static void lingerBrewing(Potion pot, Item item) {
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.addPotionToItemStack(
                new ItemStack(Items.LINGERING_POTION), Potions.AWKWARD),
                Ingredient.fromStacks(new ItemStack(item)),
                PotionUtils.addPotionToItemStack(
                        new ItemStack(Items.LINGERING_POTION), pot)));
    }

}
