package entities;

public class Company extends AccountType {
    
    private static final double DEFAULT_TAX = 0.16;
    private static final double LOW_TAX = 0.14;
    private static final short MIN_EMPLOYEES_TO_DISCOUNT = 10;

    private short employeesNum;

    public Company() {
        super();
    }
    public Company(String name, double yearIncome, short employeesNum) {
        super(name, yearIncome);
        this.employeesNum = employeesNum;
    }

    public short getEmployeesNum() {
        return employeesNum;
    }
    public void setEmployeesNum(short employeesNum) {
        this.employeesNum = employeesNum;
    }

    @Override
    public final double taxesValue() {
        return (employeesNum < MIN_EMPLOYEES_TO_DISCOUNT) ? this.getYearIncome() * DEFAULT_TAX : this.getYearIncome() * LOW_TAX;
    }

    @Override
    public final String toString() {
        return this.getName() + ": $ " + String.format("%.2f", taxesValue());
    }
}
