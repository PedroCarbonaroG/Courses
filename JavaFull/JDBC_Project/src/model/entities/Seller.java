package model.entities;

import java.text.SimpleDateFormat;

import java.io.Serializable;

import java.util.Date;

public class Seller implements Serializable {
    
    private Integer id;
    private String name;
    private String email;
    private Date birthDate;
    private double baseSalary;

    private Department department;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Seller() {
    }
    public Seller(Integer id, String name, String email, Date birthDate, double baseSalary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
        this.department = new Department(department);
    }
    public Seller(Seller seller) {
        this.id = seller.id;
        this.name = seller.name;
        this.email = seller.email;
        this.birthDate = seller.birthDate;
        this.baseSalary = seller.baseSalary;
        this.department = seller.department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public Department getDepartment() {
        return department;
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

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public void setDepartment(Department department) {
        this.department = department;
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
        return "[ Name: " + name + 
                ", Email: " + email + 
                ", BirthDate: " + sdf.format(birthDate) + 
                ", BaseSalary: " + String.format("%.2f", baseSalary) + 
                ", Department: " + department +
                " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        Seller other = (Seller) obj;
        if (id == null) { if (other.id != null) { return false; } }
        else if (!id.equals(other.id)) { return false; }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
