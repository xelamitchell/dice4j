package org.bugz.dice4j.dice;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This is the base Abstract Class for all the <code>Die</code>-types used
 * normally in RPG (those without any special rules or properties associated
 * with them: {@link D2}, {@link D3}, {@link D4}, {@link D6}, {@link D8},
 * {@link D10}, {@link D12}, {@link D20}, {@link D100}), hereafter referred to
 * as Classic RPG Dice.
 *
 * @version 0.0.1 26.09.2007
 * @author bugz
 */
public abstract class AbstractClassicDie extends AbstractDie {
    
    /** <code>AbstractClassicDie</code> Class Constructor. */
    public AbstractClassicDie(Integer sides) {
        super(sides);
    }
    
    /**
     * Rolls a pseudo-random number of the <code>Die</code>-type n number of
     * times and modifies the result by the modifier m.
     *
     * @param n the number of times the <code>Die</code> is to be rolled.
     * @param m the value of the modifier to be added or subtracted to the
     * pseudo-random value rolled.
     * @return the pseudo-random values rolled altered by the modifier.
     */
    public Collection<Integer> roll(Integer n, Integer m) {
        
        Collection<Integer> c = new ArrayList<Integer>();
        
        for(Integer i : super.roll(n)) {
            c.add(i + m);
        }
        
        return c;
    }
    
}
