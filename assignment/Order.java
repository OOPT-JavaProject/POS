package assignment;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  


public class Order {
    private String staffName, custName,phoneNum, location;
    private String orderID;
    private double total, deposit, balance, cost = 0, totSub, memberDis = 0;
    private static SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");  
    private static Date date = new Date();  
    private String dateStr;
    private ArrayList<Product> prodOrdered = new ArrayList <Product>();
    public static ArrayList<Order> transaction = new ArrayList <Order>();
    private double deliveryFees = 150;
    public Order() {
    }

    public Order(String staffName, String custName, String phoneNum, String location, String orderID, double totSub, ArrayList<Product> prodOrdered , double deposit , String dateStr) {
        this.staffName = staffName;
        this.custName = custName;
        this.phoneNum = phoneNum;
        this.location = location;
        if(this.location.length() < 5){
            this.deliveryFees = 0;
        }
        this.orderID = orderID;
        this.totSub = totSub;
        this.prodOrdered = prodOrdered;
        this.deposit = deposit;
        this.total = totSub + deliveryFees;
        for(int i=0;i < prodOrdered.size();i++ ){
            this.cost += prodOrdered.get(i).getSubCost();
        }
        this.dateStr = dateStr;
        for(int j = 0; j < Membership.getMemList().size();j++){
            if(custName.equalsIgnoreCase(Membership.getMemList().get(j).getCustName())){
                this.deliveryFees = 0;
                if(Membership.getMemList().get(j).getLevel().equalsIgnoreCase("Silver")){
                    memberDis = (totSub * 0.05);
                }else if(Membership.getMemList().get(j).getLevel().equalsIgnoreCase("gold")){
                    memberDis = (totSub *0.1);
                }
                this.total = totSub - memberDis;
            }
        }
        this.balance = (this.total - this.deposit);
    }

    public static void init() {
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
            transaction.add(new Order("yan","pipi","0173391006","kepong","I001",total,prodOrdered,300,"03/05/2020"));
            if(i == 1)
            transaction.add(new Order("yan","coco","0123656699","Selayang","I002",total,prodOrdered,400,"03/05/2020"));
            if(i == 2)
            transaction.add(new Order("Ben","shing sheng","0125588639","Petaling jaya","I003",total,prodOrdered,500,"06/06/2020"));
        }
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
        for(int j = 0; j < Membership.getMemList().size();j++){
            if(custName.equalsIgnoreCase(Membership.getMemList().get(j).getCustName())){
                this.deliveryFees = 0;
                if(Membership.getMemList().get(j).getLevel().equalsIgnoreCase("Sliver")){
                    memberDis = (totSub * 0.05);
                }else{
                    memberDis = (totSub *0.1);
                }
                this.total = totSub -  memberDis;
            }
        }
        this.balance = (this.total - this.deposit);
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
        if(this.location.length() < 2){
            this.deliveryFees = 150;
        }
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

    public void setTotal(double totsub) {
        this.total = this.totSub + this.deliveryFees; 
        for(int j = 0; j < Membership.getMemList().size();j++){
            if(custName.equalsIgnoreCase(Membership.getMemList().get(j).getCustName())){
                this.deliveryFees = 0;
                if(Membership.getMemList().get(j).getLevel().equalsIgnoreCase("Sliver")){
                    memberDis = (totSub * 0.05);
                }else{
                    memberDis = (totSub *0.1);
                }
                this.total = totSub -  memberDis;
            }
        }
        this.balance = (this.total - this.deposit);
    }


    public ArrayList<Product> getProdOrdered() {
        return prodOrdered;
    }

    public void setProdOrdered(ArrayList<Product> prodOrdered) {
        this.prodOrdered = prodOrdered;
    }

    public static ArrayList<Order> getTransaction() {
        return transaction;
    }

