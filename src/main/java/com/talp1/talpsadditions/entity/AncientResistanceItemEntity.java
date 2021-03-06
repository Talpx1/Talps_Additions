package com.talp1.talpsadditions.entity;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Arrays;

public class AncientResistanceItemEntity extends ItemEntity {

    private ItemEntity oldEntity;

    public AncientResistanceItemEntity(World worldIn, double x, double y, double z, ItemEntity oldEntity) {
        super(worldIn, x, y, z, oldEntity.getItem());
        this.oldEntity = oldEntity;
    }

    public boolean isImmuneToFire() {
        return true;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        ArrayList<DamageSource> validSources = new ArrayList<>(Arrays.asList(DamageSource.IN_FIRE, DamageSource.DRAGON_BREATH, DamageSource.HOT_FLOOR, DamageSource.LAVA, DamageSource.ON_FIRE, DamageSource.LIGHTNING_BOLT));
        if(!validSources.contains(source))return false;
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public void tick() {
        if(this.ticksExisted >= 1) this.oldEntity.remove();
        super.tick();
        float f = this.getEyeHeight() - 0.11111111F;
        if (this.isInLava() && this.func_233571_b_(FluidTags.LAVA) > (double)f) {
            this.extinguish();
            this.setMotion(0, 0, 0);
            this.setOnFireFromLava();
            if(!this.getEntityWorld().isRemote()){
                ServerWorld serverWorld = (ServerWorld)this.getEntityWorld();
                serverWorld.spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getPosX(), this.getPosY()-0.05D, this.getPosZ(), 10, 0, 0, 0, 0.01);
            }
        }
    }
    @Override
    public boolean isImmuneToExplosions() {
        return true;
    }

    @Override
    public boolean canRenderOnFire() {
        return false;
    }

    @Override
    protected void setOnFireFromLava() {this.extinguish();}
}
