package nico.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class Test {
    
    private static List<String> messages = new ArrayList<String>();

    public static void executerTests() {
    	
        try {
        	System.out.println("Driver loading...\n");
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	System.out.println("Driver loaded.\n");
        } catch (ClassNotFoundException e) {
        	System.out.println("Failed to load Driver : driver not found in classpath\n" + e.getMessage());
        }

        // Connection to database
        String url = "jdbc:mysql://localhost:3306/test2";
        String user = "root";
        String pwd = "";
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;
        
        try {
        	System.out.println("Database conection...\n");
        	conn = DriverManager.getConnection(url, user, pwd);
        	System.out.println("Connection successful.\n");
        	
        	// request manager object creation
        	statement = conn.createStatement();
        	System.out.println("requested object created\n");
        	
        	// execute read request
        	result = statement.executeQuery("SELECT id_isbn, nom_livre, date_de_fin, est_supprime, id_auteur, id_editeur, id_personne, id_lieu FROM livre");
        	System.out.println("request : \"SELECT id_isbn, nom_livre, date_de_fin, est_supprime, id_auteur, id_editeur, id_personne, id_lieu FROM livre\" : done\n");
        	
        	// retrieve data from result of read query
        	while(result.next()) {
        		System.out.println("\t" + result.getInt("id_isbn"));
        		System.out.println("\t" + result.getString("nom_livre"));
        		System.out.println("\t" + result.getDate("date_de_fin"));
        		System.out.println("\t" + result.getBoolean("est_supprime"));
        		System.out.println("\t" + result.getInt("id_auteur"));
        		System.out.println("\t" + result.getInt("id_editeur"));
        		System.out.println("\t" + result.getInt("id_personne"));
        		System.out.println("\t" + result.getInt("id_lieu"));
        		
        		System.out.println("Datas returned into variables\n");
        	}
        	
        } catch(SQLException e) {
        	System.out.println("Error at connexion : \n" + e.getMessage());
        } finally {
        	System.out.println("Closing ResultSet Object\n");
        	if(result != null) {
        		try {
        			result.close();
        		} catch(SQLException ignore) {}
        	}
        }
        System.out.println("closing statement object\n");
        if(statement != null) {
        	try {
        		statement.close();
        	} catch(SQLException ignore) {}
        }
        System.out.println("closing conneciton object\n");
        if(conn != null) {
        	try {
        		conn.close();
        	} catch(SQLException ignore) {}
        }
        
    }
    
    public static void main(String args[]) {
    	executerTests();
    	System.out.println(Test.messages);
    }
}
