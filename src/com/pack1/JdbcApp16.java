package com.pack1;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class JdbcApp16 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    String sqlQuery = "select efname,elname from employee where eid = ?";

    public void metadata(){
        System.out.println("Implementing the MetaData");

        try{
            RowSetFactory rsf = RowSetProvider.newFactory();
            JdbcRowSet jrs = rsf.createJdbcRowSet();
            jrs.setUrl(dburl);
            jrs.setUsername(dbuname);
            jrs.setPassword(dbpwd);
            jrs.setCommand("select efname,elname from employee where eid = 101");
            jrs.execute();

            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl,dbuname,dbpwd);
            PreparedStatement pstmt = con.prepareStatement(sqlQuery);
            pstmt.setString(1,"101");
            ResultSet rs = pstmt.executeQuery();

            System.out.println("------------------Database Metadata------------------");
            DatabaseMetaData dmdt = con.getMetaData();
            System.out.println("Product Name: "+dmdt.getDatabaseProductName());
            System.out.println("Version: "+dmdt.getDatabaseProductVersion());
            System.out.println("Driver Name: "+dmdt.getDriverName());
            System.out.println("Is support procedure: "+dmdt.supportsStoredProcedures());

            System.out.println("--------------Parameter MetaData-------------");
            ParameterMetaData pmdt = pstmt.getParameterMetaData();
            System.out.println("Parameter count: "+pmdt.getParameterCount());
            System.out.println("Parameter Type: "+pmdt.getParameterType(1));
            System.out.println("Parameter Mode: "+pmdt.getParameterMode(1));
            System.out.println("Is nullable: "+pmdt.isNullable(1));

            System.out.println("--------------ResultSet MetaData-------------");
            ResultSetMetaData rsmdt = rs.getMetaData();
            System.out.println("No of columns: "+rsmdt.getColumnCount());
            System.out.println("Column Name: "+rsmdt.getColumnName(2));
            System.out.println("Size of the column: "+rsmdt.getColumnDisplaySize(2));
            System.out.println("IS auto increment: "+rsmdt.isAutoIncrement(2));

            System.out.println("--------------RowSet MetaData-------------");
            RowSetMetaData rmdt = (RowSetMetaData) jrs.getMetaData();
            System.out.println("No of Column: " + rmdt.getColumnCount());
            System.out.println("Column Name: " + rmdt.getColumnName(2));
            System.out.println("Column Type: " + rmdt.getColumnType(2));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcApp16 obj = new JdbcApp16();
        obj.metadata();
    }
}
