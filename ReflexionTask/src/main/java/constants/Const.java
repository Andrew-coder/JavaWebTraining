package constants;

/**
 * Created by andri on 11/8/2016.
 */

/**
 * this interface contains all necessary constants and regular expressions
 * for input and output
 */
public interface Const {
    //regular expressions
    String REGEX_NAME ="^[\\p{L}\\s'.-]+$";
    String REGEX_PHONE ="^\\+[1-9]{1}[0-9]{3,14}$";
    String REGEX_DATE = "^([0]?[1-9]|[12][0-9]|3[01])[.]([0]?[1-9]|1[012])[.](19|20)[1-9]{2}$";
    //asking to enter
    String INPUT_FULL_NAME = "Input the full name (Name Surname Patronymic)";
    String INPUT_CELL_PHONE = "Input the cell phone number";
    String INPUT_BIRTH_DATE = "Input the date of birth (dd.mm.yyyy)";
    String INPUT_NUMBER_NOTE = "Input the number of note, which you want to delete";

    String[] MENU_ITEMS = {
            "1. Add record",
            "2. Delete record",
            "3. View all records",
            "4. Exit"
    };

    int ADD_NOTE = 1;
    int DELETE_NOTE = 2;
    int VIEW_ALL_NOTES = 3;
    int EXIT = 4;

    String DIVIDER = "___________________________";

    String WRONG_INPUT = "Wrong input!";
    String INPUT_INT_DATA = "Choose the menu item!";
    String EMPTY_NOTE_BOOK = "The record book is empty";
    String WRONG_NOTE_NUMBER = "The note with such number doesn't exist";
}
