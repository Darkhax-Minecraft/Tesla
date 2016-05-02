package net.darkhax.tesla.api;

import net.minecraft.util.EnumFacing;

/**
 * Defines a TileEntity that can interact with the Tesla system.
 */
public interface ITeslaTile {
    
    /**
     * Checks if a given side is a valid input face for the tile.
     * 
     * @param side The side being checked.
     * @return Whether or not the side is a valid input side.
     */
    boolean isInputSide (EnumFacing side);
    
    /**
     * Checks if a given side is a valid output face for the tile.
     * 
     * @param side The side being checked.
     * @return Whether or not the side is a valid output side.
     */
    boolean isOutputSide (EnumFacing side);
}
