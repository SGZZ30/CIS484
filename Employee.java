/*
 * Employee Objects
 */
package ThriftyStore;

public class Employee {
    private String empID;
    private String name;
    private String phone;
    private String address;
    private String type;
    private double salary;
    private String pwd;
    private int nextID = 1;
    
    Employee(String name, String phone, String address, double sal, String type, String pwd) {
        setName(name);
        setPhone(phone);
        setAddress(address);
        setSalary(sal);
        setType(type);
        setPassword(pwd);
        this.empID = "Employee-" + nextID++;
    }
    
    public void setName(String n) {
        this.name = n;
    }
    
    public void setPhone(String p) {
        this.phone = p;
    }
    
    public void setAddress(String a) {
        this.address = a;
    }
    
    public void setType(String t) {
        this.type = t;
    }
    
    public void setSalary(double s) {
        this.salary = s;
    }
    
    public void setPassword(String p) {
        this.pwd = p;
    }
    
    public String getEmployeeID() {
        return this.empID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getType() {
        return this.type;
    }
    
    public String getPassword() {
        return this.pwd;
    }
    
    public double getSalary() {
        return this.salary;
    }
    
    public String toString() {
        return "Name: " + this.getName() + ", Type: " + this.getType();
    }
}
