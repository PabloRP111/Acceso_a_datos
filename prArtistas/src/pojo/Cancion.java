package pojo;

import java.time.LocalDate;
import java.util.Date;

public class Cancion {
	
	private int id;
	private String nombre;
	private String genero;
	private boolean exito;
	private boolean colaboracion;
	private Date fecha_salida;
	private Artista autor;
	
	public Cancion(int id, String nombre, String genero, boolean exito, boolean colaboracion, Date fecha_salida,
			Artista autor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.exito = exito;
		this.colaboracion = colaboracion;
		this.fecha_salida = fecha_salida;
		this.autor = autor;
	}

	public Cancion(String nombre, String genero, boolean exito, boolean colaboracion, Date fecha_salida) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.exito = exito;
		this.colaboracion = colaboracion;
		this.fecha_salida = fecha_salida;
	}

	public Cancion(int int1, String string, String string2, boolean boolean1, boolean boolean2, java.sql.Date date) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.exito = exito;
		this.colaboracion = colaboracion;
		this.fecha_salida = fecha_salida;
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

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public Artista getAutor() {
		return autor;
	}

	public void setAutor(Artista autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Cancion: \nid=" + id + ", nombre=" + nombre + ", genero=" + genero + ", exito=" + exito
				+ ", colaboracion=" + colaboracion + ", fecha_salida=" + fecha_salida + ", autor=" + autor;
	}

	
	
	
	
	
	}
