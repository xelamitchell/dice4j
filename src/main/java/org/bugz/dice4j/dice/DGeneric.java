package org.bugz.dice4j.dice;

import java.util.HashMap;

/**
 * The Class can create a user-defined-sided <code>Die</code> which contains
 * all of the functionality of the Classic RPG Dice with an arbitrary number of
 * sides.<br>
 * It implements the Flyweight Design Patten, therefore always use the factory
 * method getDie(int n) to instantiate a <code>GenericDie Die</code>.<br>
 * <b>A negative or zero-faced dice cannot be created</b>.
 * 
 * @version 0.0.5 28.03.2007
 * @author bugz
 */
// TODO all Dx dice should extend DGeneric
public class DGeneric extends AbstractClassicDie {
    
    /**
     * The java.util.HashMap maintains a reference to all of the previously
     * instantiated <code>DGeneric</code> dice which enables the Class to
     * employ the Flyweight Design Pattern.
     */
    private static final HashMap<Integer, DGeneric> dice = new HashMap<Integer, DGeneric>();
    
    /**
     * <code>GenericDie</code> Class Constructor.<br/>
     * In order to ensure that the Flyweight Design Pattern implemented within
     * this Class to control the number of <code>GenericDie</code> objects
     * instantiated, use the factory method getDie(Integer n).
     * 
     * @param sides the number of sides the <code>Die</code> is to have.
     * @see #getDie(Integer n)
     */
    private DGeneric(Integer sides) {
        super(sides);
    }
    
    /**
     * This is a factory method which implements the Flyweight Design Pattern
     * for the <code>DGeneric</code> Class.<br>
     * <b>A negative or zero-sided dice cannot be instantiated</b>, in which
     * case an <code>IllegalArgumentException</code> is thrown.
     * 
     * @param sides the number of sides the <code>Die</code> will have.
     * @return if a <code>Die</code> with the requested number of sides has
     * been instantiated previously then that reference is returned, else a new
     * <code>DGeneric</code> is instantiated and returned, while a reference to
     * it is maintained by the Class.
     * @throws <code>IllegalArgumentException</code> if the parameter which
     * defines the number of sides the <code>DGeneric Die</code> instantiation
     * must have is negative or zero.
     */
    public static DGeneric getDie(Integer sides) throws IllegalArgumentException {
        
        // Dice must have at least 1 side.
        if(sides < 1) {
            throw new IllegalArgumentException("DGeneric dice must have at least 1 side");
        }
            
        DGeneric die = dice.get(sides);

        // ONLY create a new instance if the requested die has not been
        // instantiated previously and keep a reference to the new die.
        if(die == null) {
            //System.out.printf("Factory Creating GenericDie(%d)%n", n);
            die = new DGeneric(sides);
            dice.put(die.getSides(), die);
        }
        
        return die;
    }
    
}
