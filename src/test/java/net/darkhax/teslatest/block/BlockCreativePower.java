package net.darkhax.teslatest.block;

import net.darkhax.teslatest.TeslaTest;
import net.darkhax.teslatest.tileentity.TileEntityCreativePower;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockCreativePower extends BlockContainer {

    public BlockCreativePower () {

        super(Material.ROCK);
        this.setCreativeTab(TeslaTest.tab);
        this.setUnlocalizedName("teslatest.power");
    }

    @Override
    public TileEntity createNewTileEntity (World worldIn, int meta) {

        return new TileEntityCreativePower();
    }

    @Override
    public EnumBlockRenderType getRenderType (IBlockState state) {

        return EnumBlockRenderType.MODEL;
    }
}
