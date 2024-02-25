package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
    
    private Date moment;
    private OrderStatus status;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
    private List<OrderItem> items = new ArrayList<>();
    private Client client = new Client();

    public Order() {
    }
    public Order(Date moment, OrderStatus status, List<OrderItem> items, Client client) {
        this.moment = moment;
        this.status = status;
        this.items = items;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public Client getClient() {
        return client;
    }
    public List<OrderItem> getItems() {
        return items;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double total() {
        double sum = 0;
        for (OrderItem oi : items) {
            sum += oi.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: " + sdf2.format(new Date()));
        sb.append("\nOrder status: " + status);
        sb.append("\nClient: " + client.getName() + " (" + sdf.format(client.getBirthDate()) + ") - " + client.getEmail());
        sb.append("\nOrder items: ");
        for (OrderItem oi : items) {
            sb.append("\n" + oi.getProduct().getName() + ", ");
            sb.append("$" + oi.getProduct().getPrice() + ", ");
            sb.append("Quantity: " + oi.getQuantity() + ", ");
            sb.append("Subtotal: $" + oi.subTotal());
        }
        sb.append("\nTotal price: $" + total());

        return sb.toString();
    }
}