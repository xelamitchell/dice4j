package org.bugz.dice4j.rule;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Controls all the functions associated to managing <code>Rule</code>s within
 * a Class that uses the <code>Rule</code> system.<br/>
 * <code>Rule</code>s are executed in the order they are inserted into the
 * collection, a First In, First Out basis (FIFO), however there are ways of
 * manipulating the order of the collection through the method set(Rule r).
 * 
 * @version 0.0.1 11.04.2007
 * @author bugz
 * 
 * @see #set(Rule r)
 * @see #set(Rule r, boolean keepIndex)
 */
/*
 * TODO Create activate/disactivate rules so that rules may still be present
 * within the manager but do not take effect when de-activated.
 */
public class RuleManager {
    
    /** <code>RuleManager</code> Class Constructor. */
    public RuleManager() {
        rules = new ArrayList<Rule>();
    }
    
    /**
     * Returns an ArrayList<Rule> of the <code>Rule</code>s currently
     * associated to this <code>Die</code>.
     *
     * @return the <code>Rule</code> currently enabled in this <code>Die</code>.
     */
    public ArrayList<Rule> getRules() {
        return rules;
    }
    
    /**
     * Returns the <code>Rule</code> contained a specified index.
     *
     * @param n the index of the <code>Rule</code> to be retrieved.
     * @return the <code>Rule</code> contained in the specified index, or null
     * if the index is out of the collection's range.
     */
    public Rule getRule(int n) {
        
        Rule collected = null;
        
        if(n >= 0 && n < rules.size()) {
            collected = rules.get(n);
        }
        
        return collected;
    }
    
    /**
     * Returns a <code>Rule</code> of the same type as the <code>Rule</code>
     * passed as an argument (if a <code>Rule</code> of the correct type exists
     * in the collection).
     *
     * @param rule the <code>Rule</code>-type which is being looked for.
     * @return either a <code>Rule</code> of the same type of the argument or
     * null if no <code>Rule</code> of this type currently exists in the
     * collection.
     */
    public Rule get(Rule rule) {
        
        Rule collected = null;
        
        if(rules.contains(rule)) {
            collected = rules.get(rules.indexOf(rule));
        }
        
        return collected;
    }
    
    /**
     * The methods adds new <code>Rule</code>s to the current collection of
     * <code>Rule</code>s. The new <code>Rule</code> is always added at the
     * end of the collection if there are no <code>Rule</code>s of it's type.
     * If a <code>Rule</code> of the same type already exists the new object is
     * not inserted into the list.<br>
     * To ensure that the new <code>Rule</code> is inserted into the collection
     * use the method set(Rule r).
     * 
     * @param rule the <code>Rule</code> object which will be added at the end of
     * the current collection of <code>Rule</code> if there is no <code>Rule</code>
     * of the same type already in the collection.
     * @return a boolean which indicates whether the new <code>Rule</code> has
     * been added to the collection or not. If the method returns a value of
     * false, that indicates that the new <code>Rule</code> was not added
     * because a <code>Rule</code> of the same type has already been added to
     * the collection.
     * @see #set(Rule r)
     * @see #set(Rule r, boolean keepIndex)
     */
    public boolean add(Rule rule) {
        
        boolean added = false;
        
        // Adds the new Rule to the collection if the collection does not
        // already hold another version of the same Rule.
        if(!rules.contains(rule)) {
            rules.add(rule);
            added = true;
        }
        
        return added;
    }
    
    /**
     * The method ensures that the new <code>Rule</code> is added to the
     * collection of <code>Rule</code>s even if another instance of said
     * <code>Rule</code> already exists in the collection.<br>
     * If no instance of this <code>Rule</code> exists, the new <code>Rule</code>
     * is added to the end of the queue. If a another <code>Rule</code> of the
     * same type has already been added to the collection, the old reference is
     * removed and the new <code>Rule</code> is added to the end of the queue.<br>
     * In order to switch an old reference of the <code>Rule</code> by a new
     * one while preserving the old <code>Rule</code>'s index within the queue
     * use the {@link #set(Rule r, boolean KeepIndex)} method.
     * 
     * @param rule the new <code>Rule</code> reference which is guaranteed to be
     * added to the collection.
     * @see #set(Rule r, boolean keepIndex)
     */
    public void set(Rule rule) {
        set(rule, false);
    }
    
    /**
     * This method not only guarantees that the new <code>Rule</code> will be
     * added to the collection, independent of whether a <code>Rule</code> of
     * the same type has already been added to the queue, but also allows the
     * new <code>Rule</code> to take the previous <code>Rule</code>'s place in
     * the collection.<br>
     * If there is no previous <code>Rule</code> of the same type as the
     * <code>Rule</code> being added, the new <code>Rule</code> will be added
     * at the end of the collection.
     *
     * @param rule the new <code>Rule</code> reference which is guaranteed to be
     * added to the collection.
     * @param keepIndex if true and a <code>Rule</code> of the same type as the
     * <code>Rule</code> to be inserted exists, the new <code>Rule</code>
     * maintains the old <code>Rule</code>'s index in the queue, if false the
     * old reference is removed from the queue and the new <code>Rule</code> is
     * added to the end of the collection.
     */
    public void set(Rule rule, boolean keepIndex) {
        
        if(rule != null) {
                
            // Either replace an existing Rule (if there is one)...
            if(keepIndex) {
                int index = rules.indexOf(rule);
                rules.set((index > -1) ? index : rules.size() - 1, rule);
            }
            // Or remove it and add the new Rule at the end of the queue.
            else {
                rules.remove(rule);
                rules.add(rule);
            }
        }
    }
    
    /** Clears all associated <code>Rule</code>s from the Handler. */
    public void clear() {
        rules.clear();
    }
    
    /**
     * Performs all of the collected <code>Rule</code>s.
     *
     * @param values an ArrayList<Integer> containing the pseudo-random values
     * rolled by the <code>Die</code>.
     * @return the values ArrayList<Integer> modified by whichever
     * <code>Rule</code>s are active in this handler.
     */
    public ArrayList<Integer> doRule(ArrayList<Integer> values) {
        
        // Perform a sort on the values to aid all Rules' performance.
        Collections.sort(values);
        
        // Perform each Rule in turn.
        for(Rule r : rules) {
            r.doRule(values);
        }
        
        return values;
    }
    
    /**
     * Lists all of the <code>Rule</code>s collected in this
     * <code>RuleManager</code>.
     * 
     * @return a String with all of the active <code>Rule</code>s.
     */
    @Override
    public String toString() {
        
        String s = "[";
        
        for(int i = 0; i < rules.size(); i++) {
            
            s += rules.get(i);
            
            if(i < rules.size() - 1) {
                s += ", ";
            }
            
        }
        
        return s += "]";
    }
    
    /**
     * Maintains a reference to the currently enabled rules.<br/>
     * Every <code>Rule</code> employed by the <code>Storyteller Die</code> is
     * a specialised Class which extends the <code>Rule</code> Abstract Class.<br/>
     * The <code>Rule</code>s are applied to the values using the order in
     * which they are added to the list of <code>Rule</code>s and particular
     * <code>Rule</code>s are never applied more than once to a single result
     * set (there can only ever be a single instance of a particular
     * <code>Rule</code> within the list).
     * 
     * @see #add(Rule r)
     * @see #set(Rule r)
     */
    // TODO Change to a Set as there should only be a single instance of any
    // given Rule
    private ArrayList<Rule> rules;
    
}
