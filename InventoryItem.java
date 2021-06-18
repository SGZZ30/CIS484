/*
 * InventoryItem objects
 */
package ThriftyStore;

public class InventoryItem {
    //Attributes
    private String invItemID;
    private String prodID;
    private String storeID;
    private int nextID = 1;
    
    //Constructor
    InventoryItem(String prod, String store) {
        setProductID(prod);
        setStoreID(store);
        this.invItemID = "InventoryItem-" + nextID++;
    }
    
    //Setters
    public void setProductID(String p) {
        this.prodID = p;
    }
    
    public void setStoreID(String s) {
        this.storeID = s;
    }
    
    //Getters
    public String getInventoryItemID() {
        return this.invItemID;
    }
    
    public String getProductID() {
        return this.prodID;
    }
    
    public String getStoreID() {
        return this.storeID;
    }
    
    @Override
    public String toString() {
        return "ID: " + getInventoryItemID() + ", ProductID: " + getProductID() + ", StoreID: " + getStoreID();
    }
}
