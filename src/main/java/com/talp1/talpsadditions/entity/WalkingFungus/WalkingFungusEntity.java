package com.talp1.talpsadditions.entity.WalkingFungus;

import com.talp1.talpsadditions.config.CommonConfig;
import com.talp1.talpsadditions.entity.MoleEntity.MoleEntity;
import com.talp1.talpsadditions.utils.registration.ModEntities;
import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class WalkingFungusEntity extends AnimalEntity {

    public WalkingFungusEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        WalkingFungusEntity entity = (WalkingFungusEntity)((EntityType) ModEntities.walking_fungus_entity.get()).create(p_241840_1_);
        entity.onInitialSpawn(p_241840_1_, p_241840_1_.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
        return entity;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(1, new BreedGoal(this,1D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal(this, BeeEntity.class,8f,1.25f,1.25f));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.BONE_MEAL, Items.BROWN_MUSHROOM, Items.RED_MUSHROOM), false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this,1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this,1D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 1f));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_CHORUS_FLOWER_DEATH;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, CommonConfig.walkingFungusMovementSpeed.get()).createMutableAttribute(Attributes.MAX_HEALTH, CommonConfig.walkingFungusMaxHealth.get());
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem()==Items.BONE_MEAL;
    }

    public static boolean canSpawn(EntityType<WalkingFungusEntity> moleIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

}
