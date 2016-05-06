package net.darkhax.danktest;

import net.darkhax.danktest.block.BlockAnalyzer;
import net.darkhax.danktest.block.BlockBlackhole;
import net.darkhax.danktest.block.BlockCreativePower;
import net.darkhax.danktest.common.ProxyCommon;
import net.darkhax.danktest.tileentity.TileEntityAnalyzer;
import net.darkhax.danktest.tileentity.TileEntityBlackhole;
import net.darkhax.danktest.tileentity.TileEntityCreativePower;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "danktest", name = "Dank Test", version = "1.0.0.0")
public class DankTest {
    
    @SidedProxy(serverSide = "net.darkhax.danktest.common.ProxyCommon", clientSide = "net.darkhax.danktest.client.ProxyClient")
    public static ProxyCommon proxy;
    
    @Mod.Instance("Dank|Test")
    public static DankTest instance;
    
    public static Block analyzer;
    public static Block blackhole;
    public static Block creative;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        
        analyzer = registerBlock(new BlockAnalyzer(), TileEntityAnalyzer.class, "analyzer");
        blackhole = registerBlock(new BlockBlackhole(), TileEntityBlackhole.class, "blackhole");
        creative = registerBlock(new BlockCreativePower(), TileEntityCreativePower.class, "creative_power");
        
        proxy.preInit();
    }
    
    public static Block registerBlock (Block block, Class<? extends TileEntity> tileEntityClass, String name) {
        
        block.setRegistryName(name);
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block), block.getRegistryName());
        GameRegistry.registerTileEntity(tileEntityClass, block.getRegistryName().toString());
        return block;
    }
}