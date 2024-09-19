
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author cuong
 */
public class Teacher extends Person {

    private String department;
    private String teachingSubject;

    public Teacher(String department, String teachingSubject, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public Teacher() {
    }

    ;

    public Teacher(String department, String teachingSubject) {
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

   @Override
public void addPerson() {
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        this.setId(sc.nextLine());
        System.out.println("Enter Name: ");
        this.setFullName(sc.nextLine());
        System.out.println("Enter Department: ");
        this.setDepartment(sc.nextLine());
        System.out.println("Enter Teaching Subject: ");
        this.setTeachingSubject(sc.nextLine());
        System.out.println("Enter Date of Birth (yyyy-MM-dd): ");
        String dateStr = sc.nextLine();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        this.setDateOfBirth(dateformat.parse(dateStr));
    } catch (ParseException ex) {
        Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
    }
}

@Override
public void updatePerson() {
    Scanner sc = new Scanner(System.in);
    try {
        System.out.println("Enter new Name: ");
        this.setFullName(sc.nextLine());
        System.out.println("Enter new Department: ");
        this.setDepartment(sc.nextLine());
        System.out.println("Enter new Teaching Subject: ");
        this.setTeachingSubject(sc.nextLine());
        System.out.println("Enter new Date of Birth (yyyy-MM-dd): ");
        String dateStr = sc.nextLine();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        this.setDateOfBirth(dateformat.parse(dateStr));
    } catch (ParseException ex) {
        Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
    }
}

     public void displayInfo()
    {
        System.out.println("id : "+getId());
        System.out.println("name :"+getFullName());
        System.out.println("department"+getDepartment());
        System.out.println("teachingSubject: "+getTeachingSubject());
        System.out.println("date of birth: "+ getDateOfBirth());
        
    }
}
