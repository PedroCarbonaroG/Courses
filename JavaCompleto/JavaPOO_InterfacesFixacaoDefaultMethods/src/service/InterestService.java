package service;

public interface InterestService {
    
    public double getInterestRate();

    default double payment(double amount, short months) {
        return amount * Math.pow(1.0 + getInterestRate() / 100, months);
    }
}
