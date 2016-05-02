package net.darkhax.tesla.api;

/**
 * Defines an object that can hold tesla power.
 */
public interface ITeslaHolder {
    
    /**
     * Gets the amount of tesla power stored by the holder.
     * 
     * @return The amount of tesla power stored by the holder.
     */
    long getStoredPower ();
    
    /**
     * Gets the maximum amount of tesla power that the holder can hold.
     * 
     * @return The maximum amount of tesla power that can be held by the holder.
     */
    long getCapacity ();
}
