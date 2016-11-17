import controller.Controller;
import model.entity.GameRoom;
import view.View;

public class Main {

    public static void main(String[] args)  {
        // Initialization

        GameRoom model =new GameRoom();
        View view = new View();
        Controller controller = new Controller(model,view);
        // Run
        controller.processUser();

    }
}
