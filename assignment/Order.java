
package ordring;
import java.util.ArrayList;

 public class Order{

     String staffName;
     double total;

    public Order(String staffName, double total) {
        this.staffName = staffName;
        this.total = total;
    }

    public Order() {
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   
    
    public static void addList(int prodNo, int quantity, int no){
        int x = no - 1; 
        OrderList[] ol = new OrderList[10];
        ol[x].orderList(prodNo, quantity, no++);
        
    }
    
  
 }