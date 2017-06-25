package net.darkhax.teslatest;

import java.util.ArrayList;
import java.util.List;

import net.darkhax.teslatest.block.BlockAnalyzer;
import net.darkhax.teslatest.block.BlockBlackhole;
import net.darkhax.teslatest.block.BlockCreativePower;
import net.darkhax.teslatest.common.ProxyCommon;
import net.darkhax.teslatest.creativetab.CreativeTabTesla;
import net.darkhax.teslatest.item.ItemBattery;
import net.darkhax.teslatest.item.ItemBatteryBlackhole;
import net.darkhax.teslatest.item.ItemBatteryCreative;
import net.darkhax.teslatest.tileentity.TileEntityAnalyzer;
import net.darkhax.teslatest.tileentity.TileEntityBlackhole;
import net.darkhax.teslatest.tileentity.TileEntityCreativePower;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "teslatest", name = "Tesla Test", version = "1.0.0.0")
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

    public static List<Item> items = new ArrayList<>();
    public static List<Block> blocks = new ArrayList<>();
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        tab = new CreativeTabTesla();

        analyzer = registerBlock(new BlockAnalyzer(), TileEntityAnalyzer.class, "analyzer");
        blackholeCell = registerBlock(new BlockBlackhole(), TileEntityBlackhole.class, "blackhole");
        creativeCell = registerBlock(new BlockCreativePower(), TileEntityCreativePower.class, "creative_power");

        battery = registerItem(new ItemBattery(), "battery");
        batteryBlackhole = registerItem(new ItemBatteryBlackhole(), "battery_blackhole");
        batteryCreative = registerItem(new ItemBatteryCreative(), "battery_creative");

        proxy.preInit();
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void registerItem(Register<Item> event) {
        
        for (Item item : items) {
            
            event.getRegistry().register(item);;
        }
    }

    @SubscribeEvent
    public void registerBlock(Register<Block> event) {
        
        for (Block block : blocks) {
            
            event.getRegistry().register(block);
        }
    }
    
    public static Block registerBlock (Block block, Class<? extends TileEntity> tileEntityClass, String name) {

        block.setRegistryName(name);
        GameRegistry.registerTileEntity(tileEntityClass, block.getRegistryName().toString());
        block.setCreativeTab(tab);
        registerItem(new ItemBlock(block), name);
        blocks.add(block);
        return block;
    }

    public static Item registerItem (Item item, String name) {

        item.setRegistryName(name);
        item.setCreativeTab(tab);
        items.add(item);
        return item;
    }
}