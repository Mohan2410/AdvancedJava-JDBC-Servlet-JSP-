package com.pack1;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.*;
import java.util.Scanner;

public class JdbcApp8 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    Scanner sc = new  Scanner(System.in);

    void meth1(){
        System.out.println("Implementing JdbcROwSet");
        try{
            RowSetFactory rsf = RowSetProvider.newFactory();
            JdbcRowSet jrs = rsf.createJdbcRowSet();
            jrs.setUrl(dburl);
            jrs.setUsername(dbuname);
            jrs.setPassword(dbpwd);
            jrs.setCommand("Select * from employee");
            jrs.execute();

            jrs.last();
            System.out.println(jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
            System.out.println("-----------------------------");

            jrs.first();
            System.out.println();
            System.out.println(jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
            System.out.println("--------------------------------");

            jrs.beforeFirst();
            while(jrs.next()){
                System.out.println(jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
                System.out.println("------------------------------");
                System.out.println();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void meth2(){
        System.out.println("Implementing the Cached RowSet");
        try{
            RowSetFactory rsf = RowSetProvider.newFactory();
            CachedRowSet crs = rsf.createCachedRowSet();
            crs.setUrl(dburl);
            crs.setUsername(dbuname);
            crs.setPassword(dbpwd);
            crs.setCommand("select eid,efname,esal from employee");
            crs.execute();

            System.out.println("Enter emp id: ");
            String eid = sc.nextLine();

            System.out.println("Enter emp salary: ");
            int esal = Integer.parseInt(sc.nextLine());

            while (crs.next()){
                if(crs.getString(1).equals(eid)){
                    System.out.println("Updating the salary of the employee: "+crs.getString(2));
                    crs.updateInt("esal",esal);
                    crs.updateRow();
                    System.out.println(crs.getInt(1)+" "+crs.getString(2)+" "+crs.getInt(3));
                }
            }

            crs.acceptChanges();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp8 obj = new JdbcApp8();
//        obj.meth1();
          obj.meth2();
    }

}
