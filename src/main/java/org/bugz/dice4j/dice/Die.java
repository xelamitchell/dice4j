package org.bugz.dice4j.dice;

import org.bugz.dice4j.property.Rollable;

/**
 * Die represents the Interface which all dice within the API must implement
 * to be identified as a {@code Die}-type.
 * 
 * @author bugz
 */
public interface Die<T> extends Rollable<T> {

    Integer getSides();

}
