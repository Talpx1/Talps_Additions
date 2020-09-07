package com.talp1.talpsadditions.world.features;

import com.mojang.serialization.Codec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraftforge.common.Tags;

public class FrostedVineFeature extends Feature<NoFeatureConfig> {
    private final ArrayList<Block> validBlocks = new ArrayList<>(Arrays.asList(Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE));

    public FrostedVineFeature(Codec<NoFeatureConfig> p_i232002_1_) {
        super(p_i232002_1_);
    }

    public boolean func_230362_a_(ISeedReader worldIn, StructureManager strucManager, ChunkGenerator chucnkGen, Random rand, BlockPos pos, NoFeatureConfig config) {

        BlockPos.Mutable blockPos = new BlockPos.Mutable().setPos(pos.getX(), pos.getY(), pos.getZ());
        BlockState currentBlockState = worldIn.getBlockState(blockPos);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (blockPos.getY()>63 && currentBlockState==Blocks.AIR.getDefaultState()){
                checkSorroundingBlocks(blockPos, worldIn, rand, direction);
            }
        }
        return true;
    }

    private boolean checkValidSpot(Direction dir, BlockPos pos, ISeedReader worldIn,BlockPos originalPos){
        if(validBlocks.contains(worldIn.getBlockState(pos).getBlock())){
            return RegistryHandler.frosted_vines.get().isValidPosition(RegistryHandler.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE),worldIn,originalPos);
        }
        return false;
    }

    private void checkSorroundingBlocks(BlockPos blockPos, ISeedReader worldIn, Random rand, Direction dir){

        if (checkValidSpot(dir, blockPos.east(),worldIn,blockPos)){
            worldIn.setBlockState(blockPos, RegistryHandler.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE), 2);
            for (int i=0; i<=rand.nextInt(3);i++) {
                if (worldIn.getBlockState(blockPos.add(0, -(i), 0)) == Blocks.AIR.getDefaultState()) {
                    worldIn.setBlockState(blockPos.add(0, -(i), 0), RegistryHandler.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE), 2);
                }
            }
        }

        if (checkValidSpot(dir, blockPos.west(),worldIn,blockPos)){
            worldIn.setBlockState(blockPos, RegistryHandler.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE), 2);
            for (int i=0; i<=rand.nextInt(3);i++) {
                if (worldIn.getBlockState(blockPos.add(0, -(i), 0)) == Blocks.AIR.getDefaultState()) {
                    worldIn.setBlockState(blockPos.add(0, -(i), 0), RegistryHandler.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE), 2);
                }
            }
        }

        if (checkValidSpot(dir, blockPos.north(),worldIn,blockPos)){
            worldIn.setBlockState(blockPos, RegistryHandler.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE), 2);
            for (int i=0; i<=rand.nextInt(3);i++) {
                if (worldIn.getBlockState(blockPos.add(0, -(i), 0)) == Blocks.AIR.getDefaultState()) {
                    worldIn.setBlockState(blockPos.add(0, -(i), 0), RegistryHandler.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE), 2);
                }
            }
        }

        if (checkValidSpot(dir, blockPos.south(),worldIn,blockPos)){
            worldIn.setBlockState(blockPos, RegistryHandler.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE), 2);
            for (int i=0; i<=rand.nextInt(3);i++) {
                if (worldIn.getBlockState(blockPos.add(0, -(i), 0)) == Blocks.AIR.getDefaultState()) {
                    worldIn.setBlockState(blockPos.add(0, -(i), 0), RegistryHandler.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE), 2);
                }
            }
        }
    }

}