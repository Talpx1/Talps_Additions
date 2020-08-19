package com.talp1.talpsadditions.effect;

import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;

import java.util.ArrayList;

public class SmellEffect extends Effect {

    public static BlockPos blockPos;

    public SmellEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    public static int index=0;
    public static ArrayList<BlockPos> oresInChunk=new ArrayList<>();
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        if (!oresInChunk.isEmpty()) {
            Block currBlock = entityLivingBaseIn.getEntityWorld().getBlockState(new BlockPos(oresInChunk.get(index).getX(), oresInChunk.get(index).getY(), oresInChunk.get(index).getZ())).getBlock();
            blockPos = new BlockPos(oresInChunk.get(index).getX(), oresInChunk.get(index).getY(), oresInChunk.get(index).getZ());
            if (currBlock != RegistryHandler.shiny_shard_ore.get().getBlock()&&index<=oresInChunk.size()) {
                index++;
            }
            //Main.LOGGER.info("Outlining " + oresInChunk.get(i).getX() + ", " + oresInChunk.get(i).getY() + ", " + oresInChunk.get(i).getZ());
        }
    }

    public static ArrayList<BlockPos> getOrePos(LivingEntity playerIn) {
        ArrayList<BlockPos> foundOres = new ArrayList<>();
        Vector3d playerPosIn =playerIn.getPositionVec();
        int xStart =(int)playerPosIn.getX()-25;
        int xEnd = (int)playerPosIn.getX()+25;
        int zStart = (int)playerPosIn.getZ()-25;
        int zEnd =(int)playerPosIn.getZ()+25;
        int maxOreGen = 33;
        int minOreGen = 0;
        for (int x = xStart; x <= xEnd; x++) {
            for (int z = zStart; z <= zEnd; z++) {
                for (int y = minOreGen; y <= maxOreGen; y++) {
                    BlockPos currBlockPos = new BlockPos(x, y, z);
                    Block currBlock = playerIn.getEntityWorld().getBlockState(currBlockPos).getBlock();
                    if (currBlock == RegistryHandler.shiny_shard_ore.get().getBlock()) {
                        foundOres.add(currBlockPos);
                        //Main.LOGGER.info("Found Block at: "+currBlockPos.getX()+", "+currBlockPos.getY()+", "+currBlockPos.getZ());
                    }
                }
            }
        }
        return foundOres;
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

}
