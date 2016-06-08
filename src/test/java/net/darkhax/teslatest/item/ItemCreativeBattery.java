package net.darkhax.teslatest.item;

import net.darkhax.tesla.api.BaseTeslaContainer;
import net.darkhax.tesla.api.InfiniteTeslaProducer;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.List;

/**
 * A Item that can provide power. The
 * goal of this Item is to give infinite power. This
 * class is also used as the default example of how to write a Item that can use Tesla
 * power.
 */
public class ItemCreativeBattery extends Item {

    public ItemCreativeBattery() {
        this.setCreativeTab(CreativeTabs.TOOLS);
        this.setUnlocalizedName("battery_creative");
        this.setMaxStackSize(1);
        this.setMaxDamage(1338);
    }

    @Override
    public int getDamage(ItemStack stack) {
        return 1337;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        tooltip.add(I18n.format("label.teslatest.battery.creative"));
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new ItemBattery.CapabilityProvider(stack);
    }

    public static class CapabilityProvider implements INBTSerializable<NBTTagCompound>, ICapabilityProvider {
        private final ItemStack stack;

        public CapabilityProvider(ItemStack stack) {
            this.stack = stack;
        }

        @Override
        public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
            // This method replaces the instanceof checks that would be used in an interface based
            // system. It can be used by other things to see if the TileEntity uses a capability or
            // not. This example is a Consumer, Producer and Holder, so we return true for all
            // three. This can also be used to restrict access on certain sides, for example if you
            // only accept power input from the bottom of the block, you would only return true for
            // Consumer if the facing parameter was down.
            if(capability==TeslaCapabilities.CAPABILITY_PRODUCER)
                return true;
            return false;
        }

        @Override
        public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

            // This method is where other things will try to access your ItemStack's Tesla
            // capability. In the case of the analyzer, is a consumer, producer and holder so we
            // can allow requests that are looking for any of those things. This example also does
            // not care about which side is being accessed, however if you wanted to restrict which
            // side can be used, for example only allow power input through the back, that could be
            // done here.
            if(capability==TeslaCapabilities.CAPABILITY_PRODUCER)
                return (T) new InfiniteTeslaProducer();
            return null;
        }

        @Override
        public NBTTagCompound serializeNBT() {
            return new NBTTagCompound();
        }

        @Override
        public void deserializeNBT(NBTTagCompound nbt) {

        }
    }
}
