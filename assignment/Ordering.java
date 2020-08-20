package ordring;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  


public class Ordering {
    
    
    private String staffName, custName,phoneNum, location;
    private char[] orderID;
    private double total, deposit, balance;
    private SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");  
    private Date date = new Date();  
    private Product[] ordered = new Product[10];
    private ArrayList<Product> prodOrdered = new ArrayList <Product>();
    public static ArrayList<Ordering> transaction = new ArrayList <Ordering>();

    public Ordering(String staffName, String custName, String phoneNum, String location, char[] orderID, double total, ArrayList<Product> prodOrdered , double deposit) {
        this.staffName = staffName;
        this.custName = custName;
        this.phoneNum = phoneNum;
        this.location = location;
        this.orderID = orderID;
        this.total = total;
        this.prodOrdered = prodOrdered;
        this.deposit = deposit;
        this.balance = (this.total - this.deposit);
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

    public char[] getOrderID() {
        return orderID;
    }

    public void setOrderID(char[] orderID) {
        this.orderID = orderID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Product[] getOrdered() {
        return ordered;
    }

    public void setOrdered(Product[] ordered) {
        this.ordered = ordered;
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
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
   
    
    
    
    public static void addOrder(){
      
            char yes;
            int orderNo = 0, qty, paymentMet = 0;
            double total = 0, deposit =0;
            char[] orderID = {'I', '0', '0', '0'};
            String custName, phoneNum, staffName, location = "";
            Scanner scn = new Scanner(System.in);
            
     do{
              int v = 0;
              ArrayList<Product> prodOrdered = new ArrayList <Product>();;
              System.out.print("Please enter Staff name > ");
              scn.nextLine();
              staffName = scn.nextLine();
              orderID[3]++;
              if(orderID[3]==':'){
                  orderID[3]='0';
                  orderID[2]++;
              }
              if(orderID[2]==':'){
                  orderID[2]='0';
                  orderID[1]++;
              }
              if(orderID[1]==':'){
                  orderID[1]='0';
              }
            do{
                yes = 0;
                SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");  
                Date date = new Date();  
                total = 0;
                String odrID = new String(orderID);
                System.out.println("Date       : "+form.format(date)+"\t\t\t\t\t"+" order ID: " + odrID);
                System.out.println("Staff name : "+ staffName);
                System.out.printf("No. \t Item Code \t Product \t Quantity \t Price      \tSubtotal \n");
                System.out.printf("--------------------------------------------------------------------------------\n");
                if(orderNo > 0){
                    for(int i = 0; i < prodOrdered.size();i++ ){
                        System.out.printf("%d \t %s \t\t %s \t\t\t%d \t %.2f \t %.2f\n",i+1, prodOrdered.get(i).getProductCode(),prodOrdered.get(i).getProductName(),prodOrdered.get(i).getQtyOrder(),prodOrdered.get(i).getPrice(),prodOrdered.get(i).getSubtotal());
                        total += prodOrdered.get(i).getSubtotal();
                    }
                }
                System.out.printf("--------------------------------------------------------------------------------\n");
                System.out.printf("\t\t\t\t\t\t\t  Total => RM %.2f", total);

                System.out.printf("\n\n\nProduct List\n");
                System.out.printf("------------\n");
                for(int i = 0; i < Product.getProductList().size();i++ ){
                    int x = i + 1;
                    System.out.print(""+x+"."+Product.getProductList().get(i).getProductName()+"       ");
                    System.out.println(Product.getProductList().get(i).getPrice());
                }
                System.out.printf("\n\nEnter product No. => ");
                orderNo = scn.nextInt();
                System.out.printf("Enter Quantity => "); 
                qty = scn.nextInt();

                System.out.printf("continue add ? > "); 
                yes = scn.next().charAt(0);
                prodOrdered.add(Product.getProductList().get(orderNo - 1));
                prodOrdered.get(v).calculateSub(qty);
                v++;

            }while((Character.toUpperCase(yes))  == 'Y');

            System.out.printf("Customer Name >");
            scn.nextLine(); 
            custName = scn.nextLine();

            System.out.printf("phone number >");
    //        scn.nextLine();
            phoneNum = scn.nextLine();

            System.out.printf("delivery ? >"); 
            yes = scn.next().charAt(0);

            if((Character.toUpperCase(yes))  == 'Y'){
                System.out.printf("location >");
                scn.nextLine();
                location = scn.nextLine();

            }

            System.out.println("1.Credit/Debit Card \n2.Cash");
            System.out.printf("payment method > ");
            paymentMet = scn.nextInt();
            if(paymentMet == 1){

            }
            else if (paymentMet == 2){

            }
            System.out.printf("deposit > ");
            deposit = scn.nextDouble();
            transaction.add(new Ordering(staffName,custName,phoneNum,location ,orderID ,total,prodOrdered,deposit));
            
            System.out.print("Continue Order ?? >");
            yes = scn.next().charAt(0);

        }while((Character.toUpperCase(yes))  == 'Y');
    }
   
    
    public static void addtrans(String staffName, String custName, String phoneNum, String location, char[] orderID, double total, ArrayList<Product> prodOrdered, double deposit){
        transaction.add(new Ordering(staffName,custName,phoneNum,location,orderID,total,prodOrdered, deposit));
        
    }
   
    
    public static void displayReceipt(){
        for(int x = 0; x < transaction.size();x++){
            String odrID = new String(transaction.get(x).orderID);
            System.out.println("Staff name : " + transaction.get(x).staffName);
            System.out.println("Date       : \t\t\t\t\t\t\t order ID: "+odrID);
            System.out.printf("No. \t Item Code \t Product \t Quantity \t Price      \tSubtotal \n");
            System.out.printf("--------------------------------------------------------------------------------\n");
                for(int i = 0; i < transaction.get(i).getProdOrdered().size();i++ ){
                    System.out.printf("%d \t %s \t\t %s \t\t\t%d \t %.2f \t %.2f\n",i+1,  transaction.get(x).getProdOrdered().get(i).getProductCode(), transaction.get(x).getProdOrdered().get(i).getProductName(), transaction.get(x).getProdOrdered().get(i).getQtyOrder(), transaction.get(x).getProdOrdered().get(i).getPrice(), transaction.get(x).getProdOrdered().get(i).getSubtotal());
                }
            System.out.printf("--------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\t\t\t\t  Total  => " + transaction.get(x).getTotal());
            System.out.println("\t\t\t\t\t\t\t Deposit => "+ transaction.get(x).getDeposit());
            System.out.println("\t\t\t\t\t\t\tBalance => "+transaction.get(x).getBalance());
            System.out.println("Customer name : "+transaction.get(x).getCustName());
            System.out.println("phone number : " +transaction.get(x).getPhoneNum());
            System.out.println("location : "+transaction.get(x).getLocation());
        }
    }
    public static void displaySummary(){
        System.out.printf("Staff name : \n");
        System.out.printf("Date       : \t\t\t\t\t\t\t order ID: \n");
        System.out.printf("Order Code \t order total  \t total Cost \t Total Profit \n");
        System.out.printf("----------------------------------------------------------------------------\n");
        System.out.printf("----------------------------------------------------------------------------\n");
        System.out.printf("\t\t\t\t\t\t\t  Total Cost=>\n");
        System.out.printf("\t\t\t\t\t\t\t  Total Profit=>\n");
    }
    

}
