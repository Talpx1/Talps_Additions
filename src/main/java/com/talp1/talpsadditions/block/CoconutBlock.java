package com.talp1.talpsadditions.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Foods;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class CoconutBlock extends Block {

    private static final VoxelShape BOX_SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

    public CoconutBlock(Properties properties) {
        super(properties);
    }

    public static VoxelShape getBoxShape() {
        return BOX_SHAPE;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOX_SHAPE;
    }

}
