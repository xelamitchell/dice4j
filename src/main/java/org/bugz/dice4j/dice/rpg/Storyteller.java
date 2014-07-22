package org.bugz.dice4j.dice.rpg;

import java.util.ArrayList;
import java.util.Collections;
import org.bugz.dice4j.dice.rpg.classic.D10;
import org.bugz.dice4j.property.Rollable;
import org.bugz.dice4j.util.Order;
import org.bugz.dice4j.rule.Rule;
import org.bugz.dice4j.rule.RuleManager;

/**
 * This Class represents the dice rules used by the {@code Storyteller D10}
 * multiple dice.
 * <p/>
 * The {@code Storyteller Die} works per the rules of the 3rd Edition of
 * The World of Darkness rules, by default. This means that the "10 Again" rule
 * is enabled while the Rule Of One is not and the default difficulty for
 * success is 8.<br/>
 * To play per the 2nd Edition rules leave the "10 Again" rule and add a Rule
 * Of One object and make the default difficulty equal to 6 (alternatively use
 * the {@code set2ndEdition()} helper method).
 *
 * @version 0.0.4 31.03.2007
 * @author bugz
 * 
 * @see #defaultDifficulty
 * @see #rules
 * @see #set2ndEdition()
 */
/*
 * (non-javadoc)
 * 
 * TODO The Storyteller die should include Enumerations for Ratings (pg. 66),
 * definitions of Difficulties (pg. 67), degrees of Success and the different
 * levels of success (Success, Failure or Botch).
 * Create alternative Constructors for the Die:
 *   public Storyteller(int difficulty)
 *   public Storyteller(Rule... r)
 *   public Storyteller(int difficulty, Rule... r)
 * Create set2ndEdition() and set3rdEdition() methods which configure the Die
 * to mimic the specific ruleset.
 */
public class Storyteller implements Rollable {
    
    /** <code>Storyteller</code> Class Constructor. */
    public Storyteller() {
        
        d10 = D10.getDie();
        rules = new RuleManager();
        
        // Mimics the 3rd Edition ruleset by setting the Default Difficulty to
        // 8 and enabling the "10 Again" Rule.
        // TODO Use the set3rdEdition() helper method.
        defaultDifficulty = Storyteller.THIRD_EDITION_DIFFICULTY;
        rules.add(new RuleTenAgain());
        
    }
    
    /**
     * Informs the number of sides this <code>Die</code> has.
     * 
     * @return the number of sides of the <code>Die</code>
     */
    public int getSides() {
        return d10.getSides();
    }
    
    /**
     * Returns the number of successes rolled based on the <code>Die</code>'s
     * default difficulty.
     *
     * @param values the result of the <code>Storyteller</code> roll.
     * @return the number of successes rolled.
     */
    public int getSuccessCount(ArrayList<Integer> values) {
        return getSuccessCount(values, getDefaultDifficulty());
    }
    
