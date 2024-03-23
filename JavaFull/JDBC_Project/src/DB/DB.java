package DB;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

public abstract class DB {

    public static Connection getConnection() {
        Connection conn = null;
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
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

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try { conn.close(); } 
            catch (SQLException e) { throw new DbException(e.getMessage()); }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try { st.close(); } 
            catch (SQLException e) { throw new DbException(e.getMessage()); }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try { rs.close(); } 
            catch (SQLException e) { throw new DbException(e.getMessage()); }
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try { ps.close(); } 
            catch (SQLException e) { throw new DbException(e.getMessage()); }
        }
    }
    
}
