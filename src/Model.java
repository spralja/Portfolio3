import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public  class Model {
    private String url;

    public Model(String url) {
        this.url = url;
    }

    public ArrayList< Registration > getRegistrationsOfStudentArrayList(Integer PIN) {

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
            handleException(e);
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
            handleException(e);
        } finally {
            closeConnection(conn);
        }

        return meanGrade;
    }

    public CourseWithMeanGrade getCourseWithMeanGrade(
            Course course
    ) {
        CourseWithMeanGrade courseWithMeanGrade = null;
        String sql = "SELECT Courses.Name, Courses.Year, Courses.Semester, Courses.Teacher, " +
                "AVG(Registrations.Grade) " +
                "FROM Courses " +
                "INNER JOIN Registrations " +
                "ON Registrations.CourseName = Registrations.CourseName AND " +
                "Courses.Year = Registrations.CourseYear AND " +
                "Courses.Semester = Registrations.CourseSemester " +
                "WHERE CourseName = ? AND CourseYear = ? AND CourseSemester = ?;";

        Connection conn = null;

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, course.getName());
            pst.setInt(2, course.getYear());
            pst.setString(3, course.getSemester());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                courseWithMeanGrade = new CourseWithMeanGrade(rs);
            }
        } catch(SQLException e) {
           handleException(e);
        } finally {
            closeConnection(conn);
        }

        return courseWithMeanGrade;
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

    public void grade(Student student, Course course, String grade) {
        if(!isGrade(grade)) return;
        if(isGraded(student, course)) return;
        String sql = "UPDATE Registrations " +
                "SET grade = ? " +
                "WHERE PIN = ? AND CourseName = ? AND CourseYear = ? AND CourseSemester = ?;";

        Connection conn = null;
        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, grade);
            pst.setInt(2, student.getPIN());
            pst.setString(3, course.getName());
            pst.setInt(4, course.getYear());
            pst.setString(5, course.getSemester());
            pst.executeUpdate();
        } catch(SQLException e) {
            handleException(e);
        } finally {
            closeConnection(conn);
        }
    }

    private boolean isGrade(String grade) {
        if(grade.equals("12")) return true;
        if(grade.equals("10")) return true;
        if(grade.equals("7")) return true;
        if(grade.equals("4")) return true;
        if(grade.equals("02")) return true;
        if(grade.equals("00")) return true;
        if(grade.equals("-2")) return true;
        if(grade.equals("-3")) return true;

        return false;
    }

    public boolean isGraded(Student student, Course course) {
        boolean isGraded = true;
        String sql = "SELECT * FROM Registrations " +
                "WHERE PIN = ? AND CourseName = ? AND CourseYear = ? AND " +
                "CourseSemester = ? AND Grade IS NULL;";

        Connection conn = null;
        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, student.getPIN());
            pst.setString(2, course.getName());
            pst.setInt(3, course.getYear());
            pst.setString(4, course.getSemester());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                isGraded = false;
            }
        } catch(SQLException e) {
            handleException(e);
        } finally {
            closeConnection(conn);
        }

        return isGraded;
    }
}
