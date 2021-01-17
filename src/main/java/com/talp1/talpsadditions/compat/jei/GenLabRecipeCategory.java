package com.talp1.talpsadditions.compat.jei;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.container.GenLabContainer;
import com.talp1.talpsadditions.gui.GenLabScreen;
import com.talp1.talpsadditions.recipe.gen_lab_recipe.GenLabRecipe;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
import com.talp1.talpsadditions.utils.registration.ModItems;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.StonecuttingRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Constants;

import java.util.List;

public class GenLabRecipeCategory implements IRecipeCategory<GenLabRecipe> {

    private final IDrawable background;
    private final IDrawable icon;

    public GenLabRecipeCategory(IGuiHelper guiHelper) {
        background = guiHelper.drawableBuilder(new ResourceLocation(Main.MODID, "textures/gui/jei/gen-lab-recipe-gui.png"), 0, 0, 176, 172)
                .addPadding(0, 0, 0, 0)
                .build();
        icon = guiHelper.createDrawableIngredient(new ItemStack(ModItems.gen_lab_item.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return new ResourceLocation(Main.MODID, "gen_lab_recipe");
    }

    @Override
    public Class getRecipeClass() {
        return GenLabRecipe.class;
    }

    @Override
    public String getTitle() {
        return ModBlocks.gen_lab_block.get().getTranslatedName().getString();
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients(GenLabRecipe genLabRecipe, IIngredients iIngredients) {
        iIngredients.setInputIngredients( genLabRecipe.getIngredients());
        iIngredients.setOutput(VanillaTypes.ITEM, new ItemStack(genLabRecipe.getRecipeOutput().getItem(), genLabRecipe.getOutputAmount()));
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, GenLabRecipe genLabRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStacks = iRecipeLayout.getItemStacks();
        guiItemStacks.init(0,true, 20+27, 15-4);
        guiItemStacks.init(1,true, 68+41, 15-4);
        guiItemStacks.init(2,true, 20+6, 39+12);
        guiItemStacks.init(3,true, 75+55, 40+11);
        guiItemStacks.init(4,true,5+21, 80+13);
        guiItemStacks.init(5,false,35+45, 145-5);
        guiItemStacks.set(iIngredients);
    }

}
