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
    }
    public Staff(String empName, String empID, String empPassword, int yearJoined, int age) {
        super(empName, empID, empPassword, yearJoined, age);
    }
    
    @Override
    public double rateOfOvertimePay() {
        return 1.5;
    }
    
    @Override
    public double rateOfCommission() {
        return 0.1;
    }
    
    public double getSalary() {
        double basicSalary = 2000, hourlyPayRate = 18, overtimeHours, totalSales;
        
        System.out.print("Overtime hours worked of the month : ");
        overtimeHours = POS.scan.nextDouble();
        System.out.print("Total Sales of the month : ");
        totalSales = POS.scan.nextDouble();
        return basicSalary + hourlyPayRate * overtimeHours * rateOfOvertimePay() + totalSales * rateOfCommission();
    }
    
    public void dMenu() {
        int sel = 0;
        do {
            if (sel != -1) Menu.displayStaffMenu();
            sel = Menu.getInput();
            switch (sel) {
                case 1: Order.addOrder(); break; // Accept Orders
                case 2: Product.displayAllProd(); POS.pause();break; // Display All Products
                case 3: Order.displayReceipt(); POS.pause();break; // Display Receipts (transaction history)
                case 4: manageMembership(); break; //Manage Membership
                case 5: POS.changeUser(); return; // Change User(LogOut)
                case 0: POS.exit(); break; // Quit Program
                default: System.out.println("Invalid input."); sel = -1;
            }
        } while(sel != 0);
    }
 
}
