package com.example;


enum Gender {
    MALE, FEMALE, OTHER
}

abstract class Employee {
    // variables
    //a.class variables
    public static final String COMPANY_NAME = "ABC";
    public static String projectName;
    //b.instance variables
    private int id;
    private String name;
    private Gender gender;
    private double salary;

    // constructor
    Employee(int id) {
        this(id, "Unknown", 0.0);
    }

    Employee(int id, String name) {
        this(id, name, 0.0);
    }

    Employee(int id, String name, double salary) {
        // ...
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id should be greater than 0");
        }

        if (name != null && name.length() > 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("name should not be empty");
        }

        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("salary should be greater than 0");
        }
    }

    // methods
    // a. class methods
    static void printCompanyName() {
        System.out.println(COMPANY_NAME);
    }

    abstract void doWork();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static String getProjectName() {
        return projectName;
    }
    public static void setProjectName(String projectName) {
        Employee.projectName = projectName;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class TestEmployee extends Employee {
    TestEmployee(int id) {
        super(id);
    }

    TestEmployee(int id, String name) {
        super(id, name);
    }

    TestEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    // overriding -> re-implementing super class method
    void doWork() {
        System.out.println(this.getName() + " is working with " + projectName + " on testing");
    }
}
class HR extends Employee {

    HR(int id) {
        super(id);
    }

    HR(int id, String name) {
        super(id, name);
    }

    HR(int id, String name, double salary) {
        super(id, name, salary);
    }

    void doWork() {
        System.out.println(this.getName() + " is working with " + projectName + " on HR");
    }

    void hireEmployee() {
        System.out.println(this.getName() + " is hiring new employees");
    }
}

class EmployeeManagement {
    void manageEmployee(Employee employee) {
        if(employee instanceof HR) {
            HR hr = (HR) employee; // downcasting
            hr.hireEmployee();
        }
        employee.doWork();
    }
}

public class ReferenceTypes {
    public static void main(String[] args) {

        Employee.projectName = "Project-1";

        TestEmployee testEmployee = new TestEmployee(2, "Bob", 900);
        HR hrEmployee = new HR(4, "David", 700);

        EmployeeManagement em = new EmployeeManagement();
        em.manageEmployee(hrEmployee); // upcasting
        em.manageEmployee(testEmployee);


    }
}
