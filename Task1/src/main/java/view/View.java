package view;

import model.Attempt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 10/29/2016.
 */
public class View {
    //Text's constants
    public static final String GAME_INFO = "The Game less-more. You need to guess value, which this program  guessed";
    public static final String WRONG_INPUT = "Wrong input!";
    public static final String CORRECT_VALUE = "Congratulations! You guessed the number!";
    public static final String INPUT_INT_DATA = "Input number ";
    public static final String WRONG_RANGE_DATA ="Wrong range! Repeat please!";
    public static final String MINIMUM_RANGE_VALUE = "The minimum of range value";
    public static final String MAXIMUM_RANGE_VALUE = "Tha maximum of range value";
    /**
     * Method for displaying messages on the console
     * @param message which will be displayed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * method which shows the guessed range
     * @param min the minimum of the range
     * @param max the maximum of the range
     */
    public void printBorders(int min, int max) {
        System.out.println(min + " - " + max + " (NOT INCLUSIVE!)");
        int a[]=new int[]{};
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
