package ordring;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordering {
    public static void main(String[] args) {
        char yes=0;
        int orderNo = 0, qty;
        ArrayList<Product> prodOrdered=new ArrayList <Product>();
        Scanner scn = new Scanner(System.in);
        Order order = new Order();
        Product.addProduct("Sofas","S1001",350,600,"100*50*100","Mr. Lee",50);
        Product.addProduct("Table","T1001",150,700,"100*100*100","Mr. Cheah",50);
        Product.addProduct("Beds","B1001",150,800,"100*50*100","Mrs. Teh",50);
        Product.addProduct("Ottoman","O1001",150,600,"10*10*10","Mr. Kee",50);
        Product.addProduct("Dressers","D1001",150,800,"10*10*10","Mr. Tan",50);
        Product.addProduct("Futons","F1001",150,700,"10*10*10","Mr. Soh",50);
        Product.addProduct("Lockers","L1001",150,1000,"10*10*10","Mr. Thiow",50);
          int v = 0;
        do{

          int no = 0;
            System.out.printf("Staff name : \n");
            System.out.printf("No. \t Item Code \t Product \t Quantity \t Price      Subtotal \n");
            System.out.printf("----------------------------------------------------------------------------\n");
            if(orderNo > 0){
                for(int i = 0; i < prodOrdered.size();i++ )
                    System.out.printf("%d \t %s \t %s \t %d \t %.2f \t \t %.2f\n",i+1, prodOrdered.get(i).getProductCode(),prodOrdered.get(i).getProductName(),prodOrdered.get(i).getQtyOrder(),prodOrdered.get(i).getPrice(),prodOrdered.get(i).getSubtotal());
            }
            System.out.printf("----------------------------------------------------------------------------\n");
            System.out.printf("\t\t\t\t\t\t\t  Total =>\n\n\n");

            System.out.printf("Product List\n");
            System.out.printf("------------\n");
            for(int i = 0; i < Product.getProductList().size();i++ ){
                int x = i + 1;
                System.out.print(""+x+"."+Product.getProductList().get(i).getProductName()+"       ");
                System.out.println(Product.getProductList().get(i).getPrice());
            }
            System.out.printf("\n\nEnter product No. => ");
//            if(prodNo[v] > 0)
//                v++;
//            prodNo[v] = scn.nextInt();
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
        System.out.printf("phone number >"); 
        System.out.printf("delivery ? >"); 
        if(yes=='Y'){
            System.out.printf("location >");
        }
        System.out.printf("payment method > ");
        System.out.printf("deposit > ");
        
        
    }
    public static void displayReceipt(){
        System.out.printf("Staff name : \n");
        System.out.printf("Date       : \t\t\t\t\t\t\t order ID: \n");
        System.out.printf("No. \t Item Code \t Product \t Quantity \t Price      Subtotal \n");
        System.out.printf("----------------------------------------------------------------------------\n");
        System.out.printf("----------------------------------------------------------------------------\n");
        System.out.printf("\t\t\t\t\t\t\t  Total  =>\n");
        System.out.printf("\t\t\t\t\t\t\t Deposit =>\n\n\n");
        System.out.printf("\t\t\t\t\t\t\tBalance =>\n\n\n");
        System.out.printf("Customer name : ");
        System.out.printf("phone number : ");
        System.out.printf("location : ");
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
