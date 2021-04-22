import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {
    protected String name;
    protected Integer year;
    protected Integer yearShort;
    protected String semester;
    protected Character semesterShort;
    protected String teacher;
    public Course(ResultSet rs) throws SQLException {
        this.name = rs.getString(1);
        this.year = rs.getInt(2);
        this.yearShort = year % 100;

        this.semester = rs.getString(3);
        if(semester.equals("autumn")) semesterShort = 'F';
        else semesterShort = 'E';

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

    @Override
    public String toString() {
        return String.format("%s-%c%d", name, semesterShort, yearShort);
    }
}
