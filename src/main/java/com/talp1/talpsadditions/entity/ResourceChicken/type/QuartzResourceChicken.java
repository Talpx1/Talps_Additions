package com.talp1.talpsadditions.entity.ResourceChicken.type;

import com.talp1.talpsadditions.entity.ResourceChicken.ResourceChickenEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class QuartzResourceChicken extends ResourceChickenEntity {
    public QuartzResourceChicken(EntityType<? extends ResourceChickenEntity> type, World worldIn) {
        super(type, worldIn);
        setItemToDrop(Items.QUARTZ);
    }
}
