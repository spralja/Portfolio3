import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import static java.sql.DriverManager.getConnection;

public  class StudentRegistrationSystem {
    private static final Random rand = new Random();
    private static final Integer RAND = 1000000;
    private String url;

    public StudentRegistrationSystem(String url) {
        this.url = url;
    }

    public ArrayList< Registration > getRegisteredCoursesOfStudent(String studentName,
                                                                   String studentAddress) {

        ArrayList< Registration > registrations = new ArrayList<>();
        String sql = "SELECT Registrations.StudentName, Registrations.StudentAddress, " +
                "Registrations.CourseName, Registrations.CourseYear, " +
                "Registrations.CourseSemester, Registrations.Grade, Courses.Teacher " +
                "FROM Registrations " +
                "INNER JOIN Courses " +
                "ON Registrations.CourseName = Courses.Name AND " +
                "Registrations.CourseYear = Courses.Year AND " +
                "Registrations.CourseSemester = Courses.Semester " +
                "WHERE Registrations.StudentName = ? AND Registrations.StudentAddress = ?;";

        Connection conn = null;

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2, studentAddress);
            ResultSet rs = pst.executeQuery();
            int index = 0;
            while(rs.next()) {
                registrations.add(new Registration(
                        rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getInt(6), rs.getString(7)
                ));

            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }

        return registrations;
    }

    public Float getMeanGradeOfStudent(String studentName, String studentAddress) {
        Float meanGrade = null;
        String sql = "SELECT AVG(Grade) FROM Registrations " +
                "WHERE StudentName = ? AND StudentAddress = ?;";

        Connection conn = null;

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2, studentAddress);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                meanGrade = rs.getFloat(1);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }

        return meanGrade;
    }

    public Float getMeanGradeOfCourse(String courseName, int courseYear, String courseSemester) {
        Float meanGrade = null;
        String sql = "SELECT AVG(Grade) FROM Registrations " +
                "WHERE CourseName = ? AND CourseYear = ? AND CourseSemester = ?;";

        Connection conn = null;

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, courseName);
            pst.setInt(2, courseYear);
            pst.setString(3, courseSemester);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                meanGrade = rs.getFloat(1);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }

        return meanGrade;
    }

    private void closeConnection(Connection conn) {
        if(conn == null) return;
        try {
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
