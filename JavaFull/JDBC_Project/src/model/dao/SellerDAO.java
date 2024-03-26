package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
    
    public boolean add(Seller seller);
    public boolean update(Seller seller);
    public boolean deleteById(Integer id);
    public Seller findById(Integer id);
    public List<Seller> findAll();
}
