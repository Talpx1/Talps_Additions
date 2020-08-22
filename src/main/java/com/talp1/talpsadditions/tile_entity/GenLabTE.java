package com.talp1.talpsadditions.tile_entity;

import com.talp1.talpsadditions.container.GenLabContainer;
import com.talp1.talpsadditions.utils.EnergyStorageHandler;
import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;

public class GenLabTE extends TileEntity implements ITickableTileEntity {

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
    private EnergyStorageHandler energyStorage= createEnergyHandler();
    private LazyOptional<IItemHandler> handler =  LazyOptional.of(()->itemHandler);
    private LazyOptional<IEnergyStorage> energy =  LazyOptional.of(()->energyStorage);

    //items valid in each slot, used to check where to put an itemstack on shift-click
    private static ArrayList<Item> baseItems = new ArrayList<>(Arrays.asList(Items.FEATHER, Items.WHITE_WOOL, RegistryHandler.bush_leaf.get(), Items.VINE));
    private static ArrayList<Item> toInjItems = new ArrayList<>(Arrays.asList(RegistryHandler.petal.get(),Items.BONE_MEAL, Items.BLUE_DYE, Items.RED_DYE, Items.PINK_DYE, Items.WHITE_DYE, Items.PURPLE_DYE, Items.DIAMOND_BLOCK, Items.COAL_BLOCK,Items.IRON_BLOCK, Items.EMERALD_BLOCK, Items.LAPIS_BLOCK, Items.REDSTONE_BLOCK, Items.GOLD_BLOCK, Items.QUARTZ_BLOCK, Items.NETHERITE_BRICKS));
    private static ArrayList<Item> injIntoItems = new ArrayList<>(Arrays.asList(Items.EGG, Items.WHEAT_SEEDS, RegistryHandler.bush_sprout.get()));
    private static ArrayList<Item> geneItems = new ArrayList<>(Arrays.asList(RegistryHandler.bush_gene.get(), RegistryHandler.chicken_gene.get(), RegistryHandler.vine_gene.get(), RegistryHandler.sheep_gene.get()));
    private static ArrayList<Item> geneMod = new ArrayList<>(Arrays.asList(RegistryHandler.animal_gen_modifier.get(), RegistryHandler.vegetal_gen_modifier.get()));
    //private static ArrayList<Item> outputItems = new ArrayList<>(Arrays.asList(RegistryHandler.blue_hydrangea_sprout.get(),RegistryHandler.red_hydrangea_sprout.get(),RegistryHandler.pink_hydrangea_sprout.get(),RegistryHandler.lilac_hydrangea_sprout.get(), RegistryHandler.bush_sprout.get(), RegistryHandler.floreal_vines_item.get(), RegistryHandler.ExtraRegHandler.coalChickenSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.diamondChickenSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.emeraldChickenSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.goldChickenSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.ironChickenSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.quartzChickenSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.netheriteChickenSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.lapisChickenSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.redstoneChickenSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.coalSheepSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.diamondSheepSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.emeraldSheepSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.goldSheepSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.ironSheepSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.quartzSheepSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.netheriteSheepSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.lapisSheepSpawnEgg.getItem(),RegistryHandler.ExtraRegHandler.redstoneSheepSpawnEgg.getItem() ));

