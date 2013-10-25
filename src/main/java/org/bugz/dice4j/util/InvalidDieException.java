package org.bugz.dice4j.util;

/**
 * Alerts that an Invalid <code>Die</code>-type was used.
 *
 * @version 0.0.1 05.09.2006
 * @author bugz
 */
public class InvalidDieException extends Exception {
    
    public InvalidDieException() {
        super("Attempted to roll an invalid die");
    }
    
    public InvalidDieException(String s) {
        super(s);
    }
    
}
