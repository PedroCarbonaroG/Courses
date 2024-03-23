//Dependencys
package view;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.sql.SQLException;

import entities.Department;
import entities.Seller;

import DB.DbException;
import DB.DB;

public class Prompt {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public void startPrompt() {

        try {
            System.out.println("===========================================================");
            System.out.println("Showing of departments and sellers from dataBase MySQL:");
            System.out.println();

            DB.getConnection();
            
            System.out.println("Departments:");
            System.out.println(Department.getRows());

            System.out.println("Sellers:");
            System.out.println(Seller.getRows());

            System.out.println("Inserting data into seller and department fields in dataBase MySQL:");

            Seller.add("Piter", "piter@gmail.com", sdf.parse("2002/04/06"), 3000, 1);
            Department.add("Food");

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

            System.out.println("Updating...");
            Seller.updateName("piter", "newPiter");
            Seller.updateEmail("piter@gmail.com", "newPiter@gmail.com");
            Seller.updateBirthDate(sdf.parse("2002/04/06"), sdf.parse("2002/04/08"));
            Seller.updateBaseSalary(1.1);
            Seller.updateDepartmentId(7, 2);

            Department.updateName("Food", "newFood");

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

            Seller.deleteByName("newPiter");
            Department.deleteByName("newFood");

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
        }
    }
}