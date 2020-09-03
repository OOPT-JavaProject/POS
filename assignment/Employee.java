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
public abstract class Employee implements Salary{
    //Fields for Employee
    private String empName;
    private String empID;
    private String empPassword;
    private int yearJoined;
    private int age;
    private String empPos;
    private static ArrayList<Employee> empList = new ArrayList<Employee>(); //ArrayList to store all the employees
    //Constructors
    public Employee(String empName, String empID, String empPassword) {
        this(empName, empID, empPassword, 0, 0);
    }
    public Employee(String empName, String empID, String empPassword, int yearJoined) {
        this(empName, empID, empPassword, yearJoined, 0);
    }
    public Employee(String empName, String empID, String empPassword, int yearJoined, int age) {
        this.empName = empName;
        this.empID = empID.toUpperCase();
        posCheck(this.empID);
        this.empPassword = empPassword;
        this.yearJoined = yearJoined;
        this.age = age;
    }
    
    public static void init() {
        Employee.addEmployee("Ben Nie", "M02482", "76541", 2002, 18);
        Employee.addEmployee("Alex", "S02482", "HeckYea", 2011, 21);
    }
    
    //Getter and Setter
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }
    
    public int getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmpPos() {
        return empPos;
    }

    public void setEmpPos(String empPos) {
        this.empPos = empPos;
    }

    public static ArrayList<Employee> getEmpList() {
        return empList;
    }
    
    // to Check what position is the employee based on the EMPLOYEE ID
    private String posCheck(String empID) {
        if (empID.charAt(0) == 'M') {
            empPos = "Manager";
            return "M";
        } else if (empID.charAt(0) == 'S') {
            empPos = "Staff";
            return "S";
        }
        return null;
    }
    
    public void manageMembership() {
        int sel = 0;
        do {
            if (sel != -1) Menu.displayManagerMembershipMenu();
            sel = Menu.getInput();
            switch (sel) {
                case 1:  Membership.displayMember(); POS.pause();break; // display all membership
                case 2:  Membership.addMember(); POS.pause();break; // add membership
                case 3:  Membership.modifyMember(); break; // modify membership
                case 4:  Membership.removeMember(); POS.pause();break; // remove membership
                case 5:  Membership.searchMember(); break; // search membership
                case 6:  Membership.displayActivity(); POS.pause();break; // display activity of the day
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
        } while(sel != 0);
    }
    
    public static void addEmployee() { //Add Employee(Data come from Input from user)
        String empName;
        String empID;
        String empPassword;
        int yearJoined;
        int age;
        
        System.out.println("Adding new employee:\n(Enter all the information)");
        System.out.print("Name : ");
        empName = POS.scan.nextLine();
        do {
            System.out.print("ID : ");
            empID = POS.scan.nextLine();
        } while(!Validation.vEmpID(empID) || Validation.vEmpIDExist(empID));
        do {
            System.out.print("New Password : ");
            empPassword = POS.scan.nextLine();
        } while(!Validation.vPw(empPassword));
        yearJoined = Validation.vYearJoined(); //Input yearJoined with validation with default print message
        age = Validation.vAge(); //Input age with validation with default print message
        
        if (Character.toUpperCase(empID.charAt(0)) == 'S') {
            Employee newEmp = new Staff(empName, empID, empPassword, yearJoined, age);
            empList.add(newEmp);
            System.out.println("Successfully Added " + newEmp.empName + " as " + newEmp.empPos);
        }
        else if (Character.toUpperCase(empID.charAt(0)) == 'M') {
            Employee newEmp = new Manager(empName, empID, empPassword, yearJoined, age);
            empList.add(newEmp);
            System.out.println("Successfully Added " + newEmp.empName + " as " + newEmp.empPos);
        }
    }
    
    //Add Employee(Data come from passed-in parameter)
    public static void addEmployee(String empName, String empID, String empPassword, int yearJoined, int age) {
        if (empID.charAt(0) == 'S') {
            Employee newEmp = new Staff(empName, empID, empPassword, yearJoined, age);
            empList.add(newEmp);
            System.out.println("Successfully Added " + newEmp.empName + " as " + newEmp.empPos);
        }
        else if (empID.charAt(0) == 'M') {
            Employee newEmp = new Manager(empName, empID, empPassword, yearJoined, age);
            empList.add(newEmp);
            System.out.println("Successfully Added " + newEmp.empName + " as " + newEmp.empPos);
        }
    }
    
    public static void removeEmployee() { //Remove Employee(Prompt user which user to remove)
        int i;
        System.out.println("Current Employee:");
        displayAllEmp();
        //System.out.print("\nPlease enter the No. to remove => ");
        //i = POS.scan.nextInt();
        do {
            i = Validation.vInt("\nPlease enter the No. to remove => ");
            if (i < 1 || i > empList.size()) System.out.println("Invalid Input.");
            else if (POS.userID.equalsIgnoreCase(empList.get(i-1).getEmpID())) System.out.println("You cannot Remove a user that is logged on.");
        } while (i < 1 || i > empList.size() || POS.userID.equalsIgnoreCase(empList.get(i-1).getEmpID()));
        System.out.print("Are you sure? (Y to proceed or press other key to cancel) \n=>");
        if (Character.toUpperCase(POS.scan.next().charAt(0)) == 'Y') {
            System.out.printf("Successfuly removed %s(%s).", empList.get(i-1).getEmpName(), empList.get(i-1).empID);
            empList.remove(i-1);
        }
    }
    
    public static void removeEmployee(int i) { //Remove Employee(Remove the user with the passed-in INDEX i in the empList)
        if(POS.userID.equalsIgnoreCase(empList.get(i-1).getEmpID())){ System.out.println("You cannot Remove a user that is logged on."); return;}
        System.out.print("Are you sure? (Y to proceed or press other key to cancel) \n=>");
        if (Character.toUpperCase(POS.scan.next().charAt(0)) == 'Y') {
            System.out.printf("Successfuly removed %s(%s).", empList.get(i).getEmpName(), empList.get(i).empID);
            empList.remove(i);
        }
    }
    
    public static void modifyEmployee() { //Modify Employee(Prompt user to choose who and what field to modify)
        int i;
        System.out.println("\nCurrent Employee:");
        displayAllEmp();
        //System.out.print("\nPlease enter the No. to modify => "); 
        //i = POS.scan.nextInt();
        do {
            i = Validation.vInt("\nPlease enter the No. to modify => "); //Let user choose who to modify
            if (i < 1 || i > empList.size()) System.out.println("Invalid Input.");
        } while (i < 1 || i > empList.size());
        Employee selectedEmp = Employee.getEmpList().get(i-1); //Store the selected employee object
        modifyEmployee(Employee.getEmpList().indexOf(selectedEmp));
    }
    
    public static void modifyEmployee(ArrayList<Integer> indexList) { //Modify Employee(Prompt user to choose who and what field to modify)
        int i;
        //System.out.println("\nCurrent Employee:");
        //displayAllEmp();
        //System.out.print("\nPlease enter the No. to modify => "); 
        //i = POS.scan.nextInt();
        do {
            i = Validation.vInt("\nPlease enter the No. to modify => "); //Let user choose who to modify
            if (i < 1 || i > indexList.size()) System.out.println("Invalid Input.");
        } while (i < 1 || i > indexList.size());
        Employee selectedEmp = Employee.getEmpList().get(indexList.get(i-1)); //Store the selected employee object
        modifyEmployee(Employee.getEmpList().indexOf(selectedEmp));
    }
    
    public static void modifyEmployee(int index) { //Modify Employee(Prompt user what field to modify from the given index of emp)
        //System.out.println("\nCurrent Employee:\n" + empList.get(index));
        //System.out.print("\nPlease enter the No. to modify => "); 
        //i = POS.scan.nextInt();
        int sel = 0;
        Employee selectedEmp = Employee.getEmpList().get(index); //Store the selected employee object
        do {
            if (sel != -1) {
                System.out.println("\nSelected Employee:\n" + selectedEmp); //Print the selected employee's toString()
                Menu.displayManagerModifyUserMenu();
            }
            sel = Menu.getInput();
            String oldS, newS;
            int oldI, newI;
            switch (sel) {
                case 1: // modify name
                    oldS = selectedEmp.getEmpName();
                    System.out.print("Enter new name : ");
                    selectedEmp.setEmpName(POS.scan.nextLine());
                    System.out.printf("Successfully Modified Name (%s => %s)\n", oldS, selectedEmp.getEmpName());
                    POS.pause();
                    break;
                case 2: // modify EmpID
                    oldS = selectedEmp.getEmpID();
                    if (oldS.equalsIgnoreCase(POS.userID)) {System.out.println("You cannot Modify Employee ID that is logged on.");POS.pause(); break;}
                    do {
                        System.out.print("Enter new employee ID : ");
                        newS = POS.scan.nextLine();
                    } while(!Validation.vEmpID(newS) || Validation.vEmpIDExist(newS));
                    selectedEmp.setEmpID(newS);
                    System.out.printf("Successfully Modified Employee ID (%s => %s)\n", oldS, selectedEmp.getEmpID());
                    selectedEmp.posCheck(selectedEmp.getEmpID());
                    POS.pause();
                    break; 
                case 3: // modify Year Joined
                    oldI = selectedEmp.getYearJoined();
                    selectedEmp.setYearJoined(Validation.vYearJoined("Enter new Year Joined : ")); //Input yearJoined with validation with custom print message
                    System.out.printf("Successfully Modified Year Joined (%d => %d)\n", oldI, selectedEmp.getYearJoined());
                    POS.pause();
                    break;
                case 4: // modify age
                    oldI = selectedEmp.getAge();
                    selectedEmp.setAge(Validation.vAge("Enter new Age : ")); //Input yearJoined with validation with custom print message
                    System.out.printf("Successfully Modified Age (%d => %d)\n", oldI, selectedEmp.getAge());
                    POS.pause();
                    break;
                case 5: Employee.removeEmployee(index); POS.pause();return; // delete user
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
        } while(sel != 0);
    }
    
    public static void searchEmployee() { //Search Employee(Let user search by any of the fields)
        int sel = 0;
        do {
            if (sel != -1) Menu.displaySearchByMenu();
            sel = Menu.getInput();
            String inputS;
            int inputI;
            ArrayList<Integer> foundIndexList = new ArrayList<>();
            switch (sel) {
                case 1: //Search by Name
                    foundIndexList.clear(); //reset the found array because we dont want previous search result
                    System.out.print("Enter name to search: ");
                    inputS = POS.scan.nextLine();
                    for (Employee e: empList) { //loop thru the employee List to see any matches, if matched, add the index into foundIndexList
                        if (e.empName.equals(inputS)) {
                            foundIndexList.add(empList.indexOf(e));
                        }
                    }
                    displayAllEmp(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("%d results found.", foundIndexList.size());
                    askToModify(foundIndexList);
                    break;
                case 2: //Search by EmpID
                    do {
                        System.out.print("Enter Employee ID to search: ");
                        inputS = POS.scan.nextLine();
                    } while(!Validation.vEmpID(inputS));
                    for (Employee e: empList) { 
                        if (e.empID.equals(inputS)) {
                            foundIndexList.add(empList.indexOf(e));
                        }
                    }
                    displayAllEmp(foundIndexList);
                    System.out.printf("%d results found.", foundIndexList.size());
                    askToModify(foundIndexList);
                    break; 
                case 3: //Search by Position
                    foundIndexList.clear();
                    do {
                        System.out.print("Select Position to search: ");
                        System.out.println("\n1. Manager\n2. Staff");
                        inputI = Menu.getInput();
                        if (inputI < 1 && inputI > 2) System.out.println("Invalid Input.");
                    } while(inputI < 1 && inputI > 2);
                    if (inputI == 1) inputS = "Manager";
                    else inputS = "Staff";
                    for (Employee e: empList) { 
                        if (e.empPos.equals(inputS)) {
                            foundIndexList.add(empList.indexOf(e));
                        }
                    }
                    displayAllEmp(foundIndexList);
                    System.out.printf("%d results found.", foundIndexList.size());
                    askToModify(foundIndexList);
                    break;
                case 4: //Search by Year Joined
                    foundIndexList.clear(); 
                    inputI = Validation.vYearJoined("Enter Year Joined to search: ");
                    for (Employee e: empList) { 
                        if (e.yearJoined == inputI) {
                            foundIndexList.add(empList.indexOf(e));
                        }
                    }
                    displayAllEmp(foundIndexList);
                    System.out.printf("%d results found.", foundIndexList.size());
                    askToModify(foundIndexList);
                    break; 
                case 5: //Search by Age
                    foundIndexList.clear(); 
                    inputI = Validation.vAge("Enter Age to search: ");
                    for (Employee e: empList) {
                        if (e.age == inputI) {
                            foundIndexList.add(empList.indexOf(e));
                        }
                    }
                    displayAllEmp(foundIndexList);
                    System.out.printf("%d results found.", foundIndexList.size());
                    askToModify(foundIndexList);
                    break; 
                case 6: //Search by password
                    foundIndexList.clear(); 
                    do {
                        System.out.print("Enter Password to search: ");
                        inputS = POS.scan.nextLine();
                    } while(!Validation.vPw(inputS));
                    for (Employee e: empList) { 
                        if (e.empPassword.equals(inputS)) {
                            foundIndexList.add(empList.indexOf(e));
                        }
                    }
                    displayAllEmp(foundIndexList);
                    System.out.printf("%d results found.", foundIndexList.size());
                    askToModify(foundIndexList);
                    break;
                case 0: return; //return to main menu
                default: System.out.println("Invalid input."); sel = -1;
            }
        } while(sel != 0);
    }
    
    private static void askToModify(ArrayList<Integer> indexList) {
        if (indexList.isEmpty()) return;
        System.out.print("\nDo you want to modify? (y=yes) => ");
        if (Character.toUpperCase(POS.scan.next().charAt(0)) == 'Y') {
            if (indexList.size() > 1) {
                modifyEmployee(indexList);
            }
            else modifyEmployee(indexList.get(0));
        }
    }
    
    public static void displayAllEmp() { //Display All employee in the Employee List
        System.out.println("____________________________________________________________");
        System.out.printf("%4s|\t%10s|\t%6s|\t%9s|%12s|\t%4s\n", "[No]", "Name", "ID", "Position", "Year Joined", "Age");
        System.out.println("------------------------------------------------------------");
        for (Employee e:empList)
            System.out.printf("[%2d]\t%10s\t%6s\t%9s%13s\t%4s\n", empList.indexOf(e) + 1, e.empName, e.empID, e.empPos, e.yearJoined, e.age);
    }
    
    public static void displayAllEmp(ArrayList<Integer> indexList) { //Display All employee based on the selected index in the Employee List
        System.out.println("____________________________________________________________");
        System.out.printf("%4s|\t%10s|\t%6s|\t%9s|%12s|\t%4s\n", "[No]", "Name", "ID", "Position", "Year Joined", "Age");
        System.out.println("------------------------------------------------------------");
        for (Integer i: indexList)
            System.out.printf("[%2d]\t%10s\t%6s\t%9s%13s\t%4s\n", indexList.indexOf(i) + 1, empList.get(i).empName, empList.get(i).empID, empList.get(i).empPos, empList.get(i).yearJoined, empList.get(i).age);
    }
    
    public static void salaryEmployee() {
        System.out.println("\nSalary of All the Employees:");
        for (Employee emp: empList) {
            System.out.println("\nEmployee Name: " + emp.getEmpName());
            System.out.println("Employee Position: " + emp.getEmpPos());
            if (emp instanceof Staff) {
                System.out.println("Salary: " + ((Staff)emp).getSalary());
            }
            else if (emp instanceof Manager) {
                System.out.println("Salary: " + ((Manager)emp).getSalary());
            }
        }
    }
    
    @Override
    public String toString() {
        return "Employee Name: " + empName + "\nEmployee ID: " + empID + "\nPosition: " + empPos + "\nYear Joined: " + yearJoined
                + "\nAge: " + age + "\n";
    }
}
