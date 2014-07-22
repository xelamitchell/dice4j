package org.bugz.dice4j.dice.erotic;

import java.util.ArrayList;
import java.util.List;
import org.bugz.dice4j.dice.rpg.classic.D6;
import org.bugz.dice4j.property.Rollable;

/**
 * The erotic die represents erotic actions to be performed on specific body
 * parts.
 * 
 * @author bugz
 */
/*
 * (non-javadoc)
 * 
 * TODO EroticDie could actually be composed of two separate dice: BodyDie and
 * ActionDie. These two extend Die (each with it's own enumeration as Type).
 * These two dice would be rolled by a dice pool.
 */
public class EroticDie implements Rollable {

    /** The {@link D6} Die which the {@code EroticDie} forwards method calls to. */
    private D6 d6 = D6.getInstance();
    
    @Override
    public EroticActivity roll() {
        return new EroticActivity(EroticActivity.Action.values()[d6.roll() - 1], EroticActivity.Anatomy.values()[d6.roll() - 1]);
    }

    @Override
    public List<EroticActivity> roll(Integer n) {
        
        List<EroticActivity> activities = new ArrayList<EroticActivity>(n);
        
        for(int i = 0; i < n; i++) {
            activities.add(roll());
        }
        
        return activities;
    }
    
}
