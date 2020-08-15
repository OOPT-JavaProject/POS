
public class ordering {
    public static void main(String[] args) {
        char yes=0;
        
        Product.addProduct("Sofas","S1001",350,600,"100*50*100","Mr. Lee",50);
        Product.addProduct("Table","T1001",150,700,"100*100*100","Mr. Cheah",50);
        Product.addProduct("Beds","B1001",150,800,"100*50*100","Mrs. Teh",50);
        Product.addProduct("Ottoman","O1001",150,600,"10*10*10","Mr. Kee",50);
        Product.addProduct("Dressers","D1001",150,800,"10*10*10","Mr. Tan",50);
        Product.addProduct("Futons","F1001",150,700,"10*10*10","Mr. Soh",50);
        Product.addProduct("Lockers","L1001",150,1000,"10*10*10","Mr. Thiow",50);
        do{
        System.out.printf("Staff name : \n");
        System.out.printf("No. \t Item Code \t Product \t Quantity \t Price      Subtotal \n");
        System.out.printf("----------------------------------------------------------------------------\n");
        
        System.out.printf("----------------------------------------------------------------------------\n");
        System.out.printf("\t\t\t\t\t\t\t  Total =>\n\n\n");
     
        System.out.printf("Product List\n");
        System.out.printf("------------\n");
        System.out.printf(Product.getProductList().get(0).getProductName());

        System.out.printf("\n\nEnter product No. => \n");
        System.out.printf("Enter Quantity => \n"); 
        System.out.printf("continue add ? > \n"); 
        }while(yes == 'Y');
        
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
