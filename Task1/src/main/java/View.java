import model.Attempt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 10/29/2016.
 */
public class View {
    /**
     * Text's constants
     */
    public static final String GAME_INFO = "The Game less-more. You need to guess value, which this program  guessed";
    public static final String WRONG_INPUT = "Wrong input!";
    public static final String CORRECT_VALUE = "Congratulations! You guessed the number!";
    public static final String INPUT_INT_DATA = "Input number ";

    /**
     * Method for displaying messages on the console
     * @param message which will be displayed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * method which shows the guessed range
     * @param min
     * @param max
     */
    public void printBorders(int min, int max) {
        System.out.println(min + " - " + max);
    }

    /**
     * method which displays the statistic of player
     * @param attempts list, where stores all players attemts
     */
    public void showStatistic(List<Attempt> attempts) {
        System.out.println("You guess from " + attempts.size() + " attempt");
        for(Attempt attempt:attempts) {
            System.out.println("value: "+attempt.getValue()+ " " + attempt.getMinValue() + " - " + attempt.getMaxValue());
        }
    }
}
