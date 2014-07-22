package org.bugz.dice4j.dice.rpg.classic;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.fest.assertions.core.Condition;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class D10Test {
    
    private static final Logger logger = LoggerFactory.getLogger(D10Test.class);
    
    private final D10 d10 = D10.getDie();
    private final Set<Integer> valid = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    
    @Test
    public void shouldRollASingleValidResult() {
        
        // GIVEN a 10-sided die
        // WHEN the die is rolled
        Integer result = d10.roll();
        
        // THEN the value rolled should be between 1 and 10
        assertThat(result).isIn(valid);
    }
    
    @Test
    public void shouldRollMultipleValidResults() {
        
        final Integer ROLLS = 10;
        
        // GIVEN a 10-sided die
        // WHEN the die is rolled a number of times
        List<Integer> results = d10.roll(ROLLS);
        for(Integer i : results) {
            logger.info("{}", i);
        }
        
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
    
    @Test
    public void shouldRollASingleValueModifiedByAPositiveAmount() {
        
        final Integer ROLLS = 1;
        final Integer MODIFIER = 1;
        
        List<Integer> results = d10.roll(ROLLS, MODIFIER);
        
        assertThat(results)
                .hasSize(ROLLS);
        
    }
    
}
