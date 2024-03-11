package util;

import java.util.List;

import entities.Product;

public abstract class ProductsUtil {

    public static double totalPrice(List<? extends Product> list) {
        double sum = 0;
        for (Product t : list) {
            sum += t.getPrice();
        }
        return sum;
    }
    public static double totalPrice(List<? extends Product> list, Class<? extends Product> classCriteria) {
        double sum = 0;
        for (Product t : list) {
            if (classCriteria.isInstance(t)) {
                sum += t.getPrice();
            }
        }
        return sum;
    }

    public static void print(List<? extends Product> list) {
        for (Product t : list) {
            System.out.println(t);
        }
    }
    public static void print(List<? extends Product> list, Class<? extends Product> classCriteria) {
        for (Product t : list) {
            if (classCriteria.isInstance(t)) {
                System.out.println(t);
            }
        }
    }
}
