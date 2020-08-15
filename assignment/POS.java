package assignment;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Kai Ben
 */
public class POS {
    static Scanner scan = new Scanner(System.in);
    public static Employee login() {
        String loginID;
        String loginPass;
        char cont;
        ArrayList<Employee> existingEmpList=Employee.getEmpList();
        
        System.out.println("Welcome, please start by entering your ID and password.");
        do{
            System.out.print("Staff ID: ");
            loginID=scan.nextLine();
            for(int i=0;i<existingEmpList.size();i++){
                if(loginID.equals(existingEmpList.get(i).getEmpID())){
                    System.out.print("Staff password: ");
                    loginPass=scan.nextLine();
                    if(loginPass.equals(existingEmpList.get(i).getEmpPassword())){
                        clearScreen();
                        return existingEmpList.get(i);
                    }
                }                         
            }
            System.out.print("ID entered doesn't exist.\nContinue to enter another ID?: ");
            cont=scan.next().charAt(0);
            scan.nextLine();
        }while(Character.toUpperCase(cont)!='N');
        return null;
    }
    
    public static void changeUser() {
        System.out.println("Are you sure you want to logout? (y = yes)");
        if (scan.next().charAt(0) == 'y' || scan.next().charAt(0) == 'Y') {
            System.out.println("Succesfully Logged Out.");
            scan.nextLine();
            displayMenu(login());
        }
        else System.out.println("Log Out Cancelled.");
    }
    
    public static void exit() {
        System.out.println("Exiting program...");
        System.exit(0);
    }
    
    public static void displayMenu(Employee employee) {
        if(employee.getEmpID().charAt(0) == 'M') {
            System.out.println("Login successfully, you are a manager.");
            Manager manager = new Manager(employee);
            manager.dMenu();
        }
        else if (employee.getEmpID().charAt(0) == 'S') {
            System.out.println("Login successfully, you are a staff.");
            //Menu menu = new Menu();
        }
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static void main(String[] args) {
        Employee.addEmployee("Ben Nie", "M02482", "76541", 2002, 18);
        Employee.addEmployee("Alex", "S02482", "HeckYea", 2011, 21);
        
        for (Employee e: Employee.getEmpList()) { //Print empList
            System.out.println(e);
        }
        Employee.displayAllEmp();
        displayMenu(login());
    }
}
