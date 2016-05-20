package net.darkhax.teslatest.block;

import net.darkhax.teslatest.tileentity.TileEntityBlackhole;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockBlackhole extends BlockContainer {
    
    public BlockBlackhole() {
        
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setUnlocalizedName("teslatest.blackhole");
    }
    
    @Override
    public TileEntity createNewTileEntity (World worldIn, int meta) {
        
        return new TileEntityBlackhole();
    }
    
    @Override
    public EnumBlockRenderType getRenderType (IBlockState state) {
        
        return EnumBlockRenderType.MODEL;
    }
}
