package com.talp1.talpsadditions.item;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.config.CommonConfig;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BottleOfAcidItem extends Item {
    public BottleOfAcidItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity)entityLiving;
            entityLiving.attackEntityFrom(DamageSource.HOT_FLOOR, CommonConfig.drinkAcidDamageAmount.get());
            if (!player.abilities.isCreativeMode) {
                stack.shrink(1);
                player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
            }
        }
        return stack;
    }


    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return DrinkHelper.startDrinking(worldIn, playerIn, handIn);
    }

    public int getUseDuration(ItemStack stack) {
       return 32;
    }

    /*@Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity playerIn) {
        World worldIn = playerIn.getEntityWorld();
        if (!worldIn.isRemote) {
            if(worldIn.getBlockState(pos)== Blocks.CAULDRON.getDefaultState()){
                if (!playerIn.abilities.isCreativeMode){
                    playerIn.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
                    itemstack.shrink(1);
                }
                worldIn.setBlockState(pos,RegistryHandler.cauldron_with_acid.get().getDefaultState(),2);
            }
        }
        return true;
    }*/

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, IWorldReader worldIn, BlockPos pos, PlayerEntity playerIn) {
        if (!worldIn.isRemote()) {
            if(worldIn.getBlockState(pos)== Blocks.CAULDRON.getDefaultState()){
                if (!playerIn.abilities.isCreativeMode){
                    playerIn.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
                    stack.shrink(1);
                }
                playerIn.getEntityWorld().setBlockState(pos, ModBlocks.cauldron_with_acid.get().getDefaultState(),2);
                return true;
            }
        }
        return false;
    }

}
