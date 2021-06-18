/*
 * Product objects
 */
package ThriftyStore;

public class Product {
    private String prodID;
    private String name;
    private String desc;
    private String cat;
    private double purchase;
    private double price;
    private String shipID;
    private int nextID = 1;
    
    Product(String name, String desc, String cat, double amt, double price, String ship) {
        setName(name);
        setDescription(desc);
        setCategory(cat);
        setPurchaseAmount(amt);
        setSellPrice(price);
        setShipmentID(ship);
        this.prodID = "Product-" + nextID++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public void setCategory(String cat) {
        this.cat = cat;
    }

    public void setPurchaseAmount(double amt) {
        this.purchase = amt;
    }

    public void setSellPrice(double price) {
        this.price = price;
    }

    public void setShipmentID(String ship) {
        this.shipID = ship;
    }
    
    public String getProductID() {
        return this.prodID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.desc;
    }
    
    public String getCategory() {
        return this.cat;
    }
    
    public double getPurchaseAmount() {
        return this.purchase;
    }
    
    public double getSellPrice() {
        return this.price;
    }
    
    public String getShipmentID() {
        return this.shipID;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.getName() + ", Category: " + this.getCategory();
    }
}
