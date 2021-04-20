public class Registration {
    private String studentName;
    private String studentAddress;
    private String courseName;
    private Integer courseYear;
    private String courseSemester;
    private Integer grade;
    private String teacher;
    public Registration(String studentName, String studentAddress, String courseName,
                        Integer courseYear, String courseSemester, Integer grade,
                        String teacher) {

        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.courseName = courseName;
        this.courseYear = courseYear;
        this.courseSemester = courseSemester;
        this.grade = grade;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{\n");
        string.append("studentName: ");
        string.append(this.studentName);
        string.append(",\n");
        string.append("studentAddress: ");
        string.append(this.studentAddress);
        string.append(",\n");
        string.append("courseName: ");
        string.append(courseName);
        string.append(",\n");
        string.append("courseYear: ");
        string.append(courseYear);
        string.append(",\n");
        string.append("courseSemester: ");
        string.append(courseSemester);
        string.append(",\n");
        string.append("grade: ");
        string.append(grade);
        string.append(",\n");
        string.append("teacher: ");
        string.append(teacher);
        string.append(",\n");
        string.append("}");
        return string.toString();
    }
}