    public static void setTransaction(ArrayList<Order> transaction) {
        Order.transaction = transaction;
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
    
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTotSub() {
        return totSub;
    }

    public void setTotSub(double totSub) {
        this.totSub = totSub;
    }

    public double getMemberDis() {
        return memberDis;
    }

    public void setMemberDis(double memberDis) {
        this.memberDis = memberDis;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public double getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(double deliveryFees) {
        this.deliveryFees = deliveryFees;
    }
   

    
    public static void addOrder(){
      
        char yes;
        int orderNo = 0, qty, paymentMet = 0, memberKey = -1;
        double total = 0, deposit =0, totSub = 0;
        int ordernum = transaction.size();
        String custName, phoneNum, staffName, location = "";
        Scanner scn = new Scanner(System.in);
        char[] orderIDnum = {'I', '0', '0', '0'};
        String odrID;
        String dateStr = form.format(date);
        if(transaction.size() > 0){
                orderIDnum = Order.getTransaction().get(--ordernum).getOrderID().toCharArray();
        }
        
     do{
          totSub = 0;
          int v = 0;
          ArrayList<Product> prodOrdered = new ArrayList <Product>();
          staffName = POS.userName;
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
                //SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");  
                //Date date = new Date();  
                total = 0;
                odrID = new String(orderIDnum);

                System.out.printf("\n\nPRODUCT LIST\n");
                System.out.printf("------------\n");
                for(int i = 0; i < Product.getProductList().size();i++ ){
                    int x = i + 1;
                    System.out.printf("%d. %-15s |RM%5.2f\n",x,Product.getProductList().get(i).getProductName(),Product.getProductList().get(i).getPrice());
                }
                do{
                    orderNo = Validation.vInt("\nEnter product No. => ");
                    if(orderNo <= 0 || orderNo > Product.getProductList().size())
                        System.out.println("Select out of range !!!!");
                }while(orderNo <= 0 || orderNo > Product.getProductList().size());
                prodOrdered.add(Product.getProductList().get(orderNo - 1));
                do{
                    qty = Validation.vInt("Enter Quantity    => ");
                    if(qty > prodOrdered.get(v).getStock())
                        System.out.println("No enough stock !!!");
                }while(qty <= 0 || qty > prodOrdered.get(v).getStock());
                prodOrdered.get(v).calculateSub(qty);
                prodOrdered.get(v).calQuantity(qty);
                System.out.println("\n\nDATE       : "+dateStr+"\t\t\t\t\t\t"+"  ORDER ID: " + odrID);
                System.out.println("STAFF NAME : "+ staffName);
                System.out.printf("No. \t ITEM CODE \t PRODUCT \t QUANTITY \t PRICE      \tSUBTOTAL \n");
                System.out.printf("--------------------------------------------------------------------------------\n");
                totSub = 0;
                if(orderNo > 0){
                    for(int i = 0; i < prodOrdered.size();i++ ){
                        System.out.printf("%2d %15s %13s %13d  %14.2f  %16.2f\n",i+1, prodOrdered.get(i).getProductCode(),prodOrdered.get(i).getProductName(),prodOrdered.get(i).getQtyOrder(),prodOrdered.get(i).getPrice(),prodOrdered.get(i).getSubtotal());
                        totSub += prodOrdered.get(i).getSubtotal();
                    }
                }
                System.out.printf("--------------------------------------------------------------------------------\n");
                System.out.printf("\t\t\t\t\t\t\t  TOTAL => RM %10.2f", totSub);
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
                    memberKey = j;
                }
            }
            if(memberKey+1 == 0){
                do{
                    System.out.printf("phone number     >");
                    phoneNum = scn.nextLine();
                    if(!(phoneNum.length()==10 || phoneNum.length()== 11 ))
                        System.out.println("Invalid input");
                }while(!(phoneNum.length()==10 || phoneNum.length()== 11 ));
            }
            else {
                phoneNum = Membership.getMemList().get(memberKey).getPhoneNo();
            }
            do{
                System.out.printf("Delivery ? (Y/N) >"); 
                yes = scn.next().charAt(0);
            }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));
            
