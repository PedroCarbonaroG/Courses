package model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import db.DB;

import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC extends DB implements DepartmentDao {

    @Override
    public boolean add(Department department) throws SQLException {
        boolean added = false;

        ps = conn.prepareStatement(
            "INSERT INTO department " +
            "(Id, Name) " +
            "VALUES " +
            "(?, ?)"
        );

        department.setId(getDepartmentLastId());
        ps.setInt(1, getDepartmentLastId());
        ps.setString(2, department.getName());

        ps.executeUpdate();
        added = true;

        return added;
    }

    @Override
    public boolean update(Department dp) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Department findById(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Department> findAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
