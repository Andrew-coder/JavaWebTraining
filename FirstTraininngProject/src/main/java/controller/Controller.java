package controller;
import constants.Const;
import model.entity.*;
import view.View;

import java.util.Scanner;

/**
 * Created by andri on 11/17/2016.
 */
public class Controller {
    /**
     * the instance of model where stores all business logic
     */
    private GameRoom model;
    /**
     * the instance of view where implements the work with console
     */
    private View view;

    /**
     * constructor, where initialize the model and view
     * @param model the instance of model
     * @param view the instance of view
     */
    public Controller(GameRoom model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * the method which sets the sequence of calls in program
     */
    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        int menuItem = 0;
        do {
            view.printMenu();
            menuItem = inputIntValueWithScanner(scanner);
            switch (menuItem) {
                case Const.GENERATE_DATA_AUTOMATICALLY:
                    generateData();
                    break;
                case Const.DISPLAY_TOYS:
                    view.displayToys(model.getToys());
                    break;
                case Const.DISPLAY_CHILDRENS:
                    view.displayChildren(model.getChildrens());
                    break;
                case Const.SORT_TOYS_BY_PRICE:
                    model.sortToys(SortMethod.BY_TOYS_PRICE);
                    break;
                case Const.SORT_TOYS_BY_NAME:
                    model.sortToys(SortMethod.BY_TOYS_NAME);
                    break;
                case Const.EXIT:
                    System.exit(0);
                default:
                    View.printMessage(Const.WRONG_INPUT + Const.INPUT_INT_DATA);
            }
        }while (menuItem!=Const.EXIT);
    }

    /**
     * method which fills all model's fields
     */
    public void generateData(){
        model.setAllocatedCosts(300);
        model.addToy(new Toy(75, ToyType.DOLL));
        model.addToy(new Toy(25, ToyType.BALL));
        model.addToy(new Toy(100, ToyType.CAR));
        model.addToy(new Toy(50, ToyType.CUBE));
        model.addChild(new Child("Vasia", AgeGroup.EARLY_CHILDHOOD));
        model.addChild(new Child("Petia", AgeGroup.PRESCHOOL));
        model.addChild(new Child("Sasha", AgeGroup.PRIMARY_SCHOOL));
    }

    /**
     * method where implements the input of number from console with scanner
     * @param sc Scanner with the help of which we implement the reading
     * @return the read off number
     */
    public int inputIntValueWithScanner(Scanner sc) {
        while( ! sc.hasNextInt()) {
            view.printMessage(Const.WRONG_INPUT + Const.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }
}
