package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static model.GlobalConstants.*;

/**
 * Created by andri on 10/29/2016.
 */
public class Model {
    /**
     * The value, which player will guess
     */
    private int guessValue;

    /**
     * The minimum value of range
     */
    private int minValue;
    /**
     * The maximum value of range
     */
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
        return (random.nextInt(max-1) + min+1);
    }

    /**
     * method which generates random number by default range
     * @return generated value
     */
    public static int rand() {
        Random random = new Random();
        return (random.nextInt(RAND_MAX-1) + RAND_MIN+1);
    }

    /**
     * method which compare the specified number which guessed value
     * @param number specified number
     * @return is it true number or not
     */
    public  boolean checkNumber(int number) {
        if(number < minValue || number > maxValue) {
            return false;
        }
        if(number==guessValue) {
            return true;
        }
        if(number < guessValue) {
            minValue = number;
        }
        else {
            maxValue = number;
        }
        return false;
    }

    /**
     * method which adds the value and guessed range to statistic
     * @param value which will be added
     */
    public void addToStatistic(int value) {
        attempts.add(new Attempt(value, minValue, maxValue));
    }

    /**
     * This method set range and automatically update guessed value
     * @param min minimum of the range
     * @param max maximum of the range
     */
    public void setRange(int min, int max) {
        minValue = min;
        maxValue = max;
        guessValue = rand(minValue, maxValue);
    }

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
