package com.talp1.talpsadditions.block;

import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class HydrangeaBlock extends NormalBushBlock {
    private int blockItem;
    public HydrangeaBlock(Properties p_i49971_1_, int blockItem) {
        super(p_i49971_1_);
        this.blockItem=blockItem;
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        switch (this.blockItem){
            case 1: return new ItemStack(ModItems.white_hydrangea_sprout.get());
            case 2: return new ItemStack(ModItems.red_hydrangea_sprout.get());
            case 3: return new ItemStack(ModItems.pink_hydrangea_sprout.get());
            case 4: return new ItemStack(ModItems.lilac_hydrangea_sprout.get());
            case 5: return new ItemStack(ModItems.blue_hydrangea_sprout.get());
        }
        return new ItemStack(ModItems.white_hydrangea_sprout.get());
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.get(AGE);
        boolean flag = i == 3;
        if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i > 1) {
            int j = 1 + worldIn.rand.nextInt(2);
            spawnAsEntity(worldIn, pos, new ItemStack(ModItems.bush_leaf.get(), 1));
            spawnAsEntity(worldIn, pos, new ItemStack(ModItems.petal.get(), j + (flag ? 1 : 0)));
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, 1), 2);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

}
