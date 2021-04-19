import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    private String name;
    private String address;
    private int ID;

    public Student(ResultSet rs) {
        try {
            this.name = rs.getString(1);
            this.address = rs.getString(2);
            this.ID = rs.getInt(3);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getID() {
        return this.ID;
    }
}
