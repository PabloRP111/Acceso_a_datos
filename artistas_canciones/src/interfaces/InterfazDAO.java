package interfaces;

import java.util.ArrayList;
import pojos.Canciones;
import pojos.Artistas;

public interface InterfazDAO<T> {
	public ArrayList <T> buscarTodos();
	/**
	 * Muestra el objeto T con el id especificado
	 * @param i  el id del objecto T
	 * @return devuelve un objeto T
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
	
	Artistas buscarPorId(int i);
	/**
	 *Busca el objeto T recibido en la base de datos
	 * 
	 * @param t un objeto T
	 */
	
	public void borrar(T t);
	/**Busca el objeto T y lo borra en la base de datos
	 * 
	 * @param t un objeto
	 */
	
}
