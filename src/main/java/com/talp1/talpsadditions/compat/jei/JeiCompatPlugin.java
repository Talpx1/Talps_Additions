package com.talp1.talpsadditions.compat.jei;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.container.GenLabContainer;
import com.talp1.talpsadditions.gui.GenLabScreen;
import com.talp1.talpsadditions.utils.registration.ModItems;
import com.talp1.talpsadditions.utils.registration.ModRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JeiCompatPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Main.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        final IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(new GenLabRecipeCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(Minecraft.getInstance().world.getRecipeManager().getRecipesForType(ModRecipes.GEN_LAB_RECIPE_TYPE), new ResourceLocation(Main.MODID,"gen_lab_recipe"));
    }
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModItems.gen_lab_item.get()), new ResourceLocation(Main.MODID,"gen_lab_recipe"));
    }

    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(GenLabContainer.class, new ResourceLocation(Main.MODID,"gen_lab_recipe"), 0, 5, 6, 36);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(GenLabScreen.class, 45, -30, 83, 105, new ResourceLocation(Main.MODID,"gen_lab_recipe"));
    }
}
