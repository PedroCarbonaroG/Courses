package db;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.Properties;

public class DB {

	protected static PreparedStatement ps = null;
    protected static Connection conn = null;
	protected static Connection auxConn = null;
    protected static ResultSet rs = null;
	protected static Statement st = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closePreparedStatement() {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeStatement() {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	protected static int getSellerLastId() throws SQLException {
        int newId = 0;

        String getLastIdQuery = "SELECT MAX(Id) AS LastId FROM seller";

		st = auxConn.createStatement();
        rs = st.executeQuery(getLastIdQuery);

        if (rs.next()) { newId = rs.getInt("LastId") + 1; }

        return newId;
    }

    protected static int getDepartmentLastId() throws SQLException {
        int newId = 0;

        String getLastIdQuery = "SELECT MAX(Id) AS LastId FROM department";

		st = auxConn.createStatement();
        rs = st.executeQuery(getLastIdQuery);

        if (rs.next()) { newId = rs.getInt("LastId") + 1; }

        return newId;
    }
}