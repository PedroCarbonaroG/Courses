package entities;

public class OrderItem {

    private short quantity;
    private double price;

    private Product product = new Product();

    public OrderItem() {
    }
    public OrderItem(short quantity, double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public short getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public Product getProduct() {
        return product;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public double subTotal() {
        return product.getPrice() * quantity;
    }
}
