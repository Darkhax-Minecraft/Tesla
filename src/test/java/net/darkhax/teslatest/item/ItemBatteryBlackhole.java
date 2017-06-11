package net.darkhax.teslatest.item;

import java.util.List;

import net.darkhax.tesla.api.implementation.InfiniteTeslaConsumerProvider;
import net.darkhax.teslatest.TeslaTest;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemBatteryBlackhole extends Item {

    public ItemBatteryBlackhole () {

        this.setCreativeTab(TeslaTest.tab);
        this.setUnlocalizedName("teslatest.battery.blackhole");
        this.setMaxStackSize(1);
    }

    @Override
    public void addInformation (ItemStack stack, World world, List<String> tooltip, ITooltipFlag type) {

        tooltip.add(I18n.format("tooltip.teslatest.battery.blackhole"));
        super.addInformation(stack, world, tooltip, type);
    }

    @Override
    public ICapabilityProvider initCapabilities (ItemStack stack, NBTTagCompound nbt) {

        return new InfiniteTeslaConsumerProvider();
    }
}