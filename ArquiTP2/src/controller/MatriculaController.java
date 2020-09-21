package controller;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Carrera;
import entidades.Matricula;

public class MatriculaController  implements Serializable {

	private static final long serialVersionUID = -6284052128342094661L;
	
	private EntityManagerFactory emf = null;
	
	public MatriculaController() {
		this.emf = Persistence.createEntityManagerFactory("Example");
	}

	public void insert(Matricula matricula) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			if (this.getMatricula(matricula) != null) {
				System.out.println("Ya se encuentra inscripto en la carrera: " + matricula.getCarrera().getNombre_carrera());
			} else {
				em.getTransaction().begin();
				em.persist(matricula);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Fijar que no se haya creado la matricula. Controlar:id estudiante, id carrera
	public Matricula getMatricula(Matricula matricula) {
		EntityManager em = emf.createEntityManager();
		List<Matricula> listado = em
				.createQuery("SELECT M FROM Matricula M WHERE M.id_estudiante =:id_estudiante AND M.id_carrera =:id_carrera ", Matricula.class)
				.setParameter("id_estudiante", matricula.getEstudiante().getLegajo())
				.setParameter("id_carrera", matricula.getCarrera().getId_Carrera()).getResultList();
		if (listado.size() == 0) {
			return null;
		} else {
			return listado.get(0);
		}
	}
	
}