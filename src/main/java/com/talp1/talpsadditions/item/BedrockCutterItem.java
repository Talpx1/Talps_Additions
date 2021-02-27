package com.talp1.talpsadditions.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BedrockCutterItem extends Item {

    public BedrockCutterItem(Properties properties) {
        super(properties);
    }

        @Override
        public boolean doesSneakBypassUse(ItemStack stack, IWorldReader worldIn, BlockPos pos, PlayerEntity playerIn) {
            if (!worldIn.isRemote()) {
                if(worldIn.getBlockState(pos)== Blocks.BEDROCK.getDefaultState()){
                    if (!playerIn.abilities.isCreativeMode){
                        stack.shrink(1);
                    }
                    playerIn.getEntityWorld().destroyBlock(pos, false);
                    playerIn.swing(playerIn.getActiveHand(), true);
                    return true;
                }
            }
            return false;
        }

}
