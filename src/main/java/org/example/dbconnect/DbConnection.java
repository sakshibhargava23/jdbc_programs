package org.example.dbconnect;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
   public static Connection takeConnection(){
       Connection con=null;
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");

           //2.Create connection object
           String path = "jdbc:mysql://localhost:3306/db";
           String username = "root";
           String password = "Keepsmiling_23";
           con = DriverManager.getConnection(path,username,password);
       }
       catch (Exception e) {
          e.printStackTrace();
       }
       return con;
   }

}
