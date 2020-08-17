
package ordring;


public class OrderList {
    
     public static void orderList(int prodNo, int quantity, int no){

        double unitPrice, subtotal;
     
        String prodName, itemCode;
        
        prodNo--;
        unitPrice = Product.getProductList().get(prodNo).getPrice();
        prodName = Product.getProductList().get(prodNo).getProductName();
        itemCode = Product.getProductList().get(prodNo).getProductCode();
        subtotal = quantity * unitPrice;
        System.out.printf("%d. \t %s \t %s \t %d \t %.2f      %.2f \n",no++ ,itemCode, prodName, quantity, unitPrice, subtotal);
        
        
    }
}
