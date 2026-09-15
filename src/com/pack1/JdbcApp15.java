package com.pack1;

import java.rmi.server.ServerCloneException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class JdbcApp15 {
    private String driver,dburl,dbuname,dbpwd;

    Vector<Connection> v = new Vector<Connection>();

    public JdbcApp15(String dburl, String dbuname, String dbpwd) {
        this.dburl = dburl;
        this.dbuname = dbuname;
        this.dbpwd = dbpwd;
    }

    void con_Initialization(){
        System.out.println("Creating '5' Connections objects");
        while(v.size() < 5){
            try{
                Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
                v.addElement(con);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        for(Object data :v){
            System.out.println(data);
        }
        System.out.println(v.size()+"Connection Object Present in the connection pool");
    }
    Connection con_Aquisition(){
        System.out.println("Assigning the connection Object");
        Connection con = v.elementAt(0);
        v.remove(con);
        return con;
    }

    void con_Return(Connection obj){
        System.out.println("Adding the connection object back into Connection Pool");
        v.addElement(obj);
        System.out.println("--------------------");
        for(Object data :v){
            System.out.println(data);
        }
    }
}


