package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.AccountType;

public class Prompt {
    
    private static final Scanner sc = new Scanner(System.in, "UTF-8");
    private List<AccountType> accounts = new ArrayList<>();

    public void startPrompt() {
        System.out.println("========================================================");
        System.out.println("Enter the number of tax payers: "); short payers = sc.nextShort();
        
        for (short i = 0, j = 0; i < j; i++, j++) {
            System.out.println("Tax payer #" + j + " data:");
            System.out.print("Individual or Company (i/c): ");
        }
    }
}
