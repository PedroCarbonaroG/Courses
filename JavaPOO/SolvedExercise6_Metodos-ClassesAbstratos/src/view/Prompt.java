package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Prompt {
    
    private static Scanner sc = new Scanner(System.in, "UTF-8");
    private List<Shape> shapes = new ArrayList<>();

    public void startPrompt() {

        System.out.println("======================================================");
        System.out.print("Enter the number of shapes: "); short numOfShapes = sc.nextShort();

        for (short i = 0, j = 1; i < numOfShapes; i++, j++) {
            sc.nextLine(); // Cleaning the SCANNER buffer
            System.out.println("\nShape #" + j + " data:");
            System.out.print("Rectangle or Circle (r/c): "); char type = sc.nextLine().charAt(0);
            System.out.print("Color (Black/Blue/Red): "); String color = sc.nextLine().toUpperCase();

            if (type == 'r') {
                System.out.print("Width: "); double width = sc.nextDouble();
                System.out.print("Height: "); double height = sc.nextDouble();
                shapes.add(new Rectangle(Color.valueOf(color), width, height));

            } else if (type == 'c') {
                System.out.print("Radius: "); double radius = sc.nextDouble();
                shapes.add(new Circle(Color.valueOf(color), radius));

            }
        }

        System.out.println("\nSHAPES AREAS: ");
        for (Shape s : shapes) {
            System.out.println(String.format("%.2f", s.area()));
        }
    }
}