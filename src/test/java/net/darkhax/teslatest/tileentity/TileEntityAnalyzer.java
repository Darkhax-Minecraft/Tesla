package net.darkhax.teslatest.tileentity;

import net.darkhax.tesla.api.TeslaContainer;
import net.darkhax.tesla.capability.TeslaStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;

/**
 * A TileEntity that can accept power and also have it pulled out, from any of its sides. The
 * goal of this TileEntity is to write a status message to the console every game tick. This
 * class is also used as the default example of how to write a TileEntity that can use Tesla
 * power.
 */
public class TileEntityAnalyzer extends TileEntity implements ITickable {
    
    // An implementation of ITeslaHandler which handles all of the tesla related logic. This
    // can be replaced with your own custom implementation or one of the default
    // implementations provided by the base API.
    private TeslaContainer container;
    
    public TileEntityAnalyzer() {
        
        // Initializes the container. Very straight forward.
        this.container = new TeslaContainer();
    }
    
    @Override
    public void readFromNBT (NBTTagCompound compound) {
        
        super.readFromNBT(compound);
        
        // Reads the ITeslaHandler from the TileEntity NBT. The default handler being used
        // doesn't care about side, so I am using null. You would use the correct EnumFacing
        // value if the ITeslaHandler implementation that you are using actually cares about
        // the side.
        this.container = new TeslaContainer(compound.getCompoundTag("TeslaContainer"));
    }
    
    @Override
    public void writeToNBT (NBTTagCompound compound) {
        
        super.writeToNBT(compound);
        
        // Writes the ITeslaHandler to the TileEntity NBT. Just like the read method, we are
        // using null for the face, because the default ITeslaHandler does not care about the
        // direction.
        compound.setTag("TeslaContainer", this.container.serializeNBT());
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability (Capability<T> capability, EnumFacing facing) {
        
        // Provides access to the ITeslaHandler object. This is how other things will connect
        // to this TileEntities ITeslaHandler. TeslaStorage.TESLA_HANDLER_CAPANILITY is a
        // constant reference to the Tesla capability. This is used to verify that the thing
        // requesting the capability is requesting the tesla one.
        if (capability == TeslaStorage.TESLA_HANDLER_CAPABILITY)
            return (T) this.container;
            
        return super.getCapability(capability, facing);
    }
    
    @Override
    public boolean hasCapability (Capability<?> capability, EnumFacing facing) {
        
        // This works similarly to the getter method above. It just checks to see if the
        // TileEntity has an ITeslaHandler.
        if (capability == TeslaStorage.TESLA_HANDLER_CAPABILITY)
            return true;
            
        return super.hasCapability(capability, facing);
    }
    
    @Override
    public void update () {
        
        // This tile entity will spam the console with how much power it has every tick. In
        // other tile entities this could be used to send power to a tile, or take it from
        // another tile. This isn't required for the actual Tesla tile.
        if (!this.worldObj.isRemote)
            System.out.println("I have " + this.container.getStoredPower(EnumFacing.UP) + "/" + this.container.getCapacity(EnumFacing.UP) + " power. I am at " + this.pos.toString());
    }
}