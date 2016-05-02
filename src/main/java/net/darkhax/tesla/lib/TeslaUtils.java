package net.darkhax.tesla.lib;

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
    public static final long TERATELSA = 1000000000000L;
    
    /**
     * The amount of Tesla in a PentaTesla. One Quadrilli.on
     */
    public static final long PENTATESLA = 1000000000000000L;
    
    /**
     * The amount of Tesla in a ExaTesla. One Quintillion.
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
     * @return String A human readable display of the Tesla units.
     */
    public static String getDisplayableTeslaCount (long tesla) {
        
        if (tesla < 1000)
            return tesla + " T";
            
        final int exp = (int) (Math.log(tesla) / Math.log(1000));
        final char unitType = "KMGTPEZYBG".charAt(exp - 1);
        return String.format("%.1f %sT", tesla / Math.pow(1000, exp), unitType);
    }
}
