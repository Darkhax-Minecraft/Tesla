package net.darkhax.tesla.api;

/**
 * Logic for a Tesla Consumer that will consume infinite amounts of power.
 */
public class InfiniteTeslaConsumer implements ITeslaConsumer {
    
    @Override
    public long givePower (long power, boolean simulated) {
        
        return power;
    }
}