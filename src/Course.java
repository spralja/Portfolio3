import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class Course {
    private String name;
    private int year;
    private String semester;
    private String teacher;
    private int ID;

    public Course(ResultSet rs) {
        try {
            this.name = rs.getString(1);
            this.year = rs.getInt(2);
            this.semester = rs.getString(3);
            this.teacher = rs.getString(4);
            this.ID = rs.getInt(5);
        } catch(SQLException e) {
            e.printStackTrace();
        }
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

    public int getID() {
        return this.ID;
    }
}
