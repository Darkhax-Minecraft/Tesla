package net.darkhax.tesla;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.ITeslaProducer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.capability.TeslaCapabilities.CapabilityTeslaConsumer;
import net.darkhax.tesla.capability.TeslaCapabilities.CapabilityTeslaHolder;
import net.darkhax.tesla.capability.TeslaCapabilities.CapabilityTeslaProducer;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "tesla", name = "Tesla", version = "@VERSION@", certificateFingerprint = "@FINGERPRINT@")
public class Tesla {

    private static final Logger LOG = LogManager.getLogger("Tesla");
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        CapabilityManager.INSTANCE.register(ITeslaConsumer.class, new CapabilityTeslaConsumer<>(), BaseTeslaContainer.class);
        CapabilityManager.INSTANCE.register(ITeslaProducer.class, new CapabilityTeslaProducer<>(), BaseTeslaContainer.class);
        CapabilityManager.INSTANCE.register(ITeslaHolder.class, new CapabilityTeslaHolder<>(), BaseTeslaContainer.class);
    }
    
    @EventHandler
    public void onFingerprintViolation (FMLFingerprintViolationEvent event) {

        LOG.error("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported by the author!");
    }
}