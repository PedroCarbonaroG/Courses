package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Prompt {
    
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Scanner sc = new Scanner(System.in, "UTF-8");

    private Contract contract;
    private ContractService contractService = new ContractService(new PaypalService());
    

    public void startPrompt() {

        try {

            System.out.println("==========================================");
            System.out.println("Entre com os dados do contrato: ");
            
            System.out.print("Numero: ");
            short number = sc.nextShort();
            sc.nextLine(); // Cleaning the SCANNER buffer
            
            System.out.print("Data: ");
            LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
            
            System.out.print("Valor do contrato: ");
            double totalValue = sc.nextDouble();
            
            System.out.print("Entre com o numero de parcelas: ");
            short installments = sc.nextShort();

            contract = new Contract(number, date, totalValue);
            contractService.processContract(contract, installments);

            System.out.println("\nParcelas: ");
            for (Installment i : contract.getInstallments()) {
                System.out.println(i);
            }

        }
        catch (RuntimeException e) { System.out.println(e.getMessage()); }
        finally { sc.close(); }
    }
}
