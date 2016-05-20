package net.darkhax.tesla.api;

/**
 * Logic for a Tesla Producer that will produce an infinite amount of energy.
 */
public class InfiniteTeslaProducer implements ITeslaProducer {
    
    @Override
    public long takePower (long power, boolean simulated) {
        
        return power;
    }
}