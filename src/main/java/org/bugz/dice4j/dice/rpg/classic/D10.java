package org.bugz.dice4j.dice.rpg.classic;

import org.bugz.dice4j.dice.AbstractClassicDie;

/**
 * The <code>D10</code> Class represents a ten-sided <code>Die</code>.
 *
 * @version 0.0.2 29.03.2007
 * @author bugz
 */
public final class D10 extends AbstractClassicDie {
    
    /**
     * <code>D10</code> Class Constructor.<br>
     * The Constructor's Private permission ensures that the <code>D10</code>
     * Class cannot be instantiated other than through the getInstance()
     * method.
     *
     * @see #getInstance()
     */
    private D10() {
        super(10);
    }
    
    /**
     * Guarantees that there is only ever a single <code>D10</code> object
     * instantiated in the program.
     *
     * @return either a new instance of <code>D10</code> or the current
     * reference.
     */
    public static D10 getInstance() {
        
        if(instance == null) {
            instance = new D10();
        }
        
        return instance;
    }
    
    /** Maintains the reference to an instantiation of a <code>D10 Die</code>. */
    private static D10 instance = null;
    
}
