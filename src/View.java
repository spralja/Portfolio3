import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class View {
    private Controller control;
    GridPane startView;

    Label selectStudentLabel = new Label("Select Student:");
    ComboBox< Student > studentComboBox = new ComboBox<>();

    Label selectCourseLabel = new Label("Select Course:");
    ComboBox< Course > courseComboBox = new ComboBox<>();

    Button showCourseInfoButton = new Button("Show Course Info");
    Button showStudentInfoButton = new Button("Show Student Info");

    TextArea info = new TextArea();

    public View(Controller control) {
        this.control = control;
        startView = new GridPane();
        startView.setMinSize(300, 200);
        startView.setPadding(new Insets(10, 10, 10, 10));
        startView.setVgap(5);
        startView.setHgap(1);

        startView.add(selectStudentLabel, 0, 0);
        startView.add(studentComboBox, 10, 0);
        studentComboBox.setItems(control.getStudents());
        studentComboBox.getSelectionModel().selectFirst();

        startView.add(selectCourseLabel, 0, 1);
        startView.add(courseComboBox, 10, 1);
        courseComboBox.setItems(control.getCourses());
        courseComboBox.getSelectionModel().selectFirst();

        startView.add(showCourseInfoButton, 0, 5);
        startView.add(showStudentInfoButton, 10, 5);
    }

    public Parent asParent() {
        return startView;
    }
}
