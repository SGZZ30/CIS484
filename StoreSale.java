/*
 * StoreSale objects
 */
package ThriftyStore;

public class StoreSale {
    private String storeSaleID;
    private String storeID;
    private String saleID;
    private int nextID = 1;
    
    StoreSale(String store, String sale) {
        setStoreID(store);
        setSaleID(sale);
        this.storeSaleID = "StoreSale-" + nextID++;
    }

    public void setStoreID(String store) {
        this.storeID = store;
    }

    public void setSaleID(String sale) {
        this.saleID = sale;
    }
    
    public String getStoreSaleID() {
        return this.storeSaleID;
    }
    
    public String getStoreID() {
        return this.storeID;
    }
    
    public String getSaleID() {
        return this.saleID;
    }
}
