package controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.Estudiante;


public class EstudianteController  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf = null;
	//private EntityManager em = null;

	public EstudianteController() {
		this.emf = Persistence.createEntityManagerFactory("Example");
		//this.em = emf.createEntityManager();
	}

	public Estudiante getEstudianteDNI(int dni) {
		EntityManager em = emf.createEntityManager();
		// el select devuelve un listado por mas q sea uno
		List<Estudiante> listado = em.createQuery("SELECT E FROM Estudiante E WHERE E.dni =:dni ", Estudiante.class)
				.setParameter("dni", dni).getResultList();
		if (listado.size() == 0) {// no existe el estudiante
			return null;
		} else {
			return listado.get(0);
		}
	}

	public void insert(Estudiante estudiante) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			if (this.getEstudianteDNI(estudiante.getDni()) != null) {
				System.out.println("Ya se encuentra el estudiante con el DNI: " + estudiante.getDni());
			} else {
				em.getTransaction().begin();
				em.persist(estudiante);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
