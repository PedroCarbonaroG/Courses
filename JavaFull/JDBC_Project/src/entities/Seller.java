package entities;

import java.text.ParseException;

import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;

import DB.DB;

public abstract class Seller extends DB {

    public static String getRows() throws SQLException {
        StringBuilder sb = new StringBuilder();

        rs = st.executeQuery("Select * from seller");
        
        while (rs.next()) { 
            sb.append(
                rs.getInt("Id") + ", " + 
                rs.getString("Name") + ", " +
                rs.getString("Email") + ", " +
                rs.getDate("BirthDate") + ", " +
                rs.getDouble("BaseSalary") + ", " +
                rs.getInt("DepartmentId") +
                "\n"
                ); 
        }

        return sb.toString();
    }

    public static boolean add(String name, String email, Date birthDate, double baseSalary, int departmentId) throws SQLException, ParseException {
        boolean inserted = false;

        ps = conn.prepareStatement(
            "INSERT INTO seller "
            + "(Id, Name, Email, BirthDate, BaseSalary, DepartmentId) "
            + "VALUES "
            + "(?, ?, ?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS
        );

        ps.setInt(1, getSellerLastId());
        ps.setString(2, name);
        ps.setString(3, email);
        ps.setDate(4, new java.sql.Date(birthDate.getTime()));
        ps.setDouble(5, baseSalary);
        ps.setInt(6, departmentId);

        ps.execute();
        inserted = true;

        return inserted;
    }
}