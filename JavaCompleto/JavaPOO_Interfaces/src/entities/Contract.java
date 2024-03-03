package entities;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Contract {

    private short number;
    private LocalDate date;
    private double totalValue;

    private List<Installment> installments = new ArrayList<>();
    
    public Contract() {
    }
    public Contract(short number, LocalDate date, double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public LocalDate getDate() {
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

    public void setDate(LocalDate date) {
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

}
