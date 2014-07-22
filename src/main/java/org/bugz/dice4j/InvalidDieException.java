package org.bugz.dice4j;

/**
 * An invalid {@link Die} operation occured.
 *
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
