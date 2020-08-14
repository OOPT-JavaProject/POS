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
public class Staff extends Employee{
    public Staff(Employee emp) {
        super(emp.getEmpName(), emp.getEmpID(), emp.getEmpPassword(), emp.getYearJoined(), emp.getAge());
        Menu menu = new Menu(this);
    }
    public Staff(String empName, String empID, String empPassword, int yearJoined, int age) {
        super(empName, empID, empPassword, yearJoined, age);
    }
    
    
    
}
