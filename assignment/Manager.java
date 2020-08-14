/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Z
 */
public class Manager extends Employee{
    public Manager(Employee emp) {
        super(emp.getEmpName(), emp.getEmpID(), emp.getEmpPassword(), emp.getYearJoined(), emp.getAge());
        Menu menu = new Menu(this);
    }
    public Manager(String empName, String empID, String empPassword, int yearJoined, int age) {
        super(empName, empID, empPassword, yearJoined, age);
    }
    
    
    
}
