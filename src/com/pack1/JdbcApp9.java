package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcApp9 {
    private String driver = "oracle.driver.DriverManager";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";
//    String sqlQuery = "insert into EmployeeRegistration values";

    Scanner sc = new Scanner(System.in);

    public Connection connect(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(dburl,dbuname,dbpwd);
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

    void operation(){
        Connection con = connect();

        try{
            PreparedStatement pstmt1 = con.prepareStatement("insert into EmployeeRegistration values(?,?,?,?,?,?,?)");
            while (true) {
                System.out.println("******Welcome*******");
                System.out.println("Choose your option: ");
                System.out.println("1) Add the Employee data into Database");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Adding Employee Data: ");

                        System.out.println("Enter Employee Id: ");
                        String eid1 = sc.nextLine();

                        System.out.println("Enter the Password: ");
                        String pword1 = sc.nextLine();

                        System.out.println("Enter Fname: ");
                        String fname1 = sc.nextLine();

                        System.out.println("Enter LName: ");
                        String lname1 = sc.nextLine();

                        System.out.println("Enter Address: ");
                        String addr1 = sc.nextLine();

                        System.out.println("Enter EmailId: ");
                        String mid1 = sc.nextLine();

                        System.out.println("Enter PhoneNumber: ");
                        long phn1 = Long.parseLong(sc.nextLine());

                        pstmt1.setString(1,eid1);
                        pstmt1.setString(2,pword1);
                        pstmt1.setString(3,fname1);
                        pstmt1.setString(4,lname1);
                        pstmt1.setString(5,addr1);
                        pstmt1.setString(6,mid1);
                        pstmt1.setLong(7,phn1);

                        int rowCount1 = pstmt1.executeUpdate();
                        if(rowCount1 > 0){
                            System.out.println(eid1+ "EmployeeRegistration data inserted" );
                        }else{
                            System.out.println(eid1+ "not found");
                        }
                        break;
                    case 2:
                        System.out.println(" the data");
                        break;
                    default:
                        System.out.println("Invalid data");
                }
            }
        }catch(Exception e){
              e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp9 j9 = new JdbcApp9();
        j9.operation();
    }

}
