package view;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

public class Prompt {
    
    public void startPrompt() {

        try {

            //Auxiliar attributes to tests
            List<Seller> sellerList;
            SellerDao sellerDao = DaoFactory.createSellerDao();;
            Seller seller;

            List<Department> departmentList;
            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
            Department department;

            System.out.println("======================= TEST 1 - FIND SELLER BY ID =======================");
            seller = sellerDao.findById(3);
            System.out.println(seller);

            System.out.println("\n======================= TEST 2 - FIND SELLER BY DEPARTMENT =======================");
            sellerList = sellerDao.findByDepartment(seller.getDepartment());
            sellerList.forEach(x -> System.out.println(x));

            System.out.println("\n======================= TEST 3 - FIND SELLER BY DEPARTMENT ID =======================");
            sellerList = sellerDao.findByDepartmentId(2);
            sellerList.forEach(x -> System.out.println(x));

            System.out.println("\n======================= TEST 4 - FIND ALL SELLERS =======================");
            sellerList = sellerDao.findAll();
            sellerList.forEach(x -> System.out.println(x));

            System.out.println("\n======================= TEST 5 - INSERT INTO SELLER =======================");
            seller = new Seller(null, "piter", "piter@gmail.com", new Date(), 5000, new Department(2, null));
            sellerDao.add(seller);
            System.out.println(sellerDao.findById(seller.getId()));

            System.out.println("\n======================= TEST 6 - UPDATE SELLER =======================");
            System.out.println(sellerDao.findById(5));
            seller = sellerDao.findById(5);
            seller.setName("Bob Smart");
            seller.setEmail("bobsmart@gmail.com");
            sellerDao.update(seller);
            System.out.println(sellerDao.findById(5));

            System.out.println("\n======================= TEST 7 - DELETE SELLER =======================");
            if (sellerDao.deleteById(7)) {
                System.out.println("Deleted!");
            }

            System.out.println("\n======================= TEST 8 - FIND DEPARTMENT BY ID =======================");
            System.out.println(departmentDao.findById(1));

            System.out.println("\n======================= TEST 9 - FIND ALL DEPARTMENTS =======================");
            departmentList = departmentDao.findAll();
            departmentList.forEach(x -> System.out.println(x));

            System.out.println("\n======================= TEST 10 - ADD DEPARTMENT =======================");
            departmentDao.add(new Department(null, "Food"));
            System.out.println(departmentDao.findById(5));

            System.out.println("\n======================= TEST 11 - UPDATE DEPARTMENT =======================");
            department = departmentDao.findById(5);
            department.setName("Music");
            departmentDao.update(department);
            System.out.println(departmentDao.findById(5));

            System.out.println("\n======================= TEST 12 - DELETE DEPARTMENT =======================");
            if (departmentDao.deleteById(5)) {
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
