package com.talp1.talpsadditions.utils;

import com.talp1.talpsadditions.Main;
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

    /*registrazione ricette Pozioni
    @SubscribeEvent
    public static void registerPotionRecepies(FMLCommonSetupEvent event) {
        try {
            Method addMix = PotionBrewing.class.getDeclaredMethod("addMix", Potion.class, Item.class, Potion.class);
            addMix.setAccessible(true);
            //luck
            addMix.invoke(addMix, Potions.AWKWARD, RegistryHandler.shiny_shard_dust.get(), RegistryHandler.luck_potion.get());
            //senses
            addMix.invoke(addMix, Potions.AWKWARD, RegistryHandler.mysterious_sensory_organ.get(), RegistryHandler.senses_potion.get());
        }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }*/

    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent event) {
        ItemStack AWKWARD = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.AWKWARD);
        //luck recipes
        basicBrewing(AWKWARD.copy(), RegistryHandler.luck_potion.get(), RegistryHandler.shiny_shard_dust.get());
        splashBrewing(RegistryHandler.luck_potion.get(), RegistryHandler.shiny_shard_dust.get());
        lingerBrewing(RegistryHandler.luck_potion.get(), RegistryHandler.shiny_shard_dust.get());
        //senses recipes
        basicBrewing(AWKWARD.copy(), RegistryHandler.senses_potion.get(), RegistryHandler.mysterious_sensory_organ.get());
        splashBrewing(RegistryHandler.senses_potion.get(), RegistryHandler.mysterious_sensory_organ.get());
        lingerBrewing(RegistryHandler.senses_potion.get(), RegistryHandler.mysterious_sensory_organ.get());
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
