package net.darkhax.teslatest;

import net.darkhax.teslatest.block.*;
import net.darkhax.teslatest.common.ProxyCommon;
import net.darkhax.teslatest.creativetab.CreativeTabTesla;
import net.darkhax.teslatest.item.*;
import net.darkhax.teslatest.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "teslatest", name = "Tesla Test", version = "1.0.0.0", acceptedMinecraftVersions = "[1.11]")
public class TeslaTest {

	@SidedProxy(serverSide = "net.darkhax.teslatest.common.ProxyCommon", clientSide = "net.darkhax.teslatest.client.ProxyClient")
	public static ProxyCommon proxy;

	@Mod.Instance("teslatest")
	public static TeslaTest instance;

	public static CreativeTabs tab;

	public static Block analyzer;
	public static Block blackholeCell;
	public static Block creativeCell;

	public static Item battery;
	public static Item batteryBlackhole;
	public static Item batteryCreative;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		tab = new CreativeTabTesla();

		analyzer = registerBlock(new BlockAnalyzer(), TileEntityAnalyzer.class, "analyzer");
		blackholeCell = registerBlock(new BlockBlackhole(), TileEntityBlackhole.class, "blackhole");
		creativeCell = registerBlock(new BlockCreativePower(), TileEntityCreativePower.class, "creative_power");

		battery = registerItem(new ItemBattery(), "battery");
		batteryBlackhole = registerItem(new ItemBatteryBlackhole(), "battery_blackhole");
		batteryCreative = registerItem(new ItemBatteryCreative(), "battery_creative");

		proxy.preInit();
	}

	public static Block registerBlock(Block block, Class<? extends TileEntity> tileEntityClass, String name) {

		block.setRegistryName(name);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block), block.getRegistryName());
		GameRegistry.registerTileEntity(tileEntityClass, block.getRegistryName().toString());
		return block;
	}

	public static Item registerItem(Item item, String name) {

		item.setRegistryName(name);
		GameRegistry.register(item);
		return item;
	}
}