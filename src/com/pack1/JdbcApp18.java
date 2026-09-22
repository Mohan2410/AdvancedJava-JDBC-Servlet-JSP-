
/*
create table emp11(eid varchar2(10),ename varchar2(25),primary key(eid))

create table pro11(pid varchar2(10),pname varchar2(25),primary key(pid))

insert into emp11 values('101','Mohan')

insert into pro11 values('201','s24 ultra')
*/




package com.pack1;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;


public class JdbcApp18 {
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

    void batchProcessing(){
        try{
            Connection con = connect();
            Statement stmt = con.createStatement();
            System.out.println("How many Queries you want to add to the batch: ");
            int no_ofQueries = Integer.parseInt(sc.nextLine());
            for(int i=1;i<=no_ofQueries;i++){
                System.out.println("Enter your "+i+" query");
                stmt.addBatch(sc.nextLine());
            }
            int arr[] = stmt.executeBatch();
            System.out.println("=========>"+ Arrays.toString(arr));
            stmt.clearBatch();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp18 obj = new JdbcApp18();
        obj.batchProcessing();
    }
}
