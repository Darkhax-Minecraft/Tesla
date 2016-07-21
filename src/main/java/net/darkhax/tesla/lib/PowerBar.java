package net.darkhax.tesla.lib;

import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class PowerBar {
    private final BackgroundType background;
    private final int x, y;
    private final GuiContainer container;
    private final ResourceLocation resourceLocation = new ResourceLocation("tesla", "textures/gui/sheet.png");
    
    /**
     * Draws a power bar with the amount of tesla in your machine
     *
     * @param container The Gui of the machine
     * @param x The x position of the power bar
     * @param y The y position of the power bar
     * @param bg If the function should draw a background or not
     */
    public PowerBar(GuiContainer container, int x, int y, BackgroundType bg) {
        this.background = bg;
        this.container = container;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Draws a power bar with the amount of tesla in your machine
     *
     * @param t TileEntity that has the Holder capability
     */
    public void draw (TileEntity t) {
        
        ITeslaHolder h = t.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, null);
        if (h != null)
            draw(h.getStoredPower(), h.getCapacity());
    }
    
    /**
     * Draws a power bar with the amount of tesla in your machine
     *
     * @param a Amount of tesla stored in your machine
     * @param c Capacity of tesla storable in your machine
     */
    public void draw (long a, long c) {
        
        container.mc.getTextureManager().bindTexture(resourceLocation);
        if (background != BackgroundType.CLEAR) {
            switch (background) {
                case LIGHT:
                    container.drawTexturedModalRect(x, y, 3, 1, 14, 50);
                    break;
                case DARK:
                    container.drawTexturedModalRect(x, y, 3, 53, 14, 50);
                    break;
            }
        }
        long j = (a * 51) / c;
        container.drawTexturedModalRect(x + 1, (int) (y + 50 - j), 18, (int) (51 - j), 14, (int) (j + 2));
    }
    
    public enum BackgroundType {
        CLEAR,
        LIGHT,
        DARK,
    }
    
}
