package com.talp1.talpsadditions.world.features;

import com.mojang.serialization.Codec;
import java.util.Random;

import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

public class FlorealVineFeature extends Feature<NoFeatureConfig> {
    public FlorealVineFeature(Codec<NoFeatureConfig> p_i232002_1_) {
        super(p_i232002_1_);
    }

    public boolean func_230362_a_(ISeedReader worldIn, StructureManager strucManager, ChunkGenerator chucnkGen, Random rand, BlockPos pos, NoFeatureConfig config) {

        BlockPos.Mutable blockPos = new BlockPos.Mutable().setPos(pos.getX(), pos.getY(), pos.getZ());
        BlockState currentBlockState = worldIn.getBlockState(blockPos);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            boolean isValidSpot=RegistryHandler.floreal_vines.get().isValidPosition(RegistryHandler.floreal_vines.get().getDefaultState().with(VineBlock.getPropertyFor(direction), Boolean.TRUE),worldIn,blockPos);
            if (blockPos.getY()>63 && currentBlockState==Blocks.AIR.getDefaultState()&&isValidSpot){
                worldIn.setBlockState(blockPos, RegistryHandler.floreal_vines.get().getDefaultState().with(VineBlock.getPropertyFor(direction), Boolean.TRUE),2);
                for (int i=0; i<=rand.nextInt(3);i++) {
                    if (worldIn.getBlockState(blockPos.add(0, -(i), 0)) == Blocks.AIR.getDefaultState()) {
                        worldIn.setBlockState(blockPos.add(0, -(i), 0), RegistryHandler.floreal_vines.get().getDefaultState().with(VineBlock.getPropertyFor(direction), Boolean.TRUE), 2);
                    }
                }
            }
        }
        return true;
    }
}