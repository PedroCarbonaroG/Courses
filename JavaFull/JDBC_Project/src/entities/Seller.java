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

    public static boolean updateName(String name, String newName) throws SQLException {
        boolean updated = false;

        ps = conn.prepareStatement("UPDATE seller SET Name = ? Where (Name = ?)");

        ps.setString(1, newName);
        ps.setString(2, name);

        ps.execute();
        updated = true;

        return updated;
    }

    public static boolean updateEmail(String email, String newEmail) throws SQLException {
        boolean updated = false;

        ps = conn.prepareStatement("UPDATE seller SET Email = ? Where (Email = ?)");

        ps.setString(1, newEmail);
        ps.setString(2, email);

        ps.execute();
        updated = true;

        return updated;
    }

    public static boolean updateBirthDate(Date date, Date newDate) throws SQLException {
        boolean updated = false;

        ps = conn.prepareStatement("UPDATE seller SET BirthDate = ? Where (BirthDate = ?)");

        ps.setDate(1, new java.sql.Date(newDate.getTime()));
        ps.setDate(2, new java.sql.Date(date.getTime()));

        ps.execute();
        updated = true;

        return updated;
    }

    public static boolean updateBaseSalary(double percentage) throws SQLException {
        boolean updated = false;
        
        ps = conn.prepareStatement("UPDATE seller SET BaseSalary =  BaseSalary * ? WHERE (DepartmentId = ?)");

        ps.setDouble(1, percentage);
        ps.setInt(2, 1);

        ps.execute();
        updated = true;

        return updated;
    }

    public static boolean updateDepartmentId(int sellerId, int newDepartmentId) throws SQLException {
        boolean updated = false;

        ps = conn.prepareStatement("UPDATE seller SET DepartmentId = ? Where (Id = ?)");

        ps.setInt(1, newDepartmentId);
        ps.setInt(2, sellerId);

        ps.execute();
        updated = true;

        return updated;
    }

    public static boolean delete(int sellerId) throws SQLException {
        boolean deleted = false;

        ps = conn.prepareStatement("DELETE FROM seller WHERE (Id = ?)");

        ps.setInt(1, sellerId);

        ps.execute();
        deleted = true;

        return deleted;
    }

    public static boolean deleteByName(String name) throws SQLException {
        boolean deleted = false;

        ps = conn.prepareStatement("DELETE FROM seller WHERE (Name = ?)");

        ps.setString(1, name);

        ps.execute();
        deleted = true;

        return deleted;
    }

    public static boolean deleteByEmail(String email) throws SQLException {
        boolean deleted = false;

        ps = conn.prepareStatement("DELETE FROM seller WHERE (Email = ?)");

        ps.setString(1, email);

        ps.execute();
        deleted = true;

        return deleted;
    }
}