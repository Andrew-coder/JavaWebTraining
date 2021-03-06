package controller;

import Constants.Const;
import model.Address;
import model.Group;
import model.Record;
import model.RecordBook;
import view.View;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by andri on 11/5/2016.
 */
public class Controller {
    /**
     * model's instance
     */
    private RecordBook recordBook;

    /**
     * view's instance
     */
    private View view;

    /**
     * constructor, which inits model and view
     * @param recordBook model's instance
     * @param view view's instance
     */
    public Controller(RecordBook recordBook, View view) {
        this.recordBook = recordBook;
        this.view = view;
    }

    /**
     * method which sets the sequence of actions
     */
    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        int menuItem = 0;
        do {
            View.printMenu();
            menuItem = inputIntValueWithScanner(scanner);
            switch (menuItem) {
                case Const.ADD_RECORD:
                    inputRecord(scanner);
                    break;
                case Const.VIEW_ALL_RECORDS:
                    View.showAllRecords(recordBook.getRecords());
                    break;

                case Const.EXIT:
                    System.exit(0);

                default:
                    View.printMessage(Const.WRONG_INPUT + Const.INPUT_INT_DATA);
            }
        }while (menuItem!=Const.EXIT);
    }

    /**
     * method which adds the new record to record book
     * @param scanner Scanner, with the help of which we implement the reading from console
     */
    public void inputRecord(Scanner scanner) {
        Record record = new Record();
        record.setFullName(inputStringWithRegExp(
                Const.INPUT_FULL_NAME, Const.REGEX_NAME, scanner));
        record.setNickName(inputStringWithRegExp(
                Const.INPUT_NICK, Const.REGEX_NICK, scanner));
        record.setComment(inputStringWithRegExp(
                Const.INPUT_COMMENT, Const.REGEX_COMMENT, scanner));
        record.setHomePhone(inputStringWithRegExp(
                Const.INPUT_HOME_PHONE, Const.REGEX_HOMEPHONE, scanner));
        record.setCellPhone(inputStringWithRegExp(
                Const.INPUT_CELL_PHONE, Const.REGEX_CELLPHONE, scanner));
        record.setEmail(inputStringWithRegExp(
                Const.INPUT_EMAIL, Const.REGEX_MAIL, scanner));
        record.setSkype(inputStringWithRegExp(
                Const.INPUT_SKYPE, Const.REGEX_SKYPE, scanner));
        record.setAddress(new Address(inputStringWithRegExp(
                Const.INPUT_ADDRESS, Const.REGEX_ADRESS,scanner)));
        try {
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            record.setCreationDate(format.parse(inputStringWithRegExp(
                    Const.INPUT_CREATION_DATE, Const.REGEX_DATE, scanner)));
            record.setLastChangeDate(format.parse(inputStringWithRegExp(
                    Const.INPUT_LAST_CHANGE_DATE, Const.REGEX_DATE, scanner)));
        }
        catch (ParseException exception) {}
        recordBook.addRecord(record);
    }

    /**
     *
     * @param message message, which ask user to type a data
     * @param expression regular expression, which parses the input string
     * @param scanner Scanner, with the help of which we implement the reading from console
     * @return the string which passes all necessary checks
     */
    public String inputStringWithRegExp(String message, String expression, Scanner scanner) {
        String string;
        do {
            View.printMessage(message);
            string = scanner.nextLine();
        } while (!string.matches(expression));
        return string;
    }

    /**
     *
     * @param scanner Scanner, with the help of which we implement the reading from console
     * @return the integer value which passes the checks
     */
    public int inputIntValueWithScanner(Scanner scanner) {
        while( ! scanner.hasNextInt()) {
            view.printMessage(Const.WRONG_INPUT + Const.INPUT_INT_DATA);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
