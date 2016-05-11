package net.darkhax.tesla.api;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

/**
 * A basic implementation of the ITeslaHandler. Can be used as a tank, similarly to FluidTank.
 * 
 * @deprecated The tesla capability is being split into three separate capabilities. Do not use
 *             this capability! It will be removed in 1.0.3
 */
@Deprecated
public class TeslaContainer implements ITeslaHandler {
    
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
     * A default constructor for the TeslaContainer which starts the capacity off at 5k and the
     * transfer rate as 50.
     */
    public TeslaContainer() {
        
        this.capacity = 5000;
        this.setTransferRate(50);
    }
    
    /**
     * Constructs a new TeslaContainer directly from save data.
     * 
     * @param side The side of the handler that is being read for. This is typically used for
     *            block based implementations.
     * @return A NBT that holds all critical information.
     */
    public TeslaContainer(EnumFacing side, NBTBase nbt) {
        
        this.readNBT(side, nbt);
    }
    
    /**
     * Constructs a new TeslaContainer which can be used to handle tesla power IO.
     * 
     * @param capacity The maximum amount of tesla energy that the container should hold.
     * @param input The maximum rate of energy that the container can accept.
     * @param output The maximum rate of energy that can be extracted.
     */
    public TeslaContainer(long capacity, long input, long output) {
        
        this.capacity = capacity;
        this.inputRate = input;
        this.outputRate = output;
    }
    
    @Override
    public long getStoredPower (EnumFacing side) {
        
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
    public long givePower (long tesla, EnumFacing side, boolean simulated) {
        
        final long acceptedTesla = Math.min(this.capacity - this.stored, Math.min(this.inputRate, tesla));
        
        if (!simulated)
            this.stored += acceptedTesla;
            
        return acceptedTesla;
    }
    
    @Override
    public long takePower (long tesla, EnumFacing side, boolean simulated) {
        
        final long removedPower = Math.min(this.stored, Math.min(this.outputRate, tesla));
        
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
    public TeslaContainer setCapacity (long capacity) {
        
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
    public TeslaContainer setInputRate (long rate) {
        
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
    public TeslaContainer setOutputRate (long rate) {
        
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
    public TeslaContainer setTransferRate (long rate) {
        
        this.setInputRate(rate);
        this.setOutputRate(rate);
        return this;
    }
    
    @Override
    public NBTBase writeNBT (EnumFacing side) {
        
        final NBTTagCompound dataTag = new NBTTagCompound();
        dataTag.setLong("TeslaPower", this.stored);
        dataTag.setLong("TeslaCapacity", this.capacity);
        dataTag.setLong("TeslaInput", this.inputRate);
        dataTag.setLong("TeslaOutput", this.outputRate);
        
        return dataTag;
    }
    
    @Override
    public void readNBT (EnumFacing side, NBTBase nbt) {
        
        final NBTTagCompound dataTag = (NBTTagCompound) nbt;
        this.stored = dataTag.getLong("TeslaPower");
        
        if (dataTag.hasKey("TeslaCapacity"))
            this.capacity = dataTag.getLong("TeslaCapacity");
            
        if (dataTag.hasKey("TeslaInput"))
            this.inputRate = dataTag.getLong("TeslaInput");
            
        if (dataTag.hasKey("TeslaOutput"))
            this.outputRate = dataTag.getLong("TeslaOutput");
            
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