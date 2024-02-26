package entities;

import entities.enums.Color;

public class Rectangle extends Shape {
    
    private double width;
    private double height;

    public Rectangle() {
        super();
    }
    public Rectangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }
}
