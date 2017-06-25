package net.darkhax.teslatest.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CreativeTabTesla extends CreativeTabs {

    public CreativeTabTesla () {

        super("tesla");
    }

    @Override
    public ItemStack getTabIconItem () {

        return new ItemStack(Items.STICK);
    }
}