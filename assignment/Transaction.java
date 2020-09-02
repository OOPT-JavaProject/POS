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
import static ordring.Ordering.transaction;

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

//1
    public static void main(String[] args) {
        int select = 0, sOrM;
        Scanner scn = new Scanner(System.in);
        Product.addProduct("Sofas","S1001",350,600,"100*50*100","Mr. Lee",50);
        Product.addProduct("Table","T1001",150,700,"100*100*100","Mr. Cheah",50);
        Product.addProduct("Beds","B1001",150,800,"100*50*100","Mrs. Teh",50);
        Product.addProduct("Ottoman","O1001",150,600,"10*10*10","Mr. Kee",50);
        Product.addProduct("Dressers","D1001",150,800,"10*10*10","Mr. Tan",50);
        Product.addProduct("Futons","F1001",150,700,"10*10*10","Mr. Soh",50);
        Product.addProduct("Lockers","L1001",150,1000,"10*10*10","Mr. Thiow",50);
        Ordering.runsample();
    System.out.print("1.manager \n2.staff");
    System.out.print("\nEnter a selection > ");
    sOrM = scn.nextInt();
    if (sOrM == 1){
        do{
            Ordering.displayStaffOrderMenu();
            System.out.print("\nEnter a selection > ");
            select = scn.nextInt();
            if(select == 1){
                Ordering.addOrder();
            }
            else if(select == 2 ){
                Ordering.displayReceipt();
            }
            else if(select == 3){
                Ordering.modifyOrder();
            }
            else if(select == 4 ){
                Ordering.searchOrder();
            }
            else if(select == 5 ){
                Ordering.orderSummary();
            }
            else if(select == 6 ){
                Ordering.removeOrder();
            }
        }while(select != 0);
    }
    else if(sOrM == 2){
        do{
            Ordering.displayStaffMenu();
            System.out.print("Enter a selection > ");
            select = scn.nextInt();
            if(select == 1){
                Ordering.addOrder();
            }
            if(select == 3 ){
                Ordering.displayReceipt();
            }

            }while(select != 0);
         }
    }


}