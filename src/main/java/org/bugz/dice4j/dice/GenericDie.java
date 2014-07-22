package org.bugz.dice4j.dice;

/**
 * A die which can have an arbitrary number of sides.
 * 
 * @author bugz
 */
// TODO all Dx dice should extend GenericDie
class GenericDie extends AbstractDie {
    
    /**
     * @param sides the number of sides the {@code Die} is to have.
     */
    public GenericDie(Integer sides) {
        super(sides);
    }
    
}
