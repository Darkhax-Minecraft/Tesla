package net.darkhax.teslatest.tileentity;

import net.darkhax.tesla.api.implementation.InfiniteTeslaConsumer;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * A TileEntity that can consume unlimited amounts of tesla power.
 */
public class TileEntityBlackhole extends TileEntity {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability (Capability<T> capability, EnumFacing facing) {

        if (capability == TeslaCapabilities.CAPABILITY_CONSUMER) {
            return (T) new InfiniteTeslaConsumer();
        }

        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability (Capability<?> capability, EnumFacing facing) {

        if (capability == TeslaCapabilities.CAPABILITY_CONSUMER) {
            return true;
        }

        return super.hasCapability(capability, facing);
    }
}