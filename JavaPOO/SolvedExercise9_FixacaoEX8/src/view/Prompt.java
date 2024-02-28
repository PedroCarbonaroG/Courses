package view;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.TransactionException;

public class Prompt {
    
    private static final Scanner sc = new Scanner(System.in, "UTF-8");
    private Account account;

    public void startPrompt() {
        
        try {
            account = new Account();
            System.out.println("===========================================");
            System.out.println("Enter account data:");
            System.out.print("Number: "); account.setNumber(sc.nextShort());
            sc.nextLine(); // Cleaning the SCANNER buffer
            System.out.print("Holder: "); account.setHolder(sc.nextLine());
            System.out.print("Initial balance: "); account.deposit(sc.nextDouble());
            System.out.print("Withdraw limit: "); account.setWithdrawLimit(sc.nextDouble());

            System.out.print("\nEnter amount for withdraw: "); account.withdraw(sc.nextDouble());
            System.out.println("New balance: " + account.getBalance());
        }
        catch (TransactionException e) { System.out.println("Transaction ERROR: " + e.getMessage()); }
        catch (RuntimeException e) { System.out.println("Unexpected ERROR: " + e.getMessage()); }
    }
}
