import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String URL = "jdbc:sqlite:database.db";
    private static final Integer SCENE_WIDTH = 600;
    private static final Integer SCENE_HEIGHT = 475;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Model model = new Model(URL);
        Controller control = new Controller(model);
        View view = new View(control);
        control.setView(view);
        stage.setTitle("Student Registration");
        stage.setScene(new Scene(view.asParent(), SCENE_WIDTH, SCENE_HEIGHT));
        stage.show();
    }
}
