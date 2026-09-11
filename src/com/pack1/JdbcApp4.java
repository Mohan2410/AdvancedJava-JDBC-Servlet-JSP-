package com.pack1;

import org.w3c.dom.html.HTMLDivElement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp4 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    void insertData(){
        try{
            System.out.println("Inserting Data into Database");
            System.out.println("Loading the driver");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Employee Id: ");
            int eid = sc.nextInt();

            sc.nextLine();

            System.out.println("Enter Employee FName: ");
            String fname = sc.nextLine();

            System.out.println("Enter Employee LName: ");
            String lname = sc.nextLine();

            System.out.println("Enter Employee Salary: ");
            int esal = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Employee Address: ");
            String addr = sc.nextLine();

            String sqlQuery = "insert into Employee values("+eid+",'"+fname+"','"+lname+"',"+esal+",'"+addr+"')";
            int rowCount = stmt.executeUpdate(sqlQuery);

            System.out.println("Insert data successfully "+rowCount);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void deleteData(){
        System.out.println("Deleting the Data");
        try{
            System.out.println("Loading the driver");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Employee Id which you want to delete: ");
            int eid = sc.nextInt();
            sc.nextLine();

            String sqlQuery = "delete from Employee where eid = "+eid;
            int rowCount = stmt.executeUpdate(sqlQuery);
            if(rowCount > 0){
                System.out.println(rowCount+ " Employee record deleted successfully...");
            }else{
                System.out.println("The Enter Employee Id is Invalid, please Enter correct Employee id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp4 ja4 = new JdbcApp4();
//        ja4.insertData();
        ja4.deleteData();
    }
}
