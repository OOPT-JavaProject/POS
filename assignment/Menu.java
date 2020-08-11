/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Kai Ben
 */
public class Menu {
    private int select;
    private char pos;
    
    public Menu(char pos) {
        this.pos = pos;
        if (pos == 'S') {
            displayStaffMenu();
            getStaffInput();
        }
        else {
            displayManagerMenu();
            getManagerInput();
        }
    }
    
    public static void displayStaffMenu() {
        System.out.println("Here are the function that can perform by you:");
        System.out.println("1 => Accept Orders");
        System.out.println("2 => Display Receipts");
        System.out.println("3 => Change User");
        System.out.println("4 => Quit");
    }
    
    public static void displayManagerMenu() {
        System.out.println("Here are the function that can perform by you:");
        System.out.println("1 => Accept Orders");
        System.out.println("2 => Display Receipts");
        System.out.println("3 => Change User");
        System.out.println("4 => Quit");
        System.out.println("4 => Quit");
    }
    
    public static void getStaffInput() {
        System.out.print("Please select one: ");
        //scan.
    }
    
    public static void getManagerInput() {
        System.out.print("Please select one: ");
    }
    
    
}
