package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnector {
	
	public static MyConnector connector = null;
	public static Connection connection;

	
	public MyConnector() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mapdemo", "root", "root");
			System.out.println("Data connected");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		if (connector == null) {
			connector = new MyConnector();
		}
		
		return connection;
	}
}
