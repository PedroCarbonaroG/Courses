package service;

import java.lang.reflect.InaccessibleObjectException;
import java.util.List;

public class CalculationService {

    public static <T extends Comparable<T>> T max(List<T> list) {

        if (list.isEmpty()) {
            throw new InaccessibleObjectException("Empty List, try to add some items!");
        }

        T max = list.get(0);

        for (T m : list) {
            if (m.compareTo(max) > 0) {
                max = m;
            }
        }

        return max;
    }

}