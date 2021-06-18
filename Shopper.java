/*
 * Shopper objects
 */
package ThriftyStore;

public class Shopper {
    private String shopID;
    private String name;
    private String dob;
    private String email;
    private String phone;
    private String type;
    private int nextID = 1;
    
    Shopper(String name, String dob, String email, String phone, String type) {
        setName(name);
        setDOB(dob);
        setEmail(email);
        setPhone(phone);
        setType(type);
        this.shopID = "Shopper-" + nextID++;
    }
    
    public void setName(String n) {
        this.name = n;
    }
    
    public void setDOB(String d) {
        this.dob = d;
    }
    
    public void setEmail(String e) {
        this.email = e;
    }
    
    public void setPhone(String p) {
        this.phone = p;
    }
    
    public void setType(String t) {
        this.type = t;
    }
    
    public String getShopperID() {
        return this.shopID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDOB() {
        return this.dob;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public String getType() {
        return this.type;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.getName() + ", Email: " + this.getEmail() + ", Phone: " + this.getPhone();
    }
}
