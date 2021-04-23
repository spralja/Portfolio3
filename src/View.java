import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class View {
    private final Controller control;
    GridPane startView;

    Label selectStudentLabel = new Label("Select Student:");
    ComboBox< Student > studentComboBox = new ComboBox<>();

    Label selectCourseLabel = new Label("Select Course:");
    ComboBox< Course > courseComboBox = new ComboBox<>();
    Button gradeButton = new Button("Grade");
    TextField gradeField = new TextField("");

    Button showCourseInfoButton = new Button("Show Course Info");
    Button showStudentInfoButton = new Button("Show Student Info");

    TableView infoTable = new TableView();

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
        startView.add(gradeButton, 15, 1, 20, 1);
        startView.add(gradeField, 35, 1, 40, 1);
        courseComboBox.setItems(control.getCourses());
        courseComboBox.getSelectionModel().selectFirst();

        startView.add(showCourseInfoButton, 0, 5);
        startView.add(showStudentInfoButton, 10, 5);

        startView.add(infoTable, 0, 6, 30, 16);
        infoTable.setPlaceholder(new Label(""));
    }

    public Parent asParent() {
        return startView;
    }
}
