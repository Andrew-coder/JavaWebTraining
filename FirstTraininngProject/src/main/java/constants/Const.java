package constants;

/**
 * init interface which contains the constants
 */
public interface Const {
    String WRONG_INPUT = "Wrong input!";
    String INPUT_INT_DATA = "Input number ";
    String WRONG_RANGE_DATA ="Wrong range! Repeat please!";

    String[] MENU_ITEMS = {
            "1. Generate data automatically",
            "2. Display toys list",
            "3. Display childrens list",
            "4. Sort toys by price",
            "5. Sort toys by name",
            "6. Exit"
    };

    int GENERATE_DATA_AUTOMATICALLY = 1;
    int DISPLAY_TOYS = 2;
    int DISPLAY_CHILDRENS = 3;
    int SORT_TOYS_BY_PRICE = 4;
    int SORT_TOYS_BY_NAME = 5;
    int EXIT = 6;
}
