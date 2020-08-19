package com.talp1.talpsadditions.entity.ResourceSheep.types;

import com.talp1.talpsadditions.entity.ResourceSheep.ResourceSheepEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class GoldResourceSheep extends ResourceSheepEntity {
    public GoldResourceSheep(EntityType<? extends ResourceSheepEntity> type, World worldIn) {
        super(type, worldIn);
        super.setResourceType("gold");
    }
}
