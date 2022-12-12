package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.InterfazDao;
import pojo.Artista;
import pojo.Cancion;

public class ArtistaDAO extends ObjetoDao implements InterfazDao<Artista> {

	private static Connection connection;

	public ArtistaDAO() {

	}

	@Override
	public ArrayList<Artista> buscarTodos() {
		ArrayList<Artista> artistas = new ArrayList<>();

		connection = openConnection();

		String query = "SELECT * FROM Artistas";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ArrayList<Cancion> canciones= new ArrayList<Cancion>();
				
				Artista artista = new Artista(
							rs.getInt("id"),
							rs.getString("Nombre"),
							rs.getByte("Edad"),
							rs.getString("Discografica"),
							rs.getString("Nacionalidad"),
							rs.getByte("NExitos"),
							null
				);
				
				String query_canciones = "select * from canciones where artista_id = ?";
				PreparedStatement ps_cancion = connection.prepareStatement(query_canciones);
				ps_cancion.setInt(1, rs.getInt("id")); 
				ResultSet rs_cancion = ps_cancion.executeQuery();
				
				while(rs_cancion.next()) {
					Cancion cancion = new Cancion(
								rs_cancion.getInt("id"),
								rs_cancion.getString("Nombre"),
								rs_cancion.getString("Genero"),
								rs_cancion.getBoolean("Exito"),
								rs_cancion.getBoolean("Colaboracion"),
								rs_cancion.getDate("fecha_salida")
								
					);
					canciones.add(cancion);
				}
				
				artistas.add(artista);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artistas;

	}

	@Override
	public Artista buscarPorId(int id) {
		connection = openConnection();
		
		Artista artista = null;
		
		String query = "select * from artista where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				artista = new Artista(
						rs.getInt("id"),
						rs.getString("Nombre"),
						rs.getByte("Edad"),
						rs.getString("Discografica"),
						rs.getString("Nacionalidad"),
						rs.getByte("NExitos"),
						null
				);
				artista.setCanciones(obtenerCanciones(artista));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
		return artista;
	}

	public ArrayList<Cancion> obtenerCanciones(Artista artista) {
		ArrayList<Cancion> canciones = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM canciones WHERE artista_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, artista.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cancion cancion = new Cancion(
							rs.getInt("id"),
							rs.getString("Nombre"),
							rs.getString("Genero"),
							rs.getBoolean("Exito"),
							rs.getBoolean("Colaboracion"),
							rs.getDate("fecha_salida")
						);
				canciones.add(cancion);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//closeConnection();
		
		return canciones;
	}
	
	@Override
	public void insertar(Artista artista) {
		connection = openConnection();
		
		String query = "insert into artistas (nombre, edad, discografia, nacionalidad, NExitos)"
							+ " values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, artista.getNombre());
			ps.setInt(2, artista.getEdad());
			ps.setString(3, artista.getDiscografica());
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Artista t) {

	}

	@Override
	public void borrar(Artista t) {

	}

	

	
}
