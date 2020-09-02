package ordring;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  


public class Ordering {
    
    
    private String staffName, custName,phoneNum, location;
    private String orderID;
    private double total, deposit, balance, cost = 0, totSub, memberDis;
    private static SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");  
    private static Date date = new Date();  
    private String dateStr;
    private ArrayList<Product> prodOrdered = new ArrayList <Product>();
    public static ArrayList<Ordering> transaction = new ArrayList <Ordering>();
    private double deliveryFees = 150;
    public Ordering() {
    }

    public Ordering(String staffName, String custName, String phoneNum, String location, String orderID, double totSub, ArrayList<Product> prodOrdered , double deposit , String dateStr) {
        this.staffName = staffName;
        this.custName = custName;
        this.phoneNum = phoneNum;
        this.location = location;
        this.orderID = orderID;
        this.totSub = totSub;
        this.prodOrdered = prodOrdered;
        this.deposit = deposit;
        this.balance = (this.total - this.deposit);
        for(int i=0;i < prodOrdered.size();i++ ){
            this.cost += prodOrdered.get(i).getSubCost();
        }
        this.dateStr = dateStr;
        for(int j = 0; j < Membership.getMemList().size();j++){
            if(custName.equalsIgnoreCase(Membership.getMemList().get(j).getCustName())){
                if(Membership.getMemList().get(j).getLevel().equalsIgnoreCase("Sliver")){
                    memberDis = 0.05;
                }else{
                    memberDis = 0.1;
                }
            }
        }
//        this.total = totSub + deliveryFees +
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public ArrayList<Product> getProdOrdered() {
        return prodOrdered;
    }

    public void setProdOrdered(ArrayList<Product> prodOrdered) {
        this.prodOrdered = prodOrdered;
    }

    public static ArrayList<Ordering> getTransaction() {
        return transaction;
    }

    public static void setTransaction(ArrayList<Ordering> transaction) {
        Ordering.transaction = transaction;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
        this.balance = total - deposit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
   
    public static void runsample(){
        int stop = 2, xValue = -1, v=0;
        for(int i = 0; i < 3; i++){
            ArrayList<Product> prodOrdered = new ArrayList <Product>();
            double total = 0;
            stop++;
            xValue++;
            for(int x = 0; x < stop; x++){
                prodOrdered.add(Product.getProductList().get(x));
                prodOrdered.get(x).calculateSub(x+1);
                total += prodOrdered.get(x).getSubtotal();
            }
            if(i == 0)
            transaction.add(new Ordering("yan","pipi","0173391006","kepong","I001",total,prodOrdered,300,"03/05/2020"));
            if(i == 1)
            transaction.add(new Ordering("yan","coco","0123656699","Selayang","I002",total,prodOrdered,400,"03/05/2020"));
            if(i == 2)
            transaction.add(new Ordering("Ben","shing sheng","0125588639","Petaling jaya","I003",total,prodOrdered,500,"06/06/2020"));
        }
    }
    
    
    
    public static void addOrder(){
      
        char yes;
        int orderNo = 0, qty, paymentMet = 0, memberKey = 0, memberNo = -1;
        double total = 0, deposit =0, totSub = 0, memberDis = 0;
        int ordernum = transaction.size();
        String custName, phoneNum, staffName, location = "", cardNum;
        Scanner scn = new Scanner(System.in);
        char[] orderIDnum = {'I', '0', '0', '0'};
        String odrID;
        String dateStr = form.format(date);
        if(transaction.size() > 0){
                orderIDnum = Ordering.getTransaction().get(--ordernum).getOrderID().toCharArray();
        }
        
     do{
          int v = 0;
          ArrayList<Product> prodOrdered = new ArrayList <Product>();
          System.out.print("Please enter Staff name > ");
          staffName = scn.nextLine();
          orderIDnum[3]++;
          if(orderIDnum[3]==':'){
              orderIDnum[3]='0';
              orderIDnum[2]++;
          }
          if(orderIDnum[2]==':'){
              orderIDnum[2]='0';
              orderIDnum[1]++;
          }
          if(orderIDnum[1]==':'){
              orderIDnum[1]='0';
          }
            do{
                yes = 0;
                SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");  
                Date date = new Date();  
                total = 0;
                odrID = new String(orderIDnum);


                System.out.printf("\n\nPRODUCT LIST\n");
                System.out.printf("------------\n");
                for(int i = 0; i < Product.getProductList().size();i++ ){
                    int x = i + 1;
                    System.out.printf("%d. %-15s |RM%5.2f\n",x,Product.getProductList().get(i).getProductName(),Product.getProductList().get(i).getPrice());
                }
                do{
                    System.out.printf("\nEnter product No. => ");
                    orderNo = scn.nextInt();
                }while(orderNo <= 0 || orderNo > Product.getProductList().size());
                prodOrdered.add(Product.getProductList().get(orderNo - 1));
                do{
                    System.out.printf("Enter Quantity    => "); 
                    qty = scn.nextInt();
                }while(qty <= 0 || qty > prodOrdered.get(v).getStock());
                prodOrdered.get(v).calculateSub(qty);
                System.out.println("\n\nDATE       : "+dateStr+"\t\t\t\t\t\t"+"  ORDER ID: " + odrID);
                System.out.println("STAFF NAME : "+ staffName);
                System.out.printf("No. \t ITEM CODE \t PRODUCT \t QUANTITY \t PRICE      \tSUBTOTAL \n");
                System.out.printf("--------------------------------------------------------------------------------\n");
                if(orderNo > 0){
                    for(int i = 0; i < prodOrdered.size();i++ ){
                        System.out.printf("%2d %15s %13s %13d  %14.2f  %16.2f\n",i+1, prodOrdered.get(i).getProductCode(),prodOrdered.get(i).getProductName(),prodOrdered.get(i).getQtyOrder(),prodOrdered.get(i).getPrice(),prodOrdered.get(i).getSubtotal());
                        totSub += prodOrdered.get(i).getSubtotal();
                    }
                }
                System.out.printf("--------------------------------------------------------------------------------\n");
                System.out.printf("\t\t\t\t\t\t\t  TOTAL => RM %10.2f", total);
                do{
                    System.out.printf("\nContinue add ? (Y/N) > "); 
                    yes = scn.next().charAt(0);
                }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));
                v++;

            }while((Character.toUpperCase(yes))  == 'Y');

            System.out.printf("\nCustomer Name    >");
            scn.nextLine(); 
            custName = scn.nextLine();
            for(int j = 0; j < Membership.getMemList().size();j++){
                if(custName.equalsIgnoreCase(Membership.getMemList().get(j).getCustName())){
                    System.out.printf("\n%s is a %s Member\n",Membership.getMemList().get(j).getCustName(),Membership.getMemList().get(j).getLevel());
                    memberKey = 1;
                    memberNo = j;
                    if(Membership.getMemList().get(j).getLevel().equalsIgnoreCase("Sliver")){
                        memberDis = 0.05;
                    }else{
                        memberDis = 0.1;
                    }
                }
            }
            if(memberKey == 0){
                do{
                    System.out.printf("phone number     >");
                    phoneNum = scn.nextLine();
                }while(!(phoneNum.length()==10 || phoneNum.length()== 11 ));
            }
            else {
                phoneNum = Membership.getMemList().get(memberNo).getPhoneNo();
            }
            do{
                System.out.printf("Delivery ? (Y/N) >"); 
                yes = scn.next().charAt(0);
            }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));
            
