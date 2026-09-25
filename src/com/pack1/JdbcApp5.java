package com.pack1;

import java.sql.*;
import java.util.Scanner;

public class JdbcApp5 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    Scanner sc = new Scanner(System.in);

    public Connection connect() {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dburl,dbuname,dbpwd);

        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    void operation() throws SQLException {
        Connection con = connect();

        try{

            PreparedStatement pstmt1 = con.prepareStatement("insert into patient values(?,?,?,?)");
            PreparedStatement pstmt2 = con.prepareStatement("select * from patient");
            PreparedStatement pstmt3 = con.prepareStatement(("select * from patient where pid = ?"));
            PreparedStatement pstmt4 = con.prepareStatement("UPDATE patient set age = ? where pid = ? ");
            PreparedStatement pstmt5 = con.prepareStatement("delete from patient where pid = ?");


            while(true){
                System.out.println("****Welcome to patient Database*****");
                System.out.println("Choose your option");
                System.out.println("1) Add Patient Data");
                System.out.println("2) View Patient Data");
                System.out.println("3) Retrieve Patient Data");
                System.out.println("4) Update Patient Data");
                System.out.println("5) Delete Patient Data");
                System.out.println("6) Exit");

                int choice = Integer.parseInt(sc.nextLine());

                switch(choice){
                    case 1:
                        System.out.println("Adding Patient Data");
                        System.out.println("Enter Patient Id");
                        String pid1 = sc.nextLine();

                        System.out.println("Enter Patient Name: ");
                        String pname1 = sc.nextLine();

                        System.out.println("Enter Patient Age: ");
                        int page1 = Integer.parseInt(sc.nextLine());

                        System.out.println("Enter Patient Contact");
                        long pcon1 = Long.parseLong(sc.nextLine());

                        pstmt1.setString(1,pid1);
                        pstmt1.setString(2,pname1);
                        pstmt1.setInt(3,page1);
                        pstmt1.setLong(4,pcon1);

                        int rowCount1 = pstmt1.executeUpdate();
                        if(rowCount1 > 0){
                            System.out.println(pid1+" patient data inserted");
                        }else{
                            System.out.println(pid1+" id is not found");
                        }

                        break;
                    case 2:
                        System.out.println("View Patient Data");
//                        System.out.println("Enter PID which you want to view: ");
                        ResultSet rs2 = pstmt2.executeQuery();
                        while(rs2.next()){
                            System.out.println(rs2.getString(1)+" "+ rs2.getString(2)+" "+rs2.getInt(3)+" "+rs2.getLong(4));
                        }
                        break;
                    case 3:
                        System.out.println("Retriving patient Data");
                        System.out.println("Enter the patient id which you want to view: ");
                        String pid3 = sc.nextLine();
                        pstmt3.setString(1,pid3);
                        ResultSet rs3 = pstmt3.executeQuery();
                        if(rs3.next()){
                            System.out.println(rs3.getString(1)+" "+ rs3.getString(2)+" "+rs3.getInt(3)+" "+rs3.getLong(4));
                        }else{
                            System.out.println(pid3+ " patient id is not found");
                        }
                        break;
                    case 4:
                        System.out.println("Updating patient Data");
                        System.out.println("Enter a patient id: ");
                        String pid4 = sc.nextLine();

                        System.out.println("Enter a patient age: ");
                        int page4 = Integer.parseInt(sc.nextLine());

                        pstmt4.setInt(1,page4);
                        pstmt4.setString(2,pid4);

                        int rowCount4 = pstmt4.executeUpdate();
                        if(rowCount4 > 0){
                            System.out.println(pid4+ "patient data upodated");
                        }else{
                            System.out.println(pid4+ "patient data not updated");
                        }
                        break;
                    case 5:
                        System.out.println("Deleting patient data");
                        System.out.println("Enter a Patient Id which you want to delete: ");
                        String pid5 = sc.nextLine();

                        pstmt5.setString(1,pid5);
                        ResultSet rs5 = pstmt5.executeQuery();
                        int rowCount5 = pstmt5.executeUpdate();

                        if(rowCount5 > 0){
                            System.out.println("patient data deleted");
                        }
                        break;
                    case 6:
                        System.out.println("Thank you for visiting");
                        System.out.println("Have a grat day");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input, check and try again");

                }

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            con.close();
        }

    }
    public static void main(String[] args) throws SQLException {
        JdbcApp5 obj = new JdbcApp5();
        obj.operation();
    }

}
