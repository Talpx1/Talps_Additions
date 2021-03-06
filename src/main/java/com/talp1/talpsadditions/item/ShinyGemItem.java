package com.talp1.talpsadditions.item;

import com.talp1.talpsadditions.utils.registration.ModBlocks;
import com.talp1.talpsadditions.utils.registration.ModEnchants;
import net.minecraft.entity.EntityType;
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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ShinyGemItem extends Item {
    public ShinyGemItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, IWorldReader world, BlockPos pos, PlayerEntity player) {
        if (world.isRemote()) return false;
        if(!isRitualCorrectSetup(pos, player.getEntityWorld())) return false;
        if (!player.abilities.isCreativeMode) stack.shrink(1);
        ServerWorld serverWorld = (ServerWorld) world;
        spawnLightning(serverWorld, pos);
        spawnRitualParticleFormation(ParticleTypes.WITCH, serverWorld, pos);
        ItemStack reward = new ItemStack(Items.ENCHANTED_BOOK);
        reward.addEnchantment(ModEnchants.ancient_resistance_enchant.get(),1);
        player.getEntityWorld().addEntity(new ItemEntity(player.getEntityWorld(), pos.getX(), pos.getY()+1, pos.getZ(), reward));
        return true;
    }

    private void spawnRitualParticleFormation(BasicParticleType particleType, ServerWorld serverWorld, BlockPos pos){
        serverWorld.spawnParticle(ParticleTypes.ENCHANTED_HIT, pos.getX()+0.5, pos.getY()+1, pos.getZ()+0.5, 100, 0, 1, 0, 0.25);
        for(Direction direction : Direction.Plane.HORIZONTAL){
            BlockPos spawnPos = pos.offset(direction, 3);
            serverWorld.spawnParticle(particleType, spawnPos.getX()+0.5, spawnPos.getY()+1, spawnPos.getZ()+0.5, 100, 0, 1, 0, 0);
        }
    }

    private void spawnLightning(ServerWorld world, BlockPos pos){
        LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(world);
        lightningboltentity.moveForced(Vector3d.copyCenteredHorizontally(pos));
        lightningboltentity.setEffectOnly(true);
        world.addEntity(lightningboltentity);
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
