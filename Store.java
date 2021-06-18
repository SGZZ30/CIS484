/*
 * Store objects
 */
package ThriftyStore;

public class Store {
    //Attributes
    private String storeID;
    private String location;
    private int nextID = 1;
    
    //Constructor
    Store(String loc) {
        setLocation(loc);
        this.storeID = "Store-" + nextID++;
    }
    
    //Setters
    public void setLocation(String l) {
        this.location = l;
    }
    
    //Getters
    public String getStoreID() {
        return this.storeID;
    }
    
    public String getLocation() {
        return this.location;
    }
    
    @Override
    public String toString() {
        return "ID: " + getStoreID() + ", Location: " + getLocation();
    }
}
