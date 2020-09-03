package assignment;

import java.util.ArrayList;
import java.time.LocalDate;
public class Membership {
    private String custName;
    private String membershipID;
    private String phoneNo;
    private String address;
    private String level;
    private double rate;
    private LocalDate joinedDate;
    private static ArrayList<Membership> membershipList = new ArrayList<Membership>();
    private static int addMemberCount = 0;
    private static int removeMemberCount = 0;
    private static int modifiedMemberCount = 0;
    //constructors
    public Membership(String custName, String membershipID, String phoneNo,String address,String level,LocalDate joinedDate){
        this.custName=custName;
        this.membershipID=membershipID;
        this.phoneNo=phoneNo;
        this.address=address;
        this.level=level;
        if(level.equals("SILVER"))
            rate=30;
        else
            rate=45;
        this.joinedDate=joinedDate;
    }
    
    public static void init(){
        Membership.addMember("Ben Ben","MS1001","0128594779","NO.30, Jalan 1, Taman 2, 52100 KL","Gold",LocalDate.of(2019,10,24));
        Membership.addMember("Black Lun","MS1002","0138628779","NO.3, Jalan 22, Taman 5, 71250 PD","Gold",LocalDate.of(2019,11,12));
        Membership.addMember("ZhenYan","MS1003","0112275943","NO.52, Jalan Lian, Taman 8, 52100 KL","Silver",LocalDate.of(2019,12,10));
        Membership.addMember("Kai Kai","MS1004","0173335118","NO.35, Jalan 4/39, Taman M, 52100 KL","Silver",LocalDate.of(2020,04,24));
    }
    //getter and setter
    public String getCustName(){
        return custName;
    }
    public void setCustname(String custName){
        this.custName=custName;
    }    
    public String getMembershipID(){
        return membershipID;
    }
    public void setMembershipID(String membershipID){
        this.membershipID=membershipID;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getLevel(){
        return level;
    }
    public void setLevel(String level){
        this.level=level;
    }
    public double getRate(){
        return rate;
    }
    public static ArrayList<Membership> getMemList() {
        return membershipList;
    }
    
    public static Membership addMember(){
        String idPrefix="MS";
        int id=membershipList.size()+1001;
        String custName;
        String membershipID;
        String phoneNo;
        String address;
        String level;
        int vali=1;
        int valiName=1;
        System.out.println("Adding new customer details as a member: ");
        do{
            valiName=1;
            System.out.print("Customer name: ");
            custName=POS.scan.nextLine();
            for(Membership m:membershipList){
                if(custName.equals(m.custName)){
                    valiName=0;
                    System.out.println("This customer is already a member!!");
                }  
            }
        }while(valiName==0);
        membershipID=String.join("",idPrefix,String.valueOf(id));
        System.out.print("Phone Number: ");
        phoneNo=POS.scan.nextLine();
        System.out.print("Address: ");
        address=POS.scan.nextLine();
        do{
            vali=1;
            System.out.print("Level of service requested: ");
            level=POS.scan.nextLine();
            if(!level.equalsIgnoreCase("Silver")&&!level.equalsIgnoreCase("Gold")){
               
                 vali=0;
                 System.out.println("The level is either Silver or Gold!! Please enter again.");
            }
        }while(vali==0);
        Membership newMem=new Membership(custName,membershipID,phoneNo,address,level.toUpperCase(),LocalDate.now());
        membershipList.add(newMem);
        System.out.println("Congratulations on joining as our member "+custName+"! Welcome to the big family!!");
        addMemberCount++;
        return newMem;
    }
    //membership record
    public static void addMember(String custName, String membershipID, String phoneNo,String address, String level,LocalDate joinedDate) {
        Membership newMem=new Membership(custName,membershipID,phoneNo,address,level.toUpperCase(),joinedDate);
        membershipList.add(newMem);
        System.out.println("Congratulations on joining as our member "+custName+"! Welcome to the big family!!");
        addMemberCount++;
    }
    //from menu
    public static void displayMember(){
        System.out.println("Member that holds a gold membership:");
        System.out.println("__________________________________________________________________________________________________________________________________________");
        System.out.printf("%4s||\t%10s||\t%6s||\t%12s||%42s||\t%15s||%16s\n", "[No]", "Name", "ID", "Phone Number", "Address", "Level of service","Date Joined");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for (Membership m:membershipList)
        {
            if(m.level.equals("GOLD"))
                System.out.printf("%4s||\t%10s||\t%6s||\t%12s||\t%40s||\t%16s||%16s\n", membershipList.indexOf(m)+1,m.custName, m.membershipID, m.phoneNo, m.address, m.level,m.joinedDate);
        }
        System.out.println("Member that holds a silver membership:");
        System.out.println("__________________________________________________________________________________________________________________________________________");
        System.out.printf("%4s||\t%10s||\t%6s||\t%12s||%42s||\t%15s||%16s\n", "[No]", "Name", "ID", "Phone Number", "Address", "Level of service","Date Joined");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for (Membership m:membershipList)
        {
            if(m.level.equals("SILVER"))
                System.out.printf("%4s||\t%10s||\t%6s||\t%12s||\t%40s||\t%16s||%16s\n", membershipList.indexOf(m)+1,m.custName, m.membershipID, m.phoneNo, m.address, m.level,m.joinedDate);
        }
    }
    //from search
    public static void displayMember(ArrayList<Integer> searchedList){
        System.out.println("Member searched:");
        System.out.println("__________________________________________________________________________________________________________________________________________");
        System.out.printf("%4s||\t%10s||\t%6s||\t%12s||%42s||\t%15s||%16s\n", "[No]", "Name", "ID", "Phone Number", "Address", "Level of service","Date Joined");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for (Integer i:searchedList)
        {
                System.out.printf("%4s||\t%10s||\t%6s||\t%12s||\t%40s||\t%16s||%16s\n", searchedList.indexOf(i)+1,membershipList.get(i).custName, membershipList.get(i).membershipID, membershipList.get(i).phoneNo, membershipList.get(i).address,membershipList.get(i).level,membershipList.get(i).joinedDate);
        }
    }
    
    public static void modifyMember(){
       boolean modified = false;
       int choice;
       int action=0;
       int validAc=1;
       int newNameC=1;
       int selectedIndex=0;
       char changeLvl;
       int validLvl=1;
       String newName,newPhoneNo,newAddress;
       System.out.println("Here are the current member records: ");
       displayMember();
        do{
            choice = Validation.vInt("\nPlease select a member(index) to modify => "); 
            if (choice< 1 || choice > membershipList.size()) System.out.println("Invalid input. Please enter again.");
            else selectedIndex=choice-1;
        } while (choice < 1 || choice > membershipList.size());
        do{
            System.out.println("\n\nHere are the fields that can be modified: ");
            System.out.println("1. Customer name \n2. Contact number\n3. Address\n4. Level of service.\n5. REMOVE THIS MEMBERSHIP\n0.Back to membership menu");
            do{  
                validAc=1;
                System.out.print("Please select one: ");
                if(POS.scan.hasNextInt()){
                    action=POS.scan.nextInt();
                    POS.scan.nextLine();
                }
                else
                    validAc=0;
            }while(validAc==0);
            switch(action){
                case 1:
                    do{
                        newNameC=1;
                        System.out.print("Enter a new name: ");
                        newName=POS.scan.nextLine();
                        for(Membership m:membershipList){
                            if(newName.equals(m.custName)){
                                newNameC=0;
                                System.out.println("This customer is already a member!!");
                                break;
                            }
                        }   
                    }while(newNameC==0);
                    membershipList.get(selectedIndex).custName=newName;
                    System.out.println("Modified successfully!!");
                    modified = true;
                    break;
                case 2:
                    System.out.print("Enter a new phone number: ");
                    newPhoneNo=POS.scan.nextLine();
                    membershipList.get(selectedIndex).phoneNo=newPhoneNo;
                    System.out.println("Modified successfully!!");
                    modified = true;
                    break;
                case 3: 
                    System.out.print("Enter a new address: ");
                    newAddress=POS.scan.nextLine();
                    membershipList.get(selectedIndex).address=newAddress;
                    System.out.println("Modified successfully!!");
                    modified = true;
                    break;
                case 4:
                    if(membershipList.get(selectedIndex).level.equals("SILVER")){
                        do{
                            validLvl=1;
                            System.out.print("Your current level is silver, do you want to upgrade to gold(Y/N) >");
                            changeLvl=POS.scan.next().charAt(0);
                            if(Character.toUpperCase(changeLvl)=='Y'){
                                membershipList.get(selectedIndex).level="GOLD";
                                System.out.println("Modified successfully!!");
                                modified = true;
                            } 
                            else if(Character.toUpperCase(changeLvl)=='N')
                                break;
                            else
                            {
                                System.out.println("Please enter y/n only.");
                                validLvl=0;
                            }
                        }while(validLvl==0);
                    }
                    else
                         System.out.print("Your current level is gold and is already the highest level!!");
                    break;   
                case 5:
                    removeMember(selectedIndex);
                    break;
                case 0: if (modified) modifiedMemberCount++; return;
                default: System.out.println("Invalid input. Please enter again."); action = -1;
            }
        }while(action!=0);
    }
    
    public static void removeMember(){
        int remove;
        int selectedIndex=0;
        char removeYorN;
        System.out.println("Here are the current member records: ");
        displayMember();
        do{
            remove = Validation.vInt("\nPlease select a member(index) to remove => "); 
            if (remove< 1 || remove > membershipList.size()) System.out.println("Invalid input. Please enter again.");
            else selectedIndex=remove-1;
        } while (remove < 1 || remove > membershipList.size());
        do {
        System.out.print("Are you sure about removing this membership? (Y/y:yes || N/n:no)> ");
        removeYorN=POS.scan.next().charAt(0);
        if(Character.toUpperCase(removeYorN)=='Y'){
            System.out.printf("Removed successfully!! %s is no longer a member.",membershipList.get(selectedIndex).custName);
            membershipList.remove(selectedIndex);
            removeMemberCount++;
        }
        else if (Character.toUpperCase(removeYorN)=='N')
            System.out.println("Remove process cancelled.");
        }while(Character.toUpperCase(removeYorN)!='Y' && Character.toUpperCase(removeYorN)!='N');
    }
    public static void removeMember(int index){
        char removeYorN;
        do {
        System.out.print("Are you sure about removing this membership? (Y/y:yes || N/n:no)> ");
        removeYorN=POS.scan.next().charAt(0);
        if(Character.toUpperCase(removeYorN)=='Y'){
            System.out.printf("Removed successfully!! %s is no longer a member.",membershipList.get(index).custName);
            membershipList.remove(index);
            removeMemberCount++;
        }
        else if (Character.toUpperCase(removeYorN)=='N')
            System.out.println("Remove process cancelled.");
        }while(Character.toUpperCase(removeYorN)!='Y' && Character.toUpperCase(removeYorN)!='N');
    }
    
    public static void searchMember(){
        int search=0,validAc=0,searchCat;
        String cName,cID,cat;
        do{
            ArrayList<Integer> searchedList=new ArrayList<>();
            System.out.println("\n\n\nHere are the fields that can be searched: ");
            System.out.println("1. Customer name. \n2. Membership ID.\n3. Category.\n0. Back to menu.");
            search=Validation.vInt("Please select one: ");
            switch(search){
                case 1:
                        searchedList.clear();
                        System.out.print("Enter customer's name: ");
                        cName=POS.scan.nextLine();
                        for(Membership m:membershipList){
                            if(cName.equalsIgnoreCase(m.custName)){
                                searchedList.add(membershipList.indexOf(m));
                            }
                        }
                    displayMember(searchedList);
                    System.out.printf("%d results found.", searchedList.size());
                    
                    break;
                case 2:
                    do{
                        System.out.print("Enter a membership ID: ");
                        cID=POS.scan.nextLine();
                    }while(cID.length()!=6||cID.charAt(0)!='M'||cID.charAt(1)!='S');
                    for(Membership m:membershipList){
                        if(cID.equalsIgnoreCase(m.membershipID))
                            searchedList.add(membershipList.indexOf(m));
                    }
                    displayMember(searchedList);
                    System.out.printf("%d results found.", searchedList.size());
                    break;
                case 3: 
                    searchedList.clear();
                    do {
                        searchCat = Validation.vInt("Select one category to search: \n1. Silver\n2. Gold\nChoose 1 or 2: ");
                        if (searchCat < 1 || searchCat > 2) 
                            System.out.println("Invalid Input.");
                    } while(searchCat < 1 || searchCat > 2);
                    if(searchCat==1)
                        cat="SILVER";
                    else
                        cat="GOLD";
                    for(Membership m:membershipList){
                        if(cat.equals(m.level))
                            searchedList.add(membershipList.indexOf(m));
                    }
                    displayMember(searchedList);
                    System.out.printf("%d results found.", searchedList.size());
                    break;
                case 0:
                    return;
                default: System.out.println("Invalid input.");search=-1;
            }
        }while(search!=0);
    }
    
    public static void displayActivity() {
        LocalDate today = LocalDate.now();
        System.out.println("Activity of today (" + today + ") :");
        System.out.println(addMemberCount + " New Member Added.");
        System.out.println(removeMemberCount + " Existing Members removed.");
        System.out.println(modifiedMemberCount + " Existing Member modified.");
        System.out.println("Total activities of today => "+ (addMemberCount + removeMemberCount + modifiedMemberCount));
    }
    @Override
    public String toString(){
        return "\nCustomer Name: "+custName+"\nMembership ID: "+membershipID+"\nContact number: "+phoneNo+"\nHousing Address: "+address+"\nLevel of membership: "+level+"\nDate Joined: "+joinedDate;
    }
    
}