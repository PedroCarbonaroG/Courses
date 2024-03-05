package view;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;
import service.CalculationService;

public class Prompt {
 
    private File file = new File("./resources/Products.csv");
    private List<Product> products = new ArrayList<>();
    private Scanner sc;

    public Prompt() {
        try { this.sc = new Scanner(file); } 
        catch (FileNotFoundException e) { System.out.println(e.getMessage()); }
    }

    public void startPrompt() {

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            products.add(new Product(line[0], Double.parseDouble(line[1])));
        }

        System.out.println("Most expensive: ");
        System.out.println(CalculationService.max(products));
    }
}
