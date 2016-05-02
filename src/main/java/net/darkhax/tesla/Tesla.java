package net.darkhax.tesla;

import net.darkhax.tesla.lib.Constants;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER, acceptedMinecraftVersions = Constants.MCVERSION)
public class Tesla {
    
    @Mod.Instance(Constants.MOD_ID)
    public static Tesla instance;
}