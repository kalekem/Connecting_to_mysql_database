package kalekem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

//connects to mySQL database using the JDBC Driver
public class Kensap {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Localhost can also be accessed with 127.0.0.1
		String url = "jdbc:mysql://127.0.0.1:3306/kensap_classes";
		
		//enter the username of the database
		System.out.println("Enter the username: ");
		String username = scan.nextLine();
		
		//enter the database password
		System.out.println("Enter the password: ");
		String password = scan.nextLine();

		System.out.println("Connecting to database...");
		
		scan.close();
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!!", e);
		}
	}
	
}
