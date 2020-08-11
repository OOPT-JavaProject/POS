
package assignment;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;
/**
 *
 * @author Kai Yuet
 */
public class POS {
    
    public static void main(String[] args) {
        char staffOrManager;
        Employee.addEmployee("Ben", "M02482", "76541", 2002, 18);
        Employee.addEmployee("Alex", "S02482", "HeckYea", 2011, 21);
        
        
        for (Employee e: Employee.getEmpList()) { //Print empList
            System.out.println(e);
        }
        staffOrManager=login();
        if(staffOrManager=='M')
            System.out.println("Login successfully, you are a manager.");
        else
            System.out.println("Login successfully, you are a staff.");
        
    }
    public static char login() {
        String loginID;
        String loginPass;
        char cont;
        ArrayList<Employee> existingEmpList=Employee.getEmpList();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, please start by entering your ID and password.");
        do{
        System.out.print("Staff ID: ");
        loginID=scan.nextLine();
        for(int i=0;i<existingEmpList.size();i++){
            if(loginID.equals(existingEmpList.get(i).getEmpID())){
                System.out.print("Staff password: ");
                loginPass=scan.nextLine();
                if(loginPass.equals(existingEmpList.get(i).getEmpPassword())){
                    if(existingEmpList.get(i).getEmpPos().equals("Manager"))
                        return 'M';
                    else
                        return 'S';
                   
                }
            }                         
        }
        System.out.print("ID entered doesn't exist.\nContinue to enter another ID?: ");
        cont=scan.next().charAt(0);
        scan.nextLine();
        }while(Character.toUpperCase(cont)!='N');
        return cont;
    }
}

