package entities;

public abstract class Product {

    private String name;
    private Double price;

    public Product() {
    }
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public final String toString() {
        return "Name: " + name + " -- " + "Price: " + String.format("%.2f", price);
    }

}
