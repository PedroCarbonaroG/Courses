package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean update(Department department) throws SQLException {
        boolean updated = false;

        ps = conn.prepareStatement(
            "UPDATE department " +
            "SET Name = ? " +
            "WHERE id = ?"
        );

        ps.setString(1, department.getName());
        ps.setInt(2, department.getId());

        ps.executeUpdate();
        updated = true;

        return updated;
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        boolean deleted = false;

        ps = conn.prepareStatement(
            "DELETE FROM department " +
            "WHERE Id = ?"
        );

        ps.setInt(1, id);

        ps.executeUpdate();
        deleted = true;

        return deleted;
    }

    @Override
    public Department findById(Integer id) throws SQLException {
        
        ps = conn.prepareStatement(
            "SELECT * FROM department WHERE Id = ?"
        );

        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {

            Department dp = instantiateDepartment(rs);

            return dp;
        }

        return null;
    }

    @Override
    public List<Department> findAll() throws SQLException {
        
        List<Department> list = new ArrayList<>();
        Map<Integer, Department> map = new HashMap<>();

        ps = conn.prepareStatement(
            "SELECT * FROM department ORDER BY id"
        );

        rs = ps.executeQuery();

        while (rs.next()) {

            Department dp = map.get(rs.getInt("Id"));

            if (dp == null) {
                dp = instantiateDepartment(rs);
                map.put(rs.getInt("Id"), dp);
            }

            list.add(new Department(instantiateDepartment(rs)));
        }

        return list;
    }
    
    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dp = new Department();
        dp.setId(rs.getInt("Id"));
        dp.setName(rs.getString("Name"));
        return dp;
    }
}
