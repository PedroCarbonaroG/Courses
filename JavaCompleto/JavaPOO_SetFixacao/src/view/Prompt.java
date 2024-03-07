package view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prompt {
    
    private Scanner sc = new Scanner(System.in, "UTF-8");

    private Set<Short> totalStudents = new HashSet<>();

    public void startPrompt() {

        System.out.println("==========================================");

        System.out.print("How many courses: ");
        short courses = sc.nextShort();
        short students = 0;
        for (short i = 0, j = 1; i < courses; i++, j++) {
            System.out.print("How many students for Course #" + j + ": ");
            students = sc.nextShort();
            for (short k = 0; k < students; k++) {
                totalStudents.add(sc.nextShort());
            }
        }

        System.out.println("Total Students: " + totalStudents.size());

    }
}
