package net.darkhax.tesla.api;

/**
 * Provides the essential methods for accepting and storing tesla power.
 */
public interface TeslaContainer {
    
    /**
     * Attempts to add power to the stored amount.
     * 
     * @param tesla The amount of tesla power to add.
     * @return The amount of power that was accepted.
     */
    public long addPower (long tesla);
    
    /**
     * Attempts to remove power from the stored amount.
     * 
     * @param tesla The amount of tesla power to remove.
     * @return The amount of power that was actually removed.
     */
    public long takePower (long tesla);
    
    /**
     * Gets the amount of tesla power stored within the container.
     * 
     * @return The amount of power stored in the container.
     */
    public long getStoredPower ();
    
    /**
     * Gets the maximum amount of power that the container can hold.
     * 
     * @return The maximum amount of power that can be stored.
     */
    public long getPowerLimit ();
}
