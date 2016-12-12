package controller;

import model.Model;
import view.View;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by andri on 10/29/2016.
 */
public class Controller {
    /**
     * the instance of model where stores all business logic
     */
    private Model model;
    /**
     * the instance of view where implements the work with console
     */
    private View view;

    /**
     * constructor, where initialize the model and view
     * @param model the instance of model
     * @param view the instance of view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * the method which sets the sequence of calls in program
     */
    public void processUser() {
        InputStream inputStream = System.in;
        //setting range
        view.printMessage(View.GAME_INFO);
        Scanner scanner = new Scanner(System.in);
        int minimumValue = 0;
        int maximumValue = 0;

        do {
            view.printMessage(View.INPUT_INT_DATA+View.MINIMUM_RANGE_VALUE);
            minimumValue = inputIntValueWithScanner(inputStream);
            view.printMessage(View.INPUT_INT_DATA+View.MAXIMUM_RANGE_VALUE);
            maximumValue = inputIntValueWithScanner(inputStream);
        }while (minimumValue>=maximumValue);
        model.setRange(minimumValue, maximumValue);

        //guessing the value
        guessingProcess(inputStream);
    }

    public void guessingProcess(InputStream in) {
        int inputNumber = 0;
        do {
            view.printMessage(View.INPUT_INT_DATA);
            view.printBorders(model.getMinValue(), model.getMaxValue());
            inputNumber = inputIntValueInRange(in);
            model.addToStatistic(inputNumber);
        }while(!model.checkNumber(inputNumber));
        view.printMessage(View.CORRECT_VALUE);
        view.showStatistic(model.getAttempts());
    }

    /**
     * method where implements the input of number from console with scanner
     * @param inputStream stream with the help of which we implement the reading
     * @return the read off number
     */
    public int inputIntValueWithScanner(InputStream inputStream) {
        Scanner sc = new Scanner(inputStream);
        while( ! sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT + view.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * method where implements the input of number from console
     * in range with all necessary checks
     * @param stream strwam with the help of which we implement the reading
     * @return the read off value
     */
    public int inputIntValueInRange(InputStream stream) {
        Scanner sc = new Scanner(stream);
        int res=0;
        while( true ) {
            // check int - value
            while (!sc.hasNextInt()) {
                view.printMessage(View.WRONG_INPUT + View.INPUT_INT_DATA);
                sc.next();
            }
            // check value in diapason
            if ((res = sc.nextInt()) <= model.getMinValue() ||
                    res >= model.getMaxValue()) {
                view.printMessage(View.WRONG_RANGE_DATA
                        + View.INPUT_INT_DATA);
                continue ;
            }
            break;
        }
        return res;
    }
}
