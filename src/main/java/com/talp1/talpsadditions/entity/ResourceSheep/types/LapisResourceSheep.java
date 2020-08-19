package com.talp1.talpsadditions.entity.ResourceSheep.types;

import com.talp1.talpsadditions.entity.ResourceSheep.ResourceSheepEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class LapisResourceSheep extends ResourceSheepEntity {
    public LapisResourceSheep(EntityType<? extends ResourceSheepEntity> type, World worldIn) {
        super(type, worldIn);
        super.setResourceType("lapis");
    }
}
