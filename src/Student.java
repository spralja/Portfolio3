public class Student {
    private String name;
    private String address;
    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String changeAddress(String address) {
        final String OLD_ADDRESS = this.address;
        this.address = address;
        return OLD_ADDRESS;
    }

    public String changeName(String name) {
        final String OLD_NAME = this.name;
        this.name = name;
        return OLD_NAME;
    }
}
