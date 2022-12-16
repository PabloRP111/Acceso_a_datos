package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.InterfazDao;
import pojo.Artista;
import pojo.Cancion;

/**
 * La clase DAO de Artista
 * @author asraum
 *
 */
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
				
				String query_canciones = "select * from canciones where id_artista = ?";
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
								artista
								
					);
					canciones.add(cancion);
				}
				artista.setCanciones(canciones);
				
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
		
		String query = "select * from artistas where id = ?";
		
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
			e.printStackTrace();
		}
		
		closeConnection();
		
		return artista;
	}

	/**
	 * Metodo que utilizo para sacar las canciones de los Artistas
	 * @param artista un objeto de Artista
	 * @return
	 */
	
	public ArrayList<Cancion> obtenerCanciones(Artista artista) {
		ArrayList<Cancion> canciones = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM canciones WHERE id_artista = ?";
		
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
							artista
						);
				canciones.add(cancion);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//closeConnection();
		
		return canciones;
	}
	
	@Override
	public void insertar(Artista artista) {
		connection = openConnection();
		
		String query = "insert into artistas (nombre, edad, discografica, nacionalidad, NExitos)"
							+ " values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, artista.getNombre());
			ps.setInt(2, artista.getEdad());
			ps.setString(3, artista.getDiscografica());
			ps.setString(4, artista.getNacionalidad());
			ps.setInt(5, artista.getnExitos());
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Artista artista) {
		int id = artista.getId();
		String nombre = artista.getNombre();
		int edad = artista.getEdad();
		String discografica = artista.getDiscografica();
		String nacionalidad = artista.getNacionalidad();
		Byte nExitos = artista.getEdad();
		
		connection = openConnection();
		
		String query = "UPDATE artistas SET nombre = ?, edad = ?, discografica = ?, nacionalidad = ?, nExitos = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setInt(2, edad);
			ps.setString(3, discografica);
			ps.setString(4, nacionalidad);
			ps.setByte(5, nExitos);
			ps.setInt(6, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void borrar(Artista artista) {
		int artista_id = artista.getId();
		
		CancionDAO CancionDao = new CancionDAO();
		CancionDao.borrarPorArtista(artista_id); 
		
		connection = openConnection();
		
		String query = "DELETE FROM artistas WHERE id = ?";
		
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
	 * Metodo para resetear el Auto Increment del id de artistas
	 */
	public void resetAutoIncrement() {
		connection = openConnection();
		
		String query = "alter table artistas AUTO_INCREMENT=1;";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	/**
	 * Funcion para borrar todos lor registros
	 */
	public void borrarTodo() {
		connection = openConnection();
		
		
		String query2 = "DELETE FROM artistas";
		
		/*
		String query1 = "DELETE FROM canciones";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		try {
			PreparedStatement ps = connection.prepareStatement(query2);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	/**
	 * Funcion que funciona prácticamente igual que buscar por id, pero pasandole 
	 * en la consulta el nombre en vez del id
	 * @param nombre
	 * @return
	 */
	public Artista buscarPorNombre(String nombre) {
		connection = openConnection();
		
		Artista artista = null;
		
		String query = "select * from artistas where nombre = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
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
			e.printStackTrace();
		}

		closeConnection();
		
		return artista;
	}
	
}
