/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;

/**
 *
 * @author Z
 */

    //Fields for Employee
    private String empName;
    private String empID;
    private String empPassword;
    private int yearJoined;
    private int age;
    private String empPos;
    private static ArrayList<Employee> empList = new ArrayList<Employee>(); //ArrayList to store all the employees
    //Constructors
    public Employee(String empName, String empID, String empPassword) {
        this(empName, empID, empPassword, 0, 0);
    }
    public Employee(String empName, String empID, String empPassword, int yearJoined) {
        this(empName, empID, empPassword, yearJoined, 0);
    }
    public Employee(String empName, String empID, String empPassword, int yearJoined, int age) {
        this.empName = empName;
        this.empID = empID.toUpperCase();
        posCheck(this.empID);
        this.empPassword = empPassword;
        this.yearJoined = yearJoined;
        this.age = age;
    }
    
    //Getter and Setter
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }
    
    public int getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmpPos() {
        return empPos;
    }

    public void setEmpPos(String empPos) {
        this.empPos = empPos;
    }

    public static ArrayList<Employee> getEmpList() {
        return empList;
    }
    
    // to Check what position is the employee based on the EMPLOYEE ID
    private String posCheck(String empID) {
        if (empID.charAt(0) == 'M') {
            empPos = "Manager";
            return "M";
        } else if (empID.charAt(0) == 'S') {
            empPos = "Staff";
            return "S";
        }
        return null;
    }
    
    public static void addEmployee(String empName, String empID, String empPassword, int yearJoined, int age) {
        Employee newEmp = new Employee(empName, empID, empPassword, yearJoined, age);
        empList.add(newEmp);
        System.out.println("Successfully Added " + newEmp.empName + " as " + newEmp.empPos);
    }
    
    @Override
    public String toString() {
        return "Employee Name: " + empName + "\nEmployee ID: " + empID + "\nPosition: " + empPos + "\nYear Joined: " + yearJoined
                + "\nAge: " + age + "\n";
    }
}
