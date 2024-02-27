package model.entities;

import model.exceptions.TransactionException;

public class Account {
    private short number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account() {
    }
    public Account(short number, String holder, double balance, double withdrawLimit) throws TransactionException {
        if (balance < 0) { throw new TransactionException("Negative value for balance is unavailable!"); }
        if (withdrawLimit <= 0) { throw new TransactionException("Negative or 0 value for withdraw limit is unavailable!"); }
        
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public short getNumber() {
        return number;
    }
    public double getBalance() {
        return balance;
    }
    public String getHolder() {
        return holder;
    }
    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setNumber(short number) {
        this.number = number;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }
    public void setWithdrawLimit(double withdrawLimit) throws TransactionException {
        if (withdrawLimit <= 0) { throw new TransactionException("Negative or 0 value for withdraw limit is unavailable!"); }
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) throws TransactionException {
    }

    public void withdraw(double amount) throws TransactionException {
    }
}
