package entities;

import entities.enums.Color;

public class Circle extends Shape {
    
    private double radius;

    public Circle() {
        super();
    }
    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
        // return 3.14 * (radius * radius); //CAN BE USED TOO
    }
}
