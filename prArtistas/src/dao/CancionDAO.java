package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.InterfazDao;
import pojo.Artista;
import pojo.Cancion;
/**
 * La clase DAO de Cancion
 * @author asraum
 *
 */
public class CancionDAO extends ObjetoDao implements InterfazDao<Cancion>{

	private static Connection connection;
	
	public CancionDAO() {
		
	}
	
	@Override
	public ArrayList<Cancion> buscarTodos() {
		ArrayList<Cancion> canciones = new ArrayList<>();

		connection = openConnection();

		String query = "SELECT * FROM Canciones";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs_cancion = ps.executeQuery();
			
			while(rs_cancion.next()) {
				Cancion cancion = new Cancion(
						rs_cancion.getInt("id"),
						rs_cancion.getString("Nombre"),
						rs_cancion.getString("Genero"),
						rs_cancion.getBoolean("Exito"),
						rs_cancion.getBoolean("Colaboracion"),
						null
						);
				
				cancion.setAutor(obtenerAutor(cancion));
				canciones.add(cancion);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return canciones;
	}

	@Override
	public Cancion buscarPorId(int id) {
		connection = openConnection();
		
		Cancion cancion = null;
		Artista artista = null;
		
		String query = "select * from canciones where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				cancion = new Cancion(
						rs.getInt("id"),
						rs.getString("Nombre"),
						rs.getString("Genero"),
						rs.getBoolean("Exito"),
						rs.getBoolean("Colaboracion"),
						null
				);
				cancion.setAutor(obtenerAutor(cancion));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
		return cancion;
	}
	
	/**
	 * Metodo que utilizo para sacar el autor de las canciones
	 * @param cancion
	 * @return
	 */
	private Artista obtenerAutor(Cancion cancion) {
		connection = openConnection();
		Artista autor = null;
		int artista_id = 1;
		String query = "SELECT id_artista FROM canciones WHERE id = ?";
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, cancion.getId());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			artista_id = rs.getInt("id_artista");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		query = "SELECT * FROM artistas WHERE id = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, artista_id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				autor = new Artista(
						rs.getString("Nombre"),
						rs.getByte("Edad"),
						rs.getString("Discografica"),
						rs.getString("Nacionalidad"),
						rs.getByte("NExitos")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//closeConnection();
		
		return autor;
	}

	@Override
	public void insertar(Cancion cancion) {
		connection = openConnection();
		
		String query = "insert into canciones (nombre, genero, exito, colaboracion, id_artista)"
				+ " values (?, ?, ?, ?, ? )";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cancion.getNombre());
			ps.setString(2, cancion.getGenero());
			ps.setBoolean(3, cancion.isExito());
			ps.setBoolean(4, cancion.isColaboracion());
			ps.setInt(5, cancion.getAutor().getId()); 
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	@Override
	public void modificar(Cancion cancion) {
		int id = cancion.getId();
		String nombre = cancion.getNombre();
		String genero = cancion.getGenero();
		Boolean exito = cancion.isExito();
		Boolean colaboracion = cancion.isColaboracion();
		
		connection = openConnection();
		
		String query = "UPDATE canciones SET nombre = ?, genero = ?, exito = ?, colaboracion = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, genero);
			ps.setBoolean(3, exito);
			ps.setBoolean(4, colaboracion);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		
	}

	@Override
	public void borrar(Cancion cancion) {
		connection = openConnection();
		
		int id = cancion.getId();
		
		String query = "DELETE FROM canciones WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id); 
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	public void borrarPorArtista(int artista_id) {
		connection = openConnection();
		
		String query = "DELETE FROM canciones WHERE id_artista = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, artista_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	
	
	/**
	 * Metodo para resetear el Auto Increment del id de canciones
	 */
	public void resetAutoIncrement() {
		connection = openConnection();
		
		String query = "alter table canciones AUTO_INCREMENT=1;";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
	}

	/**
	 * Funcion para borrar todos los registros
	 */
	public void borrarTodo() {
		connection = openConnection();
		
		String query1 = "DELETE FROM canciones";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		closeConnection();
		
	}
	
	/**Función que es casi identica a buscar por id, pero cambiando la consulta
	 * por un String (nombre)
	 * 
	 * @param nombre
	 * @return
	 */
	public Cancion buscarPorNombre( String nombre) {
		connection = openConnection();
		
		Cancion cancion = null;
		Artista artista = null;
		
		String query = "select * from canciones where nombre = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				cancion = new Cancion(
						rs.getInt("id"),
						rs.getString("Nombre"),
						rs.getString("Genero"),
						rs.getBoolean("Exito"),
						rs.getBoolean("Colaboracion"),
						null
				);
				cancion.setAutor(obtenerAutor(cancion));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
		return cancion;
	}
	
}
