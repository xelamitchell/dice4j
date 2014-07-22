package org.bugz.dice4j.dice.rpg.classic;

import org.bugz.dice4j.dice.Die;
import org.bugz.dice4j.dice.DieFactory;
import org.bugz.dice4j.dice.GenericDie;

/**
 * A 100-sided {@link Die}.
 *
 * @author bugz
 */
public final class D100 extends GenericDie {
    
    private static final D100 DIE = new D100(DieFactory.getDie(100));
    
    private D100(Die die) {
        super(die.getSides());
    }

    /**
     * Creates a 100-sided {@code Die}.
     *
     * @return a 100-sided {@code Die}.
     */
    public static D100 getDie() {
        return DIE;
    }
    
}
