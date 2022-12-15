package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.DatabaseConnection;

/**
 * La clase que contiene las funciones de abrir y cerrar conexion
 * @author asraum
 *
 */
public class ObjetoDao {
	
	private static Connection connection;

	protected static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	protected static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
