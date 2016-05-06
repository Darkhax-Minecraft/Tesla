package net.darkhax.danktest.tileentity;

import net.darkhax.dank.api.DankContainer;
import net.darkhax.dank.capability.DankStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;

/**
 * A TileEntity that can accept power and also have it pulled out, from any of its sides. The
 * goal of this TileEntity is to write a status message to the console every game tick. This
 * class is also used as the default example of how to write a TileEntity that can use Dank
 * power.
 */
public class TileEntityAnalyzer extends TileEntity implements ITickable {
    
    // An implementation of IDankHandler which handles all of the dank related logic. This
    // can be replaced with your own custom implementation or one of the default
    // implementations provided by the base API.
    private DankContainer container;
    
    public TileEntityAnalyzer() {
        
        // Initializes the container. Very straight forward.
        this.container = new DankContainer();
    }
    
    @Override
    public void readFromNBT (NBTTagCompound compound) {
        
        super.readFromNBT(compound);
        
        // Reads the IDankHandler from the TileEntity NBT. The default handler being used
        // doesn't care about side, so I am using null. You would use the correct EnumFacing
        // value if the IDankHandler implementation that you are using actually cares about
        // the side.
        this.container = new DankContainer(null, compound.getTag("DankContainer"));
    }
    
    @Override
    public void writeToNBT (NBTTagCompound compound) {
        
        super.writeToNBT(compound);
        
        // Writes the IDankHandler to the TileEntity NBT. Just like the read method, we are
        // using null for the face, because the default IDankHandler does not care about the
        // direction.
        compound.setTag("DankContainer", this.container.writeNBT(null));
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability (Capability<T> capability, EnumFacing facing) {
        
        // Provides access to the IDankHandler object. This is how other things will connect
        // to this TileEntities IDankHandler. DankStorage.DANK_HANDLER_CAPANILITY is a
        // constant reference to the Dank capability. This is used to verify that the thing
        // requesting the capability is requesting the dank one.
        if (capability == DankStorage.DANK_HANDLER_CAPABILITY)
            return (T) this.container;
            
        return super.getCapability(capability, facing);
    }
    
    @Override
    public boolean hasCapability (Capability<?> capability, EnumFacing facing) {
        
        // This works similarly to the getter method above. It just checks to see if the
        // TileEntity has an IDankHandler.
        if (capability == DankStorage.DANK_HANDLER_CAPABILITY)
            return true;
            
        return super.hasCapability(capability, facing);
    }
    
    @Override
    public void update () {
        
        // This tile entity will spam the console with how much power it has every tick. In
        // other tile entities this could be used to send power to a tile, or take it from
        // another tile. This isn't required for the actual Dank tile.
        if (!this.worldObj.isRemote)
            System.out.println("I have " + this.container.getStoredPower(EnumFacing.UP) + "/" + this.container.getCapacity(EnumFacing.UP) + " power. I am at " + this.pos.toString());
    }
}