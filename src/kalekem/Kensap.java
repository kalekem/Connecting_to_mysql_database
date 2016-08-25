package kalekem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Statement;

//connects to mySQL database using the JDBC Driver
public class Kensap {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//localhost can also be accessed with 127.0.0.1
		String url = "jdbc:mysql://127.0.0.1:3306/kensap_classes";
		
		//enter the username of the database
		System.out.println("Enter the username: ");
		String username = scan.nextLine();
		
		//enter the database password
		System.out.println("Enter the password: ");
		String password = scan.nextLine();

		System.out.println("Connecting to database...");
		
		scan.close();
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
		    
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!!", e);
		}
		
		//reading data from mySQL database tables
		try {
	        Statement stmt = (Statement) connection.createStatement();
	        String query = "select * from kensap_2017;";
	       
	        //kensap_2017 is the table name in the database
	        System.out.println("class_id\t firstname\t lastname\t email_address\t college\t create_date\t post_date");
	        
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            String class_id = rs.getObject(1).toString();
	            String firstname = rs.getObject(2).toString();
	            String lastname = rs.getObject(3).toString();
	            String email_address = rs.getObject(4).toString();
	            String college= rs.getObject(5).toString();
	            String create_date = rs.getObject(6).toString();
	            String post_date= rs.getObject(7).toString();
	            System.out.println(class_id +"\t" + firstname + "\t" + lastname +"\t" + email_address +"\t"
	            		+ college + "\t" + create_date + "\t" + post_date);
	           
	            //kensap_2017 table has class_id, firstname, lastname, email_address, college, create_date and post_date columns    

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        for(Throwable ex : e) {
	            System.err.println("Error occurred " + ex);
	        }
	        System.out.println("Error in fetching data");
	    }
	}	
}
