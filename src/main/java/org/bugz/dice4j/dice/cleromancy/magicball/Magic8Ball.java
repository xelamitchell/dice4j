package org.bugz.dice4j.dice.cleromancy.magicball;

import java.util.Locale;
import java.util.ResourceBundle;
import org.bugz.dice4j.dice.Die;
import org.bugz.dice4j.dice.rpg.classic.D20;
import org.bugz.dice4j.util.ResourceLoader;

/**
 * <i>"The Magic 8-Ball, manufactured by Mattel is a toy used for
 * fortune-telling. Invented by Abe Bookman in 1946 of the Alabe Toy Company,
 * it is a hollow, plastic sphere resembling an oversized, black and white
 * 8-ball."</i> - Wikipedia.org
 *
 * see <a href="http://en.wikipedia.org/wiki/">Wikipedia: Magic 8-Ball</a>
 *
 * @version 0.0.1 20.07.2007
 * @author bugz
 */
/*
 * TODO Loads the answers from an internationalisation .properties file.
 */
public class Magic8Ball implements Die {
    
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
        return turn();
    }
    
    /**
     * To use the Magic 8-Ball the petitioner would ask a question and turn the
     * ball so that the window underneath would be visible, presenting the
     * answer to the question.
     *
     * @return a String containing one of the possible yes-no answers.
     */
    private String turn() {
        return null;
    }
    
    /**
     * The Magic 8-Ball toy contained 20 yes-no anwers, each was a face in the
     * 20-sided <code>Die</code> which floated in the liquid within the sphere.<br>
     * This is the <code>D20 Die</code> to with method calls are forwarded to.
     */
    private D20 d20 = D20.getInstance();
    /** The possible yes-no answers. */
    private ResourceBundle resource;
    
}
