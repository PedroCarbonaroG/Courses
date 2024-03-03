package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
    
    private short number;
    private Date date;
    private double totalValue;

    private List<Installment> installments = new ArrayList<>();
    
    public Contract() {
    }
    public Contract(short number, Date date, double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Date getDate() {
        return date;
    }
    public short getNumber() {
        return number;
    }
    public List<Installment> getInstallments() {
        return installments;
    }
    public double getTotalValue() {
        return totalValue;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setNumber(short number) {
        this.number = number;
    }

    public void addInstallment(Installment installment) {
        this.installments.add(installment);
    }

    public void removeInstallment(Installment installment) {
        this.installments.remove(installment);
    }

    public void setTotalValue() {
        double totalValue = 0;
        for (Installment i : installments) {
            totalValue += i.getAmount();
        }

        this.totalValue = totalValue;
    }

}
