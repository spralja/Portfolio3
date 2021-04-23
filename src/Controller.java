import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
        view.showStudentInfoButton.setOnAction(
                e -> handlerPrintStudentInfo(
                        view.infoTable,
                        model.getRegistrationsOfStudentArrayList(
                                view.studentComboBox.getValue().getPIN()
                        ),
                        model.getMeanGradeOfStudent(view.studentComboBox.getValue().getPIN())
                )
        );

        view.showCourseInfoButton.setOnAction(e -> handlerPrintCourseInfo(
                view.infoTable,
                model.getCourseWithMeanGrade(view.courseComboBox.getValue())
        ));

        view.gradeButton.setOnAction(e -> handlerGrading(
                view.studentComboBox.getValue(),
                view.courseComboBox.getValue()
        ));
    }

    private void handlerGrading(Student student, Course course) {
        String grade = view.gradeField.getText();
        model.grade(student, course, grade);
        handlerPrintStudentInfo(
                view.infoTable,
                model.getRegistrationsOfStudentArrayList(student.getPIN()),
                model.getMeanGradeOfStudent(student.getPIN())
        );
    }

    public View getView() {
        return view;
    }

    public ObservableList<Student> getStudents() {
        return FXCollections.observableArrayList(model.getStudentArrayList());
    }

    public ObservableList<Course> getCourses() {
        return FXCollections.observableArrayList(model.getCourseArrayList());
    }

    public void handlerPrintStudentInfo(
            TableView table,
            ArrayList< Registration > registrations,
            Float meanGrade
    ) {
        table.getColumns().remove(0, table.getColumns().size());
        table.getItems().remove(0, table.getItems().size());
        TableColumn< Registration, String > column0 = new TableColumn<>("Course Name");
        column0.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        TableColumn< Registration, String > column1 = new TableColumn<>("Year");
        column1.setCellValueFactory(new PropertyValueFactory<>("courseYear"));
        TableColumn< Registration, String > column2 = new TableColumn<>("Semester");
        column2.setCellValueFactory(new PropertyValueFactory<>("courseSemester"));
        TableColumn< Registration, String > column3 = new TableColumn<>("Teacher");
        column3.setCellValueFactory(new PropertyValueFactory<>("courseTeacher"));
        TableColumn< Registration, String > column4 = new TableColumn<>("Grade");
        column4.setCellValueFactory(new PropertyValueFactory<>("grade"));

        table.getColumns().add(column0);
        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);

        for(Registration r : registrations) {
            table.getItems().add(r);
        }

        table.getItems().add(Registration.getMEAN(meanGrade.toString()));
    }

    public void handlerPrintCourseInfo(TableView table, CourseWithMeanGrade course) {
        table.getColumns().remove(0, table.getColumns().size());
        table.getItems().remove(0, table.getItems().size());
        TableColumn< CourseWithMeanGrade, String > column0 = new TableColumn<>("Course Name");
        column0.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn< CourseWithMeanGrade, String > column1 = new TableColumn<>("Year");
        column1.setCellValueFactory(new PropertyValueFactory<>("year"));
        TableColumn< CourseWithMeanGrade, String > column2 = new TableColumn<>("Semester");
        column2.setCellValueFactory(new PropertyValueFactory<>("semester"));
        TableColumn< CourseWithMeanGrade, String > column3 = new TableColumn<>("Teacher");
        column3.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        TableColumn< CourseWithMeanGrade, String > column4 = new TableColumn<>("Mean Grade");
        column4.setCellValueFactory(new PropertyValueFactory<>("meanGrade"));

        table.getColumns().add(column0);
        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);

        table.getItems().add(course);
    }
}
