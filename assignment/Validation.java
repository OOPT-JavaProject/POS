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
public class Validation {
    
    public Validation() {
        
    }
    
    public static int vInt(String msg) {
        int intIn;
        while(true) {
            System.out.print(msg);
            if (POS.scan.hasNextInt()) {
                intIn = POS.scan.nextInt();
                POS.scan.nextLine();
                return intIn;
            }
            else {
                System.out.println("Invalid input.");
                POS.scan.nextLine();
            }
        }
    }
    
    public static boolean vID(String id) { //validate Employee ID
        if (Character.toUpperCase(id.charAt(0)) == 'M' || Character.toUpperCase(id.charAt(0)) == 'S') {
            return true;
        }
        else {
            System.out.println("Invalid ID.(E.g M02423, S02425)");
            return false;
        }
    }
    
    public static boolean vPw(String password) { //validate New Password
        if (password.length() >= 4 && password.length() <= 10) {
            return true;
        }
        else {
            System.out.println("Invalid Password.(Password length must be 4-10)");
            return false;
        }
    }
    
    public static int vYearJoined() { //validate Year Joined
        int year;
        while (true) {
            System.out.print("Year Joined: ");
            if (POS.scan.hasNextInt()) {
                year = POS.scan.nextInt();
                POS.scan.nextLine();
                if (year >= 2000 && year <= 2020) return year;
            }
            System.out.println("Invalid Year Joined.(Between 2000-2020)");
        }
    }
    
    public static int vYearJoined(String msg) { //validate Year Joined Overload with Custom Message
        int year;
        while (true) {
            System.out.print(msg);
            if (POS.scan.hasNextInt()) {
                year = POS.scan.nextInt();
                POS.scan.nextLine();
                if (year >= 2000 && year <= 2020) return year;
            }
            System.out.println("Invalid Year Joined.(Between 2000-2020)");
        }
    }
    
    public static int vAge() { //validate Age
        int age;
        while (true) {
            System.out.print("Age : ");
            if (POS.scan.hasNextInt()) {
                age = POS.scan.nextInt();
                POS.scan.nextLine();
                if (age >= 16 && age <= 80) return age;
            }
            System.out.println("Invalid Age.");
        }
    }
    public static int vAge(String msg) { //validate Age Overload with Custom Message
        int age;
        while (true) {
            System.out.print(msg);
            if (POS.scan.hasNextInt()) {
                age = POS.scan.nextInt();
                POS.scan.nextLine();
                if (age >= 16 && age <= 80) return age;
            }
            System.out.println("Invalid Age.");
        }
    }
}
