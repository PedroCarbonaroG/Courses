package service;

import java.util.List;

import entities.Shape;

public class UtilityService {
    
    public static double totalArea(List<? extends Shape> list) {
        double sum = 0;
        for(Shape s : list) {
            sum += s.area();
        }
        return sum;
    }

    public static void copy(List<? extends Shape> source, List<? extends Object> target) {
        
    }
}
