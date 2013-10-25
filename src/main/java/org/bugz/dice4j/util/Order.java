package org.bugz.dice4j.util;

/**
 * The Class represents two values which indicate the extremes of a range.
 *
 * @version 0.0.2 22.04.2007
 * @author bugz
 */
public enum Order {

    /** Indicates the <code>Highest</code> value. */
    HIGHEST("Highest"),
    /** Indicates the <code>Lowest</code> value. */
    LOWEST("Lowest");

    /**
     * <code>Order</code> Enum Constructor.<br>
     * The Constructor assigns a more user-friendly name to the Order
     * Enumerations.
     *
     * @param a String representing a human-readable representation of the
     * <code>Order</code>.
     */
    Order(String s) {
        name = s;
    }

    /**
     * Returns a more user-friendly string representation of the Enum's
     * value.
     *
     * @return a string representation of enumerated value.
     */
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        String value = super.toString();
        
        return value.substring(0, 1).substring(2, value.length()).toLowerCase();
    }

    /** Maintains a reference to the Enum's string representation. */
    private String name;

}
