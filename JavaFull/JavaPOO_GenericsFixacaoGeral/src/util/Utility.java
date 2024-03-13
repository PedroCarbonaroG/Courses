package util;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class Utility {


    public static <T> Set<T> findUniqueElements(List<T> list) {
        return new HashSet<>(list);
        /*Can be used like this:
            
            Set<T> setList = new HashSet<>();
            for(T t : list) {
                setList.add(t);
            }
            return setList;
        */
    }

    public static Map<String, Integer> countWords(String sequence) {
        Map<String, Integer> list = new TreeMap<>();
        String[] wordsList = sequence.split(" ");
        for (String s : wordsList) {
            list.put(s, list.containsKey(s) ? list.get(s) + 1 : 1);
        }
        return list;
    }

    public static <T> Map<T, Integer> countFrequency(List<T> source) {
        Map<T, Integer> list = new TreeMap<>();
        for (T content : source) {
            list.put(content, list.containsKey(content) ? list.get(content) + 1 : 1);
        }
        return list;
    }
}
