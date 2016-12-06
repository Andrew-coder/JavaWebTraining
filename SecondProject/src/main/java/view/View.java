package view;

/**
 * Created by andri on 12/4/2016.
 */
public class View {
    //Text's constants
    public static final String SUCCESFULL_PARSE = "The thext was succesfully parsed!!!";
    public static final String UNIQUE_WORD = "unique word: ";
    public static final String UNIQUE_WORD_NOT_FOUND = "unique word wasn't found";

    /**
     * Method for displaying messages on the console
     * @param message which will be displayed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
