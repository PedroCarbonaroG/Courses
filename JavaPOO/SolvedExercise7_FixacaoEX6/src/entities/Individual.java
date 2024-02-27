package entities;

public class Individual extends AccountType {

    private static final double MIN_TAX = 0.15;
    private static final double MAX_TAX = 0.25;
    private static final double HEATH_DESCOUNT_TAX = 0.5;
    private static final int DEFAULT_VALUE_YEAR = 20000;

    private double healthExpense;

    public Individual() {
        super();
    }
    public Individual(String name, double yearIncome, double healthExpense) {
        super(name, yearIncome);
        this.healthExpense = healthExpense;
    }

    public double getHealthExpense() {
        return healthExpense;
    }
    public void setHealthExpense(double healthExpense) {
        this.healthExpense = healthExpense;
    }

    @Override
    public final double taxesValue() {
        double tax = 0;
        
        tax = (this.getYearIncome() < DEFAULT_VALUE_YEAR) ? getYearIncome() * MIN_TAX : getYearIncome() * MAX_TAX;
        if (healthExpense > 0) { tax -= (healthExpense * HEATH_DESCOUNT_TAX); }

        return tax;
    }

    @Override
    public final String toString() {
        return this.getName() + ": $ " + String.format("%.2f", taxesValue());
    }
}
