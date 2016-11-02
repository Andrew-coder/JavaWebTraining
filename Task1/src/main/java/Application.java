import controller.Controller;
import model.Model;
import view.View;

/**
 class Application starts the less more game
 * Created by andri on 10/29/2016.
 */
public class Application {
    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }
}
