package Constants;

/**
 * Created by andri on 11/5/2016.
 */
public interface Const {
    //Regular expressions
    String REGEX_NAME="^[\\p{L}\\s'.-]+$";
    String REGEX_SURNAME="[A-Z]{1}[a-z]{1,}";
    String REGEX_PATRONYMIC="[A-Z]{1}[a-z]{1,}";
    String REGEX_NICK="\\w+";
    String REGEX_COMMENT="\\w{1,}(\\ \\w)*\\.{1}";
    String REGEX_GROUP="[A-Za-z]+";
    String REGEX_HOMEPHONE="/^07\\d{9}$/";
    String REGEX_CELLPHONE="^\\+[1-9]{1}[0-9]{3,14}$";
    String REGEX_SKYPE="[A_Za-z][-_.A_Za-z0-9]{5,31}";
    String REGEX_MAIL="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String REGEX_DATE= "^\\d{4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])$";
    String REGEX_ADRESS="";

    String[] MENU_ITEMS = {
            "1. Add record",
            "2. View all records",
            "3. Exit"
    };

    String DIVIDER = "___________________________";

    String WRONG_INPUT = "Wrong input!";
    String INPUT_INT_DATA = "Choose the menu item!";
    String EMPTY_RECORD_BOOK = "The record book is empty";

    int ADD_RECORD = 1;
    int VIEW_ALL_RECORDS = 2;
    int EXIT = 3;

    String INPUT_FULL_NAME = "Input the full name (Name Surname Patronymic)";
    String INPUT_NICK = "Input the nickname (1 character must be letter)";
    String INPUT_COMMENT = "Input the comment (After comment put the DOT)";
    String INPUT_GROUP = "Input the group";
    String INPUT_HOME_PHONE = "Input the home phone (11 digits must begin with 0)";
    String INPUT_CELL_PHONE = "Input the cell phone number";
    String INPUT_EMAIL = "Input your email";
    String INPUT_SKYPE = "Input your Skype login";
    String INPUT_ADDRESS = "Input your full address (index city_name home_number appartment_number)";
    String INPUT_CREATION_DATE = "Input record creation date (MM dd, yyyy)";
    String INPUT_LAST_CHANGE_DATE = "Input the date of last change (MM dd, yyyy)";

}
