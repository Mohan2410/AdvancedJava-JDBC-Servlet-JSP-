package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp6 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    void insertData() {
        try {
            System.out.println("Inserting the Data");

            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Employee id: ");
            int eid = sc.nextInt();
            sc.nextLine();

            System.out.println("E	nter Employee FName: ");
            String fname = sc.nextLine();

            System.out.println("Enter Employee LName: ");
            String lname = sc.nextLine();

            System.out.println("Enter Salary: ");
            int esal = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Employee Address: ");
            String addr = sc.nextLine();


            String sqlQuery = "insert into employee values("+ eid + ",'"+ fname + "','"+ lname + "',"+ esal + ",'"+addr + "')";
            int rowCount = stmt.executeUpdate(sqlQuery);

            System.out.println("insert data successfully..."+rowCount);

            con.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    void deleteData() {
        System.out.println("Deleting the employee data based on employee id");

        try {
            System.out.println("Loading the driver");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Employee Id which you want to delete: ");
            int eid = sc.nextInt();
            String sqlQuery = "delete from Employee where eid = "+eid;

            int rowCount = stmt.executeUpdate(sqlQuery);

            if(rowCount > 0) {
                System.out.println("Employee deleted successfully..."+rowCount);
            }else {
                System.out.println("Employee "+eid+" not found");
            }
            con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    void updateData() {
        System.out.println("trying to update the data in database");

        try {
            System.out.println("Loading the driver");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Employee Id which you want to update: ");
            int eid = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter new Salary");
            int esal = sc.nextInt();

            sc.nextLine();

            System.out.println("Enter new Address: ");;
            String addr = sc.nextLine();

            String sqlQuery  = "update Employee set esal = "+esal+", eaddress = '"+addr+"' where eid = "+eid;
            int rowCount = stmt.executeUpdate(sqlQuery);

            if(rowCount > 0) {
                System.out.println("Employee updated successfully");
            }else {
                System.out.println("Employee "+eid+" not found");
            }

            con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    void retriveData() {
        System.out.println("Retriving the data");
        try {
            System.out.println("Loading the driver");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Employee id to retrive: ");
            int eid = sc.nextInt();

            String sqlQuery = "select * from employee where eid = "+eid;

            ResultSet rs = stmt.executeQuery(sqlQuery);

            if(rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
            }else {
                System.out.println("Employee "+eid+" not found");
            }

            con.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp6 j6 = new JdbcApp6();
        j6.insertData();
        j6.deleteData();
        j6.updateData();
        j6.retriveData();
    }
}