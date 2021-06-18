/*
 * Sale objects
 */
package ThriftyStore;

import java.sql.Time;

public class Sale {
    private String saleID;
    private Time date;
    private double total;
    private String shopID;
    private String empID;
    private String storeID;
    private int nextID = 1;
    
    Sale(Time date, double total, String shop, String emp, String store) {
        setDate(date);
        setTotalPrice(total);
        setShopperID(shop);
        setEmployeeID(emp);
        setStoreID(store);
        this.saleID = "Sale-" + nextID++;
    }

    public void setDate(Time date) {
        this.date = date;
    }

    public void setTotalPrice(double total) {
        this.total = total;
    }

    public void setShopperID(String shop) {
        this.shopID = shop;
    }

    public void setEmployeeID(String emp) {
        this.empID = emp;
    }

    public void setStoreID(String store) {
        this.storeID = store;
    }
    
    public String getSaleID() {
        return this.saleID;
    }
    
    public Time getDate() {
        return this.date;
    }
    
    public double getTotalPrice() {
        return this.total;
    }
    
    public String getShopperID() {
        return this.shopID;
    }
    
    public String getEmployeeID() {
        return this.empID;
    }
    
    public String getStoreID() {
        return this.storeID;
    }
    
    @Override
    public String toString() {
        return "ShopperID: " + this.getShopperID() + ", EmployeeID: " + this.getEmployeeID() + ", StoreID: " 
                + this.getStoreID() + ", Date: " + this.getDate() + ", Total: " + this.getTotalPrice();
    }
}
