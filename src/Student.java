import java.sql.SQLException;
import java.util.Random;

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
        String sql = "SELECT StudentNumber" +
                "WHERE StudentNumber = ? FROM Students;";

        return randomStudentNumber;
    }
}
