package net.darkhax.tesla.api;

/**
 * Defines an object that can accept tesla power from other sources.
 */
public interface ITeslaReceiver {
    
    /**
     * Provides the reciever with a bit of power.
     * 
     * @param power The amount of power to provide the reciever with.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of power that was accepted by the reciever.
     */
    long givePower (long power, boolean simulated);
}
