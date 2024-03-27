package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;

import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC extends DB implements SellerDao {

    public SellerDaoJDBC() {
        conn = DB.getConnection();
        auxConn = DB.getConnection();
    }

    @Override
    public boolean add(Seller seller) throws SQLException {
        boolean added = false;

        ps = conn.prepareStatement(
            "INSERT INTO seller " +
            "(Id, Name, Email, BirthDate, BaseSalary, DepartmentId) " +
            "VALUES " +
            "(?, ?, ?, ?, ?, ?)"
        );

        seller.setId(getSellerLastId());
        ps.setInt(1, getSellerLastId());
        ps.setString(2, seller.getName());
        ps.setString(3, seller.getEmail());
        ps.setDate(4, new java.sql.Date(seller.getBirthDate().getTime()));
        ps.setDouble(5, seller.getBaseSalary());
        ps.setInt(6, seller.getDepartment().getId());

        ps.executeUpdate();
        added = true;

        return added;
    }

    @Override
    public boolean update(Seller seller) throws SQLException {
        boolean updated = false;

        //...

        return updated;
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        boolean deleted = false;

        //...

        return deleted;
    }

    @Override
    public Seller findById(Integer id) throws SQLException {

        ps = conn.prepareStatement(
            "SELECT seller.*, department.Name as DpName " +
            "FROM seller INNER JOIN department " +
            "ON seller.DepartmentId = department.Id " +
            "WHERE seller.Id = ?"
        );

        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {

            Department dp = instantiateDepartment(rs);
            Seller seller = instantiateSeller(rs, dp);

            return seller;
        }

        return null;
    }

    @Override
    public List<Seller> findAll() throws SQLException {
        List<Seller> list = new ArrayList<>();
        Map<Integer, Department> map = new HashMap<>();

        ps = conn.prepareStatement(
            "SELECT seller.*, Department.Name as DpName " +
            "FROM seller INNER JOIN department " +
            "ON seller.DepartmentId = department.Id " +
            "ORDER BY name"
        );

        rs = ps.executeQuery();

        while (rs.next()) {

            Department dp = map.get(rs.getInt("DepartmentId"));

            if (dp == null) {
                dp = instantiateDepartment(rs);
                map.put(rs.getInt("DepartmentId"), dp);
            }

            list.add(new Seller(instantiateSeller(rs, dp)));
        }

        return list;
    }

    @Override
    public List<Seller> findByDepartment(Department department) throws SQLException {

        if (department.getName() == null || department.getId() == null) {
            throw new DbException("Trying to findByDepartment, Name or Id are null");
        }

        List<Seller> list = new ArrayList<>();

        ps = conn.prepareStatement(
            "SELECT seller.*, Department.Name as DpName " +
            "FROM seller INNER JOIN department " +
            "ON seller.DepartmentId = department.Id " +
            "WHERE DepartmentId = ? " +
            "ORDER BY name"
        );

        ps.setInt(1, department.getId());
        rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Seller(instantiateSeller(rs, department)));
        }

        return list;
    }
    @Override
    public List<Seller> findByDepartmentId(Integer departmentId) throws SQLException {

        if (departmentId == null) {
            throw new DbException("Trying to findByDepartmentId, Id are null");
        }
        
        List<Seller> list = new ArrayList<>();
        Map<Integer, Department> map = new HashMap<>();

        ps = conn.prepareStatement(
            "SELECT seller.*, Department.Name as DpName " +
            "FROM seller INNER JOIN department " +
            "ON seller.DepartmentId = department.Id " +
            "WHERE DepartmentId = ? " +
            "ORDER BY name"
        );

        ps.setInt(1, departmentId);
        rs = ps.executeQuery();

        while (rs.next()) {

            Department dp = map.get(rs.getInt("DepartmentId"));

            if (dp == null) {
                dp = instantiateDepartment(rs);
                map.put(rs.getInt("DepartmentId"), dp);
            }

            list.add(new Seller(instantiateSeller(rs, dp)));
        }

        return list;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dp = new Department();
        dp.setId(rs.getInt("DepartmentId"));
        dp.setName(rs.getString("DpName"));
        return dp;
    }
    private Seller instantiateSeller(ResultSet rs, Department dp) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getInt("Id"));
        seller.setName(rs.getString("Name"));
        seller.setEmail(rs.getString("Email"));
        seller.setBirthDate(rs.getDate("BirthDate"));
        seller.setBaseSalary(rs.getDouble("BaseSalary"));
        seller.setDepartment(dp);

        return seller;
    }
}