/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;


import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author wei lun
 */
public class Product {
    private String productName ;
    private String productCode ;
    private double costs ;
    private double price ;
    private String size;
    private String supplier;
    private int stock;
    
    private static ArrayList<Product> productList=new ArrayList <Product>();

    public Product(String productName, String productCode, double costs, double price, String size, String supplier, int stock) {
        this.productName = productName;
        this.productCode = productCode;
        this.costs = costs;
        this.price = price;
        this.size = size;
        this.supplier = supplier;
        this.stock = stock;
        
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "-----------------------"+ "\nProduct Name :" + productName + "\nProduct Code :" + productCode + 
                "\nCosts :" + costs + "\nPrice :" + price + "\nSize :" + size + "\nSupplier :" + supplier + "\nStock :" + stock +"\n";
    }
    public static void addProduct(){
       Scanner src=new Scanner(System.in);
       System.out.print("Enter the product name :");
       String prodName=src.nextLine();
       
    do{
       System.out.print("Enter the product code :");
       String prodCode=src.nextLine();
       checkCode(prodCode);
       String checkedProdCode=prodCode;
       }while(false);
       
       System.out.print("Enter the cost :");
       double prodCost=src.nextDouble();
       System.out.print("Enter the selling price :");
       double prodPrice=src.nextDouble();
       src.nextLine();
       System.out.print("Enter the product size :");
       String prodSize=src.nextLine();
       System.out.print("Enter the supplier :");
       String prodSupplier=src.nextLine();
       System.out.print("Enter the stock :");
       int prodStock=src.nextInt();
       
       productList.add(new Product(prodName,prodCode,prodCost,prodPrice,prodSize,prodSupplier,prodStock));
    }
    public static void addProduct(String productName, String productCode, double costs, double price, String size, String supplier, int stock){
       productList.add(new Product(productName,productCode,costs,price,size,supplier,stock));
    }
    
    public static boolean checkCode(String prodCode){
        if(prodCode.length()>5) return false;
        
        int letterCount=0;
        int digitCount=0;
        for(int i=0;i<prodCode.length();i++){
            char ch=prodCode.charAt(i);
            if(isChar(ch)){
                letterCount++;
            }
            else if(isDigit(ch)){

                digitCount++;
            }
            else return false;
        }
    return(letterCount==1 && digitCount==4 );
    }
    
    public static boolean isChar(char ch){
        ch = Character.toLowerCase(ch);
        return(ch>='A' && ch<='Z');//allow A to Z only
    }
    
    public static boolean isDigit(char ch){
        return(ch>='0' && ch<='9');  // allow 0 to  only
    }
    
    public static ArrayList<Product> getProductList() {
        return productList;
    }
    
    public static void displayProduct(){
        displayAllProd();
    }
    
    
    public static void searchProduct(){

        Scanner src=new Scanner(System.in);
        ArrayList<Integer> foundIndexList = new ArrayList<>();
        foundIndexList.clear();
        System.out.print("\n\nSearch product by\n");
        System.out.print("-----------------\n");
        System.out.print("1.Product Code\n2.Prodcut Name\n3.Product Costs\n4.Product Price\n5.Product Size\n6.Product Supplier\n7.Product stock");
        int option=Menu.getInput();
        switch(option){
            case 1:
                
                System.out.println("\nEnter the product code :");
                String searchCode = src.nextLine();
                for(Product p:productList){
            
                    if(p.productCode.equalsIgnoreCase(searchCode)){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                
                break;
               
            case 2:
                System.out.print("\nEnter the product name :");
                String searchName = src.nextLine();
                for(Product p:productList){
            
                    if(p.productName.equalsIgnoreCase(searchName)){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                    
                break;
            
            case 3:
                System.out.print("\nEnter the product costs :");
                double searchCost = src.nextDouble();
                for(Product p:productList){
            
                    if(p.costs == searchCost){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                    
                break;
                
             case 4:
                System.out.print("\nEnter the product price :");
                double searchPrice = src.nextDouble();
                for(Product p:productList){
            
                    if(p.price == searchPrice){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                    
                break;   
                
                
            case 5:
                
                System.out.print("\nEnter the product size :");
                String searchSize = src.nextLine();
                for(Product p:productList){
            
                    if(p.size.equalsIgnoreCase(searchSize)){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                
                break;
                
             case 6:
                
                System.out.print("\nEnter the product supplier :");
                String searchSupplier = src.nextLine();
                for(Product p:productList){
            
                    if(p.supplier.equalsIgnoreCase(searchSupplier)){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                
                break;
            
            case 7:
                
                System.out.print("\nEnter the product stock :");
                int searchStock = src.nextInt();
                for(Product p:productList){
            
                    if(p.stock == searchStock){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                
                break;
        }

        
    }
    
    public static void displayAllProd() { //Display All product in the Product List
        System.out.printf("%55s ","Porduct List");
        System.out.println("\n---------------------------------------------------------------------------------------------------");
        System.out.printf("%4s|%10s|%10s|%13s|%13s|%15s|%15s|%10s|\n", "[No]", "Name", "Code", "Costs(RM)", "Price(RM)", "Size", "Supplier", "Stock");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Product p:productList)
            System.out.printf("[%2d]|%10s|%10s|%13s|%13s|%15s|%15s|%10s|\n", productList.indexOf(p) + 1, p.productName,p.productCode,p.costs,p.price,p.size,p.supplier,p.stock);
    }
    
    public static void displayAllProd(ArrayList<Integer> indexList) { //Display All product based on the selected index in the Product List
        System.out.printf("%55s ","Porduct List");
        System.out.println("\n---------------------------------------------------------------------------------------------------");
        System.out.printf("%4s|%10s|%10s|%13s|%13s|%15s|%15s|%10s|\n", "[No]", "Name", "Code", "Costs(RM)", "Price(RM)", "Size", "Supplier", "Stock");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Integer i: indexList)
            System.out.printf("[%2d]|%10s|%10s|%13s|%13s|%15s|%15s|%10s|\n", indexList.indexOf(i) + 1, productList.get(i).productName,productList.get(i).productCode,productList.get(i).costs,productList.get(i).price,productList.get(i).size,productList.get(i).supplier,productList.get(i).stock);
    }
    
    public static void removeProd(){
        Scanner src=new Scanner(System.in);
        ArrayList<Integer> foundIndexList = new ArrayList<>();
        
        displayAllProd();
        System.out.print("Enter the number that you want to remove :");
        int delete=src.nextInt();
        System.out.printf("Successfuly removed %s | %s | %.2f | %.2f | %s | %s | %d |",productList.get(delete-1).productName,productList.get(delete-1).productCode,
        productList.get(delete-1).costs,productList.get(delete-1).price,productList.get(delete-1).size,productList.get(delete-1).supplier,productList.get(delete-1).stock);
        productList.remove(delete-1);
        
    }
    
}


