package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Prompt {

    private static final Scanner sc = new Scanner(System.in, "UTF-8");
    private List<Product> products = new ArrayList<>();

    public void startPrompt() throws ParseException {
        System.out.println("=================================================");
        System.out.print("Enter the number of products: "); short n = sc.nextShort();
    
        for (short i = 0, j = 1; i < n; i++, j++) {
            sc.nextLine(); //Cleaning the SCANNER buffer
            System.out.println("Product #" + j + " data:");
            System.out.print("Common, used or imported (c/u/i): "); char answer = sc.nextLine().charAt(0);

            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Price: "); double price = sc.nextDouble();

            if (answer == 'i') {
                System.out.print("Customs fee: "); double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));

            } else if (answer == 'u') {
                sc.nextLine(); //Cleaning the SCANNER buffer
                System.out.print("Manufacture date (DD/MM/YYYY): "); String date = sc.nextLine();
                products.add(new UsedProduct(name, price, new SimpleDateFormat("dd/MM/yyyy").parse(date)));
            } else {
                products.add(new Product(name, price));
            }
            
        }

        System.out.println();
        System.out.println("Price Tags: ");
        for (Product p : products) {
            System.out.println(p.priceTag());
        }
    }
}
