/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordring;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  

/**
 *
 * @author Dora
 */
public class Transaction {
//    public static ArrayList<Ordering> transaction = new ArrayList <Ordering>();
//
//    public static ArrayList<Ordering> getTransaction() {  
//        
//        return transaction;
//    }
//
////
////
//    public static void setTransaction(ArrayList<Ordering> transaction) {
//        Transaction.transaction = transaction;
//    }

//
    public static void main(String[] args) {
        Product.addProduct("Sofas","S1001",350,600,"100*50*100","Mr. Lee",50);
        Product.addProduct("Table","T1001",150,700,"100*100*100","Mr. Cheah",50);
        Product.addProduct("Beds","B1001",150,800,"100*50*100","Mrs. Teh",50);
        Product.addProduct("Ottoman","O1001",150,600,"10*10*10","Mr. Kee",50);
        Product.addProduct("Dressers","D1001",150,800,"10*10*10","Mr. Tan",50);
        Product.addProduct("Futons","F1001",150,700,"10*10*10","Mr. Soh",50);
        Product.addProduct("Lockers","L1001",150,1000,"10*10*10","Mr. Thiow",50);
        Ordering.addOrder();
        Ordering.displayReceipt();
    }
    

}
