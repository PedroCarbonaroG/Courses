package model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import db.DB;

import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC extends DB implements SellerDao {

    public SellerDaoJDBC() {
        conn = DB.getConnection();
    }

    @Override
    public boolean add(Seller seller) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean update(Seller seller) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Seller findById(Integer id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

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
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
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