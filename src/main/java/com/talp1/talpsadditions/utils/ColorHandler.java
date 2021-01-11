package com.talp1.talpsadditions.utils;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorHandler {
    @SubscribeEvent
    public static void blockColorReg(ColorHandlerEvent.Block event) {
        event.getBlockColors().register(new BlockColorImpl(),
                ModBlocks.floreal_vines.get());
    }

    static class BlockColorImpl implements IBlockColor{
        @Override
        public int getColor(BlockState blockStateIn, @Nullable IBlockDisplayReader p_getColor_2_, @Nullable BlockPos blockPosIn, int p_getColor_4_) {
            return Minecraft.getInstance().world.getBiome(blockPosIn).getFoliageColor();
        }
    }
}
