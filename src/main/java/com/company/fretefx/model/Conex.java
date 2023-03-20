package com.company.fretefx.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conex {

    public Connection conex(){

        Connection conn = null;

        try{
            String url = "jdbc:mysql://localhost:3306/study?user=srborges&password=143103";

            conn = DriverManager.getConnection(url);

            System.out.println("Conectado");

        }catch(SQLException e){
            System.out.println("Desconectado");
        }

        return conn;

    }

}
