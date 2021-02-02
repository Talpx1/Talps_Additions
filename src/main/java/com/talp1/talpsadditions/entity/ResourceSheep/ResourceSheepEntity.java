package com.talp1.talpsadditions.entity.ResourceSheep;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ResourceSheepEntity extends SheepEntity{

    private final Item resourceType;

    public Item getResourceType() {
        return resourceType;
    }

    public ResourceSheepEntity(EntityType<? extends ResourceSheepEntity> type, World worldIn, Item resourceType){
        super(type, worldIn);
        this.setSheared(false);
        this.resourceType=resourceType;
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setSheared(false);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }


    @Nullable
    public AgeableEntity createChild(AgeableEntity ageable) {
        return null;
    }

    @Override
    public void shear(SoundCategory category) {
        this.world.playMovingSound((PlayerEntity)null, this, SoundEvents.ENTITY_SHEEP_SHEAR, category, 1.0F, 1.0F);
        this.setSheared(true);
        entityDropItem(this.resourceType);
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nullable PlayerEntity player, @Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
        world.playMovingSound(null, this, SoundEvents.ENTITY_SHEEP_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
        if (!world.isRemote) {
            java.util.List<ItemStack> items = new java.util.ArrayList<>();
            this.setSheared(true);
            items.add(new ItemStack(this.resourceType));
            return items;
        }
        return java.util.Collections.emptyList();
    }


    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setSheared(compound.getBoolean("Sheared"));
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("Sheared",this.getSheared());
    }



    @Override
    public SheepEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 8.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.23F);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }
}
