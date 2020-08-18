
 
package assignment;

 import java.util.Scanner;
public class Assignment {

  
    public static void main(String[] args) {
        Scanner src=new Scanner(System.in);
        Product.addProduct("Sofas","S1001",350,600,"100*50*100","Mr. Lee",50);
        Product.addProduct("Table","T1001",150,700,"100*100*100","Mr. Cheah",50);
        Product.addProduct("Beds","B1001",150,800,"100*50*100","Mrs. Teh",50);
        Product.addProduct("Ottomars","D1001",150,800,"10*10*10","Mr. Tan",50);
        Product.addProduct("Futons","F1001",150,700,"10*10*10","Mr. Soh",50);
        Product.addProduct("Lockers","L1001",150,1000,"10*10*10","Mr. Thiow",50);
        
//        Product.addProduct();
//        System.out.print("\nProduct List\n");
//        Product.displayProduct();
        Product.searchProduct();
        
//        String y=new String("Y");
//        do{
//            System.out.println("Add product(Y/N) ?>> ");
//            y = src.nextLine();
//            if(y.equalsIgnoreCase("Y")){
//                addProduct();
//            }
//        }while(y=="Y");
        
        
    }
    
    
}
