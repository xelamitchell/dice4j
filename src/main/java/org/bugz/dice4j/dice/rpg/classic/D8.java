package org.bugz.dice4j.dice.rpg.classic;

/**
 * The <code>D8</code> Class represents a eight-sided <code>Die</code>.
 *
 * @version 0.0.2 29.03.2007
 * @author bugz
 */
public final class D8 extends AbstractRpgDie {
    
    /**
     * <code>D8</code> Class Constructor.<br>
     * The Constructor's Private permission ensures that the <code>D8</code>
     * Class cannot be instantiated other than through the getInstance()
     * method.
     *
     * @see #getInstance()
     */
    private D8() {
        super(8);
    }
    
    /**
     * Guarantees that there is only ever a single <code>D8</code> object
     * instantiated in the program.
     *
     * @return either a new instance of <code>D8</code> or the current
     * reference.
     */
    public static D8 getInstance() {
        
        if(instance == null) {
            instance = new D8();
        }
        
        return instance;
    }
    
    /** Maintains the reference to an instantiation of a <code>D8 Die</code>. */
    private static D8 instance = null;
    
}
