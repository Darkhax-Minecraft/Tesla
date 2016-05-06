package net.darkhax.dank;

import net.darkhax.dank.api.IDankHandler;
import net.darkhax.dank.api.DankContainer;
import net.darkhax.dank.capability.DankStorage;
import net.darkhax.dank.lib.Constants;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER, acceptedMinecraftVersions = Constants.MCVERSION)
public class Dank {
    
    @Mod.Instance(Constants.MOD_ID)
    public static Dank instance;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        
        CapabilityManager.INSTANCE.register(IDankHandler.class, new DankStorage<IDankHandler>(), DankContainer.class);
    }
}