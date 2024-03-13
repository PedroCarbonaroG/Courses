package service;

import java.util.List;

import entities.Shape;

public abstract class UtilityService {
    
    public static double totalArea(List<? extends Object> list) {
        double sum = 0;
        for(Object s : list) {
            sum += ((Shape) s).area();
        }
        return sum;
    }

    public static void copy(List<? extends Shape> source, List<? super Shape> target) {
        for (Shape s : source) { target.add(s); }
    }
}
