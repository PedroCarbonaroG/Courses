package entities;

public class Rectangle implements Shape {

    private double width;
    private double height;

    public Rectangle() {
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("%.2f", area());
    }
    
}
