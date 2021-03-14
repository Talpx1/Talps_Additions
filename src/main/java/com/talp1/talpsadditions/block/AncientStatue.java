package com.talp1.talpsadditions.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class AncientStatue extends BasketBlock{
    private static final VoxelShape HORIZONTAL = Block.makeCuboidShape(5D, 0.0D, 5D, 11D, 8D, 11.0D);
    private static final VoxelShape VERTICAL = Block.makeCuboidShape(5D, 0.0D, 5D, 11.0D, 8D, 11D);

    public AncientStatue(Properties properties) {
        super(properties);
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.getShape(state, worldIn, pos, context);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(BlockStateProperties.HORIZONTAL_FACING)) {
            case EAST:
            case WEST:
                return VERTICAL;
            case NORTH:
            case SOUTH:
                return HORIZONTAL;
            default:
                return VoxelShapes.fullCube();
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}
