import java.util.Date;
public class Student extends Person {
    private float gpa;
    private String major;
    Student(String id, String fullName, Date dateOfBirth,float gpa,String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }
    Student(){}

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void displayInfo() {
        System.out.println("--------------------------------");
        System.out.println("Student ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("GPA: " + getGpa());
        System.out.println("Major: " + getMajor());
        System.out.println("--------------------------------");
    }
    public void addStudent(Student student) {}


}
