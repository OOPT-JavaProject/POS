/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.util.Scanner;
/**
 *
 * @author Kai Ben
 */
public final class Menu {
    private static int select;
    private char pos;
    private Employee emp;
    private Scanner scan = new Scanner(System.in);
    
    public Menu(Employee emp) {
        this.emp = emp;
        this.pos = emp.getEmpID().charAt(0);
    }
    
    public void display() {
        if (pos == 'S') {
            displayStaffMenu();
            getStaffInput();
        }
        else if (pos == 'M') {
            displayManagerMenu();
            getManagerInput();
        }
    }
    
    public void displayStaffMenu() {
        System.out.println("Here are the function that can perform by you:");
        System.out.println("1 => Accept Orders");
        System.out.println("2 => Display Receipts");
        System.out.println("3 => Change User");
        System.out.println("4 => Quit");
    }
    
    public void displayManagerMenu() {
        System.out.println("Here are the function that can perform by you:");
        System.out.println("1 => Manage Orders");
        System.out.println("2 => Manage Product");
        System.out.println("3 => Manage User");
        System.out.println("4 => Change User");
        System.out.println("5 => Quit");
    }
    
    public void getStaffInput() {
        do {
            System.out.print("\nPlease select one: ");
            select = scan.nextInt();
            switch (select) {
                case 1:  break;
                case 2:  break;
                case 3: POS.changeUser(); return;
                case 4: POS.exit(); break;
                default: System.out.println("Invalid input."); select = -1;
            }
        } while(select != 4);
    }
    
    public void getManagerInput() {
        do {
            System.out.print("\nPlease select one: ");
            select = scan.nextInt();
            switch (select) {
                case 1: break;
                case 2: break;
                case 3: 
                case 4: POS.changeUser(); return;
                case 5: POS.exit(); break;
                default: System.out.println("Invalid input."); select = -1;
            }
        } while(select != 5);
    }
    
    
}
