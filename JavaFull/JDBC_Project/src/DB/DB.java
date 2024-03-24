package DB;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Properties;

public abstract class DB {

    protected static PreparedStatement ps = null;
    protected static Connection conn = null;
    protected static Statement st = null;
    protected static ResultSet rs = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
                st = conn.createStatement();
            }
            catch(SQLException e) { throw new DbException(e.getMessage()); }
        }
        return conn;
    }
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e) { throw new DbException(e.getMessage()); }
    }

    public static void closeConnection() {
        if (conn != null) {
            try { conn.close(); } 
            catch (SQLException e) { throw new DbException(e.getMessage()); }
        }
    }

    public static void closeStatement() {
        if (st != null) {
            try { st.close(); } 
            catch (SQLException e) { throw new DbException(e.getMessage()); }
        }
    }

    public static void closeResultSet() {
        if (rs != null) {
            try { rs.close(); } 
            catch (SQLException e) { throw new DbException(e.getMessage()); }
        }
    }

    public static void closePreparedStatement() {
        if (ps != null) {
            try { ps.close(); } 
            catch (SQLException e) { throw new DbException(e.getMessage()); }
        }
    }

    protected static int getSellerLastId() throws SQLException {
        conn.setAutoCommit(false);
        int newId = 0;

        String getLastIdQuery = "SELECT MAX(Id) AS LastId FROM seller";
        rs = st.executeQuery(getLastIdQuery);

        if (rs.next()) { newId = rs.getInt("LastId") + 1; }

        conn.commit();
        return newId;
    }

    protected static int getDepartmentLastId() throws SQLException {
        conn.setAutoCommit(false);
        int newId = 0;

        String getLastIdQuery = "SELECT MAX(Id) AS LastId FROM department";
        rs = st.executeQuery(getLastIdQuery);

        if (rs.next()) { newId = rs.getInt("LastId") + 1; }

        conn.commit();
        return newId;
    }

    public static void getRollBack() throws SQLException {
        conn.rollback();
    }

}