            if((Character.toUpperCase(yes))  == 'Y'){
                if(memberKey+1 > 0){
                    System.out.printf("The address is %s ?",Membership.getMemList().get(memberKey).getAddress());
                    do{
                        System.out.print("(Y/N)>");
                        yes = scn.next().charAt(0);
                    }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));
                }
                if((Character.toUpperCase(yes))  == 'N' || memberKey+1 == 0){
                    System.out.printf("Location         >");
                    scn.nextLine();
                    location = scn.nextLine();
                }
                else{
                    location = Membership.getMemList().get(memberKey).getAddress();
                }
            }
            
            System.out.println("\n\nPAYMENT METHOD\n==============\n1.Credit/Debit Card \n2.Cash\n");
            do{
                paymentMet = Validation.vInt("Payment method > ");
                if(paymentMet < 1 || paymentMet > 2) System.out.println("Invalid input.");
            }while(paymentMet < 1 || paymentMet > 2);
            if(paymentMet == 1){
                
            }
            do{
                deposit = Validation.vDouble("Deposit        > ");
            }while(deposit < 0);
            if(deposit >= totSub){
                System.out.println("\nFull Paid!!");
                if(deposit > totSub){
                   double change;
                   change = deposit - totSub;
                   System.out.printf("Change to customer RM %5.2f" , change);
                   deposit = totSub;
                }
            }
            do{
                System.out.printf("\nConfirm Order ?? (Y/N)>");
                yes = scn.next().charAt(0);
            }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));
            if((Character.toUpperCase(yes))  == 'Y' ){
               transaction.add(new Order(staffName,custName,phoneNum,location ,odrID ,totSub,prodOrdered,deposit,dateStr));
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
        transaction.add(new Order(staffName,custName,phoneNum,location,orderID,total,prodOrdered, deposit,dateStr));
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
        System.out.printf("\t\t\t\t\t\t TOTAL SUBTOTAL => RM %10.2f\n", transaction.get(x).getTotSub());
        System.out.printf("\t\t\t\t\t\t DELIVERY FEES  => RM %10.2f\n", transaction.get(x).getDeliveryFees());
        System.out.printf("\t\t\t\t\t       MEMBER DISCOUNT =>(-RM %10.2f)\n", transaction.get(x).getMemberDis());
        System.out.printf("\t\t\t\t\t\t\t------------------------\n");
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
        System.out.printf("\t\t\t\t\t\t TOTAL SUBTOTAL => RM %10.2f\n", transaction.get(x).getTotSub());
        System.out.printf("\t\t\t\t\t\t DELIVERY FEES  => RM %10.2f\n", transaction.get(x).getDeliveryFees());
        System.out.printf("\t\t\t\t\t       MEMBER DISCOUNT =>(-RM %10.2f)\n", transaction.get(x).getMemberDis());
        System.out.printf("\t\t\t\t\t\t\t------------------------\n");
        System.out.printf("\t\t\t\t\t\t\tTOTAL   => RM %10.2f\n", transaction.get(x).getTotal());
        System.out.printf("\t\t\t\t\t\t\tDEPOSIT => RM %10.2f\n", transaction.get(x).getDeposit());
        System.out.printf("\t\t\t\t\t\t\tBALANCE => RM %10.2f\n", transaction.get(x).getBalance());
        System.out.println("CUSTOMER NAME  : "+transaction.get(x).getCustName());
        System.out.println("PHONE NUMBER   : " +transaction.get(x).getPhoneNum());
        System.out.println("LOCATION       : "+transaction.get(x).getLocation()+"\n\n\n\n\n");

    }
    
    
