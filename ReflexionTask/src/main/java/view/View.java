package view;

import constants.Const;
import model.Note;

import java.util.List;

/**
 * Created by andri on 11/8/2016.
 */

/**
 * this method implements all work with output
 */
public class View {
    /**
     * this method print the message on console
     * @param messages message which will be displayed
     */
    public static void printMessage(String ...messages) {
        for(String message : messages) {
            System.out.println(message);
        }
    }

    /**
     * this method prints the user menu
     */
    public static void printMenu() {
        printMessage(Const.MENU_ITEMS);
    }

    /**
     * this method shows all notes in notebook
     * @param notes
     */
    public static void showAllRecords(List<Note> notes) {
        if(notes.size()!=0) {
            for (Note note : notes) {
                System.out.println(note);
                printMessage(Const.DIVIDER);
            }
        }
        else {
            printMessage(Const.EMPTY_NOTE_BOOK);
        }
    }
}
