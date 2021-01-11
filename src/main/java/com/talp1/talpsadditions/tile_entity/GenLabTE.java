package com.talp1.talpsadditions.tile_entity;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.container.GenLabContainer;
import com.talp1.talpsadditions.recipe.gen_lab_recipe.GenLabRecipe;
import com.talp1.talpsadditions.utils.EnergyStorageHandler;
import com.talp1.talpsadditions.utils.registration.ModItems;
import com.talp1.talpsadditions.utils.registration.ModRecipes;
import com.talp1.talpsadditions.utils.registration.ModSpawnEggs;
import com.talp1.talpsadditions.utils.registration.ModTiles;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GenLabTE extends TileEntity implements ITickableTileEntity{

    private final int USAGE_PER_TICK=50;//RF per Tick
    private int timer;//timer for recipes
    private int currAmount;//amount of items to output (for the itemstack constructor)
    private boolean isCrafting;
    private ArrayList<Item> lastRecipe;//last recipe used, to check if items in slot are being removed
    private int totalTime;//total time for the output
    private Item currResult;//output for the current recipe
    //data for the syncing
    public final IIntArray genLabData = new IIntArray() {
        public int get(int index) {
            switch(index) {
                case 0:
                    return  GenLabTE.this.timer;
                case 1:
                    return GenLabTE.this.totalTime;
                default:
                    return 0;
            }
        }

        public void set(int index, int value) {
            switch(index) {
                case 0:
                    GenLabTE.this.timer = value;
                    break;
                case 1:
                    GenLabTE.this.totalTime = value;
                    break;
            }

        }

        public int size() {
            return 2;
        }
    };

    //return the current item to output
    public Item getCurrResult() {
        return currResult;
    }

    //set the item to output and the amount (for the itemstack)
    public void setCurrResult(Item currResult , int amount) {
        this.currResult = currResult;
        this.currAmount=amount;
    }

    //handlers
    private ItemStackHandler itemHandler= createItemHandler();
    public EnergyStorageHandler energyStorage= createEnergyHandler();
    private LazyOptional<IItemHandler> handler =  LazyOptional.of(()->itemHandler);
    private LazyOptional<IEnergyStorage> energy =  LazyOptional.of(()->energyStorage);

    //items valid in each slot, used to check where to put an itemstack on shift-click
    private static ArrayList<Item> baseItems = new ArrayList<>(Arrays.asList(Items.FEATHER, Items.WHITE_WOOL, ModItems.bush_leaf.get(), Items.VINE));
    private static ArrayList<Item> toInjItems = new ArrayList<>(Arrays.asList(ModItems.petal.get(),Items.BONE_MEAL, Items.BLUE_DYE, Items.RED_DYE, Items.PINK_DYE, Items.WHITE_DYE, Items.PURPLE_DYE, Items.DIAMOND_BLOCK, Items.COAL_BLOCK,Items.IRON_BLOCK, Items.EMERALD_BLOCK, Items.LAPIS_BLOCK, Items.REDSTONE_BLOCK, Items.GOLD_BLOCK, Items.QUARTZ_BLOCK, Items.NETHERITE_BRICKS));
    private static ArrayList<Item> injIntoItems = new ArrayList<>(Arrays.asList(Items.EGG, Items.WHEAT_SEEDS, ModItems.bush_sprout.get()));
    private static ArrayList<Item> geneItems = new ArrayList<>(Arrays.asList(ModItems.bush_gene.get(), ModItems.chicken_gene.get(), ModItems.vine_gene.get(), ModItems.sheep_gene.get()));
    private static ArrayList<Item> geneMod = new ArrayList<>(Arrays.asList(ModItems.animal_gen_modifier.get(), ModItems.vegetal_gen_modifier.get()));
    //private static ArrayList<Item> outputItems = new ArrayList<>(Arrays.asList(ModItems.blue_hydrangea_sprout.get(),ModItems.red_hydrangea_sprout.get(),ModItems.pink_hydrangea_sprout.get(),ModItems.lilac_hydrangea_sprout.get(), ModItems.bush_sprout.get(), ModItems.floreal_vines_item.get(), ModSpawnEggs.coalChickenSpawnEgg.getItem(),ModSpawnEggs.diamondChickenSpawnEgg.getItem(),ModSpawnEggs.emeraldChickenSpawnEgg.getItem(),ModSpawnEggs.goldChickenSpawnEgg.getItem(),ModSpawnEggs.ironChickenSpawnEgg.getItem(),ModSpawnEggs.quartzChickenSpawnEgg.getItem(),ModSpawnEggs.netheriteChickenSpawnEgg.getItem(),ModSpawnEggs.lapisChickenSpawnEgg.getItem(),ModSpawnEggs.redstoneChickenSpawnEgg.getItem(),ModSpawnEggs.coalSheepSpawnEgg.getItem(),ModSpawnEggs.diamondSheepSpawnEgg.getItem(),ModSpawnEggs.emeraldSheepSpawnEgg.getItem(),ModSpawnEggs.goldSheepSpawnEgg.getItem(),ModSpawnEggs.ironSheepSpawnEgg.getItem(),ModSpawnEggs.quartzSheepSpawnEgg.getItem(),ModSpawnEggs.netheriteSheepSpawnEgg.getItem(),ModSpawnEggs.lapisSheepSpawnEgg.getItem(),ModSpawnEggs.redstoneSheepSpawnEgg.getItem() ));

    public GenLabTE() {
        super(ModTiles.gen_lab_te.get());
        this.isCrafting=false;
        this.timer=-1;
        this.currResult=null;
        this.currAmount=0;
        this.totalTime=-1;
        this.lastRecipe=new ArrayList<>();
    }

    //set timer from secs to ticks
    private void setTimerInSecond(int sec){
        this.timer=sec*20;
    }

    //decrease the timer by 1 every tick
    private void decreaseTimer(){
        this.timer--;
        markDirty();
    }

    //check if the recipe is ready to output
    private boolean checkIfDone(){
        return timer==0;
    }

    private boolean isTimerDisabled(){
        return timer==-1;
    }

    private void disbleTimer(){
        this.timer=-1;
        this.totalTime=-1;
    }

    private Item getItemInSlot(int slot){
        return itemHandler.getStackInSlot(slot).getItem();
    }

    //drop the itemstacks in the tile
    private void dropContent(){
        for (int i=0;i<=5;i++){
            if (!itemHandler.getStackInSlot(i).isEmpty()){
                this.getWorld().addEntity(new ItemEntity(this.getWorld(), this.getPos().getX(), this.getPos().getY()+1,this.getPos().getZ(),itemHandler.getStackInSlot(i)));
            }
        }
    }

    @Override
    public void remove() {
        super.remove();
        dropContent();
        handler.invalidate();
        energy.invalidate();
    }


    private EnergyStorageHandler createEnergyHandler(){
        return new EnergyStorageHandler(50000,0){
            @Override
            public boolean canReceive() { return true; }

            @Override
            public int receiveEnergy(int maxReceive, boolean simulate) {
                if (!canReceive())
                    return 0;

                int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
                if (!simulate)
                    energy += energyReceived;
                markDirty();
                return energyReceived;
            }

            @Override
            public int extractEnergy(int maxExtract, boolean simulate) {
                if (!canExtract())
                    return 0;

                int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
                if (!simulate)
                    energy -= energyExtracted;
                markDirty();
                return energyExtracted;
            }
        };
    }

    private ItemStackHandler createItemHandler(){
        return new ItemStackHandler(6){
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot){
                    case 0: return geneItems.contains(stack.getItem());
                    case 1: return geneMod.contains(stack.getItem());
                    case 2: return baseItems.contains(stack.getItem());
                    case 3: return toInjItems.contains(stack.getItem());
                    case 4: return injIntoItems.contains(stack.getItem());
                    case 5: return false;
                    default: return super.isItemValid(slot, stack);
                }
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                return isItemValid(slot, stack)? super.insertItem(slot,stack,simulate):stack;
            }
        };
    }

    //save the current recipe to check if the ingredients are being removed
    private void saveRecipe(){
        lastRecipe.clear();
        for (int i=0;i<5;i++){
            if (!itemHandler.getStackInSlot(i).isEmpty())
                lastRecipe.add(i,itemHandler.getStackInSlot(i).getItem());
        }
    }

    //start the crafting process setting timers
    private void startCrafting(int timerDuration){
        saveRecipe();
        this.totalTime=timerDuration*20;
        this.isCrafting=true;
        if (isTimerDisabled()){
            setTimerInSecond(timerDuration);
        }
    }

    //check the slots of the tiles to see if items are being removed
    private boolean checkSlots(){
        for (int i=0;i<5;i++){
            if (!itemHandler.getStackInSlot(i).isEmpty()){
                if (itemHandler.getStackInSlot(i).getItem()!=lastRecipe.get(i)){
                    stopCrafting();
                    return false;
                }
            }else{
                stopCrafting();
                return false;
            }
        }
        return true;
    }

    //aborts the current crafting without output
    private void stopCrafting(){
        this.isCrafting=false;
        this.totalTime=-1;
        disbleTimer();
        markDirty();
    }

    //creates the output and consume items in slots
    private void produceResult(){
        itemHandler.extractItem(0,1,false);
        itemHandler.extractItem(1,1,false);
        itemHandler.extractItem(2,1,false);
        itemHandler.extractItem(3,1,false);
        itemHandler.extractItem(4,1,false);
        if(itemHandler.getStackInSlot(5).isEmpty()){
            itemHandler.setStackInSlot(5,new ItemStack(getCurrResult(), this.currAmount));
        }else if(itemHandler.getStackInSlot(5).getItem()==getCurrResult()&&itemHandler.getStackInSlot(5).getCount()+currAmount<=64){
            itemHandler.getStackInSlot(5).setCount(itemHandler.getStackInSlot(5).getCount()+currAmount);
        }else{
            dropContent();
            this.getWorld().addEntity(new ItemEntity(this.getWorld(), this.getPos().getX(), this.getPos().getY()+1,this.getPos().getZ(),new ItemStack(getCurrResult(), this.currAmount)));
        }

    }

    @Override
    public void tick() {
        if (world.isRemote){
            return;
        }

        //changing blockstate
        BlockState blockState = world.getBlockState(pos);
        if (energyStorage.getEnergyStored()>0 && this.timer > 0) {
            world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, true), Constants.BlockFlags.NOTIFY_NEIGHBORS + Constants.BlockFlags.BLOCK_UPDATE);
        }else{
            world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, false), Constants.BlockFlags.NOTIFY_NEIGHBORS + Constants.BlockFlags.BLOCK_UPDATE);
        }

        //crafting actions
        if (isCrafting){
            energyStorage.consumeEnergy(USAGE_PER_TICK);//consume RF
            decreaseTimer();
            checkSlots();//check if items got removed from slots
            //check if there's still energy
            if(energyStorage.getEnergyStored()<USAGE_PER_TICK){
                stopCrafting();
            }
            //check if done
            if (checkIfDone()){
                stopCrafting();
                produceResult();
            }
        }else{
            //check if slots are not empty
            boolean isValidInput=true;
            for (int i=0; i<itemHandler.getSlots()-1; i++){
                if(itemHandler.getStackInSlot(i).isEmpty())
                    isValidInput=false;
            }
            //get the right recipe (if exists) for the items in the genlabs
            if (isValidInput){
                for (final IRecipe<?> recipe : getWorld().getRecipeManager().getRecipesForType(ModRecipes.GEN_LAB_RECIPE_TYPE)) {
                    final GenLabRecipe genLabRecipe = (GenLabRecipe) recipe;
                    if (genLabRecipe.isValid(itemHandler.getStackInSlot(0), itemHandler.getStackInSlot(1), itemHandler.getStackInSlot(2), itemHandler.getStackInSlot(3), itemHandler.getStackInSlot(4))) {
                        startCrafting(genLabRecipe.getTimeToCraft());
                        setCurrResult(genLabRecipe.getRecipeOutput().getItem(), genLabRecipe.getOutputAmount());
                        break;
                    }
                }
            }
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.put("inv", itemHandler.serializeNBT());
        compound.put("energy", energyStorage.serializeNBT());
        compound.putInt("progress", getTimer());
        compound.putInt("total_time", getTotalTime());
        return  compound;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        energyStorage.deserializeNBT(nbt.getCompound("energy"));
        nbt.getInt("progress");
        nbt.getInt("total_time");
    }

    public int getTimer(){
        return this.timer;
    }

    public int getTotalTime(){
        return this.totalTime;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        if (cap == CapabilityEnergy.ENERGY) {
            return energy.cast();
        }
        return super.getCapability(cap, side);
    }

}
