package net.darkhax.tesla.api;

/**
 * Defines an object that can be used to handle the flow of tesla power. This works similarly
 * to the IFluidTank interface provided by Minecraft Forge.
 */
public interface ITeslaContainer {
    
    /**
     * Gets the amount of tesla power stored in the container.
     * 
     * @return The amount of tesla power stored in the container.
     */
    long getStoredPower ();
    
    /**
     * Attempts to add power to the container.
     * 
     * @param tesla The amount of tesla power to add.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of tesla power that was accepted.
     */
    long addPower (long tesla, boolean simulated);
    
    /**
     * Attempts to remove power from the container.
     * 
     * @param tesla The amount of tesla power to attempt to remove.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of tesla power that was removed.
     */
    long removePower (long tesla, boolean simulated);
    
    /**
     * Gets the maximum amount of tesla power that the container can hold.
     * 
     * @return The maximum amount of tesla power that can be held.
     */
    long getCapacity ();
}
