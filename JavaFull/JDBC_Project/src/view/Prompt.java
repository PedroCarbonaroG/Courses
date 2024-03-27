package view;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

public class Prompt {
    
    public void startPrompt() {

        try {

            //Auxiliar attributes to tests
            List<Seller> list;
            SellerDao sellerDao;
            Seller seller;

            System.out.println("======================= TEST 1 - FIND BY ID =======================");
            sellerDao = DaoFactory.createSellerDao();
            seller = sellerDao.findById(3);
            System.out.println(seller);

            System.out.println("\n======================= TEST 2 - FIND BY DEPARTMENT =======================");
            list = sellerDao.findByDepartment(seller.getDepartment());
            list.forEach(x -> System.out.println(x));

            System.out.println("\n======================= TEST 3 - FIND BY DEPARTMENT ID =======================");
            list = sellerDao.findByDepartmentId(2);
            list.forEach(x -> System.out.println(x));

            System.out.println("\n======================= TEST 4 - FIND ALL =======================");
            list = sellerDao.findAll();
            list.forEach(x -> System.out.println(x));

            System.out.println("\n======================= TEST 5 - INSERT INTO SELLER =======================");
            seller = new Seller(null, "piter", "piter@gmail.com", new Date(), 5000, new Department(2, null));
            sellerDao.add(seller);
            System.out.println(sellerDao.findById(seller.getId()));

            System.out.println("\n======================= TEST 6 - UPDATE =======================");
            System.out.println(sellerDao.findById(5));
            seller = sellerDao.findById(5);
            seller.setName("Bob Smart");
            seller.setEmail("bobsmart@gmail.com");
            sellerDao.update(seller);
            System.out.println(sellerDao.findById(5));

            System.out.println("\n======================= TEST 7 - DELETE =======================");
            if (sellerDao.deleteById(7)) {
                System.out.println("Deleted!");
            }
        }

        catch (SQLException e) { throw new DbException(e.getMessage()); }
        
        finally {
            DB.closeResultSet();
            DB.closeStatement();
            DB.closePreparedStatement();
            DB.closeConnection();
        }
    }
}
