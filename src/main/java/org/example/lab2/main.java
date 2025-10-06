package org.example.lab2;
import java.sql.*;
public class main {
    public static void main(String[] args){
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

            String sql = "INSERT INTO Teachers(id,name,subject) VALUES(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 3);
            pstmt.setString(2, "Emma");
            pstmt.setString(3, "Chemistry");
            pstmt.executeUpdate();

            String updateSQL = "UPDATE Teachers SET subject=? WHERE id=?";
            PreparedStatement pstmt2 = con.prepareStatement(updateSQL);
            pstmt2.setString(1,"Biology");
            pstmt2.setInt(2,2);
            pstmt2.executeUpdate();

            String selectSQL = "SELECT * FROM Teachers WHERE id=?";
            PreparedStatement pstmt3 = con.prepareStatement(selectSQL);
            pstmt3.setInt(1,1);
            ResultSet rs = pstmt3.executeQuery();



// Iterate through the ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");           // Get 'id' column value
                String name = rs.getString("name"); // Get 'name' column value
                String subject = rs.getString("subject"); // Get 'subject' column value

                // Print the values
                System.out.println("ID: " + id + ", Name: " + name + ", Subject: " + subject);
            }

// Close the ResultSet
            rs.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
