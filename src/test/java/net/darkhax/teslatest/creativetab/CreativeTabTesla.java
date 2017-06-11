package net.darkhax.teslatest.creativetab;

import net.darkhax.teslatest.TeslaTest;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabTesla extends CreativeTabs {

    public CreativeTabTesla () {

        super("tesla");
    }

    @Override
    public ItemStack getTabIconItem () {

        return new ItemStack(TeslaTest.creativeCell);
    }
}