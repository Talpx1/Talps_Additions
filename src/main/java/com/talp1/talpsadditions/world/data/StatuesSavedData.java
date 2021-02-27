package com.talp1.talpsadditions.world.data;

import com.talp1.talpsadditions.Main;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.WorldSavedData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StatuesSavedData extends WorldSavedData {
    private static final String DATA_NAME = Main.MODID + "_statues_saved_data";

    private BlockPos statue_1_pos;
    private BlockPos statue_2_pos;
    private BlockPos statue_3_pos;
    private BlockPos statue_4_pos;

    public StatuesSavedData() {
        super(DATA_NAME);
    }

    @Override
    public void read(CompoundNBT nbt) {
        this.statue_1_pos = new BlockPos(nbt.getIntArray("statue_1")[0],nbt.getIntArray("statue_1")[1],nbt.getIntArray("statue_1")[2]);
        this.statue_2_pos = new BlockPos(nbt.getIntArray("statue_2")[0],nbt.getIntArray("statue_2")[1],nbt.getIntArray("statue_2")[2]);
        this.statue_3_pos = new BlockPos(nbt.getIntArray("statue_3")[0],nbt.getIntArray("statue_3")[1],nbt.getIntArray("statue_3")[2]);
        this.statue_4_pos = new BlockPos(nbt.getIntArray("statue_4")[0],nbt.getIntArray("statue_4")[1],nbt.getIntArray("statue_4")[2]);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putIntArray("statue_1", new int[]{this.statue_1_pos.getX(), this.statue_1_pos.getY(), this.statue_1_pos.getZ()});
        compound.putIntArray("statue_2", new int[]{this.statue_2_pos.getX(), this.statue_2_pos.getY(), this.statue_2_pos.getZ()});
        compound.putIntArray("statue_3", new int[]{this.statue_3_pos.getX(), this.statue_3_pos.getY(), this.statue_3_pos.getZ()});
        compound.putIntArray("statue_4", new int[]{this.statue_4_pos.getX(), this.statue_4_pos.getY(), this.statue_4_pos.getZ()});
        return compound;
    }

    public static StatuesSavedData get(World world){
        if (!(world instanceof ServerWorld)) throw new RuntimeException("Not a ServerWorld!");
        ServerWorld overworld = world.getServer().getWorld(World.OVERWORLD);
        DimensionSavedDataManager storage = overworld.getSavedData();
        return storage.getOrCreate(StatuesSavedData::new, DATA_NAME);
    }

    public List<BlockPos> getPositions(){
        List<BlockPos> positions= Arrays.asList(this.statue_1_pos, this.statue_2_pos, this.statue_3_pos, this.statue_4_pos);
        for (BlockPos pos: positions) {
            if(pos==null) return null;
        }
        return positions;
    }

    public void setPositions(Map<String, BlockPos> positions){
        this.statue_1_pos = positions.get("statue_1");
        this.statue_2_pos = positions.get("statue_2");
        this.statue_3_pos = positions.get("statue_3");
        this.statue_4_pos = positions.get("statue_4");
        this.markDirty();
    }

}
