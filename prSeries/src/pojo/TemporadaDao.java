package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.InterfazDao;
import util.DatabaseConnection;

public class TemporadaDao extends ObjetoDAO implements InterfazDao<Temporada>{

	private static Connection connection;
	
	@Override
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public TemporadaDao() {
		
	}
	
	@Override
	public void insertar(Temporada t) {
		connection = openConnection();
		
		String query ="insert into temporadas (num_temporada, titulo, serie_id) value(?,?,?)";
		
		try{
		PreparedStatement ps= connection.prepareStatement(query);		
		
		ps.setInt(1, t.getNum_temporada());
		
		ps.setString(2, t.getTitulo());
		
		ps.setInt(3, t.getSerie().getId());
		
		ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e);
		}
		closeConnection();
		
	}

	@Override
	public void modificar(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Temporada t) {
	connection = openConnection();
	
	int id = t.getId();
	
	String query ="Delete from temporadas where id=?";
	
	try {
		PreparedStatement ps= connection.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	closeConnection();
	
	}
	
	public void borrarPorSerie (int serie_id) {
		connection = openConnection();
		
		String query = "Delete from temporadas where serie_id =?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public Serie buscarPorId(int i) {
		
		return null;
	}
	
	
	
}


