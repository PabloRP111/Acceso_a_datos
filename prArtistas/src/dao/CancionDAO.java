package dao;

import java.sql.Connection;
import java.util.ArrayList;

import interfaces.InterfazDao;
import pojo.Cancion;

public class CancionDAO extends ObjetoDao implements InterfazDao<Cancion>{

	private static Connection connection;
	
	public CancionDAO() {
		
	}
	
	@Override
	public ArrayList buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cancion buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Cancion t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Cancion t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Cancion t) {
		// TODO Auto-generated method stub
		
	}

}
