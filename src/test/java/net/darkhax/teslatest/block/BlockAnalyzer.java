package net.darkhax.teslatest.block;

import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.darkhax.teslatest.TeslaTest;
import net.darkhax.teslatest.TextUtils;
import net.darkhax.teslatest.tileentity.TileEntityAnalyzer;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockAnalyzer extends BlockContainer {

    /**
     * Message ID used by all messages from the analyzer. Allows for spamless messages.
     */
    private final int MESSAGE_ID = 14940026;

    public BlockAnalyzer () {

        super(Material.ROCK);
        this.setCreativeTab(TeslaTest.tab);
        this.setUnlocalizedName("teslatest.analyzer");
    }

    @Override
    public boolean onBlockActivated (World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote) {

            final TileEntity tile = worldIn.getTileEntity(pos);

            if (tile.hasCapability(TeslaCapabilities.CAPABILITY_HOLDER, side)) {

                final ITeslaHolder holder = tile.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, side);
                TextUtils.sendSpamlessMessage(this.MESSAGE_ID, new TextComponentString(I18n.format("tooltip.teslatest.battery.normal", holder.getStoredPower(), holder.getCapacity())));
            }
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
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
