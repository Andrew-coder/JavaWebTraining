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
     * borders of range
     */
    private int minValue;
    private int maxValue;

    /**
     * constructor
     * @param value
     * @param minValue
     * @param maxValue
     */
    public Attempt(int value, int minValue, int maxValue) {
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    /** getters and setters */
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
