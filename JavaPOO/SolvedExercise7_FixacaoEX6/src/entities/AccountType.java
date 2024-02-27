package entities;

public abstract class AccountType {

    private String name;
    private double yearIncome;

    public AccountType() {
    }
    public AccountType(String name, double yearIncome) {
        this.name = name;
        this.yearIncome = yearIncome;
    }

    public String getName() {
        return name;
    }
    public double getYearIncome() {
        return yearIncome;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setYearIncome(double yearIncome) {
        this.yearIncome = yearIncome;
    }

    public abstract double taxesValue();
}
