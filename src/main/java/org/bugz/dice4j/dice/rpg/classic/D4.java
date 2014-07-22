package org.bugz.dice4j.dice.rpg.classic;

/**
 * The <code>D4</code> Class represents a four-sided <code>Die</code>.
 *
 * @version 0.0.2 28.03.2007
 * @author bugz
 */
public final class D4 extends AbstractRpgDie {
    
    /**
     * <code>D4</code> Class Constructor.<br>
     * The Constructor's Private permission ensures that the <code>D4</code>
     * Class cannot be instantiated other than through the getInstance()
     * method.
     *
     * @see #getInstance()
     */
    private D4() {
        super(4);
    }
    
    /**
     * Guarantees that there is only ever a single <code>D4</code> object
     * instantiated in the program.
     *
     * @return either a new instance of <code>D4</code> or the current
     * reference.
     */
    public static D4 getInstance() {
        
        if(instance == null) {
            instance = new D4();
        }
        
        return instance;
    }
    
    /** Maintains the reference to an instantiation of a <code>D4 Die</code>. */
    private static D4 instance = null;
    
}
