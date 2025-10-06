package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Example1 {
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
           Statement st=con.createStatement();
           String q="insert into person (name,location,age)values('"+name+"','"+loc+"',"+age+")";
           st.executeUpdate(q);
           System.out.println("Record inserted");
           con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}