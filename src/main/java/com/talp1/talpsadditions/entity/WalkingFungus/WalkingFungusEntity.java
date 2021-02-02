package com.talp1.talpsadditions.entity.WalkingFungus;

import com.talp1.talpsadditions.config.CommonConfig;
import com.talp1.talpsadditions.utils.registration.ModEntities;
import com.talp1.talpsadditions.utils.registration.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WalkingFungusEntity extends AnimalEntity {

    private int tradeTimer;
    private ArrayList<Item> outputs = new ArrayList<>(Arrays.asList(Items.ORANGE_TULIP, Items.PINK_TULIP, Items.RED_TULIP, Items.WHITE_TULIP, Items.MUSHROOM_STEM, Items.BROWN_MUSHROOM_BLOCK, Items.RED_MUSHROOM_BLOCK, Items.MUSHROOM_STEW));

    public WalkingFungusEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
        tradeTimer=0;
    }

    private void setTradeTimer(int ticks){
        this.tradeTimer=ticks;
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
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.BONE_MEAL, Items.BROWN_MUSHROOM, Items.RED_MUSHROOM, ModItems.golden_mushroom.get()), false));
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

    @Override
    public ActionResultType applyPlayerInteraction(PlayerEntity player, Vector3d vec, Hand hand) {
        if(!this.getEntityWorld().isRemote() && this.tradeTimer==0){
            this.setTradeTimer(20);
            //get server world for particles
            ServerWorld serverWorld = (ServerWorld)this.getEntityWorld();
            if( player.getHeldItem(hand).getItem() == ModItems.golden_mushroom.get() ){
                //spawn happy villager particles + play sound
                this.playSound(SoundEvents.ENTITY_DOLPHIN_PLAY, 1, 1);
                serverWorld.spawnParticle(ParticleTypes.HAPPY_VILLAGER, this.getPosX(), this.getPosY(), this.getPosZ(), 10, 0.2, 0.25, 0.2, 2);

                Random random = new Random();
                //drop a random item in random quantity
                this.entityDropItem(new ItemStack(this.outputs.get(random.nextInt(this.outputs.size()-1)), random.nextInt(3)+1));
                //shrink the player golden mushroom stack
                if (!player.abilities.isCreativeMode)
                    player.getHeldItem(hand).shrink(1);
                //drop shiny gem
                if(random.nextInt(CommonConfig.chanceTradeGem.get()) == 0){
                    this.entityDropItem(ModItems.shiny_gem.get());
                }
                return ActionResultType.CONSUME;
            }else{
                //spawn angry villager particles + play sound
                this.playSound(SoundEvents.ENTITY_PARROT_HURT, 1, 1);
                serverWorld.spawnParticle(ParticleTypes.ANGRY_VILLAGER, this.getPosX(), this.getPosY(), this.getPosZ(), 6, 0.1, 0.25, 0.2, 2);
                return  ActionResultType.PASS;
            }
        }
        return ActionResultType.FAIL;
    }

    @Override
    public void livingTick() {
        if(this.tradeTimer>0) this.tradeTimer--;
        super.livingTick();
    }
}
