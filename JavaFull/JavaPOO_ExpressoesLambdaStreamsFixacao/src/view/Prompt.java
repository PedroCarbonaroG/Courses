package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Prompt {
    
    private static final String FILE_PATH = "./resources/Employees.csv";
    private File file;
    private Scanner userSc;
    private Scanner fileSc;

    private List<Employee> list;

    public Prompt() {
        try {
            this.file = new File(FILE_PATH);
            this.fileSc = new Scanner(file);

            this.userSc = new Scanner(System.in, "UTF-8");
            this.list = new ArrayList<>();
        } 
        catch (FileNotFoundException e) { System.out.println("Opening file error: " + e.getMessage()); }
    }

    public void startPrompt() {

        while (fileSc.hasNextLine()) {
            String[] line = fileSc.nextLine().split(",");
            list.add(new Employee(line[0], line[1], Double.parseDouble(line[2])));
        }

        System.out.println("============================================");
        System.out.print("Enter salary: "); double criteria = userSc.nextDouble();

        System.out.println("Email of people whose salary is more than R$" + String.format("%.2f", criteria) + ":");
        //Getting list of emails using lambda expressions
        new ArrayList<String>(list
                                    .stream()
                                    .filter(p -> p.getSalary() > criteria)
                                    .map(p -> p.getEmail())
                                    .sorted((e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase()))
                                    .collect(Collectors.toList())
                                    )
                                    .forEach(System.out::println)
        ;

        //Getting the summary calculation of all salaries that satisfy the condition
        double sumSalary = list
                            .stream()
                            .filter(p -> p.getName().charAt(0) == 'M')
                            .map(p -> p.getSalary())
                            .reduce(0.0, (x, y) -> x + y)
        ;
        System.out.print("Sum of salary of people whose name starts with 'M': " + sumSalary);

        if (userSc != null && fileSc != null) {
            userSc.close();
            fileSc.close();
        }
    }
}
