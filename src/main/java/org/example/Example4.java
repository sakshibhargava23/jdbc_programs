package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Example4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name");
        String name=sc.nextLine();
        System.out.print("Enter location");
        String loc=sc.nextLine();
        System.out.print("Enter age");
        int age=sc.nextInt();
        try{
            Connection con= DbConnection.takeConnection();
            String q="insert into person (name,location,age)values(?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);

            ps.setString(1,name);
            ps.setString(2,loc);
            ps.setInt(3,age);
            ps.execute();
            System.out.println("Record inserted");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}