import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseWithMeanGrade extends Course {
    private Float meanGrade;
    public CourseWithMeanGrade(ResultSet rs) throws SQLException {
        super(rs);
        this.meanGrade = rs.getFloat(5);
    }
}
