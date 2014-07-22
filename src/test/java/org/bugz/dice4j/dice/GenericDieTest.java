package org.bugz.dice4j.dice;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.fest.assertions.core.Condition;
import org.junit.Test;

/**
 * Basically tests functionality for {@link AbstractDie} as it serves as a
 * wrapper for that class.
 * 
 * @author amitchell
 */
public class GenericDieTest {
    
    private final Die<Integer> d10 = DieFactory.getDie(10);
    private final Set<Integer> valid = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    
    @Test
    public void shouldRollASingleValidResult() {
        
        // GIVEN a 10-sided die
        // WHEN the die is rolled
        Integer result = d10.roll();
        
        // THEN the value rolled should be between 1 and 10
        assertThat(result)
                .isIn(valid);
    }
    
    @Test
    public void shouldRollMultipleValidResults() {
        
        final Integer ROLLS = 10;
        
        // GIVEN a 10-sided die
        // WHEN the die is rolled a number of times
        List<Integer> results = d10.roll(ROLLS);
        
        // THEN all values rolled should be between 1 and 10
        assertThat(results)
                .hasSize(ROLLS)
                .has(new Condition<Iterable<Integer>>() {

            @Override
            public boolean matches(Iterable<Integer> values) {
                
                for(Integer i : values) {
                    if(!valid.contains(i)) {
                        return false;
                    }
                }
                
                return true;
            }
        });
    }
    
}
