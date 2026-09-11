package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp13 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    String sqlQuery = "update bankaccount set ACC_HOLDER_NAME-1000 where acc_no=?";

    public Connection connect(){
        Connection con = null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(dburl,dbuname,dbpwd);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    void meth1(){
        System.out.println("Transferring funds from one account to another");
        try {
            Connection con = connect();

            System.out.println("getAutoCommit(): "+con.getAutoCommit());
            con.setAutoCommit(false);
            System.out.println("getAutoCommit(): "+con.getAutoCommit());

            PreparedStatement pstmt1 = con.prepareStatement(sqlQuery);
            pstmt1.setString(1,"1000");


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
