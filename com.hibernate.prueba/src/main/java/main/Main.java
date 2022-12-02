package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import pojo.Animales;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session =HibernateUtil.getSessionFactory().openSession();
		
		/*Animal a1 = new Animal("HomoSapiens","La decadendia y el Nihilismo",new BigDecimal(1));
		session.save(a1);
		
		int id =1;
		
		Animal a = (Animal) session.get(Animal.class, id);
		
		System.out.println(a.getNombre());
	
		*/
		String hql = "FROME Animales WHERE habitat =:habita";
		Query query = session.createQuery(hql);
		query.setParameter("habitat","Bosque");
		
		
		Animales a1 = new Animales("Kuokka","Jungla",new BigDecimal(2));
		
		List animales = session.createQuery("FROM Animal").getResultList();
		
		for(Iterator i =animales.iterator();i.hasNext();) {
			Animales a =(Animales) i.next();
			System.out.println(a.getNombre());
		}
		
		session.close();
	}

}
