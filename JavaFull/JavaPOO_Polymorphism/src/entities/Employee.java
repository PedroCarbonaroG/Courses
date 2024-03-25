package entities;

public class Employee {
    private String name;
    protected short hours;
    protected double valuePerHour;

    public Employee() {
    }
    public Employee(String name, short hours, double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public String getName() {
        return name;
    }
    public short getHours() {
        return hours;
    }
    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHours(short hours) {
        this.hours = hours;
    }
    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public double payment() {
        return valuePerHour * hours;
    }
}
