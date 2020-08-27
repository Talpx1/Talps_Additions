package com.talp1.talpsadditions.item;

import com.talp1.talpsadditions.block.FlorealDecorationBlock;
import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class GeneCollectorItem extends Item {
    public GeneCollectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if(stack.getItem() instanceof GeneCollectorItem){
            if(entity.getType()== EntityType.SHEEP){
                stack.shrink(1);
                player.addItemStackToInventory(new ItemStack(RegistryHandler.sheep_gene.get()));
            }
            if(entity.getType()== EntityType.CHICKEN){
                stack.shrink(1);
                player.addItemStackToInventory(new ItemStack(RegistryHandler.chicken_gene.get()));
            }
        }
        return true;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player) {
        if(itemstack.getItem() instanceof GeneCollectorItem){
            Block clicked = player.getEntityWorld().getBlockState(pos).getBlock();
            if (clicked instanceof SweetBerryBushBlock){
                itemstack.shrink(1);
                player.addItemStackToInventory(new ItemStack(RegistryHandler.bush_gene.get()));
            }
            if (clicked instanceof VineBlock && !(clicked instanceof FlorealDecorationBlock)){
                itemstack.shrink(1);
                player.addItemStackToInventory(new ItemStack(RegistryHandler.vine_gene.get()));
            }
        }
        return true;
    }
}
