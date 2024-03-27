package model.dao;

import java.sql.SQLException;

import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public abstract class DaoFactory {

    public static SellerDao createSellerDao() throws SQLException {
        return new SellerDaoJDBC();
    }

    public static DepartmentDao createDepartmentDao() throws SQLException {
        return new DepartmentDaoJDBC();
    }
}
