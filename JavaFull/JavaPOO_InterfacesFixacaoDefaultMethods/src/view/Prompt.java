package view;

import java.util.Scanner;

import service.BrazilInterestService;
import service.InterestService;
import service.UsaInterestService;

public class Prompt {

    private static Scanner sc = new Scanner(System.in, "UTF-8");

    public void startPrompt() {
        System.out.println("===============================================");
        
        System.out.print("Amount to borrow: "); 
        double amount = sc.nextDouble();
        
        System.out.print("Months to pay in installments: ");
        short months = sc.nextShort();

        InterestService is1 = new BrazilInterestService(2);
        InterestService is2 = new UsaInterestService(1);
        
        double brazilPayment = is1.payment(amount, months);
        double usaPayment = is2.payment(amount, months);

        System.out.println("\nTotal Payment after " + months + " months: ");
        System.out.println("Brazil: " + String.format("%.2f", brazilPayment));
        System.out.println("Usa: " + String.format("%.2f", usaPayment));
        System.out.println();

    }
}
