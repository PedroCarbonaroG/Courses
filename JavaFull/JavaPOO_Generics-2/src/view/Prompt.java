package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import util.Utility;

public class Prompt {

    /*

    ** First Exercise.: Implement a class called UniqueElements that
    takes a list of elements of any type and returns a HashSet
    containing only the unique elements. Use Generics to make the
    flexible class for different data types.

    ** Second Exercise.: Create a class called SortedUniqueWords that 
    takes a phrase as input and returns an alphabetically ordered 
    TreeMap, where the words are the keys and the number of 
    occurrences of each word is the associated value. Use 
    LinkedHashSet to maintain the order of insertion of words in the
    sentence.

    ** Third Exercise.: Create a method called FrequencyCounter that 
    takes a list of integers and returns a LinkedHashMap where the 
    keys are the unique numbers in the list and the values ​​are their 
    frequencies. Use TreeSet to ensure that the keys in the map 
    are in ascending order.

    */

    //EX01
    private List<Integer> integersList01 = new ArrayList<>();
    private List<String> stringList01 = new ArrayList<>();
    private List<Double> doubleList01 = new ArrayList<>();

    //EX03
    private List<Integer> integersList03 = new ArrayList<>();
    private List<String> stringList03 = new ArrayList<>();
    private List<Double> doubleList03 = new ArrayList<>();

    public void startPrompt() {

        System.out.println("===========================================================");

        //EX01
        System.out.println("Results of Exercise 1: ");
        integersList01.addAll(Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3));
        stringList01.addAll(Arrays.asList("Piter", "Jonas" , "Lisa", "Lisa", "Fred", "Piter", "Jonas"));
        doubleList01.addAll(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 1.0, 2.0, 3.0));

        System.out.println(new HashSet<>(Utility.findUniqueElements(integersList01)));
        System.out.println(new HashSet<>(Utility.findUniqueElements(stringList01)));
        System.out.println(new HashSet<>(Utility.findUniqueElements(doubleList01)));
        System.out.println();
        //Can be used like this too
        // System.out.println(new HashSet<>(integersList01));

        //EX02
        System.out.println("Results of Exercise 2: ");
        System.out.println(new TreeMap<>(Utility.countWords("java programming is java fun is programming")));
        System.out.println(new TreeMap<>(Utility.countWords("yesterday i remebered that yesterday was good as cream that i enjoyed")));
        System.out.println(new TreeMap<>(Utility.countWords("for all days i need all days a good thing to think for")));
        System.out.println();

        //EX03
        System.out.println("Results of Exercise 3: ");
        integersList03.addAll(Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3));
        stringList03.addAll(Arrays.asList("Piter", "Jonas" , "Lisa", "Lisa", "Fred", "Piter", "Jonas"));
        doubleList03.addAll(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 1.0, 2.0, 3.0));

        System.out.println(new LinkedHashMap<>(Utility.countFrequency(integersList03)));
        System.out.println(new LinkedHashMap<>(Utility.countFrequency(stringList03)));
        System.out.println(new LinkedHashMap<>(Utility.countFrequency(doubleList03)));
        System.out.println();
    }
}
