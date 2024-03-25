package entities;

public class Product {
    
    private String name;
    private double price;
    private short quantity;

    public Product() {
    }
    public Product(String name, double price, short quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public short getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    private double finalPrice() {
        return price * quantity;
    }

    @Override
    public final String toString() {
        return name + "," + String.format("%.2f", finalPrice());
    }

}
