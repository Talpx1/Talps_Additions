package com.talp1.talpsadditions.recipe.gen_lab_recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
import com.talp1.talpsadditions.utils.registration.ModRecipes;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.HashMap;

//thx to Darkhax: https://github.com/Minecraft-Forge-Tutorials/Custom-Json-Recipes
public class GenLabRecipe implements IRecipe<IInventory> {

    public static final Serializer SERIALIZER = new Serializer();

    private final Ingredient base;
    private final Ingredient gene_type;
    private final Ingredient gene_mod;
    private final Ingredient item_to_inj;
    private final Ingredient item_to_inj_into;
    private final int time_to_craft;
    private final int output_amount;
    private final ItemStack output;
    private final ResourceLocation id;

    public GenLabRecipe(ResourceLocation id, Ingredient base, Ingredient gene_type, Ingredient gene_mod, Ingredient item_to_inj, Ingredient item_to_inj_into, int time_to_craft, int output_amount, ItemStack output){
        this.id = id;
        this.base = base;
        this.gene_type = gene_type;
        this.gene_mod = gene_mod;
        this.item_to_inj = item_to_inj;
        this.item_to_inj_into = item_to_inj_into;
        this.time_to_craft = time_to_craft;
        this.output_amount = output_amount;
        this.output = output;
        Main.LOGGER.info("Loaded " + this.toString());
    }

    public int getOutputAmount(){
        return this.output_amount;
    }

    public int getTimeToCraft(){
        return this.time_to_craft;
    }

    @Override
    public String toString () {
        return "GenLabRecipe [gene_type=" + this.gene_type + ", gene_mod=" + this.gene_mod + ", base=" + this.base + ", item_to_inj=" + this.item_to_inj+ ", item_to_inj_into=" + this.item_to_inj_into + ", id=" + this.id + "]";
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {

        return (this.gene_type.test(inv.getStackInSlot(0)) &&
                this.gene_mod.test(inv.getStackInSlot(1)) &&
                this.base.test(inv.getStackInSlot(2)) &&
                this.item_to_inj.test(inv.getStackInSlot(3)) &&
                this.item_to_inj_into.test(inv.getStackInSlot(4))
        );
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return this.output.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public IRecipeType<?> getType () {
        return ModRecipes.GEN_LAB_RECIPE_TYPE;
    }

    public boolean isValid (ItemStack gen_type, ItemStack gen_mod, ItemStack base, ItemStack item_to_inj, ItemStack item_to_inj_into) {
        return (this.gene_type.test(gen_type) &&
                this.gene_mod.test(gen_mod) &&
                this.base.test(base) &&
                this.item_to_inj.test(item_to_inj) &&
                this.item_to_inj_into.test(item_to_inj_into)
        );
    }

    @Override
    public ItemStack getIcon () {
        return new ItemStack(ModBlocks.gen_lab_block.get());
    }

    public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>>  implements IRecipeSerializer<GenLabRecipe> {

        Serializer() {
            this.setRegistryName(new ResourceLocation(Main.MODID, "gen_lab_recipe"));
        }

        @Override
        public GenLabRecipe read(ResourceLocation recipeId, JsonObject json) {
            //gene_type
            final JsonElement gene_typeElem = JSONUtils.isJsonArray(json, "gene-type") ? JSONUtils.getJsonArray(json, "gene-type") : JSONUtils.getJsonObject(json, "gene-type");
            final Ingredient gene_type = Ingredient.deserialize(gene_typeElem);
            //gene_mod
            final JsonElement gene_modElem = JSONUtils.isJsonArray(json, "gene-modifier") ? JSONUtils.getJsonArray(json, "gene-modifier") : JSONUtils.getJsonObject(json, "gene-modifier");
            final Ingredient gene_mod = Ingredient.deserialize(gene_modElem);
            //base
            final JsonElement baseElem = JSONUtils.isJsonArray(json, "base") ? JSONUtils.getJsonArray(json, "base") : JSONUtils.getJsonObject(json, "base");
            final Ingredient base = Ingredient.deserialize(baseElem);
            //item_to_inj
            final JsonElement item_to_injElem = JSONUtils.isJsonArray(json, "item-to-inject") ? JSONUtils.getJsonArray(json, "item-to-inject") : JSONUtils.getJsonObject(json, "item-to-inject");
            final Ingredient item_to_inj = Ingredient.deserialize(item_to_injElem);
            //item_to_inj_into
            final JsonElement item_to_inj_intoElem = JSONUtils.isJsonArray(json, "item-to-inject-into") ? JSONUtils.getJsonArray(json, "item-to-inject-into") : JSONUtils.getJsonObject(json, "item-to-inject-into");
            final Ingredient item_to_inj_into = Ingredient.deserialize(item_to_inj_intoElem);
            //output options
            final HashMap<String, Integer> options = deserilizeJsonOutputOptions(json);
            final int time_to_craft = options.get("time");
            final int output_amount= options.get("amount");
            //output
            final ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "output"));
            return new GenLabRecipe(recipeId, base, gene_type, gene_mod, item_to_inj, item_to_inj_into, time_to_craft, output_amount, output);
        }

        private HashMap<String, Integer> deserilizeJsonOutputOptions(JsonObject json){
            HashMap<String, Integer> options=new HashMap<>();
            options.put("time",JSONUtils.getInt(json,"time-to-craft"));
            options.put("amount",JSONUtils.getInt(json,"output-amount"));
            return options;
        }

        @Override
        public GenLabRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            final Ingredient gene_type = Ingredient.read(buffer);
            final Ingredient gene_mod = Ingredient.read(buffer);
            final Ingredient base = Ingredient.read(buffer);
            final Ingredient item_to_inj = Ingredient.read(buffer);
            final Ingredient item_to_inj_into = Ingredient.read(buffer);
            final int time_to_craft = buffer.readInt();
            final int output_amount = buffer.readInt();
            final ItemStack output = buffer.readItemStack();
            return new GenLabRecipe(recipeId, base, gene_type, gene_mod, item_to_inj, item_to_inj_into, time_to_craft, output_amount, output);
        }

        @Override
        public void write(PacketBuffer buffer, GenLabRecipe recipe) {
            recipe.gene_type.write(buffer);
            recipe.gene_mod.write(buffer);
            recipe.base.write(buffer);
            recipe.item_to_inj.write(buffer);
            recipe.item_to_inj_into.write(buffer);
            buffer.writeInt(recipe.time_to_craft);
            buffer.writeInt(recipe.output_amount);
            buffer.writeItemStack(recipe.output);
        }
    }
}
