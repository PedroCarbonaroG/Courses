package model.dao;

import java.sql.SQLException;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
    
    public boolean add(Department dp) throws SQLException;
    public boolean update(Department dp) throws SQLException;
    public boolean deleteById(Integer id) throws SQLException;
    public Department findById(Integer id) throws SQLException;
    public List<Department> findAll() throws SQLException;
}
