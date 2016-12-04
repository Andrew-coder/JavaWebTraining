import controller.Controller;
import model.Model;
import view.View;

/**
 * Created by andri on 12/4/2016.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }
}
