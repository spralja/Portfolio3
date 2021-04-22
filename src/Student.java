import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

    private Integer PIN;
    private String name;
    private String address;
    public Student(ResultSet rs) throws SQLException {
        PIN = rs.getInt(1);
        name = rs.getString(2);
        address = rs.getString(3);
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Integer getPIN() {
        return this.PIN;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", name, address);
    }
}
