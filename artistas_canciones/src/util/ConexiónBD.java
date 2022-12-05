package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexiónBD {

Connection connection;
	
	public Connection getConnection () {
		String dbName = "bd_artístas_canciones";
		String userName = "root";
		String password = "admin";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName,userName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
}
