package entities.products;

public abstract class Product implements Comparable<Product> {
    
    private int id;
    private String name;
    private double price;
    private static int nextId = 1;

    public Product() {
    }
    public Product(String name, double price) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
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

    @Override
    public final String toString() {
        return name + " " + String.format("%.2f", price);
    }

    @Override
    public final int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public final int compareTo(Product p) {
        // TODO Auto-generated method stub
        return 0;
    }
}
