package org.bugz.dice4j.dice.rpg.classic;

/**
 * The {@code D3} Class represents a three-sided {@link Die}.
 *
 * @version 0.0.2 28.03.2007
 * @author bugz
 */
public final class D3 extends AbstractRpgDie {
    
    /**
     * <code>D3</code> Class Constructor.<br/>
     * The Constructor's Private permission ensures that the <code>D3</code>
     * Class cannot be instantiated other than through the getInstance()
     * method.
     *
     * @see #getInstance()
     */
    private D3() {
        super(3);
    }
    
    /**
     * Guarantees that there is only ever a single <code>D3</code> object
     * instantiated in the program.
     *
     * @return either a new instance of <code>D3</code> or the current
     * reference.
     */
    public static D3 getInstance() {
        
        if(instance == null) {
            instance = new D3();
        }
        
        return instance;
    }
    
    /** Maintains the reference to an instantiation of a <code>D3 Die</code>. */
    private static D3 instance = null;
    
}
