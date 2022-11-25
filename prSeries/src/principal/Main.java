package principal;

import java.util.ArrayList;

import pojo.Serie;
import pojo.SerieDAO;
import pojo.Temporada;
import pojo.TemporadaDao;

public class Main {

	public static void main(String[] args) {
		
		Serie serie1 = new Serie("Los Simpsons",7,"DisneyPlus");
		
		Serie serie2= new Serie("The Mandalorian",16,"DisneyPlus");
		SerieDAO serieDao = new SerieDAO(); 
		//serieDao.insertar(serie2);
		System.out.println(serieDao.buscarPorId(1));
		
		//Serie aux que hace referencia a la serie 1 de la base de datos 
		Serie serieB= serieDao.buscarPorId(1);
		
		Temporada t1= new Temporada(1,"Primera Temporada",serieB);
		Temporada t2= new Temporada(2,"Segunda Temporada",serieB);
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);
		System.out.println(t1);
		
		ArrayList<Serie> series = serieDao.buscarTodos();
		
		serie1.setPlataforma("Netflix");
		serieDao.modificar(serie2);
		
		/*
		for(int i=0; i<series.size();i++) {
			System.out.println(series.get(i));
		}
		*/
		//For each
		for(Serie serie: series) {
			System.out.println(serie.getTitulo());
		}
		
		ArrayList<Temporada> temporadas = new ArrayList<>();
		temporadas = serieDao.obtenerTemporadas(serieB);
		
		for(Temporada temporada: temporadas) {
			System.out.println(temporada.getTitulo());
		}
		
		
		Serie m = serieDao.buscarPorId(3);
		
		
		
		
		
		
		
	}

}
