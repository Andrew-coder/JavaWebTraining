package view;

import Constants.Const;
import model.Record;

import java.util.List;

public class View {
    /**
     * static method which prints the message on the console
     * @param messages messages, which will be shown
     */
    public static void printMessage(String ... messages) {
        for(String message : messages) {
            System.out.println(message);
        }
    }

    /**
     * static methods which prints the user menu on console
     */
    public static void printMenu() {
        printMessage(Const.MENU_ITEMS);
    }

    /**
     * method which displays the list of records
     * @param records the list of records
     */
    public static void showAllRecords(List<Record> records) {
        if(records.size()!=0) {
            for (Record record : records) {
                System.out.println(record);
                printMessage(Const.DIVIDER);
            }
        }
        else {
            printMessage(Const.EMPTY_RECORD_BOOK);
        }
    }

}
