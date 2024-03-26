package model.dao;

import java.sql.SQLException;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

    public boolean add(Seller seller) throws SQLException;
    public boolean update(Seller seller) throws SQLException;
    public boolean deleteById(Integer id) throws SQLException;
    public Seller findById(Integer id) throws SQLException;
    public List<Seller> findAll() throws SQLException;
    public List<Seller> findByDepartment(Department dp) throws SQLException;
    public List<Seller> findByDepartmentId(Integer departmentId) throws SQLException;
}
