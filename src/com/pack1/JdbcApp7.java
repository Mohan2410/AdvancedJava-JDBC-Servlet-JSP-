package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp7 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";
    String sqlQuery = "Select * from employee";
    String sqlQuery2 = "select eid,efname,esal from employee";

    Scanner sc = new Scanner(System.in);

    public Connection connect(){
        Connection con = null;
        try {

            Class.forName(driver);
            con = DriverManager.getConnection(dburl,dbuname,dbpwd);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    void meth1() {
        System.out.println("Implementing scrollable Resultset");
        try {
            Connection con = connect();
            Statement stmt = con.createStatement(1004,1007);
            ResultSet rs = stmt.executeQuery(sqlQuery);

            rs.afterLast();
            while(rs.previous()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
            }
            System.out.println("-----------------------------");

            rs.last();
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
            System.out.println("-----------------------------");

            rs.absolute(-6);
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
            System.out.println("-----------------------------");

            rs.relative(-2);
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
            System.out.println("-----------------------------");

            ;		}catch(Exception e) {
            e.printStackTrace();
        }
    }

    void meth2() {
        System.out.println("Implementing scrollable Result set ====> \n");

        try {
            Connection con = connect();
            Statement stmt = con.createStatement(1004,1008);

            ResultSet rs = stmt.executeQuery(sqlQuery2);



            while(rs.next()) {
                String empId = rs.getString(1);


                if("eid".equals(empId)) {
                    System.out.println("Updating the salary for employee: "+rs.getString(2));
                    rs.updateInt("esal", 6000);
                    rs.updateRow();
                }
            }
            System.out.println("Data Updated!!! do you want ot view (Y/N) ?");
            char choice = sc.nextLine().charAt(0);
            switch(choice) {
                case 'Y','y':
                    rs.absolute(6);
                    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
                    break;

                case 'N','n':
                    System.out.println("See you soon");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid data");

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp7 obj = new JdbcApp7();
//		obj.meth1();
//		obj.connect();

        obj.meth2();
        obj.connect();
    }

}



//ask used id and then display the salary===>assignment