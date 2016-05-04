package net.darkhax.tesla.api;

import net.minecraft.util.EnumFacing;

/**
 * An implementation of the TeslaContainer that will consume Tesla power indefinitely. This
 * implementation can not send power.
 */
public class InfiniteTeslaConsumer extends TeslaContainer {
    
    @Override
    public long givePower (long tesla, EnumFacing side, boolean simulated) {
        
        return tesla;
    }
    
    @Override
    public long takePower (long tesla, EnumFacing side, boolean simulated) {
        
        return 0;
    }
    
    @Override
    public boolean isOutputSide (EnumFacing side) {
        
        return false;
    }
}