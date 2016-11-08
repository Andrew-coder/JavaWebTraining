package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by andri on 11/8/2016.
 */

/**
 * this class describes the date with day, month and year
 */
public class Date {
    private int day;
    private Month month;
    private int year;

    /**
     * base constructor
     */
    public Date() {
        Calendar calendar = Calendar.getInstance();
        day= calendar.get(Calendar.DAY_OF_MONTH);
        month = Month.getMonth(Calendar.MONTH+1);
        year = calendar.get(Calendar.YEAR);
    }

    public Date(int day, Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return day+"."+month.getMonthIndex()+"."+year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * this method analyzes the string and reads from string the date information
     * @param date the date in string format
     */
    public void setDate(String date){
        StringBuilder builder = new StringBuilder(date);
        day = Integer.parseInt(
                builder.substring(0,builder.indexOf(".")));
        builder.delete(0,builder.indexOf(".")+1);
        month = Month.getMonth(
                Integer.parseInt(builder.substring(0,builder.indexOf("."))));
        builder.delete(0,builder.indexOf(".")+1);
        year = Integer.parseInt(builder.toString());
    }
}
