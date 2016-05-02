package net.darkhax.tesla;

import net.darkhax.tesla.common.CommonProxy;
import net.darkhax.tesla.lib.Constants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER, acceptedMinecraftVersions = Constants.MCVERSION)
public class Tesla {
    
    @SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    @Mod.Instance(Constants.MOD_ID)
    public static Tesla instance;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent pre) {
        
    }
}