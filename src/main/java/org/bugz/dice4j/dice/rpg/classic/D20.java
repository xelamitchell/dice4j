package org.bugz.dice4j.dice.rpg.classic;

/**
 * The <code>D20</code> Class represents a 20-sided <code>Die</code>.
 *
 * @version 0.0.2 29.03.2007
 * @author bugz
 */
public final class D20 extends AbstractRpgDie {
    
    /**
     * <code>D20</code> Class Constructor.<br>
     * The Constructor's Private permission ensures that the <code>D20</code>
     * Class cannot be instantiated other than through the getInstance()
     * method.
     *
     * @see #getInstance()
     */
    private D20() {
        super(20);
    }
    
    /**
     * Guarantees that there is only ever a single <code>D20</code> object
     * instantiated in the program.
     *
     * @return either a new instance of <code>D20</code> or the current
     * reference.
     */
    public static D20 getInstance() {
        
        if(instance == null) {
            instance = new D20();
        }
        
        return instance;
    }
    
    /** Maintains the reference to an instantiation of a <code>D20 Die</code>. */
    private static D20 instance = null;
    
}
