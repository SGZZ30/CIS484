/*
 * Photo objects
 */
package ThriftyStore;

public class Photo {
    //Attributes
    private String photoID;
    private String photoDesc;
    private String invID;
    private int nextID = 1;
    
    //Constructor
    Photo(String desc, String inv) {
        setPhotoDescription(desc);
        setInventoryID(inv);
        this.photoID = "Photo-" + nextID++;
    }
    
    //Setters
    public void setPhotoDescription(String d) {
        this.photoDesc = d;
    }
    
    public void setInventoryID(String i) {
        this.invID = i;
    }
    
    //Getters
    public String getPhotoID() {
        return this.photoID;
    }
    
    public String getPhotoDescription() {
        return this.photoDesc;
    }
    
    public String getInventoryID() {
        return this.invID;
    }
    
    @Override
    public String toString() {
        return "ID: " + getPhotoID() + ", Description: " + getPhotoDescription() + ", InventoryID: " + getInventoryID();
    }
}
