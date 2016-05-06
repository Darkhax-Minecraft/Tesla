package net.darkhax.dank.api;

import net.minecraft.util.EnumFacing;

/**
 * An implementation of the DankContainer that will consume Dank power indefinitely. This
 * implementation can not send power.
 */
public class InfiniteDankConsumer extends DankContainer {
    
    @Override
    public long givePower (long dank, EnumFacing side, boolean simulated) {
        
        return dank;
    }
    
    @Override
    public long takePower (long dank, EnumFacing side, boolean simulated) {
        
        return 0;
    }
    
    @Override
    public boolean isOutputSide (EnumFacing side) {
        
        return false;
    }
}