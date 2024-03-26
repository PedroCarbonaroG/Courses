package view;

import java.sql.SQLException;

import db.DB;
import db.DbException;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Seller;

public class Prompt {
    
    public void startPrompt() {

        try {

            System.out.println("======================= TEST 1 - FIND BY ID =======================");
            SellerDao sellerDao = DaoFactory.createSellerDao();
            Seller seller = sellerDao.findById(3);
            System.out.println(seller);

            System.out.println("\n======================= TEST 2 - FIND BY ID =======================");
        }
        catch (SQLException e) { throw new DbException(e.getMessage()); }
        
        finally {
            DB.closeResultSet();
            DB.closePreparedStatement();
            DB.closeConnection();
        }
    }
}
