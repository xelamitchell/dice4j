package org.bugz.dice4j.dice.rpg.classic;

import java.util.ArrayList;
import java.util.List;
import org.bugz.dice4j.dice.AbstractDie;

/**
 * Base class for all the {@code Die}-types used normally in RPG (those without
 * any special rules or properties associated with them:
 * <ol>
 * <li>{@link D2}</li>
 * <li>{@link D3}</li>
 * <li>{@link D4}</li>
 * <li>{@link D6}</li>
 * <li>{@link D8}</li>
 * <li>{@link D10}</li>
 * <li>{@link D12}</li>
 * <li>{@link D20}</li>
 * <li>{@link D100}</li>
 * </ol>
 * hereafter referred to as Classic RPG Dice.
 *
 * @version 0.0.1 26.09.2007
 * @author bugz
 */
public abstract class AbstractRpgDie extends AbstractDie {
    
    /**
     * @param sides the number of sides the {@code Die} is to have.
     */
    protected AbstractRpgDie(Integer sides) {
        super(sides);
    }
    
    /**
     * Rolls a pseudo-random number of the {@code Die}-type n number of times
     * and modifies the result by the modifier m.
     *
     * @param n the number of times the {@code Die} is to be rolled.
     * @param m the value of the modifier to be added or subtracted to the
     * pseudo-random value rolled.
     * @return the pseudo-random values rolled altered by the modifier.
     */
    public List<Integer> roll(Integer n, Integer m) {
        
        List<Integer> results = new ArrayList<>();
        
        for(Integer i : super.roll(n)) {
            results.add(i + m);
        }
        
        return results;
    }
    
}
