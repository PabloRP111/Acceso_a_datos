package pojo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.InterfazDao;
import util.DatabaseConnection;

public class SerieDAO extends ObjetoDAO implements InterfazDao<Serie> {

	private static Connection connection;
	
	@Override
	public ArrayList<Serie> buscarTodos() {
		connection = openConnection();
		ArrayList<Serie> series=new ArrayList<>();
		String query ="Select * from series";
		Serie serie;
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				serie=new Serie(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null
						);
				series.add(serie);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		return series;
	}

	@Override
	public void insertar(Serie t) {
		connection = openConnection();
		String query ="insert into series (titulo, edad, plataforma) value(?,?,?)";
		
		
		try{
		PreparedStatement ps= connection.prepareStatement(query);		
		
		ps.setString(1, t.getTitulo());
		
		ps.setInt(2, t.getEdad());
		
		ps.setString(3, t.getPlataforma());
		
		ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e);
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Serie t) {
		
		int id=t.getId();
		String titulo= t.getTitulo();
		int edad = t.getEdad();
		String plataforma = t.getPlataforma();

		String query ="Update Series set titulo =?,  plataforma=?, edad=? where id= ? ";
		connection =openConnection();
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, titulo);
			ps.setInt(2, edad);
			ps.setString(3, plataforma);
			ps.setInt(4, id);
			ps.executeUpdate();
			;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void borrar(Serie t) {
		int serie_id = t.getId();
		
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.borrarPorSerie(serie_id);
		
		connection = openConnection();
		
		String query ="Delete from series Where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}
	
	@Override
	public Serie buscarPorId(int id) {
		Serie serie = null;
		String query ="select * from Series where id= ?";
		
		connection = openConnection();
		
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				serie=new Serie(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		closeConnection();
		return serie;
	}
	
	public ArrayList<Temporada> obtenerTemporadas(Serie serie){
		ArrayList<Temporada> temporadas = new ArrayList<>();
		connection = openConnection();
		
		String query ="Select * from temporadas where serie_id = ?";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Temporada temporada = new Temporada(
						rs.getInt("id"),
						rs.getInt("num_temporada"),
						rs.getString("titulo"), 
						serie);
				temporadas.add(temporada);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		return temporadas;
	}
	
}
