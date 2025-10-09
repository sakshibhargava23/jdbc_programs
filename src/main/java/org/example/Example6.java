package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Example6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try{
            Connection con= DbConnection.takeConnection();

            CallableStatement ps=con.prepareCall("{call GetRecord(?,?)}");
            ps.setInt(1,50);
            ps.registerOutParameter(2, Types.VARCHAR);
            ps.execute();

            String name=ps.getString(2);
            System.out.println(name);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}