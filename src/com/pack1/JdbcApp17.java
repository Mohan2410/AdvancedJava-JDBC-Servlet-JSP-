package com.pack1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.*;

public class JdbcApp17 {
    private String driver = "oracle.jdbc.OracleDriver";
    private String dburl = "jdbc:oracle:thin:@localhost:1521:free";
    private String dbuname = "system";
    private String dbpwd = "System123";

    String sqlQuery4 = "select file_data from mydata";

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
    void meth3(){

    }
    void meth4(){
        try{
            Connection con = connect();
            PreparedStatement pstm = con.prepareStatement(sqlQuery4);
            pstm.setString(1,"101");
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                Clob b = rs.getClob(1);
                Reader data = b.getCharacterStream();

                BufferedReader br = new BufferedReader(data);
                FileWriter fw = new FileWriter("C:\\NIT\\file2.txt");
                String line;
//                while(line=br.readLine()) != null){
//                    fw.write(line);
//                }
                br.close();
                fw.close();
                System.out.println("Clob data is Retrieved");
            }else{
                throw new SQLException("Invalid Id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
