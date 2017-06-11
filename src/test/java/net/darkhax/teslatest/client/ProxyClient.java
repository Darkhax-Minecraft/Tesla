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
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TeslaTest.blackholeCell), 0, new ModelResourceLocation(TeslaTest.blackholeCell.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TeslaTest.creativeCell), 0, new ModelResourceLocation(TeslaTest.creativeCell.getRegistryName(), "inventory"));

        ModelLoader.setCustomModelResourceLocation(TeslaTest.battery, 0, new ModelResourceLocation(TeslaTest.battery.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(TeslaTest.batteryBlackhole, 0, new ModelResourceLocation(TeslaTest.batteryBlackhole.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(TeslaTest.batteryCreative, 0, new ModelResourceLocation(TeslaTest.batteryCreative.getRegistryName(), "inventory"));
    }
}
