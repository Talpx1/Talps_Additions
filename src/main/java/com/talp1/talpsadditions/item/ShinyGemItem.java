package com.talp1.talpsadditions.item;

import com.talp1.talpsadditions.entity.MoleEntity.MoleEntity;
import com.talp1.talpsadditions.utils.registration.ModBlocks;
import com.talp1.talpsadditions.utils.registration.ModEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.core.jmx.Server;

public class ShinyGemItem extends Item {
    public ShinyGemItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, IWorldReader world, BlockPos pos, PlayerEntity player) {
        if (world.isRemote()) return false;
        if(!isRitualCorrectSetup(pos, player.getEntityWorld())) return false;
        if (!player.abilities.isCreativeMode) stack.shrink(1);
        EntityType<LightningBoltEntity> lightningBolt = EntityType.LIGHTNING_BOLT;
        lightningBolt.spawn(player.getEntityWorld().getServer().getWorld(player.getEntityWorld().getDimensionKey()), null,null,pos, SpawnReason.MOB_SUMMONED,true,true);
        ServerWorld serverWorld = (ServerWorld) player.getEntityWorld();
        spawnRitualParticleFormation(ParticleTypes.WITCH, serverWorld, pos);
        BlockPos playerPos = player.getPosition();
        player.getEntityWorld().addEntity(new ItemEntity(player.getEntityWorld(), playerPos.getX(), playerPos.getY()+1, playerPos.getZ(), new ItemStack(Items.DIAMOND)));
        return true;
    }

    private static void spawnRitualParticleFormation(BasicParticleType particleType, ServerWorld serverWorld, BlockPos pos){
        serverWorld.spawnParticle(ParticleTypes.ENCHANTED_HIT, pos.getX()+0.5, pos.getY()+1, pos.getZ()+0.5, 100, 0, 1, 0, 0.25);
        for(Direction direction : Direction.Plane.HORIZONTAL){
            BlockPos spawnPos = pos.offset(direction, 3);
            serverWorld.spawnParticle(particleType, spawnPos.getX()+0.5, spawnPos.getY()+1, spawnPos.getZ()+0.5, 100, 0, 1, 0, 0);
        }
    }

    private boolean isRitualCorrectSetup(BlockPos pos, World world){
        if (pos.getZ()!=0 || pos.getX()!=0) return false;
        if(world.getBlockState(pos).getBlock() != ModBlocks.shiny_shard_block.get())return false;
        for (Direction direction : Direction.Plane.HORIZONTAL){
            if (world.getBlockState(pos.offset(direction, 3)).getBlock() != ModBlocks.ancient_statue.get()) return false;
        }
        return true;
    }
}