            if((Character.toUpperCase(yes))  == 'Y'){
                if(memberKey == 1){
                    System.out.printf("The the address is %s ?",Membership.getMemList().get(memberNo).getAddress());
                    do{
                        System.out.print("(Y/N)>");
                        yes = scn.next().charAt(0);
                    }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));
                }
                if((Character.toUpperCase(yes))  == 'N' || memberKey == 0){
                    System.out.printf("Location         >");
                    scn.nextLine();
                    location = scn.nextLine();
                }
                else{
                    location = Membership.getMemList().get(memberNo).getAddress();
                }
            }
            
            System.out.println("\n\nPAYMENT METHOD\n==============\n1.Credit/Debit Card \n2.Cash\n");
            do{
                System.out.printf("Payment method > ");
                paymentMet = scn.nextInt();
            }while(paymentMet < 1 || paymentMet > 2);
            if(paymentMet == 1){
                
            }
            do{
                System.out.printf("Deposit        > ");
                deposit = scn.nextDouble();
            }while(deposit < 0);
            if(deposit >= total){
                System.out.println("\nFull Paid!!");
                if(deposit > total){
                   double change;
                   change = deposit - total;
                   System.out.printf("Change to customer RM %5.2f" , change);
                   deposit = total;
                }
            }
            do{
                System.out.printf("\nConfirm Order ?? (Y/N)>");
                yes = scn.next().charAt(0);
            }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));
            if((Character.toUpperCase(yes))  == 'Y' ){
               transaction.add(new Ordering(staffName,custName,phoneNum,location ,odrID ,totSub,prodOrdered,deposit,dateStr)); 
                ordernum = transaction.size();
                ordernum--;
                displayReceipt(ordernum);
            }
            else if((Character.toUpperCase(yes))  == 'N' ){
                 System.out.printf("Order Cancelled !!!!\n");
            }
            do{
                System.out.print("Continue Order ?? (Y/N)>");
                yes = scn.next().charAt(0);
            }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));
            scn.nextLine();
        }while((Character.toUpperCase(yes))  == 'Y');
    }
   
    
    public static void addtrans(String staffName, String custName, String phoneNum, String location,String orderID, double total, ArrayList<Product> prodOrdered, double deposit, String dateStr){
        transaction.add(new Ordering(staffName,custName,phoneNum,location,orderID,total,prodOrdered, deposit,dateStr));
        
    }
   
    
    public static void displayReceipt(){
       
        for(int x = 0; x < transaction.size();x++){
            String odrID = new String(transaction.get(x).getOrderID());
        System.out.printf("\n\nSTAFF NAME : %s \n",transaction.get(x).getStaffName());
        System.out.printf("DATE       : %s\t\t\t\t\t\t ORDER ID:%6s\n",transaction.get(x).dateStr,odrID);
        System.out.printf("No. \t ITEM CODE\t PRODUCT \t QUANTITY \t PRICE     \tSUBTOTAL \n");
        System.out.printf("--------------------------------------------------------------------------------\n");
            for(int i = 0; i < transaction.get(x).getProdOrdered().size();i++ ){
                 System.out.printf("%2d %15s %13s %13d  %14.2f  %16.2f\n",i+1,  transaction.get(x).getProdOrdered().get(i).getProductCode(), transaction.get(x).getProdOrdered().get(i).getProductName(), transaction.get(x).getProdOrdered().get(i).getQtyOrder(), transaction.get(x).getProdOrdered().get(i).getPrice(), transaction.get(x).getProdOrdered().get(i).getSubtotal());
            }
        System.out.printf("--------------------------------------------------------------------------------\n");
        System.out.printf("\t\t\t\t\t\t\tTOTAL   => RM %10.2f\n", transaction.get(x).getTotal());
        System.out.printf("\t\t\t\t\t\t\tDEPOSIT => RM %10.2f\n", transaction.get(x).getDeposit());
        System.out.printf("\t\t\t\t\t\t\tBALANCE => RM %10.2f\n", transaction.get(x).getBalance());
        System.out.println("CUSTOMER NAME  : "+transaction.get(x).getCustName());
        System.out.println("PHONE NUMBER   : " +transaction.get(x).getPhoneNum());
        System.out.println("LOCATION       : "+transaction.get(x).getLocation()+"\n\n\n\n\n");
        }

       
    }
    
    public static void displayReceipt(int no){

        int x = no;
        String odrID = new String(transaction.get(x).getOrderID());
        System.out.printf("\n\nSTAFF NAME : %s \n",transaction.get(x).getStaffName());
        System.out.printf("DATE       : %s\t\t\t\t\t\t ORDER ID:%6s\n",transaction.get(x).dateStr,odrID);
        System.out.printf("No. \t ITEM CODE\t PRODUCT \t QUANTITY \t PRICE     \tSUBTOTAL \n");
        System.out.printf("--------------------------------------------------------------------------------\n");
            for(int i = 0; i < transaction.get(x).getProdOrdered().size();i++ ){
                 System.out.printf("%2d %15s %13s %13d  %14.2f  %16.2f\n",i+1,  transaction.get(x).getProdOrdered().get(i).getProductCode(), transaction.get(x).getProdOrdered().get(i).getProductName(), transaction.get(x).getProdOrdered().get(i).getQtyOrder(), transaction.get(x).getProdOrdered().get(i).getPrice(), transaction.get(x).getProdOrdered().get(i).getSubtotal());
            }
        System.out.printf("--------------------------------------------------------------------------------\n");
        System.out.printf("\t\t\t\t\t\t\tTOTAL   => RM %10.2f\n", transaction.get(x).getTotal());
        System.out.printf("\t\t\t\t\t\t\tDEPOSIT => RM %10.2f\n", transaction.get(x).getDeposit());
        System.out.printf("\t\t\t\t\t\t\tBALANCE => RM %10.2f\n", transaction.get(x).getBalance());
        System.out.println("CUSTOMER NAME  : "+transaction.get(x).getCustName());
        System.out.println("PHONE NUMBER   : " +transaction.get(x).getPhoneNum());
        System.out.println("LOCATION       : "+transaction.get(x).getLocation()+"\n\n\n\n\n");

    }
    
    
    public static void displayStaffMenu() {
        System.out.println("\nHere are the function that can perform by you:");
        System.out.println("1 => Accept Orders");
        System.out.println("2 => Display All Products");
        System.out.println("3 => Display all Receipts");
        System.out.println("4 => Change User");
        System.out.println("0 => Quit");
    }
    
    public static void displayStaffOrderMenu() {
        System.out.println("\nManger Order:");
        System.out.println("1 => Accept Orders");
        System.out.println("2 => Display All Orders");
        System.out.println("3 => Modify Order");
        System.out.println("4 => Search Order");
        System.out.println("5 => Order Summary ");
        System.out.println("6 => Remove order ");
        System.out.println("0 => Return to main menu");
    }
    
    public static void modifyOrder(){
        int selection, mod = -1, select = 0;
        char yes;
        int orderNo = 0, qty = 0, num = 0;
        Ordering modifyOdr = new Ordering();
        Scanner scn = new Scanner(System.in);
        System.out.println("Choose an order first");
        System.out.printf("ORDER ID \t CUSTOMER NAME \t PHONE NUMBER \t   TOTAL    BALANCE \t   Staff Name \n");
        System.out.printf("---------------------------------------------------------------------------------------\n");
            for(int i = 0; i < transaction.size();i++ ){
                System.out.printf("%5s|%23s|%15s|%10.2f|%10.2f|%17s\n",transaction.get(i).orderID,transaction.get(i).custName,transaction.get(i).phoneNum,transaction.get(i).total,transaction.get(i).balance,transaction.get(i).staffName);
            }
        System.out.printf("---------------------------------------------------------------------------------------\n");
        
        System.out.print("Enter the order ID to modify >");
        modifyOdr.orderID = scn.nextLine();
        int i = 0;
        for(Ordering o: transaction){
            if(o.orderID.equalsIgnoreCase(modifyOdr.orderID)){
                displayReceipt(i);
                mod = i;
            }
            i++;
        }
        System.out.println("Modify menu");
        System.out.println("1.Staff name");
        System.out.println("2.Customer Name");
        System.out.println("3.Customer phone number");
        System.out.println("4.location");
        System.out.println("5.deposit");
        System.out.println("6.Date");
        System.out.println("7.Modify Product Ordered");
        System.out.printf("Enter your selection > ");
        selection = scn.nextInt();
        switch(selection){
            case 1:
                scn.nextLine(); 
                System.out.print("Enter a new staff name >");
                modifyOdr.staffName = scn.nextLine();
                break;
            case 2:
                scn.nextLine(); 
                System.out.print("Enter a new customer name >");
                modifyOdr.custName = scn.nextLine();
                break;
            case 3:
                scn.nextLine(); 
                do{
                    System.out.print("Enter a new customer phone number >");
                    modifyOdr.phoneNum = scn.nextLine();
                }while(!(modifyOdr.phoneNum.length()==10 || modifyOdr.phoneNum.length()== 11 ));
                break;
            case 4:
                scn.nextLine(); 
                System.out.print("Enter a new location >");
                modifyOdr.location = scn.nextLine();
            break;
            case 5:
                scn.nextLine(); 
              do{
                    System.out.print("Enter a new deposit >");
                    modifyOdr.deposit = scn.nextDouble();
                    if(modifyOdr.deposit > transaction.get(mod).total){
                        System.out.println("Dposit more than a order total !!!");
                    }
                }while(modifyOdr.deposit < 0 || modifyOdr.deposit > transaction.get(mod).total);
            break;
            case 7:
                modifyOdr.total=0;
                System.out.printf("No. \t ITEM CODE \t PRODUCT \t QUANTITY \t PRICE      \tSUBTOTAL \n");
                System.out.printf("--------------------------------------------------------------------------------\n");
                    for(int v = 0; v < transaction.get(mod).getProdOrdered().size();v++ ){
                         System.out.printf("%2d %15s %13s %13d  %14.2f  %16.2f\n",v+1,  transaction.get(mod).getProdOrdered().get(v).getProductCode(), transaction.get(mod).getProdOrdered().get(v).getProductName(), transaction.get(mod).getProdOrdered().get(v).getQtyOrder(), transaction.get(mod).getProdOrdered().get(v).getPrice(), transaction.get(mod).getProdOrdered().get(v).getSubtotal());
                         modifyOdr.total += transaction.get(mod).getProdOrdered().get(v).getSubtotal();
                    }
                System.out.printf("--------------------------------------------------------------------------------\n");
                System.out.println("Choose an action");
                System.out.println("----------------");
                System.out.println("1.Add product ");
                System.out.println("2.Modify product quantity");
                System.out.println("3.Remove a product");
                do{
                    System.out.printf("\nChoose an action > ");
                    select = scn.nextInt();
                }while(select < 1 || select > 3);
                switch(select){
                    case 1: 
                        System.out.printf("\n\n\nProduct List\n");
                        System.out.printf("------------\n");
                        for(int v = 0; v < Product.getProductList().size();v++ ){
                            int x = v + 1;
                            System.out.print(""+x+"."+Product.getProductList().get(v).getProductName()+"       ");
                            System.out.println(Product.getProductList().get(v).getPrice());
                        }
                        do{
                            System.out.printf("\n\nEnter product No. => ");
                            orderNo = scn.nextInt();
                        }while(orderNo <= 0 || orderNo > Product.getProductList().size());
                        do{
                            System.out.printf("Enter Quantity => "); 
                             qty = scn.nextInt();
                         }while(qty <= 0 || qty > Product.getProductList().get(orderNo - 1).getStock());
                        break;
                    case 2:
                        do{
                            System.out.printf("\n\nEnter No. to change the quantity => ");
                            num = scn.nextInt();
                        }while(num <=0 || num > transaction.get(mod).getProdOrdered().size()); 
                        
                        System.out.printf("\n\n%2d %15s %13s %13d  %14.2f  %16.2f\n\n",num,  transaction.get(mod).getProdOrdered().get(num-1).getProductCode(), transaction.get(mod).getProdOrdered().get(num-1).getProductName(), transaction.get(mod).getProdOrdered().get(num-1).getQtyOrder(), transaction.get(mod).getProdOrdered().get(num-1).getPrice(), transaction.get(mod).getProdOrdered().get(num-1).getSubtotal());
                        do{
                            System.out.printf("Enter a new quantity > ");
                            qty = scn.nextInt();
                        }while(qty <= 0 || qty > Product.getProductList().get(orderNo - 1).getStock());
                       
                        break;
                    case 3:
                        do{
                            System.out.printf("\n\nEnter No. to remove the product ordered => ");
                            num = scn.nextInt();
                        }while(orderNo <= 0 || orderNo > Product.getProductList().size());
                }
            break;
        }
        System.out.print("Confirm to modify (y = yes) >");
        yes = scn.next().charAt(0);
        scn.nextLine();
        
        if((Character.toUpperCase(yes))  == 'Y'){
            switch(selection){
            case 1:
                transaction.get(mod).staffName = modifyOdr.staffName;
                break;
            case 2:
                transaction.get(mod).custName = modifyOdr.custName;
                break;
            case 3:
                transaction.get(mod).phoneNum = modifyOdr.phoneNum;
                break;
            case 4:
                transaction.get(mod).location = modifyOdr.location;
            break;
            case 5:
                transaction.get(mod).setDeposit(modifyOdr.deposit);
            break;
            
            case 7:
                switch(select){
                    case 1:
                        modifyOdr.total=0;
                        transaction.get(mod).getProdOrdered().add(Product.getProductList().get(orderNo - 1));
                        transaction.get(mod).getProdOrdered().get(transaction.get(mod).getProdOrdered().size()-1).calculateSub(qty);
                        for(int v = 0; v < transaction.get(mod).getProdOrdered().size();v++ ){
                            modifyOdr.total += transaction.get(mod).getProdOrdered().get(v).getSubtotal();
                        }
                        transaction.get(mod).total =  modifyOdr.total;
                        transaction.get(mod).setBalance(transaction.get(mod).total - transaction.get(mod).deposit);
                        break;
                    case 2:
                        System.out.println(qty);
                        modifyOdr.total=0;
                        transaction.get(mod).getProdOrdered().get(num-1).calculateSub(qty);
                        for(int v = 0; v < transaction.get(mod).getProdOrdered().size();v++ ){
                            modifyOdr.total += transaction.get(mod).getProdOrdered().get(v).getSubtotal();
                        }
                        transaction.get(mod).setTotal(modifyOdr.total);
                        transaction.get(mod).setBalance(transaction.get(mod).total - transaction.get(mod).deposit);
                        break;
                    case 3:
                        modifyOdr.total=0;
                        transaction.get(mod).getProdOrdered().remove(num-1);
                        for(int v = 0; v < transaction.get(mod).getProdOrdered().size();v++ ){
                            modifyOdr.total += transaction.get(mod).getProdOrdered().get(v).getSubtotal();
                        }
                        transaction.get(mod).setTotal(modifyOdr.total);
                        transaction.get(mod).setBalance(transaction.get(mod).total - transaction.get(mod).deposit);
                        break;
                }
            break;            
            }
            System.out.println("\nSuccessfully Modify !!");
            displayReceipt(mod);
        }
    }
    
    public static void searchOrder(){
        int select, record = 0;
        Ordering searchOrd = new Ordering();
        Scanner scn = new Scanner(System.in);
        System.out.println("\n\nSearch menu");
        System.out.println("1.Staff name");
        System.out.println("2.Customer Name");
        System.out.println("3.Customer phone number");
        System.out.println("4.location");
        System.out.println("5.Order ID");
        System.out.println("6.total ");
        System.out.println("7.deposit");
        System.out.println("8.Date");
        System.out.println("9.Balance");
        System.out.printf("Enter your selection > ");
        select = scn.nextInt();
        int i,x;
        switch(select){
            
            case 1: 
                i = 0;
                scn.nextLine(); 
                System.out.print("Enter a staff name >");
                searchOrd.staffName = scn.nextLine();
                for(Ordering o: transaction){
                    if(o.staffName.equalsIgnoreCase(searchOrd.staffName)){
                        displayReceipt(i);
                        record++;
                    }
                    i++;
                }
            break;
            
            case 2:
                i = 0;
                scn.nextLine(); 
                System.out.print("Enter a customer name >");
                searchOrd.custName= scn.nextLine();
                for(Ordering o: transaction){
                    if(o.custName.equalsIgnoreCase(searchOrd.custName)){
                        displayReceipt(i);
                        record++;
                    }
                    i++;
                }
            break;
            
            case 3:
                i = 0;
                scn.nextLine(); 
                do{
                    System.out.print("Enter a customer phone number >");
                    searchOrd.phoneNum= scn.nextLine();
                }while(!(searchOrd.phoneNum.length()==10 || searchOrd.phoneNum.length()== 11 ));
                
                for(Ordering o: transaction){
                    if(o.phoneNum.equalsIgnoreCase(searchOrd.phoneNum)){
                        displayReceipt(i);
                        record++;
                    }
                    i++;
                }
            break;
           
            case 4:
                i = 0;
                scn.nextLine(); 
                System.out.print("Enter a customer location>");
                searchOrd.location= scn.nextLine();
                for(Ordering o: transaction){
                    if(o.location.equalsIgnoreCase(searchOrd.location)){
                        displayReceipt(i);
                        record++;
                    }
                    i++;
                }
            break;
            
            case 5:
                i = 0;
                scn.nextLine(); 
                System.out.print("Enter an order ID>");
                searchOrd.orderID= scn.nextLine();
                for(Ordering o: transaction){
                    if(o.orderID.equalsIgnoreCase(searchOrd.orderID)){
                        displayReceipt(i);
                        record++;
                    }
                    i++;
                }
            break;
            
            
            case 6:
                i = 0;
                scn.nextLine(); 
                do{
                    System.out.print("Enter a total >");
                    searchOrd.total= scn.nextDouble();
                }while(searchOrd.total < 0);
                for(Ordering o: transaction){
                    if(o.total == searchOrd.total){
                        displayReceipt(i);
                        record++;
                    }
                    i++;
                }
            break;
            
            case 7:
                i = 0;
                scn.nextLine(); 
                do{
                    System.out.print("Enter deposit >");
                    searchOrd.deposit= scn.nextDouble();
                }while(searchOrd.deposit < 0);
                for(Ordering o: transaction){
                    if(o.deposit == searchOrd.deposit){
                        displayReceipt(i);
                        record++;
                    }
                    i++;
                }
            break;
            
            case 9:
                i = 0;
                scn.nextLine(); 
                do{
                    System.out.print("Enter balance >");
                    searchOrd.balance= scn.nextDouble();
                }while(searchOrd.balance < 0);
                
                for(Ordering o: transaction){
                    if(o.balance == searchOrd.balance){
                        displayReceipt(i);
                        record++;
                    }
                    i++;
                }
            break;
        }
        
    }
    
    public static void orderSummary(){
        double totalSales = 0, totalCost = 0, totalprofit = 0, odrProfit;
        System.out.printf("Order ID \t Total Sales \t Total Cost  \t Profit \n");
        System.out.printf("--------------------------------------------------------\n");
            for(int i = 0; i < transaction.size();i++ ){
                odrProfit = transaction.get(i).total - transaction.get(i).cost;
                System.out.printf("%7s | %17.2f | %14.2f | %9.2f \n",transaction.get(i).orderID,transaction.get(i).total,transaction.get(i).cost, odrProfit);
                totalprofit += odrProfit;
                totalSales += transaction.get(i).total;
                totalCost += transaction.get(i).cost;
            }
        System.out.printf("--------------------------------------------------------\n");
        System.out.printf("%45s = %6.2f\n","TOTAL REVENUE",totalSales);
        System.out.printf("%45s = %6.2f\n","TOTAL COST",totalCost);
        System.out.printf("%45s = %6.2f\n","TOTAL PROFIT",totalprofit);
    }
    
    public static void removeOrder(){
        char yes;
        int orderRe=-1;
        Scanner scn = new Scanner(System.in);
        Ordering removeOrd = new Ordering();
        System.out.println("Choose an order first");
        System.out.printf("ORDER ID \t CUSTOMER NAME \t PHONE NUMBER \t   TOTAL    BALANCE \t   STAFF NAME \n");
        System.out.printf("---------------------------------------------------------------------------------------\n");
            for(int i = 0; i < transaction.size();i++ ){
                System.out.printf("%5s|%23s|%15s|%10.2f|%10.2f|%17s\n",transaction.get(i).orderID,transaction.get(i).custName,transaction.get(i).phoneNum,transaction.get(i).total,transaction.get(i).balance,transaction.get(i).staffName);
            }
        System.out.printf("---------------------------------------------------------------------------------------\n");
        
        System.out.print("Enter the order ID to remove >");
        removeOrd.orderID = scn.nextLine();
        int i = 0;
        for(Ordering o: transaction){
            if(o.orderID.equalsIgnoreCase(removeOrd.orderID)){
                displayReceipt(i);
                orderRe = i;
            }
            i++;
        }
        do{
            System.out.printf("\n\nConfirm remove this Order ?(Y/N) >");
            yes = scn.next().charAt(0);
            if((Character.toUpperCase(yes))  == 'Y'){
                transaction.remove(orderRe);
                System.out.println("Successfully Removed !!");
            }
            else if((Character.toUpperCase(yes))  == 'N'){
                System.out.println("Remove cancel!!");
            }
        }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));
}
}
