package entities;

import java.text.ParseException;

import java.sql.SQLException;
import java.sql.Statement;

import DB.DB;

public abstract class Department extends DB {

    public static String getRows() throws SQLException {
        StringBuilder sb = new StringBuilder();

        rs = st.executeQuery("Select * from department");
    
        while (rs.next()) { sb.append(rs.getInt("Id") + ", " + rs.getString("Name") + "\n"); }

        return sb.toString();
    }

    public static boolean add(String name) throws SQLException, ParseException {
        boolean inserted = false;

        ps = conn.prepareStatement(
            "INSERT INTO department "
            + "(Id, Name) "
            + "VALUES "
            + "(?, ?)",
            Statement.RETURN_GENERATED_KEYS
        );

        ps.setInt(1, getDepartmentLastId());
        ps.setString(2, name);

        ps.execute();
        inserted = true;

        return inserted;
    }

    public static boolean delete(int departmentId) throws SQLException {
        boolean deleted = false;

        ps = conn.prepareStatement("DELETE FROM department WHERE (Id = ?)");

        ps.setInt(1, departmentId);

        ps.execute();
        deleted = true;

        return deleted;
    }

    public static boolean deleteByName(String name) throws SQLException {
        boolean deleted = false;

        ps = conn.prepareStatement("DELETE FROM department WHERE (Name = ?)");

        ps.setString(1, name);

        ps.execute();
        deleted = true;

        return deleted;
    }

    public static boolean updateName(String departmentName, String newDepartmentName) throws SQLException {
        boolean updated = false;

        ps = conn.prepareStatement("UPDATE department SET Name = ? Where (Name = ?)");

        ps.setString(1, newDepartmentName);
        ps.setString(2, departmentName);

        ps.execute();
        updated = true;

        return updated;
    }

    
}