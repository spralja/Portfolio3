import com.sun.source.doctree.DeprecatedTree;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import static java.sql.DriverManager.getConnection;

public  class Model {
    private static final Random rand = new Random();
    private static final Integer RAND = 1000000;
    private String url;

    public Model(String url) {
        this.url = url;
    }

    public ArrayList< Registration > getRegisteredCoursesOfStudent(Integer PIN) {

        ArrayList< Registration > registrations = new ArrayList<>();
        String sql = "SELECT Registrations.PIN, " +
                "Registrations.CourseName, Registrations.CourseYear, " +
                "Registrations.CourseSemester, Registrations.Grade, Courses.Teacher " +
                "FROM Registrations " +
                "INNER JOIN Courses " +
                "ON Registrations.CourseName = Courses.Name AND " +
                "Registrations.CourseYear = Courses.Year AND " +
                "Registrations.CourseSemester = Courses.Semester " +
                "WHERE Registrations.PIN = ?;";

        Connection conn = null;

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, PIN);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) registrations.add(new Registration(rs));

        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            closeConnection(conn);
        }

        return registrations;
    }

    public Float getMeanGradeOfStudent(Integer PIN) {
        Float meanGrade = null;
        String sql = "SELECT AVG(Grade) FROM Registrations " +
                "WHERE PIN = ?;";

        Connection conn = null;

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, PIN);
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

    public ArrayList< Student > getStudentArrayList() {
        ArrayList< Student > students = new ArrayList<>();
        String sql = "SELECT PIN, Name, Address " +
                "FROM Students";

        Connection conn = null;

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                students.add(new Student(rs));
            }

        } catch(SQLException e) {
            handleException(e);
        } finally {
            closeConnection(conn);
        }

        return students;
    }

    public ArrayList< Course > getCourseArrayList() {
        ArrayList< Course > courses = new ArrayList<>();
        String sql = "SELECT Name, Year, Semester, Teacher FROM Courses";

        Connection conn = null;

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                courses.add(new Course(rs));
            }

        } catch(SQLException e) {
            handleException(e);
        } finally {
            closeConnection(conn);
        }

        return courses;
    }

    private void closeConnection(Connection conn) {
        if(conn == null) return;
        try {
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleException(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
}
