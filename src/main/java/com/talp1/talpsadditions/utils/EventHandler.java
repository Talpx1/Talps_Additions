package com.talp1.talpsadditions.utils;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sun.javafx.geom.Vec3d;
import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.effect.SmellEffect;
import com.talp1.talpsadditions.gui.OverlayLineRenderer;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.block.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.ModelBakery;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.Half;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraftforge.client.event.DrawHighlightEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.GL11;

import java.util.Random;

import static javax.swing.UIManager.put;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler{

    //--------------------------------Worm Drop----------------------------------
    //may drop a worm when dirt/grass get hoed into farmland
    @SubscribeEvent
    public static void onHoeingDropWorm(UseHoeEvent event){
        Block targetBlock=event.getContext().getWorld().getBlockState(event.getContext().getPos()).getBlock();
        if(targetBlock == Blocks.DIRT||targetBlock==Blocks.GRASS_BLOCK){
            Random random = new Random();
            if(random.nextInt(3)+1==1){
                World worldIn = event.getContext().getWorld();
                worldIn.addEntity(new ItemEntity(worldIn, event.getContext().getPos().getX(), event.getContext().getPos().getY()+1,event.getContext().getPos().getZ(), new ItemStack(RegistryHandler.earth_worm.get())));
            }
        }
    }


    //--------------------------------Head Drop----------------------------------
    //drop talp1's head when a mole is struck by a lightning
    @SubscribeEvent
    public static void onMoleStruckByLightning(EntityStruckByLightningEvent event){
        if(event.getEntity().getType()== RegistryHandler.mole_entity.get()){
            ItemStack customPlayerHead = new ItemStack(Items.PLAYER_HEAD);
            customPlayerHead.setTag(new CompoundNBT());
            customPlayerHead.getTag().putString("SkullOwner", "Talp1");
            event.getEntity().entityDropItem(customPlayerHead);
        }
    }


    //--------------------------------BoneMeal Coral----------------------------------
    @SubscribeEvent
    public static void onBonemealCoralFan(BonemealEvent event){
        if(event.getBlock().getBlock()==Blocks.BRAIN_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.BRAIN_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.BRAIN_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.BRAIN_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
        if(event.getBlock().getBlock()==Blocks.BUBBLE_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.BUBBLE_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.BUBBLE_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.BUBBLE_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
        if(event.getBlock().getBlock()==Blocks.FIRE_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.FIRE_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.FIRE_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.FIRE_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
        if(event.getBlock().getBlock()==Blocks.HORN_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.HORN_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.HORN_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.HORN_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
        if(event.getBlock().getBlock()==Blocks.TUBE_CORAL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.TUBE_CORAL_WALL_FAN.getBlock()||event.getBlock().getBlock()==Blocks.TUBE_CORAL.getBlock()){
            if(checkForFreeSpace(event.getWorld().getBlockState(event.getPos().up())))
                spawnCorals(Blocks.TUBE_CORAL_BLOCK.getBlock(), event.getPos(), event.getWorld());
        }
    }

    private static void spawnCorals(Block blockIn, BlockPos posIn, World worldIn){
        worldIn.setBlockState(posIn,blockIn.getDefaultState());
        worldIn.setBlockState(posIn.up(),blockIn.getDefaultState());
    }

    private static boolean checkForFreeSpace(BlockState stateIn){
        return  stateIn.getBlock()==Blocks.AIR||stateIn.getBlock()==Blocks.WATER;
    }


//--------------------------------SMELL EFFECT----------------------------------
    @SubscribeEvent
    public static void onSmellAdded(PotionEvent.PotionAddedEvent event){
        if (event.getPotionEffect().getPotion()==RegistryHandler.smell_effect.get()&&event.getEntityLiving()instanceof PlayerEntity){
            SmellEffect.oresInChunk=SmellEffect.getOrePos(event.getEntityLiving());
            SmellEffect.index=0;
            if (SmellEffect.oresInChunk.isEmpty()){
                ItemStack potion = new ItemStack(Items.POTION);
                potion.setDisplayName(ITextComponent.func_241827_a_("No Ores (Re)Found!"));
                event.getEntityLiving().entityDropItem(PotionUtils.addPotionToItemStack(potion,RegistryHandler.smell_potion.get()));
                event.getEntityLiving().removeActivePotionEffect(RegistryHandler.smell_effect.get());
                event.getEntityLiving().removeActivePotionEffect(Effects.BLINDNESS.getEffect());
            }
        }
    }

    @SubscribeEvent
    public static void renderOreOutline(RenderWorldLastEvent event) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player.isPotionActive(RegistryHandler.smell_effect.get()))
            drawLines(player, event.getMatrixStack());
    }

    private static void createLines(IVertexBuilder builder, Matrix4f positionMatrix, BlockPos pos, float dx1, float dy1, float dz1, float dx2, float dy2, float dz2) {
        builder.pos(positionMatrix, pos.getX()+dx1, pos.getY()+dy1, pos.getZ()+dz1)
                .color(0.0f, 1f, 0f, 1.0f)
                .endVertex();
        builder.pos(positionMatrix, pos.getX()+dx2, pos.getY()+dy2, pos.getZ()+dz2)
                .color(0.0f, 1f, 0f, 1.0f)
                .endVertex();
    }

    private static void drawLines(ClientPlayerEntity player, MatrixStack matrixStack) {
        IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
        IVertexBuilder builder = buffer.getBuffer(OverlayLineRenderer.OVERLAY_LINES);
        BlockPos playerPos = player.getPosition();
        int px = playerPos.getX();
        int py = playerPos.getY();
        int pz = playerPos.getZ();
        World world = player.getEntityWorld();
        matrixStack.push();
        Vector3d projectedView = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();
        matrixStack.translate(-projectedView.x, -projectedView.y, -projectedView.z);
        Matrix4f matrix = matrixStack.getLast().getMatrix();
        BlockPos.Mutable pos = new BlockPos.Mutable();
        if (SmellEffect.blockPos!=null){
            pos.setPos(SmellEffect.blockPos.getX(), SmellEffect.blockPos.getY(),SmellEffect.blockPos.getZ());
            if (world.getBlockState(pos) != null) {
                createLines(builder, matrix, pos, 0, 0, 0, 1, 0, 0);
                createLines(builder, matrix, pos, 0, 1, 0, 1, 1, 0);
                createLines(builder, matrix, pos, 0, 0, 1, 1, 0, 1);
                createLines(builder, matrix, pos, 0, 1, 1, 1, 1, 1);

                createLines(builder, matrix, pos, 0, 0, 0, 0, 0, 1);
                createLines(builder, matrix, pos, 1, 0, 0, 1, 0, 1);
                createLines(builder, matrix, pos, 0, 1, 0, 0, 1, 1);
                createLines(builder, matrix, pos, 1, 1, 0, 1, 1, 1);

                createLines(builder, matrix, pos, 0, 0, 0, 0, 1, 0);
                createLines(builder, matrix, pos, 1, 0, 0, 1, 1, 0);
                createLines(builder, matrix, pos, 0, 0, 1, 0, 1, 1);
                createLines(builder, matrix, pos, 1, 0, 1, 1, 1, 1);
             }
            matrixStack.pop();
            RenderSystem.disableDepthTest();
            buffer.finish(OverlayLineRenderer.OVERLAY_LINES);
        }
    }
}