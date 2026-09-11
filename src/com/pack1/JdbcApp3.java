package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp3 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";
    private String sqlQuery = "insert into Employee values(112,'Raj','Avchar',50000,'BLR')";
    Scanner sc = new Scanner(System.in);

    void insertData(){
        System.out.println("Inserting the data in Database");
        try{
            System.out.println("Loading the Driver");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
            Statement stmt = con.createStatement();
            int rowCount = stmt.executeUpdate(sqlQuery);

            if(rowCount > 0){
                System.out.println("Database Updated");
                System.out.println("Do you want to update the Database: (Y/N)? ");

                char choice = sc.nextLine().charAt(0);
                switch(choice){
                    case 'Y','y':
                        new JdbcApp2().getEmpData();
                        break;
                    case 'N','n':
                }

            }
        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Dont enter the duplicate values");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp3 ob3 = new JdbcApp3();
        ob3.insertData();
    }
}
