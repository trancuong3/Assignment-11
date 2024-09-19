import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonList {
    private ArrayList<Person> personList;

    public PersonList() {
        personList = new ArrayList<>();
    }

    public void addStudent() {
        Student student = new Student();
        student.addPerson();
        personList.add(student);
    }

    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.addPerson();
        personList.add(teacher);
    }

    public void updatePerson(String id) {
        for (Person p : personList) {
            if (p.getId().equals(id)) {
                p.updatePerson();
                return;
            }
        }
        System.out.println("Person with ID " + id + " not found.");
    }

    public void deletePersonById(String id) {
        boolean removed = personList.removeIf(p -> p.getId().equals(id));
        if (removed) {
            System.out.println("Person with ID " + id + " has been removed.");
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    public Person findPersonById(String id) {
        for (Person p : personList) {
            if (p.getId().equals(id)) {
                p.displayInfo();
                return p;
            }
        }
        System.out.println("Person with ID " + id + " not found.");
        return null;
    }

    public void displayEveryone() {
        if (personList.isEmpty()) {
            System.out.println("No persons to display.");
        } else {
            for (Person p : personList) {
                p.displayInfo();
                System.out.println();
            }
        }
    }

    public Student findTopStudent() {
        Student topStudent = null;
        for (Person p : personList) {
            if (p instanceof Student) {
                Student student = (Student) p;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }
        if (topStudent != null) {
            System.out.println("Top Student:");
            topStudent.displayInfo();
        } else {
            System.out.println("No students found.");
        }
        return topStudent;
    }

    public void findTeachersByDepartment(String department) {
        boolean found = false;
        for (Person p : personList) {
            if (p instanceof Teacher && ((Teacher) p).getDepartment().equals(department)) {
                found = true;
                p.displayInfo();
                System.out.println();
            }
        }
        if (!found) {
            System.out.println("No teachers found in department " + department);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonList personList = new PersonList();
        int choice = 0;
        do {
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Update Person by ID");
            System.out.println("4. Delete Person by ID");
            System.out.println("5. Find Person by ID");
            System.out.println("6. Display All");
            System.out.println("7. Find Top Student");
            System.out.println("8. Find Teachers by Department");
            System.out.println("9. Exit");
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // clear invalid input
                continue;
            }

            switch (choice) {
                case 1 -> personList.addStudent();
                case 2 -> personList.addTeacher();
                case 3 -> {
                    System.out.println("Enter ID to update:");
                    String id = sc.nextLine();
                    personList.updatePerson(id);
                }
                case 4 -> {
                    System.out.println("Enter ID to delete:");
                    String id = sc.nextLine();
                    personList.deletePersonById(id);
                }
                case 5 -> {
                    System.out.println("Enter ID to find:");
                    String id = sc.nextLine();
                    personList.findPersonById(id);
                }
                case 6 -> personList.displayEveryone();
                case 7 -> personList.findTopStudent();
                case 8 -> {
                    System.out.println("Enter Department to find teachers:");
                    String department = sc.nextLine();
                    personList.findTeachersByDepartment(department);
                }
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }
}
