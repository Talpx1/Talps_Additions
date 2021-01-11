package com.talp1.talpsadditions.block;

import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class RedHydrangeaBlock extends WhiteHydrangeaBlock {
    public RedHydrangeaBlock(Properties p_i49971_1_) {
        super(p_i49971_1_);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.red_hydrangea_sprout.get());
    }

}
