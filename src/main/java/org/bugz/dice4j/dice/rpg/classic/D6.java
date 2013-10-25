package org.bugz.dice4j.dice.rpg.classic;

import org.bugz.dice4j.dice.AbstractClassicDie;

/**
 * The <code>D6</code> Class represents a six-sided <code>Die</code>.
 *
 * @version 0.0.2 28.03.2007
 * @author bugz
 */
public final class D6 extends AbstractClassicDie {
    
    /**
     * <code>D6</code> Class Constructor.<br>
     * The Constructor's Private permission ensures that the <code>D6</code>
     * Class cannot be instantiated other than through the getInstance()
     * method.
     *
     * @see #getInstance()
     */
    private D6() {
        super(6);
    }
    
    /**
     * Guarantees that there is only ever a single <code>D6</code> object
     * instantiated in the program.
     *
     * @return either a new instance of <code>D6</code> or the current
     * reference.
     */
    public static D6 getInstance() {
        
        if(instance == null) {
            instance = new D6();
        }
        
        return instance;
    }
    
    /** Maintains the reference to an instantiation of a <code>D6 Die</code>. */
    private static D6 instance = null;
    
}
