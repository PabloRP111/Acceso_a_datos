package pojo;

import java.util.ArrayList;
/**
 * El pojo artistas, tine lo tipico de los pollos los getters, los setters y un toString
 * @author asraum
 *
 */
public class Artista {
	//Creo que los nombres de las variables son muy autodescriptivos como para explicar que representan
	private int id;
	private String nombre;
	private byte edad;
	private String discografica;
	private String nacionalidad;
	private byte nExitos;
	private ArrayList<Cancion> canciones;
	
	public Artista(int id, String nombre, byte edad, String discografica, String nacionalidad, byte nExitos,
			ArrayList<Cancion> canciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.discografica = discografica;
		this.nacionalidad = nacionalidad;
		this.nExitos = nExitos;
		this.canciones = canciones;
	}

	public Artista(String nombre, byte edad, String discografica, String nacionalidad, byte nExitos) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.discografica = discografica;
		this.nacionalidad = nacionalidad;
		this.nExitos = nExitos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public String getDiscografica() {
		return discografica;
	}

	public void setDiscografica(String discografica) {
		this.discografica = discografica;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public byte getnExitos() {
		return nExitos;
	}

	public void setnExitos(byte nExitos) {
		this.nExitos = nExitos;
	}

	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public String toString() {
		return "\n\tid=" + id + ", \n\t nombre=" + nombre + ", \n\t edad=" + edad + ", \n\t discografica=" + discografica
				+ ", \n\t nacionalidad=" + nacionalidad + ",\n\t nExitos=" + nExitos + ", \n\t canciones=" + canciones +"\n\n";
	}
	
	
	
	
}
