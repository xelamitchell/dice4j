package org.bugz.dice4j.property;

/**
 * The Interface which defines the appropriate actions for a random number
 * generator which is rolled in order to generate the random value.
 *
 * @version 0.0.1 26.09.2007
 * @author bugz
 */
// TODO Add Generics rather than return Object
public interface Rollable extends Randomizable {
    
    /**
     * Represents a single basic roll of the random generator.
     *
     * @return a randomly selected Object.
     */
    public Object roll();
    
    /**
     * Represents a number of rolls of the random generator.
     *
     * @param n an integer indicating how many times the random generator must
     * be rolled.
     * @return a randomly selected Object.
     */
    public Object roll(Integer n);
    
    /**
     * Represents a number of rolls of the random generator modified by a value.
     *
     * @param n an integer indicating how many times the random generator must
     * be rolled.
     * @param m the modifier by which each value is to be altered.
     * @return a randomly selected Object.
     */
    //public Object roll(int n, int m);
    
}
