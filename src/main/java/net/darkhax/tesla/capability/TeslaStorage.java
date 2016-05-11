package net.darkhax.tesla.capability;

import net.darkhax.tesla.api.ITeslaHandler;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

/**
 * @deprecated The tesla capability is being split into three separate capabilities. Do not use
 *             this capability! It will be removed in 1.0.3
 */
@Deprecated
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