package entities;

public class OutsourcedEmployee extends Employee {
    
    private double additionalCharge;

    public OutsourcedEmployee() {
    }
    public OutsourcedEmployee(double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    public double getAdditionalCharge() {
        return additionalCharge;
    }
    public void setAdditionalCharge(double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    @Override
    public final double payment() {
        return valuePerHour * hours + additionalCharge * 1.1;
    }
}
