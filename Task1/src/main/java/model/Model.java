package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by andri on 10/29/2016.
 */
public class Model {
    /**
     * Default values of minimum border for generating random numbers
     */
    public static final int RAND_MIN = 0;
    /**
     * Default values of maximum border for generating random numbers
     */
    public static final int RAND_MAX = 100;
    /**
     * The value, which player will guess
     */
    private int guessValue;

    private int minValue;
    private int maxValue;

    /**
     * list, where stored all player's attempts
     * including
     * 1.input value by player
     * 2.minimum border of range
     * 3.maximum border of range
     */
    private List<Attempt> attempts;

    /**
     * default constructor which fills the fields by default values
     */
    public Model() {
        attempts = new ArrayList<Attempt>();
        minValue = RAND_MIN;
        maxValue = RAND_MAX;
        guessValue = rand(minValue,maxValue);
    }

    /**
     * method which generates random number by specified range
     * @param min minimum border of range
     * @param max maximum border of range
     * @return generated value
     */
    public static int rand(int min, int max) {
        if(min>max) {
            int tmp=min;
            min=max;
            max=tmp;
        }
        Random random = new Random();
        return (random.nextInt(max) + min);
    }

    /**
     * method which generates random number by default range
     * @return generated value
     */
    public static int rand() {
        Random random = new Random();
        return (random.nextInt(RAND_MAX) + RAND_MIN);
    }

    /**
     * method which compare the specified number which guessed value
     * @ param specified number
     * @return is it true number or not
     */
    public  boolean checkNumber(int number) {
        if(number < minValue || number > maxValue)
            return false;
        if(number==guessValue)
            return true;
        if(number < guessValue)
            minValue = number;
        else
            maxValue = number;
        return false;
    }

    /**
     * method which adds the value and guessed range to statistic
     * @param value which will be added
     */
    public void addToStatistic(int value) {
        attempts.add(new Attempt(value, minValue, maxValue));
    }

    /** getters and setters */
    public int getGuessValue() {
        return guessValue;
    }

    public void setGuessValue(int guessValue) {
        this.guessValue = guessValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<Attempt> attempts) {
        this.attempts = attempts;
    }
}
