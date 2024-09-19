
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
public class Student extends Person {
    private float gpa;
    private String major;

    public Student(float gpa, String major, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }
    public Student(){};

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
public void addPerson() {
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        this.setId(sc.nextLine());
        System.out.println("Enter Name: ");
        this.setFullName(sc.nextLine());
        System.out.println("Enter GPA: ");
        this.setGpa(sc.nextFloat());
        sc.nextLine(); 
        System.out.println("Enter Major: ");
        this.setMajor(sc.nextLine());
        System.out.println("Enter Date of Birth (yyyy-MM-dd): ");
        String dateStr = sc.nextLine();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        this.setDateOfBirth(dateformat.parse(dateStr));
    } catch (ParseException ex) {
        Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
    }
}

@Override
public void updatePerson() {
    Scanner sc = new Scanner(System.in);
    try {
        System.out.println("Enter new Name: ");
        this.setFullName(sc.nextLine());
        System.out.println("Enter new Major: ");
        this.setMajor(sc.nextLine());
        System.out.println("Enter new GPA: ");
        this.setGpa(sc.nextFloat());
        sc.nextLine(); // consume newline
        System.out.println("Enter new Date of Birth (yyyy-MM-dd): ");
        String dateStr = sc.nextLine();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        this.setDateOfBirth(dateformat.parse(dateStr));
    } catch (ParseException ex) {
        Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    public void displayInfo()
    {
        System.out.println("id : "+getId());
        System.out.println("name :"+getFullName());
        System.out.println("gpa : "+getGpa());
        System.out.println("date of birth: "+ getDateOfBirth());
        System.out.println("major: "+getMajor());
    }
    
}
