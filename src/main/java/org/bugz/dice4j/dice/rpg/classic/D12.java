package org.bugz.dice4j.dice.rpg.classic;

/**
 * The <code>D12</code> Class represents a 12-sided <code>Die</code>.
 *
 * @version 0.0.2 29.03.2007
 * @author bugz
 */
public final class D12 extends AbstractRpgDie {
    
    /**
     * <code>D12</code> Class Constructor.<br>
     * The Constructor's Private permission ensures that the <code>D12</code>
     * Class cannot be instantiated other than through the getInstance()
     * method.
     *
     * @see #getInstance()
     */
    private D12() {
        super(12);
    }
    
    /**
     * Guarantees that there is only ever a single <code>D12</code> object
     * instantiated in the program.
     *
     * @return either a new instance of <code>D12</code> or the current
     * reference.
     */
    public static D12 getInstance() {
        
        if(instance == null) {
            instance = new D12();
        }
        
        return instance;
    }
    
    /** Maintains the reference to an instantiation of a <code>D12 Die</code>. */
    private static D12 instance = null;
    
}
