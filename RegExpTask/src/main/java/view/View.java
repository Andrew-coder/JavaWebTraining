package view;

import Constants.Const;
import model.Record;

import java.util.List;

/**
 * Created by andri on 11/5/2016.
 */
public class View {
    public static void printMessage(String ... messages) {
        for(String message : messages) {
            System.out.println(message);
        }
    }

    public static void printMenu() {
        printMessage(Const.MENU_ITEMS);
    }

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
