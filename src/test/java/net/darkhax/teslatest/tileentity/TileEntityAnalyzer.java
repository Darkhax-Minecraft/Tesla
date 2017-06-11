package net.darkhax.teslatest.tileentity;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * A TileEntity that can accept power and also have it pulled out, from any of its sides. The
 * goal of this TileEntity is to write a status message to the console every game tick. This
 * class is also used as the default example of how to write a TileEntity that can use Tesla
 * power.
 */
public class TileEntityAnalyzer extends TileEntity {

    // An instance of something that implements ITeslaConsumer, ITeslaProducer or
    // ITeslaHandler. In this case we use the BaseTeslaContainer which makes use of all three.
    // The purpose of this instance is to handle all tesla related logic for the TileEntity.
    private BaseTeslaContainer container;

    public TileEntityAnalyzer () {

        // Initializes the container. Very straight forward.
        this.container = new BaseTeslaContainer();
    }

    @Override
    public void readFromNBT (NBTTagCompound compound) {

        super.readFromNBT(compound);

        // It is important for the power being stored to be persistent. The BaseTeslaContainer
        // includes a method to make reading one from a compound tag very easy. This method is
        // completely optional though, you can handle saving however you prefer. You could even
        // choose not to, but then power won't be saved when you close the game.
        this.container = new BaseTeslaContainer(compound.getCompoundTag("TeslaContainer"));
    }

    @Override
    public NBTTagCompound writeToNBT (NBTTagCompound compound) {

        // It is important for the power being stored to be persistent. The BaseTeslaContainer
        // includes a method to make writing one to a compound tag very easy. This method is
        // completely optional though, you can handle saving however you prefer. You could even
        // choose not to, but then power won't be saved when you close the game.
        compound.setTag("TeslaContainer", this.container.serializeNBT());
        return super.writeToNBT(compound);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability (Capability<T> capability, EnumFacing facing) {

        // This method is where other things will try to access your TileEntity's Tesla
        // capability. In the case of the analyzer, is a consumer, producer and holder so we
        // can allow requests that are looking for any of those things. This example also does
        // not care about which side is being accessed, however if you wanted to restrict which
        // side can be used, for example only allow power input through the back, that could be
        // done here.
        if (capability == TeslaCapabilities.CAPABILITY_CONSUMER || capability == TeslaCapabilities.CAPABILITY_PRODUCER || capability == TeslaCapabilities.CAPABILITY_HOLDER) {
            return (T) this.container;
        }

        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability (Capability<?> capability, EnumFacing facing) {

        // This method replaces the instanceof checks that would be used in an interface based
        // system. It can be used by other things to see if the TileEntity uses a capability or
        // not. This example is a Consumer, Producer and Holder, so we return true for all
        // three. This can also be used to restrict access on certain sides, for example if you
        // only accept power input from the bottom of the block, you would only return true for
        // Consumer if the facing parameter was down.
        if (capability == TeslaCapabilities.CAPABILITY_CONSUMER || capability == TeslaCapabilities.CAPABILITY_PRODUCER || capability == TeslaCapabilities.CAPABILITY_HOLDER) {
            return true;
        }

        return super.hasCapability(capability, facing);
    }
}