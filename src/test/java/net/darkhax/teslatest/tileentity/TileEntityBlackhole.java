package net.darkhax.teslatest.tileentity;

import net.darkhax.tesla.api.InfiniteTeslaConsumer;
import net.darkhax.tesla.capability.TeslaStorage;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;

/**
 * A TileEntity that can consume unlimited amounts of tesla power.
 */
public class TileEntityBlackhole extends TileEntity implements ITickable {
    
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability (Capability<T> capability, EnumFacing facing) {
        
        if (capability == TeslaStorage.TESLA_HANDLER_CAPABILITY)
            return (T) new InfiniteTeslaConsumer();
            
        return super.getCapability(capability, facing);
    }
    
    @Override
    public boolean hasCapability (Capability<?> capability, EnumFacing facing) {
        
        if (capability == TeslaStorage.TESLA_HANDLER_CAPABILITY)
            return true;
            
        return super.hasCapability(capability, facing);
    }
    
    @Override
    public void update () {
        
        TeslaUtils.consumePowerEqually(this.worldObj, this.pos, 50, false);
    }
}