package com.talp1.talpsadditions.entity.MoleEntity;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.config.CommonConfig;
import com.talp1.talpsadditions.utils.registration.ModEntities;
import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.*;
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
import net.minecraft.world.spawner.WorldEntitySpawner;
import net.minecraftforge.server.permission.context.WorldContext;

import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MoleEntity extends AnimalEntity {

    public MoleEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        MoleEntity entity = (MoleEntity)((EntityType) ModEntities.mole_entity.get()).create(p_241840_1_);
        entity.onInitialSpawn(p_241840_1_, p_241840_1_.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
        return entity;
    }

    @Nullable
    public MoleEntity createChild(AgeableEntity ageable) {
        MoleEntity entity = (MoleEntity)((EntityType)ModEntities.mole_entity.get()).create(this.world);
        entity.onInitialSpawn(this.world.getServer().func_241755_D_(), this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
        return entity;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(1, new BreedGoal(this,1D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal(this, CatEntity.class,8f,1.25f,1.25f));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(ModItems.earth_worm.get()), true));
        this.goalSelector.addGoal(4, new AvoidEntityGoal(this, PlayerEntity.class,8f,1.25f,1.25f));
        this.goalSelector.addGoal(5, new FollowParentGoal(this,1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this,1D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 1f));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_BAT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, CommonConfig.moleMovementSpeed.get()).createMutableAttribute(Attributes.MAX_HEALTH, CommonConfig.moleMaxHealth.get());
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem()==ModItems.earth_worm.get();
    }

    //TODO -> moles only spawn in caves
    public static boolean canSpawn(EntityType<MoleEntity> moleIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        //Main.LOGGER.info("trying at: " + pos.getY());
        //return pos.getY()<64 && (worldIn.canBlockSeeSky(pos)||worldIn.canSeeSky(pos));
        return worldIn.canBlockSeeSky(pos)||worldIn.canSeeSky(pos);
    }

    @Override //drop talp1's head when a mole is struck by a lightning
    public void func_241841_a(ServerWorld p_241841_1_, LightningBoltEntity p_241841_2_) {
        if(!this.world.isRemote()){
            ItemStack customPlayerHead = new ItemStack(Items.PLAYER_HEAD);
            customPlayerHead.setTag(new CompoundNBT());
            customPlayerHead.getTag().putString("SkullOwner", "Talp1");
            customPlayerHead.getOrCreateChildTag("prevent_lightning_destroy");
            this.entityDropItem(customPlayerHead);
        }
    }
}
