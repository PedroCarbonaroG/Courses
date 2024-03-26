package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
    
    public boolean add(Department dp);
    public boolean update(Department dp);
    public boolean deleteById(Integer id);
    public Department findById(Integer id);
    public List<Department> findAll();
}
