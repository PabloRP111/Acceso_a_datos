package pojo;
// Generated 2 dic 2022 14:25:06 by Hibernate Tools 5.5.9.Final

import java.math.BigDecimal;

/**
 * Animales generated by hbm2java
 */
public class Animales implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private String habitad;
	private BigDecimal pesoAprox;

	public Animales() {
	}

	public Animales(String nombre, String habitad, BigDecimal pesoAprox) {
		this.nombre = nombre;
		this.habitad = habitad;
		this.pesoAprox = pesoAprox;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHabitad() {
		return this.habitad;
	}

	public void setHabitad(String habitad) {
		this.habitad = habitad;
	}

	public BigDecimal getPesoAprox() {
		return this.pesoAprox;
	}

	public void setPesoAprox(BigDecimal pesoAprox) {
		this.pesoAprox = pesoAprox;
	}

}
