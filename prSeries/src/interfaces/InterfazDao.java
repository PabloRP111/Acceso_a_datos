package interfaces;

import java.util.ArrayList;


import pojo.Serie;

public interface InterfazDao<T> {

	/**
	 * Muestra todos los objetos t de la base de datos
	 * 
	 * @return un ArrayList de objetos
	 */
	
	public ArrayList <T> buscarTodos();
	/**
	 * Muestra el objeto T con el id especificado
	 * @param i  el id del objecto T
	 * @return devuelve un objeto T
	 */
	
	Serie buscarPorId(int i);
	/**
	 *Busca el objeto T recibido en la base de datos
	 * 
	 * @param t un objeto T
	 */
	
	public void insertar(T t);
	/**
	 *Inserta el objeto T recibido en la base de datos
	 * 
	 * @param t un objeto T
	 */
	
	public void modificar(T t);
	/**
	 *Actualiza el objeto T en la base de datos
	 * 
	 * @param t un objeto T
	 */
	
	public void borrar(T t);
	/**
	 *Borra el objeto T en la base de datos
	 * 
	 * @param t un objeto T
	 */

	
	
}
