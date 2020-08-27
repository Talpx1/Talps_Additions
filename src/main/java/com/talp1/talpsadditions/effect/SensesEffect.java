package com.talp1.talpsadditions.effect;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.gui.OverlayLineRenderer;
import com.talp1.talpsadditions.utils.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

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
        ArrayList<BlockPos> foundOres = new ArrayList<>();
        Vector3d playerPosIn =playerIn.getPositionVec();
        int xStart =(int)playerPosIn.getX()-3;
        int xEnd = (int)playerPosIn.getX()+3;
        int zStart = (int)playerPosIn.getZ()-3;
        int zEnd =(int)playerPosIn.getZ()+3;
        int maxOreGen = (int)playerPosIn.getY()+3;
        int minOreGen = (int)playerPosIn.getY()-3;
        for (int x = xStart; x <= xEnd; x++) {
            for (int z = zStart; z <= zEnd; z++) {
                for (int y = minOreGen; y <= maxOreGen; y++) {
                    if(y>0) {
                        BlockPos currBlockPos = new BlockPos(x, y, z);
                        Block currBlock = playerIn.getEntityWorld().getBlockState(currBlockPos).getBlock();
                        if (currBlock == RegistryHandler.shiny_shard_ore.get().getBlock()) {
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
        worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), RegistryHandler.shiny_ores_sound.get(), SoundCategory.BLOCKS,0.6f,0.6f,false);
    }

}
