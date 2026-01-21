
package relationaldbs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest {
	
	//The direction of the database that we are going to connect
	private final static String dbURL = "jdbc:postgresql://localhost:5432/postgres";
								//"jdbc:postgresql://192.168.1.170:5432/sanmple?ssl=true"
	//The user name used to connect to the database
	private final static String username = "postgres";
	//The password required to connect
	private final static String password = "admin";
	//DriverManager class is used to manage different drivers for relational database
	
	public static void main(String[] args) {
		
		try {
			//Obtain a object of class "Connection"wich represents 
			//a connection between our application and the database
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("The adress of the connection object is " + conn);
			
			createDataBase(conn);
			
			String dropTableSQL = "drop table if exists users";
			PreparedStatement ps = conn.prepareStatement(dropTableSQL);
			ps.executeUpdate();
			ps.close();
						
			//Table creation SQL
			String createTableSQL = "create table if not exists users(" + "id integer not null," + "usernamne VARCHAR(255)," + "psw VARCHAR(255)," + "isVIP TINYINT(1)," + "balance FLOAT," + "PRIMARY KEY (id)" + ")";
			
			ps = conn.prepareStatement(createTableSQL);
			//ps.execute();
			ps.executeUpdate();
			
			//Insert SQL
			String insertSQL = "insert into users values(10, 'Manolo'," + " '12343', 1, 234.3), (20, 'Alejandro', '123', 1, 234.3)";
			
			ps = conn.prepareStatement(insertSQL);
			System.out.println(ps.executeUpdate());
			ps.close();
			
			//Delete SQL
			String deleteSQL = "DELETE FROM users WHERE username = 'Alejandro'";
			
			//Select psw, isVIP from users where username = 'Manolo';
			String selectSQL = "select * from users where username = 'Manolo'";
			
			/*
			 * String createTableSQL = 
			 * "create table if not exists users(" 
			 * + "id integer not null," + "usernamne VARCHAR(255)," 
			 * + "psw VARCHAR(255)," 
			 * + "isVIP TINYINT(1)," 
			 * + "balance FLOAT," 
			 * + "PRIMARY KEY (id)" 
			 * + ")";
			 */
						
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
	}
	
	private static void createDataBase(Connection conn) {
		
		try {
			//A SQL for creating a new database if it not exist
			String dbCreationSQL = "CREATE DATABASE happylearning";
			//This one is for Postgresql
			//CREATE DATABASE happylearning
			PreparedStatement ps = conn.prepareStatement(dbCreationSQL);
			//ps.execute();
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
