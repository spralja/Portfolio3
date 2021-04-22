import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
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
}
