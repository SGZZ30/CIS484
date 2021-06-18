/*
 * ProductSale objects
 */
package ThriftyStore;

public class ProductSale {
    //Attributes
    private String prodSaleID;
    private String prodID;
    private String saleID;
    private int qty;
    private double price;
    private int nextID = 1;
    
    //Constructor
    ProductSale(String prod, String sale, int qty, double price) {
        setProductID(prod);
        setSaleID(sale);
        setQuantity(qty);
        setProductPrice(price);
        this.prodSaleID = "ProductSale-" + nextID++;
    }
    
    //Setters
    public void setProductID(String p) {
        this.prodID = p;
    }
    
    public void setSaleID(String s) {
        this.saleID = s;
    }
    
    private void setQuantity(int qty) {
        this.qty = qty;
    }

    private void setProductPrice(double price) {
        this.price = price;
    }
    
    //Getters
    public String getProductSaleID() {
        return this.prodSaleID;
    }
    
    public String getProductID() {
        return this.prodID;
    }
    
    public String getSaleID() {
        return this.saleID;
    }
    
    public int getQuantity() {
        return this.qty;
    }
    
    public double getProductPrice() {
        return this.price;
    }
    
    @Override
    public String toString() {
        return "ID: " + getProductSaleID() + ", ProductID: " + getProductID() + ", SaleID: " + getSaleID();
    }
}
