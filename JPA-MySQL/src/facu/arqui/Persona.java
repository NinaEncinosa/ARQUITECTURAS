package facu.arqui;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Persona {
	@Id
	private int id;
	@Column (nullable = false)
	private String name;
	@Column (name = "age")
	private int age;
	@ManyToOne
	private Direccion adress;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "jugadores")
	private List<Turno> turnos;

	public Persona() {
		super();
	}

	public Persona(int id, String name, int age, Direccion adress) {
		super();
		this.id =  id;
		this.name = name;
		this.age = age;
		this.adress = adress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Direccion getAdress() {
		return adress;
	}

	public void setAdress(Direccion adress) {
		this.adress = adress;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + ", age=" + age + ", adress=" + adress + "]";
	}
	
	
	
}
