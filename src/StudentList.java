import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    private ArrayList<Student> students;
    public void addStudent(Student student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        student.setId(sc.nextLine());
        System.out.println("Enter Full Name: ");
        student.setFullName(sc.nextLine());
        System.out.println("Enter Date of Birth (YYYY-MM-DD): ");
        String date = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            student.setDateOfBirth(dateFormat.parse(date));
        } catch (Exception e) {
            System.out.println("Invalid Date Format");
        }
        System.out.println("Enter GPA: ");
        student.setGpa(sc.nextFloat());
        sc.nextLine();
        System.out.println("Enter Major: ");
        student.setMajor(sc.nextLine());
        students.add(student);

    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println("--------------------------------");
                student.displayInfo();
                System.out.println("--------------------------------");
            }
        }
    }

    public void deleteStudentById(String id) {
        for (int i = students.size() - 1; i >= 0; i--) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
            }
        }
    }

    Student findStudentByID(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.displayInfo();
                return student;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return null;
    }

    public float findMaxGpa() {
        float maxGpa = 0;
        for (Student student : students) {
            if (student.getGpa() > maxGpa) {
                maxGpa = student.getGpa();
            }
        }
        return maxGpa;
    }

    Student findTopStudent() {
        float maxGpa = findMaxGpa();
        for (Student student : students) {
            if (student.getGpa() == maxGpa) {
                System.out.println("Top student: " );
                student.displayInfo();
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        studentList.students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Delete Student by ID");
            System.out.println("4. Find Student by ID");
            System.out.println("5. Find Top Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student newStudent = new Student();
                    studentList.addStudent(newStudent);
                    studentList.displayStudents();
                    break;
                case 2:
                    studentList.displayStudents();
                    break;
                case 3:
                    System.out.println("enter id to delete student");
                    sc.nextLine();
                    String id=sc.nextLine();
                    studentList.deleteStudentById(id);
                    studentList.displayStudents();
                    break;
                case 4: System.out.println("enter id to find student");
                    sc.nextLine();
                    String Id=sc.nextLine();
                    studentList.findStudentByID(Id);
                    break;
                case 5:
                    studentList.findTopStudent();
                 break;

            }
        }while(choice!=0);
    }
}
