package com.example.projetjava;
import  java.sql.Connection;
import  java.sql.DriverManager;
public class db {

    public Connection con ;



    public Connection getConnection(){

        String user="safa";
        String motpasse="safa1999";
        String  url="jdbc:mysql://localhost/javafx-app";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,user,motpasse);
            System.out.println("Connection succeed....");
        }catch(Exception e){

            System.out.println("Connection failed....");
        }
        return con;
    }

}