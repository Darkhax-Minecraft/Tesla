package net.darkhax.tesla.api;

import net.minecraft.nbt.NBTTagCompound;

/**
 * A basic implementation of ITeslaContainer. This container satisfies the base requirements
 * for ITeslaContainer an provides some additional functionality such as input/output rates and
 * NBT serialization. This is very similar to the FluidTank implementation offered by Minecraft
 * Forge. This implementation is only a suggestion, other implementations can also be made.
 */
public class BaseTeslaContainer implements ITeslaContainer {
    
    /**
     * The amount of stored tesla power.
     */
    private long stored;
    
    /**
     * The maximum amount of tesla power that can be stored.
     */
    private long capacity;
    
    /**
     * The maximum amount of tesla power that can be accepted.
     */
    private long inputRate;
    
    /**
     * The maximum amount of tesla power that can be extracted
     */
    private long outputRate;
    
    /**
     * Constructs a new TeslaContainer which can be used to handle tesla power IO.
     * 
     * @param capacity The maximum amount of tesla energy that the container should hold.
     * @param input The maximum rate of energy that the container can accept.
     * @param output The maximum rate of energy that can be extracted.
     */
    public BaseTeslaContainer(long capacity, long input, long output) {
        
        this.capacity = capacity;
        this.inputRate = input;
        this.outputRate = output;
    }
    
    @Override
    public long getStoredPower () {
        
        return this.stored;
    }
    
    /**
     * Sets the stored tesla power of the container. If the amount of power set is greater then
     * the capacity, the capacity will be enforced.
     * 
     * @param power The amount of tesla power to add to the container.
     */
    public void setPower (long power) {
        
        this.stored = power;
        
        if (this.stored > this.capacity)
            this.stored = this.capacity;
    }
    
    @Override
    public long addPower (long tesla, boolean shouldAdd) {
        
        final long acceptedTesla = Math.min(this.capacity - this.stored, Math.min(this.inputRate, tesla));
        
        if (shouldAdd)
            this.stored += acceptedTesla;
            
        return acceptedTesla;
    }
    
    @Override
    public long removePower (long tesla, boolean shouldRemove) {
        
        final long removedPower = Math.min(this.stored, Math.min(this.outputRate, tesla));
        
        if (shouldRemove)
            this.stored -= removedPower;
            
        return removedPower;
    }
    
    @Override
    public long getCapacity () {
        
        return this.capacity;
    }
    
    /**
     * Sets the capacity of the the container. If the existing stored power is more than the
     * new capacity, the stored power will be decreased to match the capacity.
     * 
     * @param capacity The new capacity for the container.
     * @return The instance of the container being updated.
     */
    public BaseTeslaContainer setCapacity (long capacity) {
        
        this.capacity = capacity;
        
        if (this.stored > capacity)
            this.stored = capacity;
            
        return this;
    }
    
    /**
     * Gets the maximum amount of tesla power that can be accepted by the container.
     * 
     * @return The amount of tesla power that can be accepted at any time.
     */
    public long getInputRate () {
        
        return this.inputRate;
    }
    
    /**
     * Sets the maximum amount of tesla power that can be accepted by the container.
     * 
     * @param rate The amount of tesla power to accept at a time.
     * @return The instance of the container being updated.
     */
    public BaseTeslaContainer setInputRate (long rate) {
        
        this.inputRate = rate;
        return this;
    }
    
    /**
     * Gets the maximum amount of tesla power that can be pulled from the container.
     * 
     * @return The amount of tesla power that can be extracted at any time.
     */
    public long getOutputRate () {
        
        return this.outputRate;
    }
    
    /**
     * Sets the maximum amount of tesla power that can be pulled from the container.
     * 
     * @param rate The amount of tesla power that can be extracted.
     * @return The instance of the container being updated.
     */
    public BaseTeslaContainer setOutputRate (long rate) {
        
        this.outputRate = rate;
        return this;
    }
    
    /**
     * Sets both the input and output rates of the container at the same time. Both rates will
     * be the same.
     * 
     * @param rate The input/output rate for the tesla container.
     * @return The instance of the container being updated.
     */
    public BaseTeslaContainer setTransferRate (long rate) {
        
        this.setInputRate(rate);
        this.setOutputRate(rate);
        return this;
    }
    
    /**
     * Reads important data for the container from an NBTTagCompound.
     * 
     * @param dataTag The NBT compound tag to read data from.
     * @param readAll Whether or not capacity and IO rates should also be read.
     * @return The instance of the container being updated.
     */
    public BaseTeslaContainer readFromNBT (NBTTagCompound dataTag, boolean readAll) {
        
        this.stored = dataTag.getLong("TeslaPower");
        
        if (readAll) {
            
            if (dataTag.hasKey("TeslaCapacity"))
                this.capacity = dataTag.getLong("TeslaCapacity");
                
            if (dataTag.hasKey("TeslaInput"))
                this.inputRate = dataTag.getLong("TeslaInput");
                
            if (dataTag.hasKey("TeslaOutput"))
                this.outputRate = dataTag.getLong("TeslaOutput");
        }
        
        if (this.stored > this.capacity)
            this.stored = this.capacity;
            
        return this;
    }
    
    /**
     * Writes important data for the container to an NBTTagCompound.
     * 
     * @param dataTag The NBT compound to write data to.
     * @param writeAll Whether or not capacity and IO rates should also be written.
     * @return The instance of the container being written.
     */
    public NBTTagCompound writeToNBT (NBTTagCompound dataTag, boolean writeAll) {
        
        dataTag.setLong("TeslaPower", this.stored);
        
        if (writeAll) {
            
            dataTag.setLong("TeslaCapacity", this.capacity);
            dataTag.setLong("TeslaInput", this.inputRate);
            dataTag.setLong("TeslaOutput", this.outputRate);
        }
        
        return dataTag;
    }
}