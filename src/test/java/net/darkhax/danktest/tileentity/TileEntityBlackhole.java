package net.darkhax.danktest.tileentity;

import net.darkhax.dank.api.InfiniteDankConsumer;
import net.darkhax.dank.capability.DankStorage;
import net.darkhax.dank.lib.DankUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;

/**
 * A TileEntity that can consume unlimited amounts of dank power.
 */
public class TileEntityBlackhole extends TileEntity implements ITickable {
    
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability (Capability<T> capability, EnumFacing facing) {
        
        if (capability == DankStorage.DANK_HANDLER_CAPABILITY)
            return (T) new InfiniteDankConsumer();
            
        return super.getCapability(capability, facing);
    }
    
    @Override
    public boolean hasCapability (Capability<?> capability, EnumFacing facing) {
        
        if (capability == DankStorage.DANK_HANDLER_CAPABILITY)
            return true;
            
        return super.hasCapability(capability, facing);
    }
    
    @Override
    public void update () {
        
        DankUtils.consumePowerEqually(this.worldObj, this.pos, 50, false);
    }
}