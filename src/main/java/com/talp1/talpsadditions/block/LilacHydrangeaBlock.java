package com.talp1.talpsadditions.block;

import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class LilacHydrangeaBlock extends WhiteHydrangeaBlock {
    public LilacHydrangeaBlock(Properties p_i49971_1_) {
        super(p_i49971_1_);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(RegistryHandler.lilac_hydrangea_sprout.get());
    }
}
