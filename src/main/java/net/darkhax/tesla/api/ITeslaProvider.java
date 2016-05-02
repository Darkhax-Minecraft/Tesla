package net.darkhax.tesla.api;

/**
 * Defines an object that can provide tesla power to other objects.
 */
public interface ITeslaProvider {
    
    /**
     * Takes power from the provider by removing it from an internal source.
     * 
     * @param power The amount of power to request from the provider.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of power that was actually taken.
     */
    long takePower (long power, boolean simulated);
}