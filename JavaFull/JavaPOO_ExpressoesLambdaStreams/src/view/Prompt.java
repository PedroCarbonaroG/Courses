package view;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Prompt {

    private static final String FILE_PATH = "./resources/products.csv";
    private Scanner sc;
    private File file;

    private List<Product> list = new ArrayList<>();

    public Prompt() {
        try {
            this.file = new File(FILE_PATH);
            this.sc = new Scanner(file);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void startPrompt() {

        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            list.add(new Product(line[0], Double.parseDouble(line[1])));
        }

        double avaragePrice = list.stream()
            .map(p -> p.getPrice())
            .reduce(0.0,(x, y) -> x + y) / list.size();

        System.out.println("Avarage price : " + String.format("%.2f", avaragePrice));

        Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
        List<String> names = list.stream()
            .filter(p -> p.getPrice() < avaragePrice)
            .map(p -> p.getName())
            .sorted(comp.reversed())
            .collect(Collectors.toList());
        names.forEach(System.out::println);

    }
}