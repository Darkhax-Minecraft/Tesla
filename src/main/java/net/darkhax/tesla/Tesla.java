package net.darkhax.tesla;

import net.darkhax.tesla.api.ITeslaHandler;
import net.darkhax.tesla.api.TeslaContainer;
import net.darkhax.tesla.capability.TeslaStorage;
import net.darkhax.tesla.lib.Constants;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER, acceptedMinecraftVersions = Constants.MCVERSION)
public class Tesla {
    
    @Mod.Instance(Constants.MOD_ID)
    public static Tesla instance;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        
        CapabilityManager.INSTANCE.register(ITeslaHandler.class, new TeslaStorage<ITeslaHandler>(), TeslaContainer.class);
    }
}