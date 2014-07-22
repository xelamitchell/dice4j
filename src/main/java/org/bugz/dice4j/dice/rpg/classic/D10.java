package org.bugz.dice4j.dice.rpg.classic;

import org.bugz.dice4j.dice.Die;
import org.bugz.dice4j.dice.DieFactory;
import org.bugz.dice4j.dice.GenericDie;

/**
 * A ten-sided {@link Die}.
 *
 * @author bugz
 */
public final class D10 extends GenericDie {

    private static final D10 DIE = new D10(DieFactory.getDie(10));
    
    private D10(Die die) {
        super(die.getSides());
    }

    /**
     * Creates a ten-sided {@code Die}.
     *
     * @return a ten-sided {@code Die}.
     */
    public static D10 getDie() {
        return DIE;
    }

}
