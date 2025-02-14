/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;


import static java.lang.System.exit;
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
    private int qtyOrder;
    private double subtotal;
    private double subCost;
    
    
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
    
    public static void init() {
        Product.addProduct("Sofas","S1001",350,600,"100*50*100","Mr. Lee",50);
        Product.addProduct("Table","T1001",150,700,"100*100*100","Mr. Cheah",50);
        Product.addProduct("Beds","B1001",150,800,"100*50*100","Mrs. Teh",50);
        Product.addProduct("Ottoman","O1001",150,600,"10*10*10","Mr. Kee",50);
        Product.addProduct("Dressers","D1001",150,800,"10*10*10","Mr. Tan",50);
        Product.addProduct("Futons","F1001",150,700,"10*10*10","Mr. Soh",50);
        Product.addProduct("Lockers","L1001",150,1000,"10*10*10","Mr. Thiow",50);
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
    
    public int getQtyOrder() {
        return qtyOrder;
    }

    public void setQtyOrder(int qtyOrder) {
        this.qtyOrder = qtyOrder;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public void calQuantity(int quantity){
        this.stock -= quantity;
    }
    
    @Override
    public String toString() {
        return "-----------------------"+ "\nProduct Name :" + productName + "\nProduct Code :" + productCode + 
                "\nCosts :" + costs + "\nPrice :" + price + "\nSize :" + size + "\nSupplier :" + supplier + "\nStock :" + stock +"\n";
    }
    
    public void calculateSub(int qty){
        this.qtyOrder = qty;
        this.subtotal = qty *  price;
        this.subCost = qty * costs;
    }

    public double getSubCost() {
        return subCost;
    }

    public void setSubCost(double subCost) {
        this.subCost = subCost;
    }
    
    public static void addProduct(){
       int temp=0;
       
       Scanner src=new Scanner(System.in);

        String prodName;          
        do{
            System.out.print("Enter the product name :");
            prodName=src.nextLine();
            for(int i=0;i<prodName.length();i++){
                if(Character.isDigit(prodName.charAt(i))){
                System.out.print("-----Invalid Input!Cannot include digit.-----\n");
                    temp=1;
                    break;
                }
                else{ 
                    temp=0;
                }
            }
       }while(temp==1);
       System.out.print("-----------------COMPLETE-------------------\n");

    //------------------------------------------------PRODUCT CODE-&-VALIDATION-----------------------------------------------------------   
     String prodCode;   //validation for productCode must contain 1 alphabet and 4number
    do{
       System.out.print("\nEnter the product code(e.g. A1001) :");
       prodCode=src.nextLine();
       if(prodCode.length()== 5){  //first check the length must be 5 only 1(A) 4(D)
            if(Character.isLetter(prodCode.charAt(0))){ //second check is for 1 code must be letter
                for(int i=1;i<prodCode.length();i++){
                    if(Character.isDigit(prodCode.charAt(i))){ //third check 2 -5 must be number
                        temp=0;
                    }
                    else{
                        System.out.print("---------------Invalid Input!---------------");
                        temp=1;//user input again
                        break;
                    }   
               }
            }
            else{
                System.out.print("---------------Invalid Input!---------------");
                temp=1;//user input again
            }
       }
       else{
           System.out.print("---------------Invalid Input!---------------");
           temp=1;//user input again
       }
    }while(temp==1);
    System.out.print("-----------------COMPLETE-------------------\n");
    //------------------------------------------------PRODUCT COST-&-VALIDATION-----------------------------------------------------------  
     double prodCost=0;
     do{
       System.out.print("\nEnter the cost :");
       try{
           prodCost=src.nextDouble();
           if(prodCost<=0){
           System.out.print("---------------Invalid Input!---------------");
           }
       }
       catch(Exception e){
           System.out.print("----------Must enter a number!--------------");
           src.next();
       }
     }while(prodCost<=0);
     System.out.print("-----------------COMPLETE-----------------\n");
    //------------------------------------------------PRODUCT PRICE-&-VALIDATION----------------------------------------------------------- 
     double prodPrice=0;
     do{
       System.out.print("\nEnter the selling price :");
       try{
           prodPrice=src.nextDouble();
           if(prodPrice<=0 || prodPrice <= prodCost ){
            System.out.print("---------------Invalid Input!---------------");
           }
       }
       catch(Exception e){
           System.out.print("----------Must enter a number!--------------");
           src.next();
       }
     }while(prodPrice<=0 ||  prodPrice <= prodCost );
     System.out.print("-----------------COMPLETE-----------------\n");
     //-------------------------------------------------PRODUCT SIZE------------------------------------------------------------------- 
       src.nextLine();
       String prodSize;
       do{
            System.out.print("\nEnter the product size(e.g. 100*50*35) :");
            prodSize=src.nextLine();

                if(!prodSize.matches("-?\\d+\\*-?\\d+\\*-?\\d+")){
                System.out.print("-------Cannot include alphabet and Must follow N*N*N.-------");
                    temp=1;
                }
                else{
                    temp=0;
                }
            
       }while(temp==1);
       System.out.print("-----------------COMPLETE-----------------\n");  
    //----------------------------------------------------SUPPLIER---------------------------------------------------------------------
    String prodSupplier;   
    do{
            System.out.print("\nEnter the supplier :");
            prodSupplier=src.nextLine();
            for(int i=0;i<prodSupplier.length();i++){
                if(Character.isDigit(prodSupplier.charAt(i))){
                System.out.print("----------Invalid Input!Cannot include digit.--------");
                    temp=1;
                    break;
                }
                else{
                    temp=0;
                }
            }   
       }while(temp==1);
       System.out.print("-----------------COMPLETE-----------------\n");
    //------------------------------------------------PRODUCT STOCK-&-VALIDATION----------------------------------------------------------- 
     int prodStock=0;
     do{
       System.out.print("\nEnter the stock :");
       try{
           prodStock=src.nextInt();
           if(prodStock<=0){
               System.out.print("---------------Invalid Input!---------------");
           }
       }
       catch(Exception e){
           System.out.print("----------Must enter a number!--------------");
           src.next();
       }
     }while(prodStock<=0);
     System.out.print("-----------------COMPLETE-----------------\n");
     //-----------------------------------------------------------------------END-----------------------------------------------------------
       productList.add(new Product(prodName,prodCode,prodCost,prodPrice,prodSize,prodSupplier,prodStock));
    }
    public static void addProduct(String productName, String productCode, double costs, double price, String size, String supplier, int stock){
       productList.add(new Product(productName,productCode,costs,price,size,supplier,stock));
    }
    
    public static ArrayList<Product> getProductList() {
        return productList;
    }
    
//    public static void displayProduct(){
//        displayAllProd();
//    }
    
    //-----------------------------------------------------------------------Search function-----------------------------------------------------------
    public static void searchProduct(){

        Scanner src=new Scanner(System.in);
        ArrayList<Integer> foundIndexList = new ArrayList<>();
        foundIndexList.clear();
        int temp=0;
        
        System.out.print("\n\nSearch product by\n");
        System.out.print("-----------------\n");
        System.out.print("1.Product Code\n2.Prodcut Name\n3.Product Costs\n4.Product Price\n5.Product Size\n6.Product Supplier\n7.Product stock");
        int option=Menu.getInput();
        do{
            if(option<=0 || option >=8){
            System.out.print("Invalid message!");
            temp=1;
        }
        else{
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
                double searchCost = Validation.vDouble("\nEnter the product costs :");
                for(Product p:productList){
            
                    if(p.costs == searchCost){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                    
            break;
                
             case 4:
                double searchPrice = Validation.vDouble("\nEnter the product price :");
                for(Product p:productList){
            
                    if(p.price == searchPrice){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                    
            break;   
                
                
            case 5:
                String searchSize;
                do{
                    System.out.print("\nEnter the product size(e.g. 100*50*35) :");
                    searchSize=src.nextLine();

                    if(!searchSize.matches("-?\\d+\\*-?\\d+\\*-?\\d+")){
                        System.out.print("-------Cannot include alphabet and Must follow N*N*N.-------");
                        temp=1;
                    }
                    else{
                        temp=0;
                    }
                }while(temp==1);
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
                int searchStock = Validation.vInt("\nEnter the product stock :");
                for(Product p:productList){
            
                    if(p.stock == searchStock){
                    foundIndexList.add(productList.indexOf(p));
                    }  
                }
                    displayAllProd(foundIndexList); // Call the displayAllEmp with indexList parameter, so it print the employee of that indexes
                    System.out.printf("\n%d results found.\n", foundIndexList.size());
                
            break;
            
            default: System.out.println("Invalid input."); 
            temp=1;
            }
        }
        }while(temp==1); 
    }
    
    public static void displayAllProd() { //Display All product in the Product List
        System.out.printf("\n\n%55s ","Porduct List");
        System.out.println("\n---------------------------------------------------------------------------------------------------");
        System.out.printf("%4s|%10s|%10s|%13s|%13s|%15s|%15s|%10s|\n", "[No]", "Name", "Code", "Costs(RM)", "Price(RM)", "Size", "Supplier", "Stock");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Product p:productList)
            System.out.printf("[%2d]|%10s|%10s|%13s|%13s|%15s|%15s|%10s|\n", productList.indexOf(p) + 1, p.productName,p.productCode,p.costs,p.price,p.size,p.supplier,p.stock);
    }
    public static void displayProdStaff() { //Display All product in the Product List
        System.out.printf("\n\n%55s ","Porduct List");
        System.out.println("\n---------------------------------------------------------------------------------------------------");
        System.out.printf("%4s|%10s|%10s|%13s|%15s|%15s|%10s|\n", "[No]", "Name", "Code", "Price(RM)", "Size", "Supplier", "Stock");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Product p:productList)
            System.out.printf("[%2d]|%10s|%10s|%13s|%15s|%15s|%10s|\n", productList.indexOf(p) + 1, p.productName,p.productCode,p.price,p.size,p.supplier,p.stock);
    }
    
    public static void displayAllProd(ArrayList<Integer> indexList) { //Display All product based on the selected index in the Product List
        System.out.printf("\n\n%55s ","Porduct List");
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
        int delete=Validation.vInt("Enter the number that you want to remove :");
        System.out.printf("Successfuly removed %s | %s | %.2f | %.2f | %s | %s | %d |",productList.get(delete-1).productName,productList.get(delete-1).productCode,
        productList.get(delete-1).costs,productList.get(delete-1).price,productList.get(delete-1).size,productList.get(delete-1).supplier,productList.get(delete-1).stock);
        productList.remove(delete-1);
        
    }
    
    public static void modifyProd(){
        Scanner src=new Scanner(System.in);
        ArrayList<Integer> foundIndexList = new ArrayList<>();

        int temp=0;

        do{
            displayAllProd();
            System.out.print("\n\nEnter the number that you want to modify :");
            int modify=Menu.getInput();
            if(modify<=0 || modify>productList.size()){
                System.out.print("Invalid message!\n\n");
                temp=1;
            }
            else{
                System.out.print("1.Product Code\n2.Prodcut Name\n3.Product Costs\n4.Product Price\n5.Product Size\n6.Product Supplier\n7.Product stock");
                int option=Menu.getInput();
                String modifyCode;
                switch(option){
                case 1:
                    do {
                        System.out.print("\nEnter the new product code :");
                        modifyCode = src.nextLine();

                        if(modifyCode.length()== 5){  //first check the length must be 5 only 1(A) 4(D)
                            if(Character.isLetter(modifyCode.charAt(0))){ //second check is for 1 code must be letter
                                for(int i=1;i<modifyCode.length();i++){
                                    if(Character.isDigit(modifyCode.charAt(i))){ //third check 2 -5 must be number
                                        temp=0;
                                    }
                                    else{
                                        System.out.print("---------------Invalid Input!---------------");
                                        temp=1;//user input again
                                        break;
                                    }   
                               }
                            }
                            else{
                                System.out.print("---------------Invalid Input!---------------");
                                temp=1;//user input again
                            }
                        }
                        else{
                           System.out.print("---------------Invalid Input!---------------");
                           temp=1;//user input again
                        }
                    }while (temp == 1);
                    
                    System.out.print("\n\nConfirm to modify? (Y=yes) ");
                    char ans=src.next().charAt(0);
                    if(Character.toUpperCase(ans)=='Y'){
                        productList.get(modify-1).setProductCode(modifyCode);
                        System.out.print("Successful modify!\n");
                        displayAllProd();
                    }
                    else{
                        System.out.print("\n\nModify cancel...");
                    }
                    temp=0;

                break;

                case 2:
                    System.out.print("\nEnter the new product Name :");
                    src.nextLine();
                    String modifyName = src.nextLine();

                    System.out.print("\n\nConfirm to modify? (Y=yes) ");
                    ans=src.next().charAt(0);
                    if(Character.toUpperCase(ans)=='Y'){
                        productList.get(modify-1).setProductName(modifyName);
                        System.out.print("Successful modify!\n");
                        displayAllProd();
                    }
                    else{
                        System.out.print("\n\nModify cancel...");
                    }
                    temp=0;
                break;

                case 3:
                    double modifyCost = Validation.vDouble("\nEnter the new product costs :");

                    System.out.print("\n\nConfirm to modify? (Y=yes) ");
                    ans=src.next().charAt(0);
                    if(Character.toUpperCase(ans)=='Y'){
                        productList.get(modify-1).setCosts(modifyCost);
                        System.out.print("Successful modify!\n");
                        displayAllProd();
                    }
                    else{
                        System.out.print("\n\nModify cancel...");
                    }
                    temp=0;
                break;

                case 4:
                    double modifyPrice = Validation.vDouble("\nEnter the new product price :");

                    System.out.print("\n\nConfirm to modify? (Y=yes) ");
                    ans=src.next().charAt(0);
                    if(Character.toUpperCase(ans)=='Y'){
                        productList.get(modify-1).setPrice(modifyPrice);
                        System.out.print("Successful modify!\n");
                        displayAllProd();
                    }
                    else{
                        System.out.print("\n\nModify cancel...");
                    }
                    temp=0;
                break;

                case 5:
                    String modifySize;
                    do {
                        System.out.print("\nEnter the new product size :");
                        modifySize = src.nextLine();
                        if(!modifySize.matches("-?\\d+\\*-?\\d+\\*-?\\d+")){
                            System.out.print("-------Cannot include alphabet and Must follow N*N*N.-------");
                            temp=1;
                        }
                        else{
                            temp=0;
                        }
                    }while ( temp == 1);
                    
                    
                    System.out.print("\n\nConfirm to modify? (Y=yes) ");
                    ans=src.next().charAt(0);
                    if(Character.toUpperCase(ans)=='Y'){
                        productList.get(modify-1).setSize(modifySize);
                        System.out.print("Successful modify!\n");
                        displayAllProd();
                    }
                    else{
                        System.out.print("\n\nModify cancel...");
                    }
                    temp=0;
                break;

                case 6:
                    System.out.print("\nEnter the new product supplier :");
                    String modifySupplier = src.nextLine();

                    System.out.print("\n\nConfirm to modify? (Y=yes) ");
                    ans=src.next().charAt(0);
                    if(Character.toUpperCase(ans)=='Y'){
                        productList.get(modify-1).setSupplier(modifySupplier);
                        System.out.print("Successful modify!\n");
                        displayAllProd();
                    }
                    else{
                        System.out.print("\n\nModify cancel...");
                    }
                    temp=0;
                break;

                case 7:
                    int modifyStock = Validation.vInt("\nEnter the new product stock :");

                    System.out.print("\n\nConfirm to modify? (Y=yes) ");
                    ans=src.next().charAt(0);
                    if(Character.toUpperCase(ans)=='Y'){
                        productList.get(modify-1).setStock(modifyStock);
                        System.out.print("Successful modify!\n");
                        displayAllProd();
                    }
                    else{
                        System.out.print("\n\nModify cancel...");
                    }
                    temp=0;
                break;

                default: System.out.println("Invalid input."); 
                temp=1;
                }
            }
        }while(temp==1);
    }
    
    public static void addStock(){
        Scanner src=new Scanner(System.in);
        int addStock=0;
        int temp=0;
        int newStock=0;
        ArrayList<Integer> foundIndexList = new ArrayList<>();
        
        displayAllProd();
        System.out.println("[ 0] Return to main menu");
        do{
            int addProduct=Validation.vInt("\n\nEnter the number that you want to add stock :");
            if(addProduct<0 || addProduct>productList.size()){ //cannot be negative and out of range of the arraylist
                System.out.print("Invalid message!\n\n");
                temp=1;
            }
            else if(addProduct == 0) return;
            else{
                do{
                    System.out.print("\nEnter the quantity : ");
                    try{
                        addStock=src.nextInt();
                        if(addStock<=0){
                            System.out.print("---------------Invalid Input!---------------");
                        }
                    }
                    catch(Exception e){
                    System.out.print("----------Must enter a number!--------------");
                    temp=1;
                    src.next();
                    }
                }while(addStock<=0);
                System.out.print("\nConfirm to add stock?(Y/N) > ");
                char ans=src.next().charAt(0);
                if(Character.toUpperCase(ans)=='Y'){
                    newStock=addStock+productList.get(addProduct-1).getStock(); //newStock=userinput+sotck inside arrayList
                    productList.get(addProduct-1).setStock(newStock);//put new stock inside the arrayList
                    System.out.print("Successful add!\n");
                    displayAllProd();
                }
                else{
                    System.out.print("\nAdd Product cancel...");
                    temp=1;
                }    
            }
        }while(temp==1 || addStock<=0);  //loop while get temp=1 and addStock is 0 or negative      
    }
}


