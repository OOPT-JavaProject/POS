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
public class POS {
    public static void main(String[] args) {
        Employee.addEmployee("Ben", "M02482", "76541", 2002, 18);
        Employee.addEmployee("Alex", "S02482", "HeckYea", 2011, 21);
        
        if ("22aw" == "22aw") System.out.println("True");
        for (Employee e: Employee.getEmpList()) { //Print empList
            System.out.println(e);
        }
    }
    public static void login() {
        
    }
}
