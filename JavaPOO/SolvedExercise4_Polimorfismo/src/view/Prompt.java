package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public final class Prompt {

    private static final Scanner sc = new Scanner(System.in, "UTF-8");
    private List<Employee> employees = new ArrayList<>();

    public void startPrompt() {
        System.out.println("=============================================================");
        System.out.print("Enter the number of employees: "); short n = sc.nextShort();
        
        for (short i = 0, j = 1; i < n; i++, j++) {
            System.out.println("Employee #" + j + " data:");
            System.out.print("Outsourced (y/n): "); char answer = sc.next().charAt(0); 
            sc.nextLine(); //Cleaning the SCANNER buffer

            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Hours: "); short hours = sc.nextShort();
            sc.nextLine(); //Cleaning the SCANNER buffer
            System.out.print("Value per hour: "); double valuePerHour = sc.nextDouble();
            sc.nextLine(); //Cleaning the SCANNER buffer
            
            if (answer == 'y') {
                System.out.print("Additional charge: "); double additionalCharge = sc.nextDouble();
                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));

            } else if (answer == 'n') {
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        for (Employee e : employees) {
            System.out.println(e.getName() + " - $ " + e.payment());
        }

        sc.close();
    }
}