package net.darkhax.tesla.lib;

import net.minecraft.util.text.translation.I18n;

public class TeslaUtils {
    
    /**
     * The smallest unit of power measurement.
     */
    public static final int TESLA = 1;
    
    /**
     * The amount of Tesla in a KiloTesla. One thousand.
     */
    public static final int KILOTESLA = 1000;
    
    /**
     * The amount of Telsa in a MegaTesla. One Million.
     */
    public static final int MEGATESLA = 1000000;
    
    /**
     * The amount of Tesla in a GigaTesla. One Billion.
     */
    public static final int GIGATESLA = 1000000000;
    
    /**
     * The amount of Telsa in a TeraTesla. One Trillion.
     */
    public static final long TERATESLA = 1000000000000L;
    
    /**
     * The amount of Tesla in a PentaTesla. One Quadrilli.on
     */
    public static final long PENTATESLA = 1000000000000000L;
    
    /**
     * The amount of Tesla in a ExaTesla. One Quintilian.
     * 
     * The ExaTesla should not be treated as the largest unit of Tesla. The naming scheme can
     * go on indefinitely. The next unit would be a ZettaTesla, followed by YottaTesla,
     * BronoTesla, GeopTesla and so on. While it is possible to define these measurements,
     * there really isn't a point.
     */
    public static final long EXATESLA = 1000000000000000000L;
    
    /**
     * Converts an amount of Tesla units into a human readable String. The string amount is
     * only rounded to one decimal place.
     * 
     * @param tesla The amount of Tesla units to display.
     * @return A human readable display of the Tesla units.
     */
    public static String getDisplayableTeslaCount (long tesla) {
        
        if (tesla < 1000)
            return tesla + " T";
            
        final int exp = (int) (Math.log(tesla) / Math.log(1000));
        final char unitType = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %sT", tesla / Math.pow(1000, exp), unitType);
    }
    
    /**
     * Gets the abbreviated name of the best unit to describe the provided power. For example,
     * anything less than 1000 will return t for tesla, while anything between 999 and one
     * million will return kt for kilo tesla. This method has support for up to Exatesla.
     * 
     * @param tesla The amount of Tesla to get the unit for.
     * @return The abbreviated name for the unit used to describe the provided power amount.
     */
    public static String getUnitType (long tesla) {
        
        if (tesla < 1000)
            return tesla + "t";
            
        final int exp = (int) (Math.log(tesla) / Math.log(1000));
        return "kmgtpe".charAt(exp - 1) + "t";
    }
    
    /**
     * Gets the name of the the power unit that best represents the amount of provided power.
     * The name will be translated to the local language, or english if that language is not
     * yet supported.
     * 
     * @param tesla The amount of Tesla to get the unit name for.
     * @return The name of the power unit that best represents the amount of power provided.
     */
    public static String getLocalizedUnitType (long tesla) {
        
        return I18n.translateToLocal("unit.tesla." + getUnitType(tesla));
    }
}
