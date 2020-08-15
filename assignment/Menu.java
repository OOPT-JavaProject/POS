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
    private static Scanner scan = new Scanner(System.in);
    
    public Menu() {
    }
    
//    public void display() {
//        if (pos == 'S') {
//            displayStaffMenu();
//            getStaffInput();
//        }
//        else if (pos == 'M') {
//            displayManagerMenu();
//            getManagerInput();
//        }
//    }

    //////////////////////////////MANAGER MENU///////////////////////////////////////////////
    public static void displayManagerMenu() {
        System.out.println("\nHere are the function that can perform by you:");
        System.out.println("1 => Manage Orders");
        System.out.println("2 => Manage Product");
        System.out.println("3 => Manage User");
        System.out.println("4 => Change User");
        System.out.println("0 => Quit");
    }
    
    public static void displayManagerOrderMenu() {
        System.out.println("\nManage Order:");
        System.out.println("1 => Display All Orders");
        System.out.println("2 => Modify Order");
        System.out.println("3 => Remove Order");
        System.out.println("4 => Search Order");
        System.out.println("0 => Return to main menu");
    }
    
    public static void displayManagerProductMenu() {
        System.out.println("\nManage Product:");
        System.out.println("1 => Display All Products");
        System.out.println("2 => Modify Product");
        System.out.println("3 => Remove Product");
        System.out.println("4 => Search Product");
        System.out.println("0 => Return to main menu");
    }
    
    public static void displayManagerUserMenu() {
        System.out.println("\nManage User:");
        System.out.println("1 => Display All Users");
        System.out.println("2 => Add User");
        System.out.println("3 => Modify User");
        System.out.println("4 => Remove User");
        System.out.println("5 => Search User");
        System.out.println("0 => Return to main menu");
    }
    
    public static void displayManagerModifyUserMenu() {
        System.out.println("\nModify User:\n(Select what field to modify)");
        System.out.println("1 => Name");
        System.out.println("2 => Employee ID");
        System.out.println("3 => Year Joined");
        System.out.println("4 => Age");
        System.out.println("5 => Remove User");
        System.out.println("0 => Return to main menu");
    }
    
    public static void displaySearchByMenu() {
        System.out.println("\nSearch By:\n(Select what field to search)");
        System.out.println("1 => Name");
        System.out.println("2 => Employee ID");
        System.out.println("3 => Position");
        System.out.println("4 => Year Joined");
        System.out.println("5 => Age");
        System.out.println("6 => Password");
        System.out.println("0 => Return to main menu");
    }
    
    ////////////////////////STAFF/////////////////////////////////////////////////////////////////
    public static void displayStaffMenu() {
        System.out.println("\nHere are the function that can perform by you:");
        System.out.println("1 => Accept Orders");
        System.out.println("2 => Display All Products");
        System.out.println("3 => Display Receipts");
        System.out.println("4 => Change User");
        System.out.println("0 => Quit");
    }
    
    public static void displayStaffOrderMenu() {
        System.out.println("\nManger Order:");
        System.out.println("1 => Accept Orders");
        System.out.println("2 => Display All Orders");
        System.out.println("3 => Modify Order");
        System.out.println("4 => Search Order");
        System.out.println("0 => Return to main menu");
    }
    
    public static int getInput() {
        System.out.print("\nPlease select one: ");
        select = scan.nextInt();
        scan.nextLine();
        return select;
    }
}