//    public static void displayStaffMenu() {
//        System.out.println("\nHere are the function that can perform by you:");
//        System.out.println("1 => Accept Orders");
//        System.out.println("2 => Display All Products");
//        System.out.println("3 => Display all Receipts");
//        System.out.println("4 => Change User");
//        System.out.println("0 => Quit");
//    }
//    
//    public static void displayStaffOrderMenu() {
//        System.out.println("\nManger Order:");
//        System.out.println("1 => Accept Orders");
//        System.out.println("2 => Display All Orders");
//        System.out.println("3 => Modify Order");
//        System.out.println("4 => Search Order");
//        System.out.println("5 => Order Summary ");
//        System.out.println("6 => Remove order ");
//        System.out.println("0 => Return to main menu");
//    }
    
    public static void modifyOrder(){
        if (transaction.isEmpty()) {
            System.out.println("\nThere is no Order to modify!");
            return;
        }
        int selection, mod = -1, select = 0;
        char yes;
        int orderNo = 0, qty = 0, num = 0;
        Order modifyOdr = new Order();
        Scanner scn = new Scanner(System.in);
        System.out.println("Choose an order first");
        System.out.printf("ORDER ID \t CUSTOMER NAME \t PHONE NUMBER \t   TOTAL    BALANCE \t   Staff Name \n");
        System.out.printf("---------------------------------------------------------------------------------------\n");
            for(int i = 0; i < transaction.size();i++ ){
                System.out.printf("%5s|%23s|%15s|%10.2f|%10.2f|%17s\n",transaction.get(i).orderID,transaction.get(i).custName,transaction.get(i).phoneNum,transaction.get(i).total,transaction.get(i).balance,transaction.get(i).staffName);
            }
        System.out.printf("---------------------------------------------------------------------------------------\n");
        do{
            System.out.print("Enter the order ID to modify >");
            modifyOdr.orderID = scn.nextLine();
            int i = 0;
            for(Order o: transaction){
                if(o.orderID.equalsIgnoreCase(modifyOdr.orderID)){
                    displayReceipt(i);
                    mod = i;
                }
                i++;
            }
            if(mod==-1)
                System.out.println("Invalid order ID ");
        }while(mod == -1);
        
        do {
            if (select != -1) {
            System.out.println("Modify menu");
            System.out.println("1.Staff name");
            System.out.println("2.Customer Name");
            System.out.println("3.Customer phone number");
            System.out.println("4.location");
            System.out.println("5.deposit");
            System.out.println("6.Date");
            System.out.println("7.Modify Product Ordered");
            System.out.println("0.Return to main menu");
            }
        selection = Validation.vInt("Enter your selection > ");
        switch(selection){
            case 1:
                scn.nextLine(); 
                int match = 0;
                do{
                    System.out.print("Enter a new staff name >");
                    modifyOdr.staffName = scn.nextLine();
                    for(int v = 0; v < Employee.getEmpList().size();v++){
                        if(modifyOdr.staffName.equalsIgnoreCase(Employee.getEmpList().get(v).getEmpName())){
                            match = 1;
                        }
                    }
                    if(match == 0){
                        System.out.println("Staff not found !!!");
                    }
                }while(match == 0);
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
                    if(!(modifyOdr.phoneNum.length()==10 || modifyOdr.phoneNum.length()== 11 ))
                        System.out.println("Invalid length !!!");
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
                        System.out.println("Deposit more than a order total !!!");
                    }
                }while(modifyOdr.deposit < 0 || modifyOdr.deposit > transaction.get(mod).total);
            break;
             case 6:
                int error;
                do{
                    try {
                        System.out.print("Enter a new Date (dd/mm/yyyy)(/)is required > ");
                        modifyOdr.dateStr = scn.nextLine();
                        int day = Integer.parseInt(modifyOdr.dateStr.substring(0,2));
                        int month = Integer.parseInt(modifyOdr.dateStr.substring(3,5));
                        int year = Integer.parseInt(modifyOdr.dateStr.substring(6));
                        error = dateValidation(day,month,year);
                    } catch (Exception e) {
                        error = 0;
                    }
                    if (modifyOdr.dateStr.length() != 10 || error != 1) System.out.println("Follow the format (DD/MM/YYYY)");
                }while(modifyOdr.dateStr.length() != 10 || error != 1);
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
                System.out.println("0.Return to main menu");
                do {
                select = Validation.vInt(">> ");
                
                switch(select){
                    case 1: 
                        
                        System.out.printf("\n\nPRODUCT LIST\n");
                         System.out.printf("------------\n");
                        for(int v = 0; v < Product.getProductList().size();v++ ){
                            int x = v + 1;
                             System.out.printf("%d. %-15s |RM%5.2f\n",x,Product.getProductList().get(v).getProductName(),Product.getProductList().get(v).getPrice());
                        }
                        do{
                            orderNo = Validation.vInt("\n\nEnter product No. => ");
                            if(orderNo <= 0 || orderNo > Product.getProductList().size())
                                System.out.println("Invalid product No. !!!");
                        }while(orderNo <= 0 || orderNo > Product.getProductList().size());
                        do{
                             qty = Validation.vInt("Enter Quantity => ");
                             if(qty > Product.getProductList().get(orderNo - 1).getStock())
                                 System.out.println("No enough stock !!!!");
                         }while(qty <= 0 || qty > Product.getProductList().get(orderNo - 1).getStock());
                        break;
                    case 2:
                        do{
                            num = Validation.vInt("\n\nEnter No. to change the quantity => ");
                        }while(num <=0 || num > transaction.get(mod).getProdOrdered().size()); 

                        System.out.printf("\n\n%2d %15s %13s %13d  %14.2f  %16.2f\n\n",num,  transaction.get(mod).getProdOrdered().get(num-1).getProductCode(), transaction.get(mod).getProdOrdered().get(num-1).getProductName(), transaction.get(mod).getProdOrdered().get(num-1).getQtyOrder(), transaction.get(mod).getProdOrdered().get(num-1).getPrice(), transaction.get(mod).getProdOrdered().get(num-1).getSubtotal());
                        do{
                            qty = Validation.vInt("Enter a new quantity > ");
                        if(qty > Product.getProductList().get(num - 1).getStock())
                                System.out.println("No enough stock !!!!");
                        }while(qty <= 0 || qty > Product.getProductList().get(num - 1).getStock());
                        
                        break;
                    case 3:
                        do{
                            num = Validation.vInt("\n\nEnter No. to remove the product ordered => ");
                        }while(num <= 0 || num > transaction.get(mod).getProdOrdered().size());
                        break;
                    case 0: break;
                    default: select = -1; System.out.println("Invalid input."); break;
                    }
                } while(select == -1);
                break;
            case 0: return;
            default: select = -1; System.out.println("Invalid input."); break;
        }
        
        do{
            System.out.print("Confirm to modify (y = yes) >");
            yes = scn.next().charAt(0);
            scn.nextLine();
        }while(!((Character.toUpperCase(yes))  == 'Y' || (Character.toUpperCase(yes))  == 'N'));

        if((Character.toUpperCase(yes))  == 'Y'){
            switch(selection){
            case 1:
                transaction.get(mod).staffName = modifyOdr.staffName;
                break;
            case 2:
                transaction.get(mod).setCustName(modifyOdr.custName);
                break;
            case 3:
                transaction.get(mod).phoneNum = modifyOdr.phoneNum;
                break;
            case 4:
                transaction.get(mod).setLocation(modifyOdr.location);
            break;
            case 5:
                transaction.get(mod).setDeposit(modifyOdr.deposit);
            break;
            case 6:
                transaction.get(mod).dateStr = modifyOdr.dateStr;
            case 7:
                modifyOdr.totSub=0;
                switch(select){
                    case 1:
                        transaction.get(mod).getProdOrdered().add(Product.getProductList().get(orderNo - 1));
                        transaction.get(mod).getProdOrdered().get(transaction.get(mod).getProdOrdered().size()-1).calculateSub(qty);
                        break;
                    case 2:
                        transaction.get(mod).getProdOrdered().get(num-1).calculateSub(qty);
                        break;
                    case 3:
                        transaction.get(mod).getProdOrdered().remove(num-1);
                        break;
                }
                for(int v = 0; v < transaction.get(mod).getProdOrdered().size();v++ ){
                    modifyOdr.totSub += transaction.get(mod).getProdOrdered().get(v).getSubtotal();
                }
                transaction.get(mod).totSub =  modifyOdr.totSub;
                transaction.get(mod).setTotal(modifyOdr.totSub);
            break;            
            }
            System.out.println("\nSuccessfully Modify !!");
            displayReceipt(mod);
        }
        }while(selection != 0);
    }
    
    public static int dateValidation(int day, int month, int year){
        switch(month){
            case 2:
                if(year %4 == 0){
                    if(day >= 30 || day <= 0)
                        return 0;
                }
                else{
                     if(day >= 29 || day <= 0)
                         return 0;
                }
            break;
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                if (day >= 32 || day <= 0)
                    return 0;
            break;
            case 4:case 6:case 9: case 11:
		if (day >= 31 || day <= 0)
                    return 0;
            break;
        }
        if(month < 1 || month > 12){
            return 0;
        }

        return 1;

    }
    
    public static void searchOrder(){
        if (transaction.isEmpty()) {
            System.out.println("\nThere is no Order to search!");
            return;
        }
        int select = 0, record = 0;
        Order searchOrd = new Order();
        Scanner scn = new Scanner(System.in);
        do {
            record = 0;
            if (select != -1) {
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
                System.out.println("0.Return to main menu");
            }
            select = Validation.vInt("Enter your selection > ");
            int i;
            switch(select){
                case 1: 
                    i = 0;
                    System.out.print("Enter a staff name >");
                    searchOrd.staffName = scn.nextLine();
                    for(Order o: transaction){
                        if(o.staffName.equalsIgnoreCase(searchOrd.staffName)){
                            displayReceipt(i);
                            record++;
                        }
                        i++;
                    }
                break;

                case 2:
                    i = 0;
                    System.out.print("Enter a customer name >");
                    searchOrd.custName= scn.nextLine();
                    for(Order o: transaction){
                        if(o.custName.equalsIgnoreCase(searchOrd.custName)){
                            displayReceipt(i);
                            record++;
                        }
                        i++;
                    }
                break;

                case 3:
                    i = 0;
                    do{
                        System.out.print("Enter a customer phone number >");
                        searchOrd.phoneNum= scn.nextLine();
                    }while(!(searchOrd.phoneNum.length()==10 || searchOrd.phoneNum.length()== 11 ));

                    for(Order o: transaction){
                        if(o.phoneNum.equalsIgnoreCase(searchOrd.phoneNum)){
                            displayReceipt(i);
                            record++;
                        }
                        i++;
                    }
                break;

                case 4:
                    i = 0;
                    System.out.print("Enter a customer location>");
                    searchOrd.location= scn.nextLine();
                    for(Order o: transaction){
                        if(o.location.equalsIgnoreCase(searchOrd.location)){
                            displayReceipt(i);
                            record++;
                        }
                        i++;
                    }
                break;

                case 5:
                    i = 0;
                    System.out.print("Enter an order ID>");
                    searchOrd.orderID= scn.nextLine();
                    for(Order o: transaction){
                        if(o.orderID.equalsIgnoreCase(searchOrd.orderID)){
                            displayReceipt(i);
                            record++;
                        }
                        i++;
                    }
                break;


                case 6:
                    i = 0;
                    do{
                        searchOrd.total= Validation.vDouble("Enter a total >");
                    }while(searchOrd.total < 0);
                    for(Order o: transaction){
                        if(o.total == searchOrd.total){
                            displayReceipt(i);
                            record++;
                        }
                        i++;
                    }
                break;

                case 7:
                    i = 0;
                    do{
                        searchOrd.deposit= Validation.vDouble("Enter deposit >");
                    }while(searchOrd.deposit < 0);
                    for(Order o: transaction){
                        if(o.deposit == searchOrd.deposit){
                            displayReceipt(i);
                            record++;
                        }
                        i++;
                    }
                break;
                case 8:
                    int error;
                    i = 0;
                    do{
                        try {
                            System.out.print("Enter a Date (dd/mm/yyyy)(/)is required > ");
                            searchOrd.dateStr = scn.nextLine();
                            int day = Integer.parseInt(searchOrd.dateStr.substring(0,2));
                            int month = Integer.parseInt(searchOrd.dateStr.substring(3,5));
                            int year = Integer.parseInt(searchOrd.dateStr.substring(6));
                            error = dateValidation(day,month,year);
                        } catch (Exception e) {
                            error = 0;
                        }
                        if(searchOrd.dateStr.length() != 10 || error != 1) System.out.println("Invalid input. Follow the format (DD/MM/YYYY)");
                    }while(searchOrd.dateStr.length() != 10 || error != 1);
                    for(Order o: transaction){
                        if(o.dateStr.equalsIgnoreCase(searchOrd.dateStr)){
                            displayReceipt(i);
                            record++;
                        }
                        i++;
                    }
                    break;
                case 9:
                    i = 0;
                    do{
                        searchOrd.balance= Validation.vDouble("Enter balance >");
                    }while(searchOrd.balance < 0);

                    for(Order o: transaction){
                        if(o.balance == searchOrd.balance){
                            displayReceipt(i);
                            record++;
                        }
                        i++;
                    }
                    break;
                case 0: return;
                default: select = -1;System.out.println("Invalid input.");break;
            }
            if(record == 0){
            System.out.printf("\n\n 0 record found \n");
            }
            else{
                System.out.printf(" %d record found \n", record);
            }
        }while(select != 0);
        
    }
    
    public static void orderSummary(){
        Scanner scn = new Scanner(System.in);
        Order sum = new Order(); 
        int select , month, year, day;
//        String dateSum;
        
        do {    
            System.out.printf("SUMMARY MENU\n");
            System.out.printf("============\n");
            System.out.printf("1.Daily Summary\n");
            System.out.printf("2.Monthly Summary\n");
            System.out.printf("3.Year Summary\n");
            System.out.printf("4.All Orders Summary\n");
            System.out.printf("0.Return to main menu\n");
            select = Validation.vInt("\nEnter your selection > ");
            switch(select){
                case 1:
                    int error = 1;
                    do{
                        try {
                            System.out.print("Enter a Date (dd/mm/yyyy)(/)is required > ");
                            sum.dateStr = scn.nextLine();
                            day = Integer.parseInt(sum.dateStr.substring(0,2));
                            month = Integer.parseInt(sum.dateStr.substring(3,5));
                            year = Integer.parseInt(sum.dateStr.substring(6));
                            error = dateValidation(day,month,year);
                        } catch (Exception e) {
                            //System.out.println("Invalid Input. Follow the format (DD/MM/YYYY)");
                            error = 0;
                        }
                        if (error != 1) System.out.println("Invalid Input. Follow the format (DD/MM/YYYY)");
                    }while(sum.dateStr.length() != 10 || error != 1);
                    displaySuammary(sum.dateStr);
                break;

                case 2:
                    month = Validation.vInt("Enter month > ");
                    year =  Validation.vInt("Enter year  > ");
                    displaySuammary(month, year);
                    break;
                case 3:
                    year =  Validation.vInt("Enter year  > ");
                    displaySuammary(0, year);   
                    break;
                case 4:
                    System.out.println("Showing all orders summary...");
                    displaySummary();
                    break;
                case 0: return;
                default: System.out.println("Invalid input."); select = -1;
            }
        }while(select != 0);
    }

    public static void displaySummary(){
        double totalSales = 0, totalCost = 0, totalprofit = 0, odrProfit;
        int i = 0;
        System.out.printf("\tDate  \t Order ID \t Total Sales \t Total Cost  \t Profit \n");
        System.out.printf("-----------------------------------------------------------------------\n");
        for(Order o: transaction){
            odrProfit = o.total - o.cost;
            System.out.printf("%12s | %7s | %17.2f | %14.2f | %9.2f \n",o.dateStr,o.orderID,o.total,o.cost, odrProfit);
            totalprofit += odrProfit;
            totalSales += o.total;
            totalCost += o.cost;
            i++;   
        }
           
        System.out.printf("-----------------------------------------------------------------------\n");
        System.out.printf("%56s = RM  %8.2f\n","TOTAL REVENUE",totalSales);
        System.out.printf("%56s = RM  %8.2f\n","TOTAL COST",totalCost);
        System.out.printf("%56s = RM  %8.2f\n","TOTAL PROFIT",totalprofit);
    }
    
    public static void displaySuammary(String dateSum){
        double totalSales = 0, totalCost = 0, totalprofit = 0, odrProfit;
        int i = 0;
        System.out.printf("\tDate \t Order ID \t Total Sales \t Total Cost  \t Profit \n");
        System.out.printf("-----------------------------------------------------------------------\n");
        for(Order o: transaction){
            if(o.dateStr.equalsIgnoreCase(dateSum)){
                odrProfit = transaction.get(i).total - transaction.get(i).cost;
                System.out.printf("%12s | %7s | %17.2f | %14.2f | %9.2f \n",transaction.get(i).dateStr,transaction.get(i).orderID,transaction.get(i).total,transaction.get(i).cost, odrProfit);
                totalprofit += odrProfit;
                totalSales += transaction.get(i).total;
                totalCost += transaction.get(i).cost;
            }
            i++;
        }
        System.out.printf("-----------------------------------------------------------------------\n");
        System.out.printf("%56s = RM  %8.2f\n","TOTAL REVENUE",totalSales);
        System.out.printf("%56s = RM  %8.2f\n","TOTAL COST",totalCost);
        System.out.printf("%56s = RM  %8.2f\n","TOTAL PROFIT",totalprofit);
    }

    public static void displaySuammary(int month, int year){
        double totalSales = 0, totalCost = 0, totalprofit = 0, odrProfit;
        int i = 0, chkMonth = 0, chkyear;
        System.out.printf("\tDate  \t Order ID \t Total Sales \t Total Cost  \t Profit \n");
        System.out.printf("-----------------------------------------------------------------------\n");
        for(Order o: transaction){
            if(month!=0)
                chkMonth = Integer.parseInt(o.dateStr.substring(3, 5));
            chkyear = Integer.parseInt(o.dateStr.substring(6));
            if(chkyear == year){
                if(chkMonth == month){
                    odrProfit = transaction.get(i).total - transaction.get(i).cost;
                    System.out.printf("%12s | %7s | %17.2f | %14.2f | %9.2f \n",transaction.get(i).dateStr,transaction.get(i).orderID,transaction.get(i).total,transaction.get(i).cost, odrProfit);
                    totalprofit += odrProfit;
                    totalSales += transaction.get(i).total;
                    totalCost += transaction.get(i).cost;
                }

            }
            i++;
        }
        System.out.printf("-----------------------------------------------------------------------\n");
        System.out.printf("%56s = RM  %8.2f\n","TOTAL REVENUE",totalSales);
        System.out.printf("%56s = RM  %8.2f\n","TOTAL COST",totalCost);
        System.out.printf("%56s = RM  %8.2f\n","TOTAL PROFIT",totalprofit);
    }
    
    public static void removeOrder(){
        if (transaction.isEmpty()) {
            System.out.println("\nThere is no Order to remove!");
            return;
        }
        char yes;
        int orderRe=-1;
        Scanner scn = new Scanner(System.in);
        Order removeOrd = new Order();
        System.out.println("Choose an order first");
        System.out.printf("ORDER ID \t CUSTOMER NAME \t PHONE NUMBER \t   TOTAL    BALANCE \t   STAFF NAME \n");
        System.out.printf("---------------------------------------------------------------------------------------\n");
            for(int i = 0; i < transaction.size();i++ ){
                System.out.printf("%5s|%23s|%15s|%10.2f|%10.2f|%17s\n",transaction.get(i).orderID,transaction.get(i).custName,transaction.get(i).phoneNum,transaction.get(i).total,transaction.get(i).balance,transaction.get(i).staffName);
            }
        System.out.printf("---------------------------------------------------------------------------------------\n");
        do{
            System.out.print("Enter the order ID to remove >");
            removeOrd.orderID = scn.nextLine();
            int i = 0;
            for(Order o: transaction){
                if(o.orderID.equalsIgnoreCase(removeOrd.orderID)){
                    displayReceipt(i);
                    orderRe = i;
                }
                i++;
            }
            if(orderRe == -1){
                System.out.println("Invalid order ID");
            }
        }while(orderRe == -1);
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