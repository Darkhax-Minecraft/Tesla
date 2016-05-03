package net.darkhax.tesla.api;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;

/**
 * An interface used by objects that can handle Tesla power.
 */
public interface ITeslaHandler {
    
    /**
     * Gets the amount of tesla power stored by the handler.
     * 
     * @return The amount of tesla power stored by the handler.
     */
    long getStoredPower ();
    
    /**
     * Gets the maximum amount of tesla power that the handler can hold.
     * 
     * @return The maximum amount of tesla power that can be held by the handler.
     */
    long getCapacity ();
    
    /**
     * Takes power from the handler by removing it from an internal source.
     * 
     * @param power The amount of power to request from the handler.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of power that was actually taken.
     */
    long takePower (long power, boolean simulated);
    
    /**
     * Provides the handler with a bit of power.
     * 
     * @param power The amount of power to provide the handler with.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of power that was accepted by the handler.
     */
    long givePower (long power, boolean simulated);
    
    /**
     * Serializes the handler to an NBT. Allows for critical information to be saved.
     * 
     * @param side The side of the handler that is being written. This is typically used for
     *            block based implementations.
     * @return A NBT that holds all critical information. Null can be returned if no data
     *         storage is needed.
     */
    public NBTBase writeNBT (EnumFacing side);
    
    /**
     * Desearializes the handler from an NBT. Allows for critical information to be read from
     * saved data.
     * 
     * @param side The side of the handler that is being read. This is typically used for block
     *            based implementations.
     * @param nbt A NBT that holds the data. Should never be null.
     */
    public void readNBT (EnumFacing side, NBTBase nbt);
}
