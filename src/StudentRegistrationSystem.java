import java.io.File;
import java.sql.*;
import java.util.Random;

import static java.sql.DriverManager.getConnection;

public  class StudentRegistrationSystem {
    private static final Random rand = new Random();
    private static final int RAND = 1000000;
    private Connection conn;

    private String url;
    public StudentRegistrationSystem(String url) {
        this.url = url;
    }

    public void createStudent(String name, String address) {
        String sql = "INSERT INTO Students VALUES (?, ?, ?);";
        int ID = getUniqueStudentID();
        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setInt(3, ID);
            pst.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void registerStudentForCourse(
            int studentID, String courseName, int courseYear, String courseSemester) {

        if(!studentExists(studentID)) return;
        if(!courseExists(courseName, courseYear, courseSemester)) return;
        if(registrationExists(studentID, courseName, courseYear, courseSemester)) return;

        String sql = "INSERT INTO Registrations " +
                "(StudentID, CourseName, CourseYear, CourseSemester, Grade) " +
                "VALUES (?, ?, ?, ?, NULL)";
        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            Student student = getStudent(studentID);
            Course course = getCourse(courseName, courseYear, courseSemester);
            pst.setInt(1, student.getID());
            pst.setString(2, course.getName());
            pst.setInt(3, course.getYear());
            pst.setString(4, course.getSemester());
            pst.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private int getUniqueStudentID() {
        int ID;
        String sql = "SELECT ID FROM Students WHERE ID = ?";
        while(true) {
            ID = rand.nextInt(RAND);
            try {
                conn = getConnection(url);
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, ID);
                ResultSet rs = pst.executeQuery();
                if(!rs.next()) break;
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        closeConnection();
        return ID;
    }

    private void closeConnection() {
        if(conn == null) return;
        try {
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean studentExists(int ID) {
        boolean studentExists = true;
        String sql = "SELECT ID FROM Students WHERE ID = ?;";
        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            if(!rs.next()) studentExists = false;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return studentExists;
    }

    private boolean courseExists(String name, int year, String semester) {
        boolean courseExists = true;
        String sql = "SELECT Name, Year, Semester FROM Courses " +
                "WHERE Name = ? AND Year = ? AND Semester = ?;";
        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, year);
            pst.setString(3, semester);
            ResultSet rs = pst.executeQuery();
            if(!rs.next()) courseExists = false;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return courseExists;
    }

    private boolean registrationExists(
            int studentID, String courseName, int courseYear, String courseSemester) {
        boolean registrationExists = true;
        String sql = "SELECT StudentID, CourseName, CourseYear, CourseSemester " +
                "FROM Registrations " +
                "WHERE StudentID = ? AND CourseName = ? " +
                "AND CourseYear = ? AND CourseSemester = ?;";
        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, studentID);
            pst.setString(2, courseName);
            pst.setInt(3, courseYear);
            pst.setString(4, courseSemester);
            ResultSet rs = pst.executeQuery();
            if(!rs.next()) registrationExists = false;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return registrationExists;
    }

    private Student getStudent(int ID) {
        if(!studentExists(ID)) return null;
        Student student = null;
        String sql = "SELECT Name, Address, ID FROM Students WHERE ID = ?;";

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                student = new Student(rs);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            closeConnection();
            return null;
        }

        closeConnection();
        return student;
    }

    private Course getCourse(String name, int year, String semester) {
        if(!courseExists(name, year, semester)) return null;
        Course course = null;
        String sql = "SELECT Name, Year, Semester, Teacher FROM Courses " +
                "WHERE Name = ? AND Year = ? AND Semester = ?";

        try {
            conn = getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, year);
            pst.setString(3, semester);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                course = new Course(rs);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            closeConnection();
            return null;
        }

        closeConnection();
        return course;
    }
}
