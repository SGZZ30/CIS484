/*
 * Shipment Objects
 */
package ThriftyStore;

import java.sql.Date;

public class Shipment {
    private String shipID;
    private double weight;
    private String origin;
    private Date shipped;
    private Date received;
    private int nextID = 1;
    
    Shipment(double weight, String origin, Date ship, Date rec) {
        setWeight(weight);
        setOrigin(origin);
        setDateShipped(ship);
        setDateReceived(rec);
        this.shipID = "Shipment-" + nextID++;
    }

    public void setWeight(double w) {
        this.weight = w;
    }

    public void setOrigin(String o) {
        this.origin = o;
    }

    public void setDateShipped(Date s) {
        this.shipped = s;
    }

    public void setDateReceived(Date r) {
        this.received = r;
    }
    
    public String getShipmentID() {
        return this.shipID;
    }
    
    public double getWeight() {
        return this.weight;
    }
    
    public String getOrigin() {
        return this.origin;
    }
    
    public Date getDateShipped() {
        return this.shipped;
    }
    
    public Date getDateReceived() {
        return this.received;
    }
    
    @Override
    public String toString() {
        return "Origin: " + this.getOrigin() + ", Weight: " + this.getWeight() + ", Date Shipped: " 
                + this.getDateShipped() + ", Date Received: " + this.getDateReceived();
    }
}