    /**
     * Returns the number of successes rolled based on the difficulty informed
     * by the programmer.
     *
     * @param values the result of the <code>Storyteller</code> roll.
     * @param difficulty the values considered a success.
     * @return the number of successes rolled.
     */
    public int getSuccessCount(ArrayList<Integer> values, int difficulty) {
        
        int count = 0;
        
        for(int i : values) {
            
            if(i >= difficulty) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Returns the value which begins the range of the success values (which is
     * from <code>defaultDifficulty</code> to 10).
     *
     * @return the first value considered a success in this instance of the
     * <code>Storyteller Die</code>.
     */
    public int getDefaultDifficulty() {
        return defaultDifficulty;
    }
    
    /**
     * Sets the first value considered a success equal to the argument.
     *
     * @param n the value which informs the range of values considered
     * successes.
     */
    public void setDefaultDifficulty(int n) {
        
        if(isValidDifficulty(n)) {
            defaultDifficulty = n;
        }
        
    }

    /**
     * A difficulty must be within a range of 2 to 10 (1 always being
     * considered a failure).
     *
     * @param n a value which must be between 2 and 10.
     * @return a boolean value indicating whether the int value is a valid
     * difficulty.
     */
    private boolean isValidDifficulty(int n) {
        
        boolean valid = false;
        
        if(n > 1 && n <= 10) {
            valid = true;
        }
        
        return valid;
    }
    
    /**
     * Returns a reference to the <code>RuleManager</code> for this instance of
     * the <code>Storyteller Die</code>-type which is responsible for the
     * management of all <code>Rule</code>s associated with this <code>Die</code>.
     * 
     * @return a reference to the <code>Die</code>'s <code>RuleManager</code>.
     * @see #rules
     */
    public RuleManager getRules() {
        return rules;
    }
    
    /**
     * Rolls a single {@code Storyteller Die}.<br/>
     * However, if the "10 Again" Rule or the "Rule of One" are active then the
     * return is a variable number of results.
     *
     * @return an array containing the result from each {@code Die}
     * rolled.
     */
    public ArrayList<Integer> roll() {
        return roll(1);
    }
    
    /**
     * Rolls n number of <code>Storyteller</code> dice.<br/>
     * However, if the "10 Again" Rule or the "Rule of One" are active then the
     * return is a variable number of results.
     *
     * @param n the number of <code>Storyteller</code> dice to be rolled.
     * @return an array containing the result of each <code>Die</code> rolled.
     */
    public ArrayList<Integer> roll(Integer n) {
        
        ArrayList<Integer> values = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++) {
            values.add(d10.roll());
        }
        
        // Perform all the Rules associated with this Die.
        rules.doRule(values);
        
        return values;
    }
    
    /**
     * Returns the String "Storyteller".
     *
     * @return a String containing the <code>Die</code>'s name.
     */
    @Override
    public String toString() {
        return "Storyteller";
    }
    
    /** The  2nd Edition default difficulty value. */
    public static final int SECOND_EDITION_DIFFICULTY = 6;
    /** The  3rd Edition default difficulty value. */
    public static final int THIRD_EDITION_DIFFICULTY  = 8;
    
    /**
     * Maintains the first value of the default difficulty range (which is
     * always from <code>defaultDifficulty</code> to 10). This means that any
     * value rolled which is equal to or above the default difficulty is
     * considered a success.<br/>
     * In the 3rd Edition of The World of Darkness rules the default difficulty
     * is set to the minimum of 8 (8, 9 and 10 are successes) while in the 2nd
     * Edition version of the rules the default is 6 (thus, 6, 7, 8, 9 and 10
     * are considered successes).<br/>
     * <code>defaultDifficulty</code> is always a value between 2 and 10 (1 is
     * always considered a failure).
     */
    private int defaultDifficulty;
    /**
     * The <code>D10 Die</code> which the <code>Storyteller Die</code> forwards
     * method calls to.
     */
    private D10 d10;
    /** Manages and executes all of the currently enabled <code>Rule</code>s. */
    private RuleManager rules;
    
    /**
     * This Class represents the "10 Again Rule" and contains the algorithm
     * which enables a <code>Die</code> to apply the following
     * <code>Rule</code> to the results of a roll: <i>"A result of 10 on any
     * die is re-rolled in an attempt to reach more <b>successes</b>."</i>
     * - The World of Darkness 3rd Edition: Storytelling System Rulebook
     * (pg. 36).
     *
     * @version 0.0.2 26.04.2007
     * @author bugz
     */
    public class RuleTenAgain extends Rule {

        /**
         * Returns "10 Again Rule" which defines this <code>Rule</code>'s type.
         *
         * @return the String "10 Again Rule".
         */
        public String toString() {
            return "10 Again Rule";
        }
        
        /**
         * For every natural 10 within the results, the <code>Die</code> is
         * rolled once again. If a 10 results, a new <code>Die</code> is rolled
         * until no more 10's are rolled. All of the results of the new rolls
         * are added to the existent collection and returned.
         *
         * @param values an ArrayList<Integer> containing the pseudo-random
         * values rolled by the <code>Die</code>.
         * @return the values ArrayList<Integer> modified by the
         * <code>Rule</code>.
         */
        public ArrayList<Integer> doRule(ArrayList<Integer> values) {
            
            int n = getTens(values);
            
            if(n > 0) {
            
                // Roll the 10's in the collection of values and append the new
                // (modified) results to the initial collection of values
                // rolled.
                values.addAll(roll(n));
                
                // Sort the modified collection of values.
                Collections.sort(values);
            }
            
            return values;
        }

        /**
         * Returns the amount of 10's contained within the collection.
         *
         * @param values the result of a <code>Storyteller Die</code> roll.
         * @return the number of 10's within the collection.
         */
        private int getTens(ArrayList<Integer> values) {
            
            int tens = 0;
            
            for(int i : values) {
                
                if(i == 10) {
                    tens++;
                }
            }
            
            return tens;
        }

    }
    
    /**
     * This Class represents the "Rule of One" and contains the algorithm which
     * enables a <code>Die</code> to apply the following <code>Rule</code> to
     * the results of a roll: <i>"Whenever you roll a 1, it cancels out a
     * success."</i> - World of Darkness 2nd Edition rulebooks (various pages).<br>
     * This <code>Rule</code> erases successes at the rate of one success per
     * "one" rolled.<br>
     * The order in which the successes are removed (from the highest first to
     * the lowest or from lowest first to highest) is customisable (lowest to
     * highest is the default).
     *
     * @version 0.0.2 09.04.2007
     * @author bugz
     */
    /*
     * TODO Create a difficulty variable (with respective getters and setters
     * so that the Rule is well-encapsulated and does not depend on the
     * Storyteller Die for any information. However, think about strategies of
     * maintaining the Rule's difficulty synchronised with the Storyteller
     * die's difficulty.
     */
    public class RuleOfOne extends Rule {

        /** <code>RuleOfOne</code> Class Constructor. */
        public RuleOfOne() {
            removeFirst = Order.LOWEST;
        }
        
        /**
         * {@code RuleOfOne} Class Constructor.<br/>
         * The <code>Order</code> by which the successes will be removed (from
         * highest to lowest success value, or from lowest to highest), can be
         * defined by passing the desired <code>Rule.Order</code> reference.<br>
         * See setOrder(Order o) for an explanation of how each <code>Rule</code>
         * will behave depending on the <code>Rule.Order</code> used.
         *
         * @param order the <code>Rule.Order</code> by which this <code>Rule</code>
         * will begin removing successes.
         * 
         * @see #setOrder(Order o)
         */
        public RuleOfOne(Order order) {
            removeFirst = order;
        }
        
        /**
         * Returns "Rule of One" which defines this <code>Rule</code>'s type.
         *
         * @return the String "Rule of One".
         */
        public String toString() {
            return "Rule of One";
        }
        
        /**
         * If there are any successes on the list of values rolled, every value
         * of 1 removes one of these successes. If there are more 1's than
         * successes the excess 1's are returned unaltered.<br/>
         * To know the range of values which indicate success see the
         * <code>Storyteller</code> Instance Field <code>success</code>.<br/>
         * By default this <code>Rule</code> removes the lowest successes
         * first, to change that see setRemoveFirst().
         *
         * @param values an ArrayList<Integer> containing the pseudo-random
         * values rolled by the <code>Die</code>.
         * @return the values ArrayList<Integer> modified by the
         * <code>Rule</code>.
         */
        public ArrayList<Integer> doRule(ArrayList<Integer> values) {
            
            // The total number of 1's rolled.
            int n = getOnes(values);
            
            while(n != 0 && hasSuccesses(values)) {
                
                // Remove a 1.
                values.remove(0);
                
                // If the Highest success is to be removed first, then remove
                // the last value. If the Lowest success is to be removed first
                // then find the index of the first value which is considered a
                // success and remove it.
                values.remove((removeFirst == Order.HIGHEST) ? values.size() - 1 : getSuccess(values));
                
                // Decrement the number of 1's rolled.
                n--;
            }
            
            return values;
        }

        /**
         * Returns the number of 1's rolled.
         *
         * @param values the result of a <code>Storyteller Die</code> roll.
         * @return the total number of 1's contained in the collection of
         * values.
         */
        private int getOnes(ArrayList<Integer> values) {
            
            int ones = 0;
            
            // Search for 1's within the collection of values and count them.
            for(int i : values) {
                
                if(i == 1) {
                    ones++;
                }
            }
            
            return ones;
        }
        
        /**
         * Returns the index of the first success within the collection of
         * values. The index is dependent on the <code>defaultDifficulty</code>
         * Instance Field of the <code>Storyteller</code> Class.<br/>
         *
         * @param values the result of a <code>Storyteller Die</code> roll.
         * @return the index of the first value within the collection of values
         * which is considered a success.<br/>
         * <b>If there are no successes -1 is returned</b>.
         */
        private int getSuccess(ArrayList<Integer> values) {
            
            for(int i = 0; i < values.size(); i++) {
                
                if(values.get(i) >= getDefaultDifficulty()) {
                    return i;
                }
            }
            
            return -1;
        }
        
        /**
         * Returns the <code>Order</code> being used by this instance of the
         * <code>Rule</code> to decide in which order the values are removed
         * first (from <code>HIGHEST</code> to <code>LOWEST</code> or the other
         * way around).
         *
         * @return the <code>Order</code> which defines in which order
         * successes are removed when this <code>Rule</code> is applied.
         */
        public Order getOrder() {
            return removeFirst;
        }
        
        /**
         * Sets the <code>Order</code> which will define how successes are
         * removed when this <code>Rule</code> is applied to the values rolled.
         *
         * @param o the <code>Order</code> which defines whether successes
         * are removed from the lowest value considered a success first or from
         * the highest.
         */
        public void setOrder(Order o) {
            removeFirst = o;
        }
        
        /**
         * Checks to see if there are still any successes within the collection
         * of values.
         *
         * @param values the result of a <code>Storyteller Die</code> roll.
         * @return a boolean indicating whether there are still values which
         * are considered successes within the collection or not.
         */
        private boolean hasSuccesses(ArrayList<Integer> values) {
            
            for(int i : values) {
                
                if(i >= getDefaultDifficulty()) {
                    return true;
                }
            }
            
            // There are no values considered successes in this collection.
            return false;
        }
        
        /**
         * Indicates the order in which successes should be removed (either
         * from the <code>HIGHEST</code> to the </code>LOWEST</code>, or
         * <code>LOWEST</code> to <code>HIGHEST</code>).
         */
        private Order removeFirst;
        
    }
    
}
