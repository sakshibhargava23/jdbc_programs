package org.example;
import org.example.dbconnect.DbConnection;

import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try{
           Connection con= DbConnection.takeConnection();
           Statement st=con.createStatement();
           String q="insert into person (name,location,age)values('James','Bhopal',25)";
           st.executeUpdate(q);
           con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}