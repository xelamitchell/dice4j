package org.bugz.dice4j.dice;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class DieFactoryTest {
    
    @Test
    public void shouldInstantiateCorrectDie() {
        
        final Integer SIDES = 100;
        
        assertThat(DieFactory.getDie(SIDES).getSides()).isEqualTo(SIDES);
    }
    
    @Test
    public void shouldCreateOnlyASingleInstanceOfADie() {
        
        // GIVEN a die
        // AND another die of the same number of sides
        Die first = DieFactory.getDie(10);
        Die second = DieFactory.getDie(10);
        
        // THEN they should point to the same instance
        assertThat(first).isEqualTo(second)
                .isEqualsToByComparingFields(second);
    }
    
}
