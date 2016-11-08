package controller;

import constants.Const;
import model.Date;
import model.Note;
import model.NoteBook;
import view.View;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by andri on 11/8/2016.
 */
public class Controller {
    /**
     * model's instance
     */
    private NoteBook noteBook;

    /**
     * view's instance
     */
    private View view;

    /**
     * constructor, which inits model and view
     * @param noteBook model's instance
     * @param view view's instance
     */
    public Controller(NoteBook noteBook, View view) {
        this.noteBook = noteBook;
        this.view = view;
    }

    /**
     * this method set the order of actions
     */
    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        int menuItem = 0;
        do {
            View.printMenu();
            menuItem = inputIntValueWithScanner(scanner);
            switch (menuItem) {
                case Const.ADD_NOTE:
                    inputNote(scanner);
                    break;
                case Const.DELETE_NOTE:
                    deleteNote(scanner);
                    break;
                case Const.VIEW_ALL_NOTES:
                    View.showAllRecords(noteBook.getNotes());
                    break;

                case Const.EXIT:
                    System.exit(0);

                default:
                    View.printMessage(Const.WRONG_INPUT + Const.INPUT_INT_DATA);
            }
        }while (menuItem!=Const.EXIT);
    }

    /**
     * this method implements the reaading int value from console
     */
    public int inputIntValueWithScanner(Scanner scanner) {
        while( ! scanner.hasNextInt()) {
            view.printMessage(Const.WRONG_INPUT + Const.INPUT_INT_DATA);
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * help method to add note to notebook
     * @param scanner Scanner which implements the reading data
     */
    public void inputNote(Scanner scanner) {
        Note note = new Note();
        note.setName(inputStringWithRegExp(
                Const.INPUT_FULL_NAME, Const.REGEX_NAME, scanner));
        note.setPhone(inputStringWithRegExp(
                Const.INPUT_CELL_PHONE, Const.REGEX_PHONE, scanner));
        note.getBirthDate().setDate(inputStringWithRegExp(
                Const.INPUT_BIRTH_DATE, Const.REGEX_DATE, scanner));
        noteBook.addNote(note);
    }

    /**
     * help method which remove pointed note from notebook
     * @param scanner Scanner which implements the reading data
     */
    public void deleteNote(Scanner scanner) {
        View.printMessage(Const.INPUT_NUMBER_NOTE);
        int number = inputIntValueWithScanner(scanner)+1;
        if(number > 1 && number<=noteBook.getNotes().size())
            noteBook.deleteNote(number - 1);
        else {
            View.printMessage(Const.WRONG_NOTE_NUMBER);
        }
    }

    /**
     * method which implements the check of input string by regular expression
     * @param message text message for asking user to input data
     * @param expression regular expression
     * @param scanner Scanner which implements the reading data
     * @return
     */
    public String inputStringWithRegExp(String message, String expression, Scanner scanner) {
        String string;
        do {
            View.printMessage(message);
            string = scanner.nextLine();
        } while (!string.matches(expression));
        return string;
    }
}
