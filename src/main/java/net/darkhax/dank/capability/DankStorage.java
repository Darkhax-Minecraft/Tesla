package net.darkhax.dank.capability;

import net.darkhax.dank.api.IDankHandler;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class DankStorage<T extends IDankHandler> implements IStorage<IDankHandler> {
    
    @CapabilityInject(IDankHandler.class)
    public static Capability<IDankHandler> DANK_HANDLER_CAPABILITY = null;
    
    @Override
    public NBTBase writeNBT (Capability<IDankHandler> capability, IDankHandler instance, EnumFacing side) {
        
        return instance.writeNBT(side);
    }
    
    @Override
    public void readNBT (Capability<IDankHandler> capability, IDankHandler instance, EnumFacing side, NBTBase nbt) {
        
        instance.readNBT(side, nbt);
    }
}