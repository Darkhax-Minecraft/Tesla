package net.darkhax.teslatest.item;

import net.darkhax.tesla.api.BaseTeslaContainer;
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
 * A Item that can accept power and also have it pulled out. The
 * goal of this Item is to have a tooltip of the energy stored, and store energy. This
 * class is also used as the default example of how to write a Item that can use Tesla
 * power.
 */
public class ItemBattery extends Item {

    public ItemBattery() {
        this.setCreativeTab(CreativeTabs.TOOLS);
        this.setUnlocalizedName("battery");
        this.setMaxStackSize(1);
    }
	
	//This method can help make the charge level of the battery more visable.
	//in this case we set it to the exact amount of stored power,
	//but could be used as a percentage.
    @Override
    public int getDamage(ItemStack stack) {
        if(stack.hasCapability(TeslaCapabilities.CAPABILITY_HOLDER,EnumFacing.DOWN))
            return (int) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER,EnumFacing.DOWN).getStoredPower();
        else
            return super.getDamage(stack);
    }

	//This method can help make the charge level of the battery more visable.
	//in this case we set it to the capacity of the battery plus one,
	//so that it will always show the damage bar.
    @Override
    public int getMaxDamage(ItemStack stack) {
        if(stack.hasCapability(TeslaCapabilities.CAPABILITY_HOLDER,EnumFacing.DOWN))
            return (int) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER,EnumFacing.DOWN).getCapacity()+1;
        else
            return super.getMaxDamage(stack);
    }

	//Sets the tooltip to the label set in the language file.
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		BaseTeslaContainer container = stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER,EnumFacing.DOWN);
        super.addInformation(stack, playerIn, tooltip, advanced);
		 //Finds the label in the language file.
        tooltip.add(I18n.format("label.teslatest.battery.normal",
		//Sets the first %d param in the lang file to the stored power.
		container.getStoredPower(),
		//Sets the second %d param in the lang file to the capacity.
		container.getCapacity()
		));
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        //How Items register a capability, so that the item stack holds the capability
        return new CapabilityProvider(stack);
    }

    // A Class that is a ICapabilityProvider to provide the capabilities for
	// the ItemStack as set in initCapabilities().
    public static class CapabilityProvider implements INBTSerializable<NBTTagCompound>, ICapabilityProvider {
        private final ItemStack stack;
        // An instance of something that implements ITeslaConsumer, ITeslaProducer or
        // ITeslaHandler. In this case we use the BaseTeslaContainer which makes use of all three.
        // The purpose of this instance is to handle all tesla related logic for the Item.
        private BaseTeslaContainer container;

        public CapabilityProvider(ItemStack stack) {
            this.stack = stack;
            // Initializes the container. Very straight forward.
            this.container = new BaseTeslaContainer(10000,500,500);
        }

        @Override
        public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
            // This method replaces the instanceof checks that would be used in an interface based
            // system. It can be used by other things to see if the ItemStack uses a capability or
            // not. This example is a Consumer, Producer and Holder, so we return true for all
            // three. This can also be used to restrict access on certain sides, for example if you
            // only accept power input from the bottom, for some reason, you would only return true for
            // Consumer if the facing parameter was down.
            if(capability== TeslaCapabilities.CAPABILITY_HOLDER||capability==TeslaCapabilities.CAPABILITY_PRODUCER||capability== TeslaCapabilities.CAPABILITY_CONSUMER)
                return true;
            return false;
        }

        @Override
        public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
            // This method is where other things will try to access your ItemStack's Tesla
            // capability. In the case of the battery, is a consumer, producer and holder so we
            // can allow requests that are looking for any of those things. This example also does
            // not care about which side is being accessed, however if you wanted to restrict which
            // side can be used, for example only allow power input through the back, that could be
            // done here.
            if(capability== TeslaCapabilities.CAPABILITY_HOLDER||capability==TeslaCapabilities.CAPABILITY_PRODUCER||capability== TeslaCapabilities.CAPABILITY_CONSUMER)
                return (T) container;
            return null;
        }

        @Override
        public NBTTagCompound serializeNBT() {
            // It is important for the power being stored to be persistent. The BaseTeslaContainer
            // includes a method to make writing one to a compound tag very easy. This method is
            // completely optional though, you can handle saving however you prefer. You could even
            // choose not to, but then power won't be saved when you close the game.
            if(container!=null) {
                NBTTagCompound compound = new NBTTagCompound();
                NBTBase data = container.serializeNBT();
                if(data!=null) {
                    compound.setTag("BatContainer",data);
                }
                return compound;
            }
            else
            return new NBTTagCompound();
        }

        @Override
        public void deserializeNBT(NBTTagCompound nbt) {
            // It is important for the power being stored to be persistent. The BaseTeslaContainer
            // includes a method to make reading one from a compound tag very easy. This method is
            // completely optional though, you can handle saving however you prefer. You could even
            // choose not to, but then power won't be saved when you close the game.
            if(container!=null&&nbt.hasKey("BatContainer"))
                this.container = new BaseTeslaContainer(nbt);
        }
    }
}
