package com.pack1;

import java.sql.*;
import java.util.Stack;

public class JdbcApp2 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String DBurl= "jdbc:oracle:thin:@localhost:1521:free";
    private String DBuname = "system";
    private String DBpwd = "System123";
    private String Sqlquery = "select * from Employee";

    public void getEmpData(){
        System.out.println("*****Retriving Data*****");
        try{
            System.out.println("Loading the driver");

            Class.forName(driver);
            Connection con = DriverManager.getConnection(DBurl,DBuname,DBpwd);

            System.out.println("Connection created successgully");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sqlquery);

            rs = stmt.executeQuery("select * from Employee order by Esal desc");

            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        JdbcApp2 ob1 = new JdbcApp2();
        ob1.getEmpData();
    }
}
