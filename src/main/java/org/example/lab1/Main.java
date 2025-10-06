package org.example.lab1;
import java.sql.*;
public class Main {
    public static void main(String[]args){
        Connection con;
        try{
            //1.register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.Create connection object
            String path = "jdbc:mysql://localhost:3306/studentdata";
            String username = "root";
            String password = "Keepsmiling_23";
            con = DriverManager.getConnection(path,username,password);

            if(con!=null){
                System.out.println("connection done");

            }
            else {
                System.out.println("connection not done");
            }
            String query="CREATE TABLE TeachersData4(id INT PRIMARY KEY, name VARCHAR(50), subject VARCHAR(50))";
            Statement st=con.createStatement();

            st.executeUpdate(query);
            st.executeUpdate("INSERT INTO TeachersData4 VALUES(1,'John','Math')");
            st.executeUpdate("INSERT INTO TeachersData4 VALUES(2,'Alice','Physics')");
            System.out.println("Data stored successfully");

            ResultSet rs = st.executeQuery("SELECT * FROM TeachersData4");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("name")+""
+rs.getString("subject"));
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
