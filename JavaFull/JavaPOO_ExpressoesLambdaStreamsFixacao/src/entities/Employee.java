package entities;

public class Employee {
    
    private String name;
    private String email;
    private double salary;

    public Employee() {
    }
    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return email;
    }
}
