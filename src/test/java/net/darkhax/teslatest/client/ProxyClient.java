package net.darkhax.teslatest.client;

import net.darkhax.teslatest.TeslaTest;
import net.darkhax.teslatest.common.ProxyCommon;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ProxyClient extends ProxyCommon {
    
    @Override
    public void preInit () {
        
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TeslaTest.analyzer), 0, new ModelResourceLocation(TeslaTest.analyzer.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TeslaTest.blackhole), 0, new ModelResourceLocation(TeslaTest.blackhole.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TeslaTest.creative), 0, new ModelResourceLocation(TeslaTest.creative.getRegistryName(), "inventory"));
    }
}
