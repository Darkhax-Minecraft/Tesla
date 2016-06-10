package net.darkhax.teslatest.creativetab;

import net.darkhax.teslatest.TeslaTest;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTesla extends CreativeTabs {
    
    public CreativeTabTesla() {
        
        super("tesla");
    }
    
    @Override
    public Item getTabIconItem () {
        
        return Item.getItemFromBlock(TeslaTest.creative);
    }
}