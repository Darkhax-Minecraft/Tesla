package net.darkhax.tesla.api;

import net.minecraft.util.EnumFacing;

/**
 * Logic for a Tesla Producer that will produce an infinite amount of energy.
 * 
 * As of 1.0.2.x the TeslaContainer has been deprecated. It will be removed in 1.0.3.x
 */
public class InfiniteTeslaProducer extends TeslaContainer implements ITeslaProducer {
    
    @Override
    @Deprecated
    public long givePower (long tesla, EnumFacing side, boolean simulated) {
        
        return 0;
    }
    
    @Override
    @Deprecated
    public long takePower (long tesla, EnumFacing side, boolean simulated) {
        
        return tesla;
    }
    
    @Override
    @Deprecated
    public boolean isInputSide (EnumFacing side) {
        
        return false;
    }
    
    @Override
    public long takePower (long power, boolean simulated) {
        
        return power;
    }
}