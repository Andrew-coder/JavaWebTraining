package model;

/**
 * Created by andri on 11/8/2016.
 */

/**
 * this enum describes 12 months of year
 */
public enum Month {
    JANUARY(1,31), FEBRUARY(2,28), MARCH(3,31), APRIL(4,30), MAY(5,31), JUNE(6,30),
    JULY(7,31), AUGUST(8,31), SEPTEMBER(9,30), OCTOBER(10,31), NOVEMBER(11,30), DECEMBER(12,31);

    /**
     * number of month
     */
    private final int monthIndex;

    /**
     * number of days in a month
     */
    private final int numberOfDaysInMonth;

    /**
     * constructor
     * @param monthIndex number of month
     * @param numberOfDaysInMonth number of days in a month
     */
    Month(int monthIndex, int numberOfDaysInMonth) {
        this.monthIndex = monthIndex;
        this.numberOfDaysInMonth = numberOfDaysInMonth;
    }

    public int getMonthIndex() {
        return monthIndex;
    }

    public int getNumberOfDaysInMonth() {
        return numberOfDaysInMonth;
    }

    /**
     * method which returns the Month instance by number of month
     * @param monthNumber the number of month
     * @return the month instance
     */
    public static Month getMonth(int monthNumber) {
          for(Month month : values()) {
              if(month.monthIndex==monthNumber)
                  return month;
          }
          return null;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
