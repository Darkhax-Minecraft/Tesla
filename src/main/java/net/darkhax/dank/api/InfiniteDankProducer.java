package net.darkhax.dank.api;

import net.minecraft.util.EnumFacing;

/**
 * An implementation of the DankContainer that will produce Dank power indefinitely. This
 * implementation can not recieve power.
 */
public class InfiniteDankProducer extends DankContainer {
    
    @Override
    public long givePower (long dank, EnumFacing side, boolean simulated) {
        
        return 0;
    }
    
    @Override
    public long takePower (long dank, EnumFacing side, boolean simulated) {
        
        return dank;
    }
    
    @Override
    public boolean isInputSide (EnumFacing side) {
        
        return false;
    }
}
