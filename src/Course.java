import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {
    private String name;
    private Integer year;
    private String semester;
    private String teacher;
    public Course(ResultSet rs) throws SQLException {
        this.name = rs.getString(1);
        this.year = rs.getInt(2);
        this.semester = rs.getString(3);
        this.teacher = rs.getString(4);
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getTeacher() {
        return teacher;
    }
}
