package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    // Optional... Can instantiate directly on 'new Scanner' and 'new FileWriter' statments
    // like 'new Scanner(new File("./resources/products.csv"))'
    // and 'new FileWriter(new File("./resources/summary.csv"))'
    private static final File SOURCE_FILE_PATH = new File("./resources/products.csv");
    private static final File TARGET_FILE_PATH = new File("./resources/summary.csv");

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        // Reader and Writer
        Scanner sc = null;
        FileWriter fw = null;

        //List of objects
        List<Product> products = new ArrayList<>();

        try {
            sc = new Scanner(SOURCE_FILE_PATH);

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                products.add(new Product(line[0],Double.parseDouble(line[1]), Short.parseShort(line[2])));
            }

            fw = new FileWriter(TARGET_FILE_PATH);

            for (Product p : products) {
                fw.append(p.toString() + "\n");
            }

        }
        catch (FileNotFoundException e) { System.out.println("File Path not Found: " + e.getMessage()); }
        catch (IOException e) { System.out.println("File Path not Found: " + e.getMessage()); }
        finally  {
            if (sc != null) { sc.close(); }
            
            try { if (fw != null) { fw.close(); } }
            catch (IOException e) { System.out.println("Failed to close FileWriter: " + e.getMessage()); }
        }
    }
}