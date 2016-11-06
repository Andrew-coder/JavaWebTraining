import controller.Controller;
import model.Record;
import model.RecordBook;
import view.View;

/**
 * Created by andri on 11/5/2016.
 */
public class Main {
    public static void main(String[] args) {
        // Initialization

        RecordBook recordBook =new RecordBook();
        View view = new View();
        Controller controller = new Controller(recordBook,view);
        // Run
        controller.processUser();

    }
}
