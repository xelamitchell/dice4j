package org.bugz.dice4j.dice.rpg.classic;

/**
 * The <code>D2</code> Class represents a two-sided <code>Die</code> (a coin,
 * for example).
 *
 * @version 0.0.2 19.02.2007
 * @author bugz
 */
public final class D2 extends AbstractRpgDie {
        
    /** Maintains the reference to an instantiation of a <code>D2 Die</code>. */
    private static D2 instance = null;
    
    /**
     * <code>D2</code> Constructor.<br>
     * The Constructor's Private permission ensures that the <code>D2</code>
     * Class cannot be instantiated other than through the getInstance()
     * method.
     *
     * @see #getInstance()
     */
    private D2() {
        super(2);
    }
    
    /**
     * Guarantees that there is only ever a single <code>D2</code> object
     * instantiated in the program.
     *
     * @return either a new instance of <code>D2</code> or the current
     * reference.
     */
    public static D2 getInstance() {
        
        if(instance == null) {
            instance = new D2();
        }
        
        return instance;
    }
    
}
