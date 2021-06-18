/*
 * EmployeeStore objects
 */
package ThriftyStore;

import java.sql.Time;

public class EmployeeStore {
    private String empStoreID;
    private String empID;
    private String storeID;
    private int days;
    private Time start;
    private Time end;
    private int nextID = 1;
    
    EmployeeStore(int days, Time start, Time end, String eID, String sID) {
        setDaysOfWeek(days);
        setStartingHour(start);
        setEndingHour(end);
        setEmployeeID(eID);
        setStoreID(sID);
        this.empStoreID = "EmployeeStore-" + nextID++;
    }
    
    public void setDaysOfWeek(int d) {
        this.days = d;
    }
    
    public void setStartingHour(Time s) {
        this.start = s;
    }
    
    public void setEndingHour(Time e) {
        this.end = e;
    }
    
    public void setEmployeeID(String e) {
        this.empID = e;
    }
    
    public void setStoreID(String s) {
        this.storeID = s;
    }
    
    public int getDaysOfWeek() {
        return this.days;
    }
    
    public Time getStartingHour() {
        return this.start;
    }
    
    public Time getEndingHour() {
        return this.end;
    }
    
    public String getEmployeeStoreID() {
        return this.empStoreID;
    }
    
    public String getEmployeeID() {
        return this.empID;
    }
    
    public String getStoreID() {
        return this.storeID;
    }
    
    @Override
    public String toString() {
        return "EmployeeID: " + this.getEmployeeID() + ", StoreID: " + this.getStoreID() + ", Days: " 
                + this.getDaysOfWeek() + ", Start Time: " + this.getStartingHour() + ", End Time: " + this.getEndingHour();
    }
}
