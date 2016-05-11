package net.darkhax.tesla.capability;

import net.darkhax.tesla.api.ITeslaHandler;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class TeslaStorage<T extends ITeslaHandler> implements IStorage<T> {
    
    @CapabilityInject(ITeslaHandler.class)
    public static Capability<ITeslaHandler> TESLA_HANDLER_CAPABILITY = null;
    
    @Override
    public NBTBase writeNBT (Capability<T> capability, T instance, EnumFacing side) {
        
        return instance.serializeNBT();
    }
    
    @Override
    public void readNBT (Capability<T> capability, T instance, EnumFacing side, NBTBase nbt) {
        
        instance.deserializeNBT(nbt);
    }
}