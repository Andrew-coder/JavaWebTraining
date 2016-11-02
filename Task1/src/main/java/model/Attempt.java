package model;

/**
 * Created by andri on 10/29/2016.
 */
public class Attempt {
    /**
     * the number which input the player
     */
    private int value;

    /**
     * The left border of the range
     */
    private int minValue;

    /**
     * The right border of the range
     */
    private int maxValue;

    /**
     * constructor
     * @param value which we will guess
     * @param minValue the left border
     * @param maxValue the right border
     */
    public Attempt(int value, int minValue, int maxValue) {
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
}
