import java.sql.ResultSet;
import java.sql.SQLException;

public class Registration {
    private Integer PIN;
    private String courseName;
    private Integer courseYear;
    private String courseSemester;
    private Float grade;
    private String courseTeacher;

    public Registration(ResultSet rs) throws SQLException{
            PIN = rs.getInt(1);
            courseName = rs.getString(2);
            courseYear = rs.getInt(3);
            courseSemester = rs.getString(4);
            grade = rs.getFloat(5);
            courseTeacher = rs.getString(6);
    }

    private Registration() {}

    public Integer getPIN() {
        return PIN;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCourseYear() {
        return courseYear;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public Float getGrade() {
        return grade;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public static Registration getMEAN(Float grade) {
        Registration MEAN = new Registration();
        MEAN.grade = grade;
        MEAN.courseTeacher = "mean";
        return MEAN;
    }
}