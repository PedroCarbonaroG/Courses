package com.example;
import java.io.Serializable;

public class Pessoa implements Serializable {
    
    private Integer id;
    private String name;
    private String email;

    public Pessoa() {
    }
    public Pessoa(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Name: " + name + " Email: " + email;
    }
}
