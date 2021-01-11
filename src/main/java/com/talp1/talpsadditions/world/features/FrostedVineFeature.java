package com.talp1.talpsadditions.world.features;

import com.mojang.serialization.Codec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
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
    private static final Direction[] DIRECTIONS = Direction.values();

    public FrostedVineFeature(Codec<NoFeatureConfig> p_i232002_1_) {
        super(p_i232002_1_);
    }

    public boolean place(ISeedReader world, ChunkGenerator chunkGenerator, Random rand, BlockPos startPos, NoFeatureConfig config) {
        return this.generate(world,chunkGenerator,rand,startPos,config);
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        BlockPos.Mutable blockpos$mutable = pos.toMutable();

        //try to find place 10 times with different y vals for each block pos passed
        for(int i=0;i<10;i++)
            tryToPlace(blockpos$mutable, reader, getValidRand(rand));

        return true;
    }

    //generate a rand between 63 and 255
    private int getValidRand(Random random){
        int currRand=random.nextInt(255);
        while(currRand<63){currRand=random.nextInt(255);}
        return currRand;
    }

    //start the process of (eventually) placing
    private void tryToPlace(BlockPos pos, ISeedReader reader, int yIn){
        BlockPos currPos=new BlockPos(pos.getX(), yIn, pos.getZ());
        checkValidSpot(currPos, reader);
    }

    //check if the block passed is next to a leave block
    private void checkValidSpot(BlockPos pos, ISeedReader worldIn){
        if (worldIn.isAirBlock(pos)){
            for (Direction dir : DIRECTIONS){
                if(dir!= Direction.DOWN){
                    if(validBlocks.contains(worldIn.getBlockState(pos.offset(dir)).getBlock())){
                        setVine(worldIn, pos, dir);
                        tryToCreateHanging(pos, worldIn, dir);
                    }
                }
            }
        }
    }

    //place the vine
    private void setVine(ISeedReader worldIn, BlockPos pos, Direction dir){
        worldIn.setBlockState(pos, ModBlocks.frosted_vines.get().getDefaultState().with(VineBlock.getPropertyFor(dir), Boolean.TRUE), 2);
    }

    //try to create the vines hanging from the vine block placed
    private void tryToCreateHanging(BlockPos pos, ISeedReader reader, Direction direction){
        if(direction!=Direction.UP){
            for (int i=0; i<new Random().nextInt(11)+1;i++){
                if (reader.isAirBlock(pos.down(i))){
                    setVine(reader, pos.down(i), direction);
                }
            }
        }
    }

}