package com.talp1.talpsadditions.utils;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.config.CommonConfig;
import com.talp1.talpsadditions.entity.WalkingFungus.WalkingFungusEntity;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
import com.talp1.talpsadditions.utils.registration.ModEnchants;
import com.talp1.talpsadditions.utils.registration.ModEntities;
import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.advancements.criterion.PlayerEntityInteractionTrigger;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
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
import net.minecraftforge.fml.config.ModConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler{

    //--------------------------------Worm Drop----------------------------------
    //may drop a worm when dirt/grass get hoed into farmland
    @SubscribeEvent
    public static void onHoeingDropWorm(UseHoeEvent event){
        if(!event.getContext().getWorld().isRemote()){
            ServerWorld serverWorld = (ServerWorld) event.getContext().getWorld();
            Block targetBlock=event.getContext().getWorld().getBlockState(event.getContext().getPos()).getBlock();
            if(targetBlock == Blocks.DIRT||targetBlock==Blocks.GRASS_BLOCK){
                Random random = new Random();
                if(random.nextInt(CommonConfig.earthWormDropChance.get())+1==1){
                    BlockPos wormBlock = event.getContext().getPos();
                    serverWorld.spawnParticle(ParticleTypes.SNEEZE, wormBlock.getX(), wormBlock.getY()+1,wormBlock.getZ(),6, 0.2D,0.2D,0.2D,0.1D);
                    World worldIn = event.getContext().getWorld();
                    worldIn.addEntity(new ItemEntity(worldIn, event.getContext().getPos().getX(), event.getContext().getPos().getY()+1,event.getContext().getPos().getZ(), new ItemStack(ModItems.earth_worm.get())));
                }
            }
        }
    }

    //--------------------------------BoneMeal Coral----------------------------------
    @SubscribeEvent
    public static void onBonemealCoralFan(BonemealEvent event){
        if(!event.getWorld().isRemote()){
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
    }

    private static void spawnCorals(Block blockIn, BlockPos posIn, World worldIn){
        Random random = new Random();
        ServerWorld serverWorld = (ServerWorld) worldIn;
        if(random.nextInt(CommonConfig.growCoralChance.get())==0){
            serverWorld.spawnParticle(ParticleTypes.HAPPY_VILLAGER, posIn.getX()+0.5, posIn.getY(), posIn.getZ()+0.5, 10, 0.2, 0.25, 0.2, 0.2D);
            worldIn.setBlockState(posIn,blockIn.getDefaultState());
            worldIn.setBlockState(posIn.up(),blockIn.getDefaultState());
        }else{
            serverWorld.spawnParticle(ParticleTypes.SMOKE, posIn.getX()+0.5, posIn.getY(), posIn.getZ()+0.5, 8, 0.2, 0.25, 0.2, 0.2D);
        }
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
    public static void craftAcidBottle(TickEvent.PlayerTickEvent event) {//TODO: make a timer or something to avoid insta-crafting
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
                        ServerWorld serverWorld = (ServerWorld)event.player.getEntityWorld();
                        serverWorld.spawnParticle(ParticleTypes.SNEEZE, event.player.getPosX(), event.player.getPosY(), event.player.getPosZ(),200, 0.5,0.25,0.5,0.65);
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

    @SubscribeEvent
    public static void onReEnchanting(ItemTossEvent event){ ;
        if (!event.getPlayer().getEntityWorld().isRemote()){
            BlockPos playerPos = event.getPlayer().getPosition();
            //check for correct multiblock struture
            if( correctReEnchantrMultiblock(playerPos, event.getPlayer().getEntityWorld()) ){
                reEnchantItem(event.getEntityItem(), event.getPlayer());
            }
        }
    }

    private static void reEnchantItem(ItemEntity itemEntity, PlayerEntity player){
        ItemStack stack = itemEntity.getItem();
        if(!stack.isEmpty()){
            ServerWorld serverWorld = (ServerWorld)player.getEntityWorld();
            Random rand = new Random();
            int expAmount = rand.nextInt(CommonConfig.maxLvlCostToIncreaseLvls.get())+1;//exp points cost
            Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(stack);//enchants on the item toss
            if(stack.isEnchanted() && player.experienceLevel>= expAmount){
                //increase enchs lvl
                enchants.forEach( (ench, lvl) ->{
                    if(rand.nextInt(CommonConfig.increaseEnchantsChance.get())==0){
                        enchants.replace(ench, lvl+rand.nextInt(CommonConfig.maxLvlIncrease.get())+1);
                        spawnReEnchanterParticleFormation(ParticleTypes.ENCHANTED_HIT, serverWorld, player.getPosition());
                    }
                });
                EnchantmentHelper.setEnchantments(enchants,stack);
                player.addExperienceLevel(-expAmount);//subtract exp points
            }
            expAmount = rand.nextInt(CommonConfig.maxLvlCostToAddEnchant.get())+1;//exp points cost
            if(rand.nextInt(CommonConfig.newEnchantChance.get())==0 && player.experienceLevel>=expAmount){
                //pick a rendom enchant and check if is compatible
                Enchantment newEnch;
                do{
                    newEnch = Enchantment.getEnchantmentByID(rand.nextInt(50));
                }while( newEnch==null ||
                        enchants.containsKey(newEnch) ||
                        ( (newEnch!=Enchantments.MENDING && newEnch!=Enchantments.FROST_WALKER) && !stack.canApplyAtEnchantingTable(newEnch) )
                      );
                spawnReEnchanterParticleFormation(ParticleTypes.WITCH, serverWorld, player.getPosition());
                stack.addEnchantment(newEnch, rand.nextInt(CommonConfig.newEnchantMaxLvl.get())+1);//add the enchant
                player.addExperienceLevel(-expAmount);//subtract the exp points
            }
        }
    }

    private static void spawnReEnchanterParticleFormation(BasicParticleType particleType, ServerWorld serverWorld, BlockPos playerPos){
        for(Direction direction : Direction.Plane.HORIZONTAL){
            BlockPos spawnPos = playerPos.offset(direction);
            serverWorld.spawnParticle(particleType, spawnPos.getX()+0.5, spawnPos.getY()+1, spawnPos.getZ()+0.5, 100, 0, 1, 0, 0);
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
