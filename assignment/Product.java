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

    public static ArrayList<Product> getProductList() {
        return productList;
    }
    
    public static void displayProduct() {
        System.out.print("\nProduct List\n");
        for(Product p:productList)
        System.out.print(p);
    }
    
    @Override
    public String toString() {
        return "-----------------------"+ "\nProduct Name :" + productName + "\nProduct Code :" + productCode + 
                "\nCosts :" + costs + "\nPrice :" + price + "\nSize :" + size + "\nSupplier :" + supplier + "\nStock :" + stock +"\n";
    }
}

