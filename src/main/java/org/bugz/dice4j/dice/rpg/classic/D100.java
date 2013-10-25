package org.bugz.dice4j.dice.rpg.classic;

import org.bugz.dice4j.dice.AbstractClassicDie;

/**
 * The {@code D100} Class represents a 100-sided {@link Die}.
 *
 * @version 0.0.2 29.03.2007
 * @author bugz
 */
public final class D100 extends AbstractClassicDie {
    
    /**
     * <code>D100</code> Class Constructor.<br>
     * The Constructor's Private permission ensures that the <code>D100</code>
     * Class cannot be instantiated other than through the getInstance()
     * method.
     *
     * @see #getInstance()
     */
    private D100() {
        super(100);
    }
    
    /**
     * Guarantees that there is only ever a single <code>D100</code> object
     * instantiated in the program.
     *
     * @return either a new instance of <code>D100</code> or the current
     * reference.
     */
    public static D100 getInstance() {
        
        if(instance == null) {
            instance = new D100();
        }
        
        return instance;
    }
    
    /** Maintains the reference to an instantiation of a <code>D100 Die</code>. */
    private static D100 instance = null;
    
}
