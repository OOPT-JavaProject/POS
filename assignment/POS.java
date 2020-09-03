package assignment;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Kai Ben
 */
public class POS {
    static Scanner scan = new Scanner(System.in);
    static char cont;
    static Employee loggedUser;
    static String userName, userID;
    public static Employee login() {
        String loginID;
        String loginPass;
        ArrayList<Employee> existingEmpList=Employee.getEmpList();
        
        System.out.println("Welcome, please start by entering your ID and password.");
        do{
            System.out.print("Staff ID: ");
            loginID=scan.nextLine();
            for(int i=0;i<existingEmpList.size();i++){
                if(loginID.equalsIgnoreCase(existingEmpList.get(i).getEmpID())){
                    do {
                        System.out.print("Staff password: ");
                        loginPass=scan.nextLine();
                        if(loginPass.equals(existingEmpList.get(i).getEmpPassword())){
                            clearScreen();
                            return existingEmpList.get(i);
                        }
                        System.out.print("Password entered is wrong.\nRetry?(y=yes) : ");
                        cont=scan.next().charAt(0);
                        scan.nextLine();
                    } while(Character.toUpperCase(cont) == 'Y');
                    break;
                }
                else if (i == existingEmpList.size() - 1) System.out.println("ID doesn't exist."); //if the for loop reached the last emp, means id not found
            }
            System.out.print("Continue to enter another ID?(y=yes): ");
            cont=scan.next().charAt(0);
            scan.nextLine();
        }while(Character.toUpperCase(cont)=='Y');
        return null;
    }
    
    public static void changeUser() {
        System.out.println("Are you sure you want to logout? (y = yes)");
        if (Character.toUpperCase(scan.next().charAt(0)) == 'Y') {
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
        if (employee == null) exit();
        else if(employee.getEmpID().charAt(0) == 'M') {
            System.out.println("Login successfully, you are a manager.");
            Manager manager = new Manager(employee);
            userName = manager.getEmpName();
            userID = manager.getEmpID();
            manager.dMenu();
        }
        else if (employee.getEmpID().charAt(0) == 'S') {
            System.out.println("Login successfully, you are a staff.");
            Staff staff = new Staff(employee);
            userName = staff.getEmpName();
            userID = staff.getEmpID();
            staff.dMenu();
        }
    }
    public static void pause(){ 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
}
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }  
    public static void main(String[] args) {
        
        Employee.init();
        Product.init();
        Membership.init();
        Order.init();
        //Membership.displayMember();
        for (Employee e: Employee.getEmpList()) { //Print empList (DEBUG PURPOSE)
            //System.out.println(e);
        }
        //Employee.displayAllEmp();
        //Product.displayProduct();
        displayMenu(login()); //Login before display the user MENU
    }
}
