package com.talp1.talpsadditions.entity.ResourceSheep.types;

import com.talp1.talpsadditions.entity.ResourceSheep.ResourceSheepEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class IronResourceSheep extends ResourceSheepEntity {
    public IronResourceSheep(EntityType<? extends ResourceSheepEntity> type, World worldIn) {
        super(type, worldIn);
        super.setResourceType("iron");
    }
}
