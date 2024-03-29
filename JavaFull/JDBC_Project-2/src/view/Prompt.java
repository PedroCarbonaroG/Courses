//Dependencys
package view;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.sql.SQLException;
import java.sql.Connection;

import entities.Department;
import entities.Seller;

import DB.DbException;
import DB.DB;

public class Prompt {

    private static Connection conn;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public void startPrompt() {

        try {
            conn = DB.getConnection();

            System.out.println("===========================================================");
            System.out.println("Showing of departments and sellers from dataBase MySQL:");
            System.out.println();
            
            System.out.println("Departments:");
            System.out.println(Department.getRows());

            System.out.println("Sellers:");
            System.out.println(Seller.getRows());

            System.out.println("Inserting data into seller and department fields in dataBase MySQL:");

            conn.setAutoCommit(false);

            Seller.add("Piter", "piter@gmail.com", sdf.parse("2002/04/06"), 3000, 1);
            Department.add("Food");

            conn.commit();

            System.out.println("After the insertions, fields in dataBase MySQL:");
            System.out.println(Department.getRows());
            System.out.println(Seller.getRows());

            System.out.println("===========================================================");
            System.out.println("Updating rows from Sellers and Departments");

            System.out.println("Before the updating:");

            System.out.println("Departments:");
            System.out.println(Department.getRows());

            System.out.println("Sellers:");
            System.out.println(Seller.getRows());

            conn.setAutoCommit(false);

            System.out.println("Updating...");
            Seller.updateName("piter", "newPiter");
            Seller.updateEmail("piter@gmail.com", "newPiter@gmail.com");
            Seller.updateBirthDate(sdf.parse("2002/04/06"), sdf.parse("2002/04/08"));
            Seller.updateBaseSalary(1.1);
            Seller.updateDepartmentId(7, 2);

            Department.updateName("Food", "newFood");

            conn.commit();

            System.out.println("After the updating:");

            System.out.println("Departments:");
            System.out.println(Department.getRows());

            System.out.println("Sellers:");
            System.out.println(Seller.getRows());

            System.out.println("===========================================================");
            System.out.println("Finnaly, deleting the chosen rows");

            System.out.println("Before the deleting:");

            System.out.println("Departments:");
            System.out.println(Department.getRows());

            System.out.println("Sellers:");
            System.out.println(Seller.getRows());

            System.out.println("Deleting...");

            conn.setAutoCommit(false);

            Seller.deleteByName("newPiter");
            Department.deleteByName("newFood");

            conn.commit();

            System.out.println("After the deleting:");

            System.out.println("Departments:");
            System.out.println(Department.getRows());

            System.out.println("Sellers:");
            System.out.println(Seller.getRows());
        }
        catch (SQLException e) {
            try { DB.getRollBack(); throw new DbException("Transaction rolled back! Caused by: " + e.getMessage()); } 
            catch (SQLException e1) { throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage()); }
        }
        catch(ParseException e) { e.printStackTrace(); }

        finally {
            DB.closePreparedStatement();
            DB.closeStatement();
            DB.closeResultSet();
            DB.closeConnection();
            try { conn.close(); }
            catch (SQLException e) { throw new DbException("PromptConnector failed! Caused by: " + e.getMessage()); }
        }
    }
}