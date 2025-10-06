package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Example3 {
    public static void main(String[] args) {


        try{
           Connection con= DbConnection.takeConnection();
           Statement st=con.createStatement();
           String q="Select * from person";
           ResultSet rs=st.executeQuery(q);

           while(rs.next()){
               System.out.print(rs.getString(1)+"\t");
               System.out.print(rs.getString("name")+"\t");
               System.out.print(rs.getString("location")+"\t");
               System.out.print(rs.getString("age")+"\t");
                System.out.println();
           }
           con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}