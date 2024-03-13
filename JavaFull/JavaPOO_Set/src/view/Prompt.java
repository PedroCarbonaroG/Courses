package view;

import java.io.File;
import java.io.FileNotFoundException;

import java.time.Instant;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import entities.Client;

public class Prompt {

    private static final String FILE_PATH = "./resources/logs.txt";
    private File file = new File(FILE_PATH);
    private Scanner sc;

    private Set<Client> clientsHashSet = new HashSet<>(); 
    private Set<Client> clientsTreeSet = new TreeSet<>();
    private Set<Client> clientsLinkedHashSet = new LinkedHashSet<>();

    public void startPrompt() {

        try {
            System.out.println("===============================================");
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                clientsHashSet.add(new Client(line[0], Date.from(Instant.parse(line[1]))));
                clientsTreeSet.add(new Client(line[0], Date.from(Instant.parse(line[1]))));
                clientsLinkedHashSet.add(new Client(line[0], Date.from(Instant.parse(line[1]))));
            }

            System.out.println("Total users hashSet: " + clientsHashSet.size());
            System.out.println("Total users treeSet: " + clientsTreeSet.size());
            System.out.println("Total users linkedHashSet: " + clientsLinkedHashSet.size());

            System.out.println("Contented confirmation(HashSet): " + clientsHashSet.toString());
            System.out.println("Contented confirmation(TreeSet): " + clientsTreeSet.toString());
            System.out.println("Contented confirmation(LinkedHashSet): " + clientsLinkedHashSet.toString());

            System.out.println();
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        finally { if (sc != null) sc.close(); }

    }
}
