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
    
    @Override
    public double rateOfOvertimePay() {
        return 1.9;
    }
    
    @Override
    public double rateOfCommission() {
        return 0.25;
    }
    
    public double getSalary() {
        double basicSalary = 4000, hourlyPayRate = 25, overtimeHours, totalSales;
        
        System.out.print("Overtime hours worked of the month : ");
        overtimeHours = POS.scan.nextDouble();
        System.out.print("Total Sales of the month : ");
        totalSales = POS.scan.nextDouble();
        return basicSalary + hourlyPayRate * overtimeHours * rateOfOvertimePay() + totalSales * rateOfCommission();
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
                case 4: manageMembership(); break;
                case 5: POS.changeUser(); break; // ChangeUser(LogOut)
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
                case 1: Order.addOrder(); break; // Accept Orders
                case 2: Order.displayReceipt(); break; // Display All Orders
                case 3: Order.modifyOrder(); break; // Modify Order
                case 4: Order.searchOrder(); break; // Search Order
                case 5: Order.orderSummary(); break; // Order Summary
                case 6: Order.removeOrder(); break; // Remove order
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
            POS.pause();
        } while(sel != 0);
    }
    public void manageProduct() {
        int sel = 0;
        do {
            if (sel != -1) Menu.displayManagerProductMenu();
            sel = Menu.getInput();
            switch (sel) {
                case 1:  Product.displayAllProd(); break; //Display All Products
                case 2:  Product.addProduct(); break; //Add Product
                case 3:  Product.modifyProd(); break; //Modify Product
                case 4:  Product.removeProd(); break; //Remove Product
                case 5:  Product.searchProduct(); break; //Search Product
                case 6:  Product.addStock(); break; //Add products' stock
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
            POS.pause();
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
                case 6:  Employee.salaryEmployee(); break;
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
            POS.pause();
        } while(sel != 0);
    }

    public void manageMembership() {
        int sel = 0;
        do {
            if (sel != -1) Menu.displayManagerMembershipMenu();
            sel = Menu.getInput();
            switch (sel) {
                case 1:  Membership.displayMember(); break; // display all membership
                case 2:  Membership.addMember(); break; // add membership
                case 3:  Membership.modifyMember(); break; // modify membership
                case 4:  Membership.removeMember(); break; // remove membership
                case 5:  Membership.searchMember(); break; // search membership
                case 6:  Membership.displayActivity(); break; // display activity of the day
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
            POS.pause();
        } while(sel != 0);
    }
}
