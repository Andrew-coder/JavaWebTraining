import controller.Controller;
import model.Note;
import model.NoteBook;
import view.View;

/**
 * Created by andri on 11/8/2016.
 */
public class Main {
    public static void main(String[] args) {
        NoteBook noteBook =new NoteBook();
        View view = new View();
        Controller controller = new Controller(noteBook,view);
        // Run
        controller.processUser();
    }
}
