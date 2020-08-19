package com.talp1.talpsadditions.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class ShinyPebbleBlock extends Block {
    private static final VoxelShape BOX_SHAPE = Block.makeCuboidShape(5D, 0.0D, 5D, 11D, 3D, 11D);

    public ShinyPebbleBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.getShape(state, worldIn, pos, context);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d vector3d = state.getOffset(worldIn, pos);
        return BOX_SHAPE.withOffset(vector3d.x, vector3d.y, vector3d.z);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        dropXpOnBlockBreak(worldIn,pos, MathHelper.nextInt(new Random(), 1, 2));
        ItemStack randItem = null;
        do{
           randItem = new ItemStack(Item.getItemById(MathHelper.nextInt(new Random(), 0, 2267)));
        }while(randItem.isEmpty());
        worldIn.addEntity(new ItemEntity(worldIn,pos.getX(), pos.getY()+1,pos.getZ(), randItem));
        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block=state.getBlock();
        return block==Blocks.STONE||block==Blocks.ANDESITE||block==Blocks.DIORITE||block==Blocks.GRANITE;
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos))
            return Blocks.AIR.getDefaultState();
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

}
