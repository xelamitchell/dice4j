package org.bugz.dice4j.dice.cleromancy.magicball;

import java.util.Locale;
import java.util.ResourceBundle;
import org.bugz.dice4j.dice.rpg.classic.D20;
import org.bugz.dice4j.property.Shakeable;
import org.bugz.dice4j.util.ResourceLoader;

/**
 * <i>"The Magic 8-Ball, manufactured by Mattel is a toy used for
 * fortune-telling. Invented by Abe Bookman in 1946 of the Alabe Toy Company,
 * it is a hollow, plastic sphere resembling an oversized, black and white
 * 8-ball."</i> - Wikipedia.org
 *
 * @author bugz
 * 
 * @see <a href="http://en.wikipedia.org/wiki/">Wikipedia: Magic 8-Ball</a>
 */
/*
 * TODO Loads the answers from an internationalisation .properties file.
 */
public class Magic8Ball implements Shakeable<String> {
    
    private D20 d20 = D20.getInstance();
    private ResourceBundle resource;
    
    /**
     * <code>Magic8Ball</code> Class Constructor.
     *
     * @param locale the Locale of the <code>Magic8Ball</code>'s .properties file.
     */
    public Magic8Ball(Locale locale) {
        resource = ResourceLoader.getBundle("magic8ball", locale);
    }
    
    /** <code>Magic8Ball</code> Class Constructor. */
    public Magic8Ball() {
        this(Locale.getDefault());
    }
    
    /**
     * The ask() method is used to make a yes or no answerable question to the
     * Magic 8 Ball. It considers whether the question asked can be answered
     * with yes or no.
     *
     * @param question the question to be asked to the Magic 8 Ball.
     * @return a String containing one of the possible yes-no answers.
     */
    public String ask(String question) {
        return shake();
    }
    
    /**
     * To use the Magic 8-Ball the petitioner would ask a question and turn the
     * ball so that the window underneath would be visible, presenting the
     * answer to the question.
     *
     * @return a String containing one of the possible yes-no answers.
     */
    private String shake() {
        return null;
    }

}
