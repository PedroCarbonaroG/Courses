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
            //Test
            SellerDao sellerDao = DaoFactory.createSellerDao();
            Seller seller = sellerDao.findById(3);
            System.out.println(seller);
        }
        catch (SQLException e) { throw new DbException(e.getMessage()); }
        
        finally {
            DB.closeConnection();
        }
    }
}
