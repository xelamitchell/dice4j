package org.bugz.dice4j.dice.erotic;

/**
 * Immutable class which encapsulates and {@link Action} and an {@link Anatomy}
 * for a complete erotic activity.
 *
 * @author bugz
 */
public final class EroticActivity {

    private Action action;
    private Anatomy anatomy;
    
    /**
     * An {@code EroticActivity} represents a complete erotic action which is
     * always composed of an {@link Action} and an {@link Anatomy} which is the
     * body part on which the {@code Action} should be performed.
     * 
     * @param action
     * @param anatomy 
     */
    public EroticActivity(Action action, Anatomy anatomy) {
        this.action = action;
        this.anatomy = anatomy;
    }

    /**
     * Returns the erotic {@link Action} associated with this activity.
     * 
     * @return 
     */
    public Action getAction() {
        return action;
    }

    /**
     * Returns the body part on which the {@link Action} should be performed.
     * 
     * @return 
     */
    public Anatomy getAnatomy() {
        return anatomy;
    }
    
    /**
     * A string representation of the erotic activity in the form:
     * <pre>
     * Action anatomy
     * </pre>
     * 
     * @return 
     */
    @Override
    public String toString() {
        return action.toString() + " " + anatomy.toString().toLowerCase();
    }
    
    /**
     * The erotic action to be performed.
     * 
     * @author bugz
     */
    public enum Action {

        BLOW,
        KISS,
        LICK,
        MASSAGE,
        TEASE,
        TOUCH;
        
    }

    /**
     * The body part on which the {@link Action} is to be performed.
     * 
     * @author bugz
     */
    public enum Anatomy {

        BODY,
        BOOBS,
        LIPS,
        NIPPLES,
        TOES,
        ANY;
        
    }

}
