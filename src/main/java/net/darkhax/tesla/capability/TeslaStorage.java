package net.darkhax.tesla.capability;

import net.darkhax.tesla.api.ITeslaHandler;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class TeslaStorage<T extends ITeslaHandler> implements IStorage<ITeslaHandler> {
    
    @CapabilityInject(ITeslaHandler.class)
    public static Capability<ITeslaHandler> TESLA_HANDLER_CAPABILITY = null;
    
    @Override
    public NBTBase writeNBT (Capability<ITeslaHandler> capability, ITeslaHandler instance, EnumFacing side) {
        
        return instance.writeNBT(side);
    }
    
    @Override
    public void readNBT (Capability<ITeslaHandler> capability, ITeslaHandler instance, EnumFacing side, NBTBase nbt) {
        
        instance.readNBT(side, nbt);
    }
}