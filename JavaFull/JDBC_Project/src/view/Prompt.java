//Dependencys
package view;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.sql.SQLException;

import entities.Department;
import entities.Seller;

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

            System.out.println("===========================================================");
            System.out.println("Inserting data into seller and department fields in dataBase MySQL:");

            Seller.add("Piter", "piter@gmail.com", sdf.parse("2002/04/06"), 3000, 1);
            Department.add("Food");

            System.out.println("After the insertions, fields in dataBase MySQL:");
            System.out.println(Department.getRows());
            System.out.println(Seller.getRows());

            System.out.println("===========================================================");

        }
        catch(SQLException e) { e.printStackTrace(); }
        catch(ParseException e) { e.printStackTrace(); }

        finally {
            DB.closePreparedStatement();
            DB.closeStatement();
            DB.closeResultSet();
            DB.closeConnection();
        }
    }
}