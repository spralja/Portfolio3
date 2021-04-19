import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import static java.sql.DriverManager.getConnection;

public  class Student {
    private static final Random rand = new Random();
    private static final int RAND = 1000000;

    public static boolean registerNewStudent(String name, String address) {
        String sql = "INSERT INTO Students (Name, Address, StudentNumber) " +
                "VALUES (?, ?, ?);";
        int StudentNumber = getNewRandomStudentNumber();

        return false;
    }

    private static int getNewRandomStudentNumber() {
        int randomStudentNumber = rand.nextInt(RAND);
        while(true) {
            Connection conn = null;
            ResultSet rs = null;
            String sql = "SELECT StudentNumber " +
                    "FROM Students " +
                    "WHERE StudentNumber = " + randomStudentNumber + ";";

            try {
                String url = "jdbc:sqlite:database.db";
                conn = getConnection(url);
                Statement statement = conn.createStatement();
                rs = statement.executeQuery(sql);
                if(!rs.next()) break;
            } catch(SQLException e) {
                e.printStackTrace();
                return -1;
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch(SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            randomStudentNumber = rand.nextInt(RAND);
        }

        return randomStudentNumber;
    }
}
