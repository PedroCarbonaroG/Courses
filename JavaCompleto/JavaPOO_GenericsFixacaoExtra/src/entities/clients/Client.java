package entities.clients;

import entities.products.Product;

public abstract class Client implements Comparable<Client> {
    
    private int id;
    private String name;
    private String email;
    private static int nextId = 1;

    public Client() {
    }
    public Client(String name, String email) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String email) {
        this.email = email;
    }

    @Override
    public final String toString() {
        return name + " " + email;
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
    public final int compareTo(Client c) {
        // TODO Auto-generated method stub
        return 0;
    }
}
