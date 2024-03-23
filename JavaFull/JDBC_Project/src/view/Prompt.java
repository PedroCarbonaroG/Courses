package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import DB.DB;

public class Prompt {
    
    public void startPrompt() {
        
        /*
         * First part attributes
         * (Recovery data)
        */
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        /*
         * Second part attributes
         * (Inserting data)
        */
        PreparedStatement ps = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        try {

            System.out.println("===========================================================");
            System.out.println("Showing of departments and sellers from dataBase MySQL: ");
            System.out.println();

            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("Select * from department");
            
            System.out.println("Departments:");
            while (rs.next()) { System.out.println(rs.getInt("Id") + ", " + rs.getString("Name")); }
            System.out.println();

            rs = st.executeQuery("Select * from seller");
            System.out.println("Sellers:");
            while (rs.next()) { 
                System.out.println(
                    rs.getInt("Id") + ", " + 
                    rs.getString("Name") + ", " +
                    rs.getString("Email") + ", " +
                    rs.getDate("BirthDate") + ", " +
                    rs.getDouble("BaseSalary") + ", " +
                    rs.getInt("DepartmentId")
                    ); 
            }
            System.out.println();

            System.out.println("===========================================================");
            System.out.println("Inserting data into seller field in dataBase MySQL: ");

            int lastId = 0;
            int newId = 0;
            String getLastIdQuery = "SELECT MAX(Id) AS LastId FROM seller";
            Statement getLastIdStatement = conn.createStatement();
            ResultSet lastIdResultSet = getLastIdStatement.executeQuery(getLastIdQuery);

            if (lastIdResultSet.next()) {
                lastId = lastIdResultSet.getInt("LastId");
            }
            newId = lastId + 1;

            ps = conn.prepareStatement(
                "INSERT INTO seller "
                + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                + "VALUES "
                + "(?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, newId);
            ps.setString(2, "Pedro");
            ps.setString(3, "pedro@gmail.com");
            ps.setDate(4, new java.sql.Date(sdf.parse("2002/04/06").getTime()));
            ps.setDouble(5, 3000);
            ps.setInt(6, 1);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) { 
                rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            }
            else {
                System.out.println("No rows affected!"); 
            }

            ps.execute();
            rs = st.executeQuery("Select * from seller");

            System.out.println();
            System.out.println("New sellers before the insertion:");
            while (rs.next()) { 
                System.out.println(
                    rs.getInt("Id") + ", " + 
                    rs.getString("Name") + ", " +
                    rs.getString("Email") + ", " +
                    rs.getDate("BirthDate") + ", " +
                    rs.getDouble("BaseSalary") + ", " +
                    rs.getInt("DepartmentId")
                    );
            }
            System.out.println();

            System.out.println("===========================================================");
        }
        catch (SQLException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace(); }

        finally {
            DB.closePreparedStatement(ps);
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConnection(conn);
        }
    }
}