    public GenLabTE() {
        super(RegistryHandler.gen_lab_te.get());
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

        //remember to remove this
        energyStorage.addEnergy(60);
        //crafting actions
        if (isCrafting){
            energyStorage.consumeEnergy(USAGE_PER_TICK);
            decreaseTimer();
            checkSlots();
            if (checkIfDone()){
                this.isCrafting=false;
                disbleTimer();
                produceResult();
            }
        }else{
            //check if is a hydrangea recipe
            if (getItemInSlot(0)==RegistryHandler.bush_gene.get()&&getItemInSlot(1)==RegistryHandler.vegetal_gen_modifier.get()&&getItemInSlot(2)==RegistryHandler.bush_leaf.get()&&getItemInSlot(4)==RegistryHandler.bush_sprout.get()){
                //blue
                if (getItemInSlot(3)==Items.BLUE_DYE){
                    startCrafting(15);
                    setCurrResult(RegistryHandler.blue_hydrangea_sprout.get(),1);}
                //red
                if (getItemInSlot(3)==Items.RED_DYE){
                    startCrafting(15);
                    setCurrResult(RegistryHandler.red_hydrangea_sprout.get(),1);}
                //pink
                if (getItemInSlot(3)==Items.PINK_DYE){
                    startCrafting(15);
                    setCurrResult(RegistryHandler.pink_hydrangea_sprout.get(),1); }
                //white
                if (getItemInSlot(3)==Items.WHITE_DYE){
                    startCrafting(15);
                    setCurrResult(RegistryHandler.white_hydrangea_sprout.get(),1); }
                //lilac
                if (getItemInSlot(3)==Items.PURPLE_DYE){
                    startCrafting(15);
                    setCurrResult(RegistryHandler.lilac_hydrangea_sprout.get(),1); }
            }
            //normal bush
            if (getItemInSlot(0)==RegistryHandler.bush_gene.get()&&getItemInSlot(1)==RegistryHandler.vegetal_gen_modifier.get()&&getItemInSlot(2)==RegistryHandler.bush_leaf.get()&&getItemInSlot(3)==Items.BONE_MEAL&&getItemInSlot(4)==Items.WHEAT_SEEDS){
                startCrafting(15);
                setCurrResult(RegistryHandler.bush_sprout.get(),1);
            }
            //floreal Vine
            if (getItemInSlot(0)==RegistryHandler.vine_gene.get()&&getItemInSlot(1)==RegistryHandler.vegetal_gen_modifier.get()&&getItemInSlot(2)==Items.VINE&&getItemInSlot(3)==RegistryHandler.petal.get()&&getItemInSlot(4)==Items.WHEAT_SEEDS){
                startCrafting(20);
                setCurrResult(RegistryHandler.floreal_vines_item.get(),2);
            }
            //check if is chicken recipe
            if (getItemInSlot(0)==RegistryHandler.chicken_gene.get()&&getItemInSlot(1)==RegistryHandler.animal_gen_modifier.get()&&getItemInSlot(2)==Items.FEATHER&&getItemInSlot(4)==Items.EGG) {
                //coal
                if (getItemInSlot(3) == Items.COAL_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.coalChickenSpawnEgg.getItem(), 1);
                }
                //diamond
                if (getItemInSlot(3) == Items.DIAMOND_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.diamondChickenSpawnEgg.getItem(), 1);
                }
                //emerald
                if (getItemInSlot(3) == Items.EMERALD_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.emeraldChickenSpawnEgg.getItem(), 1);
                }
                //gold
                if (getItemInSlot(3) == Items.GOLD_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.goldChickenSpawnEgg.getItem(), 1);
                }
                //iron
                if (getItemInSlot(3) == Items.IRON_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.ironChickenSpawnEgg.getItem(), 1);
                }
                //lapis
                if (getItemInSlot(3) == Items.LAPIS_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.lapisChickenSpawnEgg.getItem(), 1);
                }
                //quartz
                if (getItemInSlot(3) == Items.QUARTZ_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.quartzChickenSpawnEgg.getItem(), 1);
                }
                //netherite
                if (getItemInSlot(3) == Items.NETHER_BRICK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.netheriteChickenSpawnEgg.getItem(), 1);
                }
                //redstone
                if (getItemInSlot(3) == Items.REDSTONE_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.redstoneChickenSpawnEgg.getItem(), 1);
                }
            }
            //check if is sheep recipe
            if (getItemInSlot(0)==RegistryHandler.sheep_gene.get()&&getItemInSlot(1)==RegistryHandler.animal_gen_modifier.get()&&getItemInSlot(2)==Items.WHITE_WOOL&&getItemInSlot(4)==Items.EGG) {
                //coal
                if (getItemInSlot(3) == Items.COAL_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.coalSheepSpawnEgg.getItem(), 1);
                }
                //diamond
                if (getItemInSlot(3) == Items.DIAMOND_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.diamondSheepSpawnEgg.getItem(), 1);
                }
                //emerald
                if (getItemInSlot(3) == Items.EMERALD_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.emeraldSheepSpawnEgg.getItem(), 1);
                }
                //gold
                if (getItemInSlot(3) == Items.GOLD_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.goldSheepSpawnEgg.getItem(), 1);
                }
                //iron
                if (getItemInSlot(3) == Items.IRON_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.ironSheepSpawnEgg.getItem(), 1);
                }
                //lapis
                if (getItemInSlot(3) == Items.LAPIS_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.lapisSheepSpawnEgg.getItem(), 1);
                }
                //quartz
                if (getItemInSlot(3) == Items.QUARTZ_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.quartzSheepSpawnEgg.getItem(), 1);
                }
                //netherite
                if (getItemInSlot(3) == Items.NETHER_BRICK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.netheriteSheepSpawnEgg.getItem(), 1);
                }
                //redstone
                if (getItemInSlot(3) == Items.REDSTONE_BLOCK) {
                    startCrafting(60);
                    setCurrResult(RegistryHandler.ExtraRegHandler.redstoneSheepSpawnEgg.getItem(), 1); }
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
