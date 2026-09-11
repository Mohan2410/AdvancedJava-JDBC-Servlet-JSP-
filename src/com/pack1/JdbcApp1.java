package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcApp1{
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbUname = "system";
    private String dbPwd = "System123";

    void createConnection() {
        try {
            System.out.println("Loading the driver");

            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl,dbUname,dbPwd);

            System.out.println("Connection created successfully");

//			con.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp1 obj = new JdbcApp1();

        obj.createConnection();
    }
}