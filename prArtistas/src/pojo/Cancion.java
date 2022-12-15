package pojo;

import java.time.LocalDate;
import java.util.Date;
/**
 * El pojo cancion, tine lo tipico de los pollos los getters, los setters y un toString
 * @author asraum
 *
 */
public class Cancion {
	//Creo que los nombres de las variables son muy autodescriptivos como para explicar que representan
	private int id;
	private String nombre;
	private String genero;
	private boolean exito;
	private boolean colaboracion;
	private Artista autor;
	
	public Cancion(int id, String nombre, String genero, boolean exito, boolean colaboracion, 
			Artista autor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.exito = exito;
		this.colaboracion = colaboracion;
		this.autor = autor;
	}

	public Cancion(String nombre, String genero, boolean exito, boolean colaboracion) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.exito = exito;
		this.colaboracion = colaboracion;
	}

	public Cancion(int id, String nombre, String genero, boolean exito, boolean colaboracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.exito = exito;
		this.colaboracion = colaboracion;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isExito() {
		return exito;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}

	public boolean isColaboracion() {
		return colaboracion;
	}

	public void setColaboracion(boolean colaboracion) {
		this.colaboracion = colaboracion;
	}


	public Artista getAutor() {
		return autor;
	}

	public void setAutor(Artista autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "\n\tid=" + id + ", \n\t nombre=" + nombre + ", \n\t genero=" + genero + ", \n\t exito=" + exito
				+ ", \n\t colaboracion=" + colaboracion + ", \n\t autor=" + autor.getNombre();
	}

	
	
	
	
	
	}
