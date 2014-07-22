package org.bugz.dice4j.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Base class for all common dice. These dice are thread safe.
 *
 * @author bugz
 * 
 * @see <a href="http://en.wikipedia.org/wiki/Dice">Wikipedia: Dice</a>
 * @see <a href="http://en.wikipedia.org/wiki/Dice_notation">Wikipedia: Dice Notation</a>
 */
public abstract class AbstractDie implements Die<Integer> {
    
    private final Random random;
    private final Integer sides;
    
    /**
     * @param sides the number of sides the {@code Die} is to have.
     */
    protected AbstractDie(Integer sides) {
        random = new Random();
        this.sides = sides;
    }
    
    /**
     * The number of sides this {@code Die} has.
     * 
     * @return the number of sides of the {@code Die}.
     */
    @Override
    public Integer getSides() {
        return sides;
    }
    
    /**
     * Rolls a pseudo-random number of the {@code Die}-type.
     * 
     * @return an integer representing the pseudo-random value rolled.
     */
    @Override
    public Integer roll() {
        return random.nextInt(getSides()) + 1;
    }
    
    /**
     * Rolls a pseudo-random number of the {@code Die}-type n number of
     * times. This represents the notation:<br/>
     * <center>AdX</center><br/>
     * Where n is the number of times the {@code Die}-type dX must be
     * rolled.
     * 
     * @param n the number of times the {@code Die} is to be rolled.
     * @return a list of the pseudo-random values rolled.
     */
    @Override
    public List<Integer> roll(Integer n) {
        
        List<Integer> results = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            results.add(roll());
        }
        
        return results;
    }
    
    /**
     * Receives a {@code String} which represents a specific kind of RPG die
     * roll: <i>"Die rolls are described with expressions such as '3d4+3',
     * which means 'roll three four-sided dice and add 3' (resulting in a
     * number between 6 and 15)."</i> - SRD:Basics (pg. 1).<br>
     * This method parses the representation into actual numbers and performs
     * the roll specified.<br>
     * The format of the {@code String} is:<br>
     * <center>AdX[+/-]B</center><br>
     * 
     * @param roll the {@code String} specifying which roll must be made.
     * @return the pseudo-random value rolled.
     */
    // TODO Encapsulate logic into a String parser/formatter.
    /*
    public int roll(String roll) throws InvalidDieException {
        
        int n = 1;              // The number of times the die must be rolled.
        int d;                  // The die to be rolled.
        int m = 0;              // The m to the die roll (if any).
        char sign;              // Identifies whether the modifier is positive or negative.
        int position = 0;       // The modifier's position within the String.
        int result = 0;         // The result of the roll.
        
        // Format the String to comply to roll format: AdX[+/-]B.
        roll = roll.toLowerCase().replace(" ", "").trim();
        
        try {
            
            // Parsing the number of times the die must be rolled.
            if(!roll.substring(0, roll.indexOf('d')).equals("")) {
                n = Integer.parseInt(roll.substring(0, roll.indexOf('d')));
            }
            
            // Parsing the modifier to the die roll.
            if(roll.contains("+") || roll.contains("-")) {
                
                sign = ((roll.contains("+")) ? '+' : '-');
                position = roll.indexOf(sign);
                
                m = Integer.parseInt(roll.substring(position + 1), roll.length());
                // Respecting the sign of the modifier.
                m = ((sign == '+') ? m : -m);
            }
            
            // Parsing the die-type to be rolled.
            d = Integer.parseInt(roll.substring(roll.indexOf('d') + 1, ((m != 0) ? position : roll.length())));
            
            // Rolling the Die if it is the same as the indicated Die.
            if(d == sides) {
                result = roll(n, m);
            }
            else {
                throw new InvalidDieException();
            }
        
        } catch(IllegalArgumentException iae) {
            throw new InvalidDieException("The roll " + roll + " is invalid.");
        }
        
        return result;
    }
     */
    
    /**
     * Returns a String representing the dX notation where X is the number of
     * sides the {@code Die} has.
     *
     * @return a String containing a representation of the number of sides the
     * {@code Die} has with a lowercase 'd' appended before it.
     */
    @Override
    public String toString() {
        return "d" + getSides();
    }
    
}
