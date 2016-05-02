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
    public long getStoredPower ();
    
    /**
     * Attempts to add power to the container.
     * 
     * @param tesla The amount of tesla power to add.
     * @param shouldAdd Whether or not the added power should count towards the stored energy
     *            total.
     * @return The amount of tesla power that was accepted.
     */
    public long addPower (long tesla, boolean shouldAdd);
    
    /**
     * Attempts to remove power from the container.
     * 
     * @param tesla The amount of tesla power to attempt to remove.
     * @param shouldRemove Whether or not the removed power should count towards the stored
     *            energy total.
     * @return The amount of tesla power that was removed.
     */
    public long removePower (long tesla, boolean shouldRemove);
    
    /**
     * Gets the maximum amount of tesla power that the container can hold.
     * 
     * @return The maximum amount of tesla power that can be held.
     */
    public long getCapacity ();
}
