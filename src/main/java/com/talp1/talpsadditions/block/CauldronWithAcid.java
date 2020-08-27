package com.talp1.talpsadditions.block;

import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CauldronBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;

public class CauldronWithAcid extends CauldronBlock {

    private static final VoxelShape INSIDE = makeCuboidShape(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape SHAPE = VoxelShapes.combineAndSimplify(VoxelShapes.fullCube(), VoxelShapes.or(makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 3.0D, 12.0D), makeCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 3.0D, 16.0D), makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D), INSIDE), IBooleanFunction.ONLY_FIRST);

    public CauldronWithAcid(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return INSIDE;
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(!(entityIn instanceof ItemEntity)){
            entityIn.attackEntityFrom(DamageSource.HOT_FLOOR,9999);
        }
        else{
            ItemEntity itemEntityToss=(ItemEntity)entityIn;
            ItemStack stackToss=itemEntityToss.getItem();
            int count=stackToss.getCount();
            final ArrayList<Item> itemToAnimalHelix = new ArrayList<>(Arrays.asList(Items.CHICKEN, Items.MUTTON, Items.PORKCHOP, Items.RABBIT, Items.BEEF));
            final ArrayList<Item> itemToVegetalHelix = new ArrayList<>(Arrays.asList(Items.GRASS, Items.ACACIA_LEAVES, Items.BIRCH_LEAVES, Items.SPRUCE_LEAVES, Items.OAK_LEAVES, Items.JUNGLE_LEAVES, Items.DARK_OAK_LEAVES, Items.VINE));
            if(itemToAnimalHelix.contains(stackToss.getItem())){
                convertItemToss(itemEntityToss,worldIn,pos,count,1);
            }
            if(itemToVegetalHelix.contains(stackToss.getItem())){
                convertItemToss(itemEntityToss,worldIn,pos,count,2);
            }
        }
    }

    private static void convertItemToss(ItemEntity itemEntityToss, World worldIn, BlockPos pos, int count, int type){
        itemEntityToss.remove();
        Item drop;
        switch (type){
            case 1: drop = RegistryHandler.animal_dna_helix.get(); break;
            case 2: drop = RegistryHandler.vegetal_dna_helix.get(); break;
            default: drop= itemEntityToss.getItem().getItem();
        }
        worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(drop, count)));
    }

    public boolean hasComparatorInputOverride(BlockState state) {
        return false;
    }

}
