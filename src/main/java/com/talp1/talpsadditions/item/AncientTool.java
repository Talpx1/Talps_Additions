package com.talp1.talpsadditions.item;

import com.talp1.talpsadditions.utils.registration.ModBlocks;
import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

import java.util.Random;

public class AncientTool extends Item {

    public AncientTool(Properties properties) {
        super(properties);
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, IWorldReader worldIn, BlockPos pos, PlayerEntity playerIn) {
        if (!worldIn.isRemote()) {
            if(worldIn.getBlockState(pos).getBlock()== ModBlocks.ancient_statue.get()){
                if (!playerIn.abilities.isCreativeMode){
                    stack.attemptDamageItem(1, new Random(), null);
                    if(stack.getDamage()==stack.getMaxDamage()) stack.shrink(1);
                }
                playerIn.getEntityWorld().destroyBlock(pos, false);
                playerIn.getEntityWorld().addEntity(new ItemEntity(playerIn.getEntityWorld(),pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.ancient_statue_item.get())));
                playerIn.swing(playerIn.getActiveHand(), true);
                return true;
            }
        }
        return false;
    }
}