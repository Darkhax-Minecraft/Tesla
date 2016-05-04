package net.darkhax.tesla.api;

import net.minecraft.util.EnumFacing;

/**
 * An implementation of the TeslaContainer that will produce Tesla power indefinitely. This
 * implementation can not recieve power.
 */
public class InfiniteTeslaProducer extends TeslaContainer {
    
    @Override
    public long givePower (long tesla, EnumFacing side, boolean simulated) {
        
        return 0;
    }
    
    @Override
    public long takePower (long tesla, EnumFacing side, boolean simulated) {
        
        return tesla;
    }
    
    @Override
    public boolean isInputSide (EnumFacing side) {
        
        return false;
    }
}
