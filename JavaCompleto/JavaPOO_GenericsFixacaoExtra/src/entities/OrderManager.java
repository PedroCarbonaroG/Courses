package entities;

import java.util.LinkedHashMap;
import java.util.Map;

import entities.clients.Client;
import entities.products.Product;

/*
 * Not done yet, needs to think abount many to many products by one client
*/
public class OrderManager {

    private static Map<Client, Product> list = new LinkedHashMap<>();

    public OrderManager() {
    }

    public void addClient(Client client) {
        list.put(client, null);
    }
    public void addProduct(Client client, Product product) {
        list.put(client, product);
    }

    public void removeClient(Client client) {
        list.remove(client);
    }
    public void removeProduct(Client client, Product product) {
        list.remove(client, product);
    }

}
