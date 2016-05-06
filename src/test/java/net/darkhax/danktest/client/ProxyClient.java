package net.darkhax.danktest.client;

import net.darkhax.danktest.DankTest;
import net.darkhax.danktest.common.ProxyCommon;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ProxyClient extends ProxyCommon {
    
    @Override
    public void preInit () {
        
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DankTest.analyzer), 0, new ModelResourceLocation(DankTest.analyzer.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DankTest.blackhole), 0, new ModelResourceLocation(DankTest.blackhole.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DankTest.creative), 0, new ModelResourceLocation(DankTest.creative.getRegistryName(), "inventory"));
    }
}
