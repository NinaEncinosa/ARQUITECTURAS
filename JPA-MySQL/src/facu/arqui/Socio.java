package facu.arqui;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	private Persona persona;
	
	@Column
	private String tipo;

	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Socio(int id, Persona persona, String tipo) {
		super();
		this.id = persona.getId();
		this.persona = persona;
		this.tipo = tipo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Socio [persona=" + persona + ", tipo=" + tipo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
