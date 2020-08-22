package com.talp1.talpsadditions.container;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.tile_entity.GenLabTE;
import com.talp1.talpsadditions.utils.EnergyStorageHandler;
import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntArray;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import java.util.ArrayList;
import java.util.Arrays;

public class GenLabContainer extends Container {

    private TileEntity tileEntity;
    private PlayerEntity playerEntity;
    private IItemHandler playerInventory;
    private final IIntArray genLabData;

    public GenLabContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
        this(windowId,world,pos,playerInventory,player, new IntArray(2));
    }

    public GenLabContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player, IIntArray genLabDataIn) {
        super(RegistryHandler.gen_lab_container.get(), windowId);

        //setting variables
        tileEntity = world.getTileEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);

        assertIntArraySize(genLabDataIn, 2);
        this.genLabData = genLabDataIn;



        //creating slots
        if (tileEntity != null) {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                addSlot(new SlotItemHandler(h, 0, 48, 12-60));
                addSlot(new SlotItemHandler(h, 1, 110, 12-60));
                addSlot(new SlotItemHandler(h, 2, 27, 52-60));
                addSlot(new SlotItemHandler(h, 3, 131, 52-60));
                addSlot(new SlotItemHandler(h, 4, 27, 94-60));
                addSlot(new SlotItemHandler(h, 5, 81, 141-60));
            });
        }
        layoutPlayerInventorySlots(10, 90);//player inv
        trackPower();
        this.trackIntArray(genLabDataIn);
    }

    //--cretits to McJty--
    // Setup syncing of power from server to client so that the GUI can show the amount of power in the block
    private void trackPower() {
        // Unfortunatelly on a dedicated server ints are actually truncated to short so we need
        // to split our integer here (split our 32 bit integer into two 16 bit integers)
        trackInt(new IntReferenceHolder() {
            @Override
            public int get() {
                return getEnergy() & 0xffff;
            }

            @Override
            public void set(int value) {
                tileEntity.getCapability(CapabilityEnergy.ENERGY).ifPresent(h -> {
                    int energyStored = h.getEnergyStored() & 0xffff0000;
                    ((EnergyStorageHandler)h).setEnergy(energyStored + (value & 0xffff));
                });
            }
        });
        trackInt(new IntReferenceHolder() {
            @Override
            public int get() {
                return (getEnergy() >> 16) & 0xffff;
            }

            @Override
            public void set(int value) {
                tileEntity.getCapability(CapabilityEnergy.ENERGY).ifPresent(h -> {
                    int energyStored = h.getEnergyStored() & 0x0000ffff;
                    ((EnergyStorageHandler)h).setEnergy(energyStored | (value << 16));
                });
            }
        });
    }

    public int getEnergy() {
        return tileEntity.getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), playerEntity, RegistryHandler.gen_lab_block.get());
    }

    private static ArrayList<Item> baseItems = new ArrayList<>(Arrays.asList(Items.FEATHER, Items.WHITE_WOOL, RegistryHandler.bush_leaf.get(), Items.VINE));
    private static ArrayList<Item> toInjItems = new ArrayList<>(Arrays.asList(RegistryHandler.petal.get(),Items.BONE_MEAL, Items.BLUE_DYE, Items.RED_DYE, Items.PINK_DYE, Items.WHITE_DYE, Items.PURPLE_DYE, Items.DIAMOND_BLOCK, Items.COAL_BLOCK,Items.IRON_BLOCK, Items.EMERALD_BLOCK, Items.LAPIS_BLOCK, Items.REDSTONE_BLOCK, Items.GOLD_BLOCK, Items.QUARTZ_BLOCK, Items.NETHERITE_BRICKS));
    private static ArrayList<Item> injIntoItems = new ArrayList<>(Arrays.asList(Items.EGG, Items.WHEAT_SEEDS, RegistryHandler.bush_sprout.get()));
    private static ArrayList<Item> geneItems = new ArrayList<>(Arrays.asList(RegistryHandler.bush_gene.get(), RegistryHandler.chicken_gene.get(), RegistryHandler.vine_gene.get(), RegistryHandler.sheep_gene.get()));
    private static ArrayList<Item> geneMod = new ArrayList<>(Arrays.asList(RegistryHandler.animal_gen_modifier.get(), RegistryHandler.vegetal_gen_modifier.get()));
    //private static ArrayList<Item> outputItems = new ArrayList<>(Arrays.asList(RegistryHandler.blue_hydrangea_sprout.get(),RegistryHandler.red_hydrangea_sprout.get(),RegistryHandler.pink_hydrangea_sprout.get(),RegistryHandler.lilac_hydrangea_sprout.get(), RegistryHandler.bush_sprout.get(), RegistryHandler.floreal_vines_item.get()));

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            itemstack = stack.copy();
            if (index == 0||index == 1||index == 2||index == 3||index == 4||index == 5) {
                if (!this.mergeItemStack(stack, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(stack, itemstack);
            } else {
                if (geneItems.contains(stack.getItem())) {
                    if (!this.mergeItemStack(stack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else  if (geneMod.contains(stack.getItem())) {
                    if (!this.mergeItemStack(stack, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else  if (baseItems.contains(stack.getItem())) {
                    if (!this.mergeItemStack(stack, 2, 3, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else  if (toInjItems.contains(stack.getItem())) {
                    if (!this.mergeItemStack(stack, 3, 4, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else  if (injIntoItems.contains(stack.getItem())) {
                    if (!this.mergeItemStack(stack, 4, 5, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index < 28) {
                    if (!this.mergeItemStack(stack, 28, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 37 && !this.mergeItemStack(stack, 1, 28, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (stack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, stack);
        }

        return itemstack;
    }



    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        // Player inventory
        addSlotBox(playerInventory, 9, leftCol-2, topRow*2-9-60, 9, 18, 3, 18);

        // Hotbar
        addSlotRange(playerInventory, 0, leftCol-2, topRow*2+49-60, 9, 18);
    }

    public int getProgress() {
        return this.genLabData.get(0);
    }

    public int getTotal() {
        return this.genLabData.get(1);
    }
}