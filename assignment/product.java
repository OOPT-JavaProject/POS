/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

public class Product {
    private String [] productCode = new String[100];
    private int quantity=0;
    private static int orderNo=0;
    
    public product(String [] productCode, int quantity){
    this.productCode=productCode;
    this.quantity=quantity;
    orderNo++;
    }
    
    public void setProductCode(String [] productCode){
            this.productCode=productCode;
    }
    
    public String getProductCode(int i){
        return productCode[i];
    }
    
    public int getQuantity(){
        return quantity;
    }
}



