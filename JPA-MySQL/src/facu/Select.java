package facu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import facu.arqui.Persona;

public class Select {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Persona p1 = em.find(Persona.class, 1);
		//System.out.println(p1);
		
		@SuppressWarnings("unchecked")
		List<Persona> people = em.createQuery("SELECT p1 FROM Persona p1").getResultList();
		people.forEach(p -> System.out.println(p));
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
