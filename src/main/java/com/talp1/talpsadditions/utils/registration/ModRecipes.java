package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.recipe.gen_lab_recipe.GenLabRecipe;
import com.talp1.talpsadditions.recipe.gen_lab_recipe.GenLabRecipeType;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRecipes {
    public static final IRecipeType<GenLabRecipe> GEN_LAB_RECIPE_TYPE = new GenLabRecipeType();

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipeSerializer<?>> event){
        event.getRegistry().registerAll(
                GenLabRecipe.SERIALIZER
        );
    }
}
