package org.bugz.dice4j.dice;

import java.util.HashMap;

/**
 * Factory to retrieve arbitrary-sided dice.
 * 
 * @author bugz
 */
public final class DieFactory {
    
    private static final HashMap<Integer, GenericDie> dice = new HashMap<>();
    
    private DieFactory() {}
    
    /**
     * Builds a {@code Die} with an arbitrary number of sides.
     * 
     * @param sides the number of sides the {@link Die} will have.
     * @return a new {@link Die} with the number of sides defined.
     */
    public static Die<Integer> getDie(Integer sides) throws IllegalArgumentException {
        
        if(sides < 1) {
            throw new IllegalArgumentException("DGeneric dice must have at least 1 side");
        }
            
        GenericDie die = dice.get(sides);
        if(die == null) {
            die = new GenericDie(sides);
            dice.put(die.getSides(), die);
        }
        
        return die;
    }
    
}
