//package
package view;

//Dependencys
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import entities.ClothProduct;
import entities.EletronicProduct;
import entities.FoodProduct;
import entities.Product;

import util.ProductsUtil;

/*
 * 
 * Covered topics:
 *      Generics
 *      Set structure
 *      Map structure
 *      List structure
 * 
 *      Lambda functions or arrow functions
 *      Predicate functions as parameters
 *      Consumer functions as parameters
 *      Function functions as parameters
 * 
 *      Streams -> Collections
*/
public class Prompt {

    //Structures
    List<Product> products = new ArrayList<>(); // 'new LinkedList<>()' too
    Set<Product> setProducts = new LinkedHashSet<>(); // 'new HashSet<>()' and 'new TreeSet<>()' too
    Map<Product, ?> mapProducts = new LinkedHashMap<>(); // 'new HashMap<>()' and 'new TreeMap<>()' too

    public void startPrompt() {
        
        products.add(new FoodProduct("Maça", 10));
        products.add(new FoodProduct("Pera", 8));
        products.add(new FoodProduct("Uva", 5));

        products.add(new EletronicProduct("Tv", 1000));
        products.add(new EletronicProduct("Notebook", 2000));
        products.add(new EletronicProduct("Celular", 1500));

        products.add(new ClothProduct("Vans", 500));
        products.add(new ClothProduct("Huggo Boss", 10000));
        products.add(new ClothProduct("C&A", 50));

        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("All products:");
        System.out.println("(Using wildCards generics):");
        ProductsUtil.print(products);
        System.out.println();
        System.out.println("List total price: " + ProductsUtil.totalPrice(products) + "\n");
        
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("Food products:");
        System.out.println("(Using wildCards generics):");
        ProductsUtil.print(products, FoodProduct.class);
        System.out.println();
        System.out.println("Foods total price: " + ProductsUtil.totalPrice(products, FoodProduct.class) + "\n");

        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("Eletronic products:");
        System.out.println("(Using wildCards generics):");
        ProductsUtil.print(products, EletronicProduct.class);
        System.out.println();
        System.out.println("Eletronics total price: " + ProductsUtil.totalPrice(products, EletronicProduct.class) + "\n");

        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("Cloth products:");
        System.out.println("(Using wildCards generics):");
        ProductsUtil.print(products, ClothProduct.class);
        System.out.println();
        System.out.println("Cloths total price: " + ProductsUtil.totalPrice(products, ClothProduct.class) + "\n");

        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("All products after sort by name:");
        System.out.println("(Using lambda expression):");
        products.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
        ProductsUtil.print(products);
        System.out.println();

        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("All products after sort by price:");
        System.out.println("(Using lambda expression):");
        products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));
        ProductsUtil.print(products);
        System.out.println();

        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("All products after those priced at less than 100 have been removed:");
        System.out.println("(Using Predicate as argument in functions):");
        products.removeIf(p1 -> p1.getPrice() < 100);
        ProductsUtil.print(products);
        System.out.println();

        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("All products that price < 100:");
        System.out.println("(Using Consumer as argument in functions for print all products): ");
        products.forEach(System.out::println);
        // products.forEach(p1 -> System.out.println(p1)); can be used too
        System.out.println();

        System.out.println("------------------------------------------------------------------------------------------");
        
        System.out.println("All products names that price < 100:");
        System.out.println("(Using Function and map from stream->Collections to filter it):");
        List<String> names = products.stream().map(p -> p.getName()).collect(Collectors.toList());
        names.forEach(n -> System.out.println(n));
        // names.forEach(System.out::println); can be used too
        System.out.println();

        System.out.println("------------------------------------------------------------------------------------------");
    }
}