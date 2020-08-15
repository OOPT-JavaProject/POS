
 */
package assignment;

 import java.util.Scanner;
public class Assignment {

  
    public static void main(String[] args) {
        Scanner src=new Scanner(System.in);
        Product [] prodList= new Product[10];
        prodList[0] = new Product("Sofas","S1001",350,600,"100*50*100","Mr. Lee",50);
        prodList[1] = new Product("Table","T1001",150,700,"100*100*100","Mr. Cheah",50);
        prodList[2] = new Product("Beds","B1001",150,800,"100*50*100","Mrs. Teh",50);
        prodList[3] = new Product("Ottoman","O1001",150,600,"10*10*10","Mr. Kee",50);
        prodList[4] = new Product("Dressers","D1001",150,800,"10*10*10","Mr. Tan",50);
        prodList[5] = new Product("Futons","F1001",150,700,"10*10*10","Mr. Soh",50);
        prodList[6] = new Product("Lockers","L1001",150,1000,"10*10*10","Mr. Thiow",50);
        
        addProduct();
        
//        String y=new String("Y");
//        do{
//            System.out.println("Add product(Y/N) ?>> ");
//            y = src.nextLine();
//            if(y.equalsIgnoreCase("Y")){
//                addProduct();
//            }
//        }while(y=="Y");
        
        
    }
    public static void addProduct(){
        
        
       Scanner src=new Scanner(System.in);
       System.out.print("Enter the product name :");
       String prodName=src.nextLine();
       System.out.print("Enter the product code :");
       String prodCode=src.nextLine();
       System.out.print("Enter the cost :");
       double prodCost=src.nextDouble();
       System.out.print("Enter the selling price :");
       double prodPrice=src.nextDouble();
       System.out.print("Enter the product size :");
       String prodSize=src.nextLine();
       System.out.print("Enter the supplier :");
       String prodSupplier=src.nextLine();
       System.out.print("Enter the stock :");
       int prodStock=src.nextInt();
       
//       for(int i=0;i<Product.length();i++){
//           this.prodList[i] = new Product(prodName,prodCode,prodCost,
//               prodPrice,prodSize,prodSupplier,prodStock);
//       }
       
       
       
       
   }
    
}
