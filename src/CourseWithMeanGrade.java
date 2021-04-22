import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseWithMeanGrade extends Course {
    private String meanGrade;
    public CourseWithMeanGrade(ResultSet rs) throws SQLException {
        super(rs);
        this.meanGrade = rs.getString(5);
    }

    public String getMeanGrade() {
        return meanGrade;
    }
}
