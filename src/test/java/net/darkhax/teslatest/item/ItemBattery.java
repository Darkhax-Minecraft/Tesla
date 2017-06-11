package net.darkhax.teslatest.item;

import java.util.List;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.lib.TeslaUtils;
import net.darkhax.teslatest.TeslaTest;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

/**
 * A Item that can accept power and also have it pulled out. The goal of this Item is to have a
 * tooltip of the energy stored, and store energy. This class is also used as the default
 * example of how to write a Item that can use Tesla power.
 */
public class ItemBattery extends Item {

    public ItemBattery () {

        this.setCreativeTab(TeslaTest.tab);
        this.setUnlocalizedName("teslatest.battery");
        this.setMaxStackSize(1);
    }

    @Override
    public void addInformation (ItemStack stack, World world, List<String> tooltip, ITooltipFlag type) {

        TeslaUtils.createTooltip(stack, tooltip);
    }

    @Override
    public ICapabilityProvider initCapabilities (ItemStack stack, NBTTagCompound nbt) {

        return new BaseTeslaContainerProvider(new BaseTeslaContainer());
    }
}
