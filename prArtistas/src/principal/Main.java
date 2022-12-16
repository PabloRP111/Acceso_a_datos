package principal;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

import dao.ArtistaDAO;
import dao.CancionDAO;
import pojo.Artista;
import pojo.Cancion;

public class Main {

	public static void main(String[] args) {
		
		ArtistaDAO artistaDao = new ArtistaDAO();
		CancionDAO cancionDao = new CancionDAO();
		
		//Creamos artistas
		Artista artista1 = new Artista(1,"Mickel Jackson",(byte) 52, "SONY RECORDS", "Estadounidense", (byte)30, null);
		Artista artista2 = new Artista(2,"Dellaosa",(byte) 29, "Space Hammurabi", "Español", (byte)3, null);
		Artista artista3 = new Artista(3,"The beatles",(byte) 29, "Warner", "Ingleses", (byte)40, null);
		
		////Creamos canciones
		Cancion cancion1 = new Cancion(1,"La placita", "Rap", true, false, artista2);
		Cancion cancion2 = new Cancion(2,"Come Together", "Rock", true, false, artista3);
		Cancion cancion3 = new Cancion(3,"Beat It", "Pop", true, false, artista1);
		Cancion cancion4 = new Cancion(4,"Veneno", "Rap", true, true, artista2);
		
		//Borramos todos los datos anteriores usando la clave foranea
		artistaDao.borrar(artista1);
		artistaDao.borrar(artista2);
		artistaDao.borrar(artista3);
		System.out.println("Datos antiguos borrados");
		
		//Reseteamos el AutoIncremente del id
		artistaDao.resetAutoIncrement();
		cancionDao.resetAutoIncrement();
		
		//Hacemos los inserts
		artistaDao.insertar(artista1);
		artistaDao.insertar(artista2);
		artistaDao.insertar(artista3);
		
		cancionDao.insertar(cancion1);
		cancionDao.insertar(cancion2);
		cancionDao.insertar(cancion3);
		cancionDao.insertar(cancion4);
		System.out.println("Inserts Realizados con Exito");
		
		//Imprimo Todo los artistas
		System.out.println("\nLos Artistas son:");
		System.out.println(artistaDao.buscarTodos());
		
		//Imprimo Todo las canciones
		System.out.println("\n Las Canciones son:");
		System.out.println(cancionDao.buscarTodos());
		
		//Imprimo el artista1
		System.out.println("\nEl artista de id 1 es:");
		System.out.println(artistaDao.buscarPorId(1));
		//Modifico al artista1, si pusiera id 2 cambiaría el 2
		System.out.println("\nModificacion artista1");
		Artista artistaNuevo = new Artista(1,"Fredi Mercury",(byte) 52, "Universal", "Estadounidense", (byte)35, null);
		artistaDao.modificar(artistaNuevo);
		System.out.println("\nEl artista de id 1 es:");
		System.out.println(artistaDao.buscarPorId(1));
		
		//Imprimo la cancion1
		System.out.println("\nLa cancion de id 1 es:");
		System.out.println(cancionDao.buscarPorId(1));
		//Modifico la canción1, si pusiera id 2 cambiaría la 2
		System.out.println("\nModificacion cancion 1:");
		Cancion cancionNueva = new Cancion(1,"Nightmers", "Rap", true, true, artista2);
		cancionDao.modificar(cancionNueva);
		System.out.println("\nLa cancion de id 1 es:");
		System.out.println(cancionDao.buscarPorId(1));
		
		//Buscar por nombre artista
		System.out.println("\nBuscar por nombre Artista:");
		System.out.println(artistaDao.buscarPorNombre("Dellaosa"));
		
		//Buscar por nombre artista
		System.out.println("\nBuscar por nombre Cancion:");
		System.out.println(cancionDao.buscarPorNombre("Come Together"));
		
		//cancionDao.borrarTodo();
		//artistaDao.borrarTodo();

		
	}

}
