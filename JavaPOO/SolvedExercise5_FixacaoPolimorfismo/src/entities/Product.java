package entities;

public class Product {
    
    protected String name;
    protected double price;

    public Product() {
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String priceTag() {
        return String.valueOf(
                              this.name
                              + " $ "
                              + String.format("%.2f", this.price)
                              );
    }
}
