package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JdbcApp13MovieTicket {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    Scanner sc = new Scanner(System.in);

    String sqlQuery = "select available_seats from movieseatavaillability where MOVIE_ID > ?";

    public Connection connect(){
        Connection con = null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(dburl,dbuname,dbpwd);

        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public void bookTicket(String movieId,String customerId,int seatNumber){
        System.out.println("Checking the movie seat availability");
        try{
            Connection con = connect();
            System.out.println("getAutoCommit(): "+con.getAutoCommit());
            con.setAutoCommit(false);
            System.out.println("getAutoCommit(): "+con.getAutoCommit());

            PreparedStatement pstmt1 = con.prepareStatement(sqlQuery);
            System.out.println("Enter the Movie Id: ");
            String mid = sc.nextLine();

            pstmt1.setString(1,movieId);

            ResultSet rs = pstmt1.executeQuery();
            if (!rs.next()) {
                System.out.println("Movie not found");
            } else {
                int availableSeats = rs.getInt("available_seats");

                if (availableSeats > 0) {
                    System.out.println("Seat is available for booking");
                } else {
                    System.out.println("No seats are available");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp13MovieTicket obj = new JdbcApp13MovieTicket();
        obj.bookTicket("M001","C123",16);
    }


}
