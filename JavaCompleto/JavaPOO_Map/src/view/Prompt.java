package view;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Prompt {
    
    private static final String FILE_PATH = "./resources/votes.csv";
    private File file = new File(FILE_PATH);
    private Scanner sc;

    private Map<String, Short> electionHashMap = new HashMap<>();
    private Map<String, Short> electionTreeMap = new TreeMap<>();
    private Map<String, Short> electionLinkedHashMap = new LinkedHashMap<>();

    public void startPrompt() {

        try {

            System.out.println("=============================================");
            sc = new Scanner(file);

            while(sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                String name = line[0];
                Short votes = Short.parseShort(line[1]);

                electionHashMap.put(name, electionHashMap.containsKey(name) ? (short)(electionHashMap.get(name) + votes) : votes);
                electionTreeMap.put(name, electionTreeMap.containsKey(name) ? (short)(electionTreeMap.get(name) + votes) : votes);
                electionLinkedHashMap.put(name, electionLinkedHashMap.containsKey(name) ? (short)(electionLinkedHashMap.get(name) + votes) : votes);
            }

            System.out.println("HashMap:");
            for (String key : electionHashMap.keySet()) {
                System.out.println(key + ": " + electionHashMap.get(key));
            }
            System.out.println();

            System.out.println("TreeMap:");
            for (String key : electionTreeMap.keySet()) {
                System.out.println(key + ": " + electionTreeMap.get(key));
            }
            System.out.println();

            System.out.println("LinkedHashMap:");
            for (String key : electionLinkedHashMap.keySet()) {
                System.out.println(key + ": " + electionLinkedHashMap.get(key));
            }
            System.out.println();

        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        finally { sc.close(); }
    }
}
