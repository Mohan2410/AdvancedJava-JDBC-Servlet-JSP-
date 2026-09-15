package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class JdbcApp10 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    Scanner sc = new Scanner(System.in);

    public Connection connect(){
        Connection con = null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(dburl,dbuname,dbpwd);
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

    void insertData(){
        System.out.println("Implementing Callable statement");

        try{
            Connection con = connect();
            CallableStatement cstmt = con.prepareCall("{call InsertEmpData(?,?,?,?,?)}");

            System.out.println("Enter Emp Id: ");
            String eid = sc.nextLine();

            System.out.println("Enter Emp Name: ");
            String ename = sc.nextLine();

            System.out.println("Enter Emp Designation: ");
            String edesg = sc.nextLine();

            System.out.println("Enter Emp Basic Salary: ");
            int ebsal = Integer.parseInt(sc.nextLine());

            float etsal = ebsal+(0.35f*ebsal)+(0.10f*ebsal);

            cstmt.setString(1,eid);
            cstmt.setString(2,ename);
            cstmt.setString(3,edesg);
            cstmt.setInt(4,ebsal);
            cstmt.setFloat(5,etsal);

            cstmt.execute();

            System.out.println("Data Inserted");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void retriveData(){
        System.out.println("Implementing Callable statement to retrive the data");
        try{
            Connection con = connect();

            CallableStatement cstmt = con.prepareCall("{call RETRIVEEMPDETAILS(?,?,?,?,?)}");
            System.out.println("Connection created");

            System.out.println("Enter Employee ID: ");
            String eid = sc.nextLine();

            cstmt.setString(1,eid);

            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.VARCHAR);
            cstmt.registerOutParameter(4, Types.INTEGER);
            cstmt.registerOutParameter(5, Types.FLOAT);
            cstmt.execute();

            System.out.println("********Employee Details********");
            System.out.println("Employee Id: "+eid);
            System.out.println("Employee Name: "+cstmt.getString(2));
            System.out.println("Employee Designation: "+cstmt.getString(3));
            System.out.println("Employee Basic Salary: "+cstmt.getInt(4));
            System.out.println("Employee Total Salary: "+cstmt.getFloat(5));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void retrivetTsal(){
        System.out.println("Implementing Callable statement through functions");
        try{
            Connection con = connect();
            CallableStatement cstmt = con.prepareCall("{call ?:= retrivesal(?)}");

            System.out.println("Enter Employee Id: ");
            String eid = sc.nextLine();

            cstmt.setString(2,eid);

            cstmt.registerOutParameter(1,Types.FLOAT);
            cstmt.execute();

            System.out.println("Employee Id: "+eid+" Total sal is: "+cstmt.getFloat(1));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        JdbcApp10 obj = new JdbcApp10();
//        obj.insertData();
//        obj.retriveData();
        obj.retrivetTsal();
    }
}
