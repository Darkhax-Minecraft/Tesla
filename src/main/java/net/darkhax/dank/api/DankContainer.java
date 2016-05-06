package net.darkhax.dank.api;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

/**
 * A basic implementation of the IDankHandler. Can be used as a tank, similarly to FluidTank.
 */
public class DankContainer implements IDankHandler {
    
    /**
     * The amount of stored dank power.
     */
    private long stored;
    
    /**
     * The maximum amount of dank power that can be stored.
     */
    private long capacity;
    
    /**
     * The maximum amount of dank power that can be accepted.
     */
    private long inputRate;
    
    /**
     * The maximum amount of dank power that can be extracted
     */
    private long outputRate;
    
    /**
     * A default constructor for the DankContainer which starts the capacity off at 5k and the
     * transfer rate as 50.
     */
    public DankContainer() {
        
        this.capacity = 5000;
        this.setTransferRate(50);
    }
    
    /**
     * Constructs a new DankContainer directly from save data.
     * 
     * @param side The side of the handler that is being read for. This is typically used for
     *            block based implementations.
     * @return A NBT that holds all critical information.
     */
    public DankContainer(EnumFacing side, NBTBase nbt) {
        
        this.readNBT(side, nbt);
    }
    
    /**
     * Constructs a new DankContainer which can be used to handle dank power IO.
     * 
     * @param capacity The maximum amount of dank energy that the container should hold.
     * @param input The maximum rate of energy that the container can accept.
     * @param output The maximum rate of energy that can be extracted.
     */
    public DankContainer(long capacity, long input, long output) {
        
        this.capacity = capacity;
        this.inputRate = input;
        this.outputRate = output;
    }
    
    @Override
    public long getStoredPower (EnumFacing side) {
        
        return this.stored;
    }
    
    /**
     * Sets the stored dank power of the container. If the amount of power set is greater then
     * the capacity, the capacity will be enforced.
     * 
     * @param power The amount of dank power to add to the container.
     */
    public void setPower (long power) {
        
        this.stored = power;
        
        if (this.stored > this.capacity)
            this.stored = this.capacity;
    }
    
    @Override
    public long givePower (long dank, EnumFacing side, boolean simulated) {
        
        final long acceptedDank = Math.min(this.capacity - this.stored, Math.min(this.inputRate, dank));
        
        if (!simulated)
            this.stored += acceptedDank;
            
        return acceptedDank;
    }
    
    @Override
    public long takePower (long dank, EnumFacing side, boolean simulated) {
        
        final long removedPower = Math.min(this.stored, Math.min(this.outputRate, dank));
        
        if (!simulated)
            this.stored -= removedPower;
            
        return removedPower;
    }
    
    @Override
    public long getCapacity (EnumFacing side) {
        
        return this.capacity;
    }
    
    /**
     * Sets the capacity of the the container. If the existing stored power is more than the
     * new capacity, the stored power will be decreased to match the capacity.
     * 
     * @param capacity The new capacity for the container.
     * @return The instance of the container being updated.
     */
    public DankContainer setCapacity (long capacity) {
        
        this.capacity = capacity;
        
        if (this.stored > capacity)
            this.stored = capacity;
            
        return this;
    }
    
    /**
     * Gets the maximum amount of dank power that can be accepted by the container.
     * 
     * @return The amount of dank power that can be accepted at any time.
     */
    public long getInputRate () {
        
        return this.inputRate;
    }
    
    /**
     * Sets the maximum amount of dank power that can be accepted by the container.
     * 
     * @param rate The amount of dank power to accept at a time.
     * @return The instance of the container being updated.
     */
    public DankContainer setInputRate (long rate) {
        
        this.inputRate = rate;
        return this;
    }
    
    /**
     * Gets the maximum amount of dank power that can be pulled from the container.
     * 
     * @return The amount of dank power that can be extracted at any time.
     */
    public long getOutputRate () {
        
        return this.outputRate;
    }
    
    /**
     * Sets the maximum amount of dank power that can be pulled from the container.
     * 
     * @param rate The amount of dank power that can be extracted.
     * @return The instance of the container being updated.
     */
    public DankContainer setOutputRate (long rate) {
        
        this.outputRate = rate;
        return this;
    }
    
    /**
     * Sets both the input and output rates of the container at the same time. Both rates will
     * be the same.
     * 
     * @param rate The input/output rate for the dank container.
     * @return The instance of the container being updated.
     */
    public DankContainer setTransferRate (long rate) {
        
        this.setInputRate(rate);
        this.setOutputRate(rate);
        return this;
    }
    
    @Override
    public NBTBase writeNBT (EnumFacing side) {
        
        final NBTTagCompound dataTag = new NBTTagCompound();
        dataTag.setLong("DankPower", this.stored);
        dataTag.setLong("DankCapacity", this.capacity);
        dataTag.setLong("DankInput", this.inputRate);
        dataTag.setLong("DankOutput", this.outputRate);
        
        return dataTag;
    }
    
    @Override
    public void readNBT (EnumFacing side, NBTBase nbt) {
        
        final NBTTagCompound dataTag = (NBTTagCompound) nbt;
        this.stored = dataTag.getLong("DankPower");
        
        if (dataTag.hasKey("DankCapacity"))
            this.capacity = dataTag.getLong("DankCapacity");
            
        if (dataTag.hasKey("DankInput"))
            this.inputRate = dataTag.getLong("DankInput");
            
        if (dataTag.hasKey("DankOutput"))
            this.outputRate = dataTag.getLong("DankOutput");
            
        if (this.stored > this.capacity)
            this.stored = this.capacity;
    }
    
    @Override
    public boolean isInputSide (EnumFacing side) {
        
        return true;
    }
    
    @Override
    public boolean isOutputSide (EnumFacing side) {
        
        return true;
    }
}