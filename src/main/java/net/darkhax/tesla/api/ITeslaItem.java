package net.darkhax.tesla.api;

import net.minecraft.item.ItemStack;

/**
 * Defines an Item that supports Tesla power. Due to how Items are defined, the other generic
 * interfaces will not work.
 */
public interface ITeslaItem {
    
    /**
     * Gets the amount of tesla power stored in the item.
     * 
     * @param stack The ItemStack that is being used.
     * @return The amount of tesla power stored in the item.
     */
    long getStoredPower (ItemStack stack);
    
    /**
     * Attempts to add power to the item.
     * 
     * @param tesla The amount of tesla power to add.
     * @param stack The ItemStack that is being used.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of tesla power that was accepted.
     */
    long addPower (long tesla, ItemStack stack, boolean simulated);
    
    /**
     * Attempts to remove power from the item.
     * 
     * @param tesla The amount of tesla power to attempt to remove.
     * @param stack The ItemStack that is being used.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of tesla power that was removed.
     */
    long removePower (long tesla, ItemStack stack, boolean simulated);
    
    /**
     * Gets the maximum amount of tesla power that the item can hold.
     * 
     * @param stack The ItemStack that is being used.
     * @return The maximum amount of tesla power that can be held.
     */
    long getCapacity (ItemStack stack);
}
