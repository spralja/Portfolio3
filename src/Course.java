import java.sql.Connection;
import java.util.Locale;

public class Course {
    private String name;
    private int year;
    private String semester;
    private String teacher;

    public Course(String name, int year, String semester, String teacher) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.teacher = teacher;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }

    public String getSemester() {
        return this.semester;
    }

    public String getTeacher() {
        return this.teacher;
    }
}
