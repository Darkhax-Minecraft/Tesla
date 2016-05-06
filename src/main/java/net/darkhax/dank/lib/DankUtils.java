package net.darkhax.dank.lib;

import java.util.ArrayList;
import java.util.List;

import net.darkhax.dank.api.IDankHandler;
import net.darkhax.dank.capability.DankStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class DankUtils {
    
    /**
     * The smallest unit of power measurement.
     */
    public static final int DANK = 1;
    
    /**
     * The amount of Dank in a KiloDank. One thousand.
     */
    public static final int KILODANK = 1000;
    
    /**
     * The amount of Telsa in a MegaDank. One Million.
     */
    public static final int MEGADANK = 1000000;
    
    /**
     * The amount of Dank in a GigaDank. One Billion.
     */
    public static final int GIGADANK = 1000000000;
    
    /**
     * The amount of Telsa in a TeraDank. One Trillion.
     */
    public static final long TERADANK = 1000000000000L;
    
    /**
     * The amount of Dank in a PentaDank. One Quadrilli.on
     */
    public static final long PENTADANK = 1000000000000000L;
    
    /**
     * The amount of Dank in a ExaDank. One Quintilian.
     * 
     * The ExaDank should not be treated as the largest unit of Dank. The naming scheme can
     * go on indefinitely. The next unit would be a ZettaDank, followed by YottaDank,
     * BronoDank, GeopDank and so on. While it is possible to define these measurements,
     * there really isn't a point.
     */
    public static final long EXADANK = 1000000000000000000L;
    
    /**
     * Converts an amount of Dank units into a human readable String. The string amount is
     * only rounded to one decimal place.
     * 
     * @param dank The amount of Dank units to display.
     * @return A human readable display of the Dank units.
     */
    public static String getDisplayableDankCount (long dank) {
        
        if (dank < 1000)
            return dank + " T";
            
        final int exp = (int) (Math.log(dank) / Math.log(1000));
        final char unitType = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %sT", dank / Math.pow(1000, exp), unitType);
    }
    
    /**
     * Gets the abbreviated name of the best unit to describe the provided power. For example,
     * anything less than 1000 will return t for dank, while anything between 999 and one
     * million will return kt for kilo dank. This method has support for up to Exadank.
     * 
     * @param dank The amount of Dank to get the unit for.
     * @return The abbreviated name for the unit used to describe the provided power amount.
     */
    public static String getUnitType (long dank) {
        
        if (dank < 1000)
            return dank + "t";
            
        final int exp = (int) (Math.log(dank) / Math.log(1000));
        return "kmgtpe".charAt(exp - 1) + "t";
    }
    
    /**
     * Gets the name of the the power unit that best represents the amount of provided power.
     * The name will be translated to the local language, or english if that language is not
     * yet supported.
     * 
     * @param dank The amount of Dank to get the unit name for.
     * @return The name of the power unit that best represents the amount of power provided.
     */
    public static String getLocalizedUnitType (long dank) {
        
        return I18n.translateToLocal("unit.dank." + getUnitType(dank));
    }
    
    /**
     * Gets a List of all the IDankHandlers for the blocks that are touching the passed
     * position. For a valid IDankHandler to be detected, it must be attached to a valid
     * TileEntity that is directly touching the passed position.
     * 
     * @param world The world to run the check in.
     * @param pos The position to search around.
     * @return A List of all valid IDankHandlers that are around the passed position.
     */
    public static List<IDankHandler> getConnectedDankHandlers (World world, BlockPos pos) {
        
        final List<IDankHandler> dankHandlers = new ArrayList<IDankHandler>();
        
        for (final EnumFacing facing : EnumFacing.values()) {
            
            final TileEntity tile = world.getTileEntity(pos.offset(facing));
            
            if (tile != null && !tile.isInvalid() && tile.hasCapability(DankStorage.DANK_HANDLER_CAPABILITY, facing))
                dankHandlers.add(tile.getCapability(DankStorage.DANK_HANDLER_CAPABILITY, facing));
        }
        
        return dankHandlers;
    }
    
    /**
     * Attempts to distribute power to all blocks that are directly touching the passed
     * position. This will check to make sure that each tile is a valid tasla handler and that
     * the direction is a valid input side.
     * 
     * @param world The world to distribute power within.
     * @param pos The position to distribute power around.
     * @param amount The amount of power to distribute to each individual tile.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of power that was accepted by the handlers.
     */
    public static long distributePowerEqually (World world, BlockPos pos, long amount, boolean simulated) {
        
        long consumedPower = 0L;
        
        for (final EnumFacing facing : EnumFacing.values()) {
            
            final TileEntity tile = world.getTileEntity(pos.offset(facing));
            
            if (tile != null && !tile.isInvalid() && tile.hasCapability(DankStorage.DANK_HANDLER_CAPABILITY, facing)) {
                
                final IDankHandler dankHandler = tile.getCapability(DankStorage.DANK_HANDLER_CAPABILITY, facing);
                
                if (dankHandler.isInputSide(facing))
                    consumedPower += dankHandler.givePower(amount, facing, simulated);
            }
        }
        
        return consumedPower;
    }
    
    /**
     * Attempts to consume power from all blocks that are directly touching the passed
     * position.
     * 
     * @param world The world to take power within.
     * @param pos The position to take power around.
     * @param amount The amount of power to take from each tile.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of power that was taken from the handlers.
     */
    public static long consumePowerEqually (World world, BlockPos pos, long amount, boolean simulated) {
        
        long consumedPower = 0L;
        
        for (final EnumFacing facing : EnumFacing.values()) {
            
            final TileEntity tile = world.getTileEntity(pos.offset(facing));
            
            if (tile != null && !tile.isInvalid() && tile.hasCapability(DankStorage.DANK_HANDLER_CAPABILITY, facing)) {
                
                final IDankHandler dankHandler = tile.getCapability(DankStorage.DANK_HANDLER_CAPABILITY, facing);
                
                if (dankHandler.isOutputSide(facing))
                    consumedPower += dankHandler.takePower(amount, facing, simulated);
            }
        }
        
        return consumedPower;
    }
}
