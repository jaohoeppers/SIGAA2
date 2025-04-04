package com.classes.Conexao;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {

	final static String NOME_DO_BANCO = "sigaa2";
    public static Connection conectar() {
    	try {
    		Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost/" + NOME_DO_BANCO;
            return DriverManager.getConnection(url,"root","");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}