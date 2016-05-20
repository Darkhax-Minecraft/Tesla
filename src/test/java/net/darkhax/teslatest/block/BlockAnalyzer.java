package net.darkhax.teslatest.block;

import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.darkhax.teslatest.tileentity.TileEntityAnalyzer;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockAnalyzer extends BlockContainer {
    
    public BlockAnalyzer() {
        
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setUnlocalizedName("teslatest.analyzer");
    }
    
    @Override
    public boolean onBlockActivated (World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        
        if (!worldIn.isRemote) {
            
            final TileEntity tile = worldIn.getTileEntity(pos);
            
            if (tile.hasCapability(TeslaCapabilities.CAPABILITY_HOLDER, side)) {
                
                final ITeslaHolder holder = tile.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, side);
                playerIn.addChatMessage(new TextComponentString("I have " + holder.getStoredPower() + " / " + holder.getCapacity() + " power."));
            }
        }
        
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }
    
    @Override
    public TileEntity createNewTileEntity (World worldIn, int meta) {
        
        return new TileEntityAnalyzer();
    }
    
    @Override
    public EnumBlockRenderType getRenderType (IBlockState state) {
        
        return EnumBlockRenderType.MODEL;
    }
}
