package tp2;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estudiante {
	@Id
	private int legajo;
	
	private int dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "legajo","id_carrera");
	private List <SIU_guarani> matricula = new ArrayList <SIU_guarani> ();
	
	
	
	
}
