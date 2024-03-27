package view;

import java.sql.SQLException;

import java.util.List;

import db.DB;
import db.DbException;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Seller;

public class Prompt {
    
    public void startPrompt() {

        try {

            List<Seller> list;

            System.out.println("======================= TEST 1 - FIND BY ID =======================");
            SellerDao sellerDao = DaoFactory.createSellerDao();
            Seller seller = sellerDao.findById(3);
            System.out.println(seller);

            System.out.println("\n======================= TEST 2 - FIND BY DEPARTMENT =======================");
            list = sellerDao.findByDepartment(seller.getDepartment());
            for (Seller s : list) {
                System.out.println(s);
            }

            System.out.println("\n======================= TEST 3 - FIND BY DEPARTMENT ID =======================");
            list = sellerDao.findByDepartmentId(2);
            for (Seller s : list) {
                System.out.println(s);
            }

            System.out.println("\n======================= TEST 4 - FIND ALL =======================");
            list = sellerDao.findAll();
            for (Seller s : list) {
                System.out.println(s);
            }

            System.out.println("\n======================= TEST 5 - ??? =======================");
        }

        catch (SQLException e) { throw new DbException(e.getMessage()); }
        
        finally {
            DB.closeResultSet();
            DB.closePreparedStatement();
            DB.closeConnection();
        }
    }
}
