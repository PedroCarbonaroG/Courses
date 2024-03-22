package app;

import java.sql.Connection;

import DB.DB;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}