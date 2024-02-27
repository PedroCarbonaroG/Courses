package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.AccountType;
import entities.Company;
import entities.Individual;

public class Prompt {
    
    private static final Scanner sc = new Scanner(System.in, "UTF-8");
    private List<AccountType> accounts = new ArrayList<>();

    public void startPrompt() {
        System.out.println("========================================================");
        System.out.print("Enter the number of tax payers: "); short payers = sc.nextShort();
        
        for (short i = 0, j = 1; i < payers; i++, j++) {
            sc.nextLine(); // Cleaning the SCANNER buffer
            System.out.println("\nTax payer #" + j + " data:");
            System.out.print("Individual or Company (i/c): "); char type = sc.nextLine().charAt(0);
            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Anual Income: "); double anualIncome = sc.nextDouble();

            if (type == 'i') {
                System.out.print("Health expenditures: "); double healthExpenditures = sc.nextDouble();
                accounts.add(new Individual(name, anualIncome, healthExpenditures));

            } else if (type == 'c') {
                System.out.print("Number of Employee: "); short numEmployees = sc.nextShort();
                accounts.add(new Company(name, anualIncome, numEmployees));
            }
        }

        double totalTaxes = 0;
        System.out.println("\nTAXES PAID: ");
        for (AccountType at : accounts) {
            System.out.println(at);
            totalTaxes += at.taxesValue();
        }
        System.out.println("\nTOTAL TAXES: " + totalTaxes); 
    }
}
