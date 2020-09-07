package facu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import facu.arqui.Direccion;
import facu.arqui.Persona;


public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Direccion d = new Direccion ("Tandil","Chacabuco");
		em.persist(d);
		Persona p1 =  new Persona(1,"Nina",23,d);
		Persona p2 =  new Persona(2,"Pepe",34,d);
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
