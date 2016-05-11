package net.darkhax.tesla.api;

import net.minecraft.util.EnumFacing;

/**
 * Logic for a Tesla Consumer that will consume infinite amounts of power.
 * 
 * As of 1.0.2.x the TeslaContainer has been deprecated. It will be removed in 1.0.3.x
 */
public class InfiniteTeslaConsumer extends TeslaContainer implements ITeslaConsumer {
    
    @Override
    @Deprecated
    public long givePower (long tesla, EnumFacing side, boolean simulated) {
        
        return tesla;
    }
    
    @Override
    @Deprecated
    public long takePower (long tesla, EnumFacing side, boolean simulated) {
        
        return 0;
    }
    
    @Override
    @Deprecated
    public boolean isOutputSide (EnumFacing side) {
        
        return false;
    }
    
    @Override
    public long givePower (long power, boolean simulated) {
        
        return power;
    }
}