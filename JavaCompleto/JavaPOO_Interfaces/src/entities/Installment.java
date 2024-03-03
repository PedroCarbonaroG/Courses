package entities;

import java.util.Date;

public class Installment {
    
    private Date dueDate;
    private double amount;

    public Installment() {
    }
    public Installment(Date dueDate, double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    public Date getDueDate() {
        return dueDate;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
}
