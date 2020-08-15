/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author Z
 */
public class Manager extends Employee{
    private Scanner scan = new Scanner(System.in);
    public Manager(Employee emp) {
        super(emp.getEmpName(), emp.getEmpID(), emp.getEmpPassword(), emp.getYearJoined(), emp.getAge());
    }
    public Manager(String empName, String empID, String empPassword, int yearJoined, int age) {
        super(empName, empID, empPassword, yearJoined, age);
    }
    
    public void dMenu() {
        int sel = 0;
        do {
            if (sel != -1) Menu.displayManagerMenu();
            sel = Menu.getInput();
            switch (sel) {
                case 1: manageOrder(); break;
                case 2: manageProduct(); break;
                case 3: manageUser(); break;
                case 4: POS.changeUser(); break; // ChangeUser(LogOut)
                case 0: POS.exit(); break; // Quit Program
                default: System.out.println("Invalid input."); sel = -1;
            }
        } while(sel != 0);
    }
    
    public void manageOrder() {
        int sel = 0;
        do {
            if (sel != -1) Menu.displayManagerOrderMenu();
            sel = Menu.getInput();
            switch (sel) {
                case 1:  break;
                case 2:  break;
                case 3:  break;
                case 4:  break;
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
        } while(sel != 0);
    }
    public void manageProduct() {
        int sel = 0;
        do {
            if (sel != -1) Menu.displayManagerProductMenu();
            sel = Menu.getInput();
            switch (sel) {
                case 1:  break;
                case 2:  break;
                case 3:  break;
                case 4:  break;
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
        } while(sel != 0);
    }
    public void manageUser() {
        int sel = 0;
        do {
            if (sel != -1) Menu.displayManagerUserMenu();
            sel = Menu.getInput();
            switch (sel) {
                case 1:  Employee.displayAllEmp(); break; // display all user
                case 2:  Employee.addEmployee(); break; // add user
                case 3:  Employee.modifyEmployee(); break; // modify user
                case 4:  Employee.removeEmployee(); break; // remove user
                case 5:  Employee.searchEmployee(); break; // search user
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
        } while(sel != 0);
    }
    
    
}
