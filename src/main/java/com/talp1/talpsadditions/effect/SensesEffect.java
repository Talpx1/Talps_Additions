package com.talp1.talpsadditions.effect;

import com.talp1.talpsadditions.utils.registration.ModBlocks;
import com.talp1.talpsadditions.utils.registration.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.ArrayList;

public class SensesEffect extends Effect {

    private ArrayList<BlockPos> oresInChunk;
    private int delay;

    public SensesEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
        this.oresInChunk=new ArrayList<>();
        this.delay=-1;
    }

    private void setDelaySec(int sec){
        this.delay=sec*20;
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        if(delay==-1){setDelaySec(2);}
        delay--;
        if (entityLivingBaseIn instanceof  PlayerEntity){
            oresInChunk=getOrePos(entityLivingBaseIn);
            if (!oresInChunk.isEmpty()&&delay==0) {
                for(int i=0; i<oresInChunk.size();i++){
                    playSound(entityLivingBaseIn.getEntityWorld(), oresInChunk.get(i));
                }
                setDelaySec(2);
            }
        }
    }

    public static ArrayList<BlockPos> getOrePos(LivingEntity playerIn) {
        int detectDistance = 5;
        ArrayList<BlockPos> foundOres = new ArrayList<>();
        Vector3d playerPosIn =playerIn.getPositionVec();
        int xStart =(int)playerPosIn.getX()-detectDistance;
        int xEnd = (int)playerPosIn.getX()+detectDistance;
        int zStart = (int)playerPosIn.getZ()-detectDistance;
        int zEnd =(int)playerPosIn.getZ()+detectDistance;
        int yEnd = (int)playerPosIn.getY()+detectDistance;
        int yStart = (int)playerPosIn.getY()-detectDistance;
        for (int x = xStart; x <= xEnd; x++) {
            for (int z = zStart; z <= zEnd; z++) {
                for (int y = yStart; y <= yEnd; y++) {
                    if(y>0) {
                        BlockPos currBlockPos = new BlockPos(x, y, z);
                        Block currBlock = playerIn.getEntityWorld().getBlockState(currBlockPos).getBlock();
                        if (currBlock == ModBlocks.shiny_shard_ore.get().getBlock()) {
                            foundOres.add(currBlockPos);
                        }
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

    public void playSound(World worldIn, BlockPos pos){
        worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.shiny_ores_sound.get(), SoundCategory.BLOCKS,0.75f,0.75f,false);
    }

}
