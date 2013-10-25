package org.bugz.dice4j.rule;

import java.util.ArrayList;

/**
 * The Abstract Class which is extended to identify specific
 * <code>Die Rule</code>s.<br>
 * A <code>Rule</code>'s type is defined by it's Classname representation (if
 * two <code>Rule</code>s have the same Classname, then they are considered the
 * same, irrespective of case).<br>
 * <code>Rule</code>s, ideally, should be self-contained pieces of code which
 * do not actually depend in the <code>Die</code> that is using them, so as to
 * promote code reuse and proper object encapsulation.
 *
 * @version 0.0.2 09.04.2007
 * @author bugz
 */
/*
 * TODO Rule should become an Interface and it's functionalities should be
 * delegated to RuleManager.
 */
public abstract class Rule {
    
    /**
     * A comparison for equality between <code>Rules</code> is merely seeing if
     * they have the same Classname. If they do, then they are the same.
     *
     * @param obj the <code>Rule</code> which will be compared with this one.
     * @return a boolean value indicating whether they are the same or not.
     */
    @Override
    public boolean equals(Object obj) {
        
        if(obj == this) {
            return true;
        }
        else if(obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        
        return this.getClass().getName().equals(obj.getClass().getName());
    }
    
    /**
     * Because <code>Object.equals(Object obj)</code> has been Overriden and
     * now depends on the <code>Rule</code>'s Classname, so too must the
     * <code>Object.hashCode()</code> method be Overriden returning a hash
     * created using the numeric values of the characters which compose the
     * <code>Rule</code>'s Classname.
     *
     * @return an int value composed from the ASCII numeric values of the
     * <code>Rule</code>'s Classname.
     * @see #equals(Object obj)
     * @see #toString()
     */
    /*
     * TODO Check the hashCode() method because Java identifiers ('.' and '$'
     * return a -1 numeric value (maybe remove Java Identifiers and only use the
     * characters?).
     */
    @Override
    public int hashCode() {
        
        /*
        int hash = 0;
        
        // Retrieve the ASCII value of each character of the Rule's Classname.
        for(Character c : this.getClass().getName().toCharArray()) {
            hash += Character.getNumericValue(c);
            System.out.printf("%c = %d [%d]%n", c, Character.getNumericValue(c), hash);
        }
        
        return hash;
         */
        return super.hashCode();
    }
    
    /**
     * Every <code>Rule</code> should always return the <code>Rule</code>'s
     * name formatted as "Rule of ..." or "... Rule".
     *
     * @return a String holding the <code>Rule</code>'s name.
     */
    @Override
    public abstract String toString();
    
    /**
     * Executes the <code>Rule</code> associated with the <code>Die</code>.<br>
     * This is where each specific <code>Rule</code> Subclass implements it's
     * particular <code>Rule</code> which will then be applied to the values
     * rolled.
     *
     * @param values an ArrayList<Integer> containing the pseudo-random values
     * rolled by the <code>Die</code>.
     * @return the values ArrayList<Integer> modified by the <code>Rule</code>.
     */
    public abstract ArrayList<Integer> doRule(ArrayList<Integer> values);
    
}
