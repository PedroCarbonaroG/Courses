package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DB;

public class App {

    public static void main(String[] args) throws Exception {

        PreparedStatement ps;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

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

            

        }
        catch (SQLException e) { e.printStackTrace(); }
        finally {
            conn.close();
            st.close();
            rs.close();
        }

    }
}