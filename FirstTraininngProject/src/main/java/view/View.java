package view;

import constants.Const;
import model.entity.Child;
import model.entity.Toy;

import java.util.List;

/**
 * Created by andri on 11/17/2016.
 */
public class View {
    /**
     * Method for displaying messages on the console
     * @param messages which will be displayed
     */
    public static void printMessage(String ... messages) {
        for(String message : messages) {
            System.out.println(message);
        }
    }

    /**
     * static methods which prints the user menu on console
     */
    public static void printMenu(){
        printMessage(Const.MENU_ITEMS);
    }

    /**
     * static method which displays the list of toys
     * @param toys the list of toys
     */
    public static void displayToys(List<Toy> toys){
        for(Toy toy:toys) {
            System.out.println(toy);
        }
    }

    /**
     * static method which displays the list of children
     * @param children the list of children
     */
    public static void displayChildren(List<Child> children){
        for(Child child:children) {
            System.out.println(child);
        }
    }
}
