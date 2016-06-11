package net.darkhax.teslatest.item;

import java.util.List;

import net.darkhax.tesla.api.implementation.InfiniteTeslaProducerProvider;
import net.darkhax.teslatest.TeslaTest;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemBatteryCreative extends Item {
    
    public ItemBatteryCreative() {
        
        this.setCreativeTab(TeslaTest.tab);
        this.setUnlocalizedName("teslatest.battery.creative");
        this.setMaxStackSize(1);
    }
    
    @Override
    public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        
        super.addInformation(stack, playerIn, tooltip, advanced);
        
        tooltip.add(I18n.format("tooltip.teslatest.battery.creative"));
    }
    
    @Override
    public ICapabilityProvider initCapabilities (ItemStack stack, NBTTagCompound nbt) {
        
        return new InfiniteTeslaProducerProvider();
    }
}