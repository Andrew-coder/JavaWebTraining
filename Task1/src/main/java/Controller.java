import model.Model;

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
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * the method which sets the sequence of calls in program
     */
    public void processUser() {
        view.printMessage(View.GAME_INFO);
        Scanner scanner = new Scanner(System.in);
        int inputNumber = 0;
        do {
            view.printMessage(View.INPUT_INT_DATA);
            view.printBorders(model.getMinValue(), model.getMaxValue());
            inputNumber = inputIntValueWithScanner(scanner);
            model.addToStatistic(inputNumber);
        }while(!model.checkNumber(inputNumber));
        view.printMessage(View.CORRECT_VALUE);
        view.showStatistic(model.getAttempts());
    }

    /**
     * method where implements the input of number from console
     * @param
     * @return the read off value
     */
    public int inputIntValueWithScanner(Scanner sc) {
        while( ! sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT + view.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }
}
