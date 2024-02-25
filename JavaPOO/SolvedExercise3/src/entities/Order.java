package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
    
    private Date moment;
    private OrderStatus status;

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

        return 0.0;
    }
}