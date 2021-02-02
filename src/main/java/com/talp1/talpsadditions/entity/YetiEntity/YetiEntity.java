package com.talp1.talpsadditions.entity.YetiEntity;

import com.talp1.talpsadditions.config.CommonConfig;
import com.talp1.talpsadditions.entity.MoleEntity.MoleEntity;
import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

public class YetiEntity extends CreatureEntity implements IAngerable {

    private int dropTimer;
    private static final RangedInteger field_234217_by_ = TickRangeConverter.convertRange(20, 39);
    private int field_234218_bz_;
    private UUID field_234216_bA_;

    public YetiEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        this.dropTimer=0;
    }

    private void setDropTimer(int ticks){
        this.dropTimer=ticks;
    }

    @Override
    public void livingTick() {
        if(this.dropTimer>0)  this.dropTimer--;
        super.livingTick();
    }

    @Override
    public ActionResultType applyPlayerInteraction(PlayerEntity player, Vector3d vec, Hand hand) {
        if(!this.world.isRemote() && this.dropTimer==0){
            setDropTimer(100);
            this.entityDropItem(new ItemStack(ModItems.yetis_icecream.get(),1));
            return ActionResultType.SUCCESS;
        }
        return super.applyPlayerInteraction(player, vec, hand);
    }

    public static boolean canSpawn(EntityType<YetiEntity> yetiEntityEntityType, IWorld iWorld, SpawnReason spawnReason, BlockPos blockPos, Random random) {
        return true;
    }

    @Override
    public boolean isChild() {
        return false;
    }

    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new YetiEntity.MeleeAttackGoal());
        this.goalSelector.addGoal(2, new YetiEntity.PanicGoal());
        this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(0, new YetiEntity.HurtByTargetGoal());
        this.targetSelector.addGoal(1, new YetiEntity.AttackPlayerGoal());
        this.targetSelector.addGoal(2, new ResetAngerGoal<>(this, false));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, CommonConfig.yetiMaxHealth.get()).createMutableAttribute(Attributes.FOLLOW_RANGE, CommonConfig.yetiFollowRange.get()).createMutableAttribute(Attributes.MOVEMENT_SPEED, CommonConfig.yetiMovementSpeed.get()).createMutableAttribute(Attributes.ATTACK_DAMAGE, CommonConfig.yetiAttackDamage.get());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readAngerNBT((ServerWorld)this.world, compound);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.writeAngerNBT(compound);
    }

    @Override
    public int getAngerTime(){
        return this.field_234218_bz_;
    }

    @Override
    public void setAngerTime(int time) {
        this.field_234218_bz_ = time;
    }

    @Nullable
    @Override
    public UUID getAngerTarget() {
        return this.field_234216_bA_;
    }

    @Override
    public void setAngerTarget(@Nullable UUID target) {
        this.field_234216_bA_ = target;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(!world.isRemote && source.getTrueSource() instanceof PlayerEntity){
            setAngerTarget(source.getTrueSource().getUniqueID());
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public void func_230258_H__() {
        this.setAngerTime(field_234217_by_.getRandomWithinRange(this.rand));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_POLAR_BEAR_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_POLAR_BEAR_STEP, 0.15F, 1.0F);
    }

    protected void registerData() {
        super.registerData();
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    protected float getWaterSlowDown() {
        return 0.98F;
    }

    class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
        public AttackPlayerGoal() {
            super(YetiEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
        }

        protected double getTargetDistance() {
            return super.getTargetDistance() * 0.5D;
        }
    }

    class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
        public HurtByTargetGoal() {
            super(YetiEntity.this);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            super.startExecuting();
        }

        protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
            if (mobIn instanceof YetiEntity) {
                super.setAttackTarget(mobIn, targetIn);
            }
        }

    }

    class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
        public MeleeAttackGoal() {
            super(YetiEntity.this, 1.25D, true);
        }

        protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
            if (distToEnemySqr <= getAttackReachSqr(enemy) && enemy.getUniqueID()==getAngerTarget()) {
                this.func_234039_g_();
                this.attacker.attackEntityAsMob(enemy);
            }
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask(){
            super.resetTask();
        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return (double)(4.0F + attackTarget.getWidth());
        }
    }

    class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
        public PanicGoal() {
            super(YetiEntity.this, 2.0D);
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return !YetiEntity.this.isBurning() ? false : super.shouldExecute();
        }
    }
}

