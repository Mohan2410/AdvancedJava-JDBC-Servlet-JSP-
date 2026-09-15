package com.pack1;

import java.sql.Connection;

public class ConnectionPool {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    JdbcApp15 obj = new JdbcApp15(dburl,dbuname,dbpwd);

    void meth1(){
        System.out.println("Implementing COnnection Pooling");

        obj.con_Initialization();
        System.out.println("Size of vector: "+obj.v.size());

        System.out.println("\n----------User1------------");
        Connection con1 = obj.con_Aquisition();
        System.out.println("Size of vector: "+obj.v.size());

        System.out.println("\n----------User2------------");
        Connection con2 = obj.con_Aquisition();
        System.out.println("Size of vector: "+obj.v.size());

        System.out.println("\n----------User3------------");
        Connection con3 = obj.con_Aquisition();
        System.out.println("Size of vector: "+obj.v.size());

        obj.con_Return(con1);
        obj.con_Return(con2);
        obj.con_Return(con3);

    }
    public static void main(String[] args){
        new ConnectionPool().meth1();
    }
}
