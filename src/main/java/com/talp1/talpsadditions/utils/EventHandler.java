package com.talp1.talpsadditions.utils;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.config.CommonConfig;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
import com.talp1.talpsadditions.utils.registration.ModEnchants;
import com.talp1.talpsadditions.utils.registration.ModEntities;
import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler{

    //--------------------------------Worm Drop----------------------------------
    //may drop a worm when dirt/grass get hoed into farmland
    @SubscribeEvent
    public static void onHoeingDropWorm(UseHoeEvent event){
        Block targetBlock=event.getContext().getWorld().getBlockState(event.getContext().getPos()).getBlock();
        if(targetBlock == Blocks.DIRT||targetBlock==Blocks.GRASS_BLOCK){
            Random random = new Random();
            if(random.nextInt(CommonConfig.earthWormDropChance.get())+1==1){
                World worldIn = event.getContext().getWorld();
                worldIn.addEntity(new ItemEntity(worldIn, event.getContext().getPos().getX(), event.getContext().getPos().getY()+1,event.getContext().getPos().getZ(), new ItemStack(ModItems.earth_worm.get())));
            }
        }
    }


    //--------------------------------Head Drop----------------------------------
    //drop talp1's head when a mole is struck by a lightning
    @SubscribeEvent
    public static void onMoleStruckByLightning(EntityStruckByLightningEvent event){
        if(event.getEntity().getType()== ModEntities.mole_entity.get()){
            ItemStack customPlayerHead = new ItemStack(Items.PLAYER_HEAD);
            customPlayerHead.setTag(new CompoundNBT());
            customPlayerHead.getTag().putString("SkullOwner", "Talp1");
            event.getEntity().entityDropItem(customPlayerHead);
        }
    }


    //--------------------------------BoneMeal Coral----------------------------------
    @SubscribeEvent
    public static void onBonemealCoralFan(BonemealEvent event){
        if(event.getBlock().getBlock()==Blocks.BRAIN_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.BRAIN_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.BRAIN_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.BRAIN_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
        if(event.getBlock().getBlock()==Blocks.BUBBLE_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.BUBBLE_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.BUBBLE_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.BUBBLE_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
        if(event.getBlock().getBlock()==Blocks.FIRE_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.FIRE_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.FIRE_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.FIRE_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
        if(event.getBlock().getBlock()==Blocks.HORN_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.HORN_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.HORN_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.HORN_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
        if(event.getBlock().getBlock()==Blocks.TUBE_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.TUBE_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.TUBE_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.TUBE_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
    }

    private static void spawnCorals(Block blockIn, BlockPos posIn, World worldIn){
        worldIn.setBlockState(posIn,blockIn.getDefaultState());
        worldIn.setBlockState(posIn.up(),blockIn.getDefaultState());
    }

    private static boolean checkForFreeSpace(BlockState stateIn){
        return  stateIn.getBlock()==Blocks.AIR||stateIn.getBlock()==Blocks.WATER;
    }

//----------------------------------CRAFT ACID------------------------------
    private static int findSlotInInv(Item item, PlayerInventory plyerInv){
        for (int i=0; i<plyerInv.getSizeInventory(); i++){
            if (plyerInv.getStackInSlot(i).getItem()==item){
                return i;
            }
        }
        return -1;
    }

    private static int findPotionSlotInInv(ItemStack item, PlayerInventory plyerInv){
        for (int i=0; i<plyerInv.getSizeInventory(); i++){
            if (plyerInv.getStackInSlot(i).getItem()==item.getItem()){
                if (plyerInv.getStackInSlot(i).getTag().getString("Potion").equals(item.getTag().getString("Potion"))){
                    return i;
                }
            }
        }
        return -1;
    }

    @SubscribeEvent
    public static void craftAcidBottle(TickEvent.PlayerTickEvent event) {
        if(event.player.isSneaking()&&event.side.isServer()){
            World worldIn = event.player.getEntityWorld();
            BlockPos playerPos =event.player.getPosition();
            if(worldIn.getBlockState(playerPos.down())==Blocks.CAULDRON.getDefaultState()){
                ItemStack potion = new ItemStack(Items.POTION);
                potion.setTag(new CompoundNBT());
                potion.getTag().putString("Potion","minecraft:poison");

                PlayerInventory playerInv = event.player.inventory;

                if (playerInv.hasItemStack(potion)&&playerInv.hasItemStack(new ItemStack(Items.REDSTONE))&&playerInv.hasItemStack(new ItemStack(Items.FERMENTED_SPIDER_EYE))){
                    int slotRedstone=findSlotInInv(Items.REDSTONE,playerInv);
                    int slotSpiderEye=findSlotInInv(Items.FERMENTED_SPIDER_EYE,playerInv);
                    int slotPoisonPot=findPotionSlotInInv(potion,playerInv);
                    if (slotRedstone!=-1&&slotSpiderEye!=-1&&slotPoisonPot!=-1){
                        playerInv.decrStackSize(slotRedstone,1);
                        playerInv.decrStackSize(slotSpiderEye,1);
                        playerInv.decrStackSize(slotPoisonPot,1);
                        event.player.addItemStackToInventory(new ItemStack(ModItems.bottle_of_acid.get(),1));
                    }
                }
            }
        }
    }
//----------------------------------BAT EARDRUM------------------------------
    @SubscribeEvent
    public static void dropBatEardrum(LivingDeathEvent event){
        if (event.getEntity().getType()== EntityType.BAT){
            if (new Random().nextInt(CommonConfig.earthWormDropChance.get())==0){
                event.getEntityLiving().entityDropItem(new ItemStack(ModItems.bat_eardrum.get()));
            }
        }
    }

//----------------------------------FROSTED VINES TURNS WATER INTO BLUE ICE------------------------------
    @SubscribeEvent
    public static void vinesGeneratesBlueIce(BlockEvent.EntityPlaceEvent event){
        if (event.getEntity() instanceof PlayerEntity) {
            if (event.getPlacedBlock().getBlock() == ModBlocks.frosted_vines.get().getBlock() && event.getWorld().getBlockState(event.getPos().down()) == Blocks.WATER.getDefaultState()) {
                event.getWorld().setBlockState(event.getPos().down(), Blocks.BLUE_ICE.getDefaultState(), 2);
            }
        }
    }

//----------------------------------YETI DROPS ICECREAM ON RIGHTCLICK------------------------------
    @SubscribeEvent
    public static void yetiDropsIcecream(PlayerInteractEvent.EntityInteract event){
       if(event.getTarget().getType()==ModEntities.yeti_entity.get()){
           event.getTarget().entityDropItem(ModItems.yetis_icecream.get());
       }
    }

//----------------------------------DOLPHIN FIN------------------------------
    @SubscribeEvent
    public static void dropDolphinFin(LivingDeathEvent event){
        if (event.getEntity().getType()== EntityType.DOLPHIN){
            if (new Random().nextInt(CommonConfig.dolphinFinDropChance.get())==0){
                event.getEntityLiving().entityDropItem(new ItemStack(ModItems.dolphin_fin.get()));
            }
        }
    }

//----------------------------------Re-Enchanter Logic------------------------------

    //TODO: add configurble vals
    @SubscribeEvent
    public static void onReEnchanting(ItemTossEvent event){
        Main.LOGGER.info("Fired");
        if (!event.getPlayer().getEntityWorld().isRemote()){
            Main.LOGGER.info("item ok");
            BlockPos playerPos = event.getPlayer().getPosition();
            //check for correct multiblock struture
            if( correctReEnchantrMultiblock(playerPos, event.getPlayer().getEntityWorld()) ){
                Main.LOGGER.info("correct multi");
                reEnchantItem(event.getEntityItem().getItem(), event.getPlayer());
                //event.getPlayer().addExperienceLevel(-100);
            }
        }
    }

    private static void reEnchantItem(ItemStack stack, PlayerEntity player){
        if(!stack.isEmpty()){
            Random rand = new Random();
            int expAmount = rand.nextInt(29)+1;//exp points cost
            Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(stack);//enchts on the item toss
            if(stack.isEnchanted() && player.experienceLevel>= expAmount){
                //increase enchs lvl
                enchants.forEach( (ench, lvl) ->{
                    if(rand.nextInt(2)==0){
                        enchants.replace(ench, lvl+rand.nextInt(3)+1);
                    }
                });
                EnchantmentHelper.setEnchantments(enchants,stack);
                player.addExperienceLevel(-expAmount);//subtract exp points
            }
            expAmount = rand.nextInt(19)+1;//exp points cost
            if(rand.nextInt(10)==0 && player.experienceLevel>=expAmount){
                //pick a rendom enchant and check if is compatible
                Enchantment newEnch;
                do{
                    newEnch = Enchantment.getEnchantmentByID(rand.nextInt(50));
                }while( newEnch==null ||
                        enchants.containsKey(newEnch) ||
                        ( (newEnch!=Enchantments.MENDING && newEnch!=Enchantments.FROST_WALKER) && !stack.canApplyAtEnchantingTable(newEnch) )
                      );

                stack.addEnchantment(newEnch, rand.nextInt(5)+1);//add the enchant
                player.addExperienceLevel(-expAmount);//subtract the exp points
            }
        }
    }

    private static boolean correctReEnchantrMultiblock(BlockPos playerPos, World worldIn){
        if(worldIn.getFluidState(playerPos)== Fluids.WATER.getStillFluidState(false)){
            boolean allSidesAreValid=true;
            for (Direction direction : Direction.Plane.HORIZONTAL){
                if(worldIn.getBlockState(playerPos.offset(direction))!=ModBlocks.shiny_shard_block.get().getDefaultState()){
                    allSidesAreValid=false;
                    break;
                }
            }
            if(allSidesAreValid && worldIn.getBlockState(playerPos.down())==ModBlocks.shiny_shard_block.get().getDefaultState()){
                return true;
            }
        }
        return false;
    }

}
