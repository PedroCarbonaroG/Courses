package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

public class Prompt {

    //Dependencies
    private Scanner sc = new Scanner(System.in, "UTF-8");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Worker worker;

    public void buildPrompt() throws ParseException {
        worker = new Worker();
        System.out.println("==============================================");
        System.out.print("Enter department name: "); worker.setDepartment(new Department(sc.nextLine()));
        System.out.println("Enter with worker data:");
        System.out.print("Name: "); worker.setName(sc.nextLine());
        System.out.print("Level: "); worker.setLevel(WorkerLevel.valueOf(sc.nextLine().toUpperCase()));
        System.out.print("Base salary: "); worker.setBaseSalary(Double.valueOf(sc.nextLine()));
        
        System.out.println("==============================================");
        System.out.print("How many contracts to this worker: "); short contracts = sc.nextShort(); 
        sc.nextLine(); // cleaning the buffer
        HourContract contract;
        for (short i = 0, j = 1; i < contracts; i++, j++) {
            System.out.println("Enter contract #" + j + " data:");

            contract = new HourContract();
            System.out.print("Date (DD/MM/YYYY): "); contract.setDate(sdf.parse(sc.nextLine()));
            System.out.print("Value per hour: "); contract.setValuePerHour(Double.valueOf(sc.nextLine()));
            System.out.print("Duration (Hours): "); contract.setHours(sc.nextShort());
            sc.nextLine(); // cleaning the buffer
            worker.addContract(contract);
        }

        System.out.println("==============================================");
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String date = sc.nextLine();
        int month = Integer.parseInt(date.substring(0, 2));
        int year = Integer.parseInt(date.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment());
        System.out.println("Income for " + date + " : " + String.format("%.2f", worker.income(year, month)));
        System.out.println("==============================================");
    }
}
