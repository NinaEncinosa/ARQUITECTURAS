import controller.EstudianteController;
import entidades.Carrera;
import entidades.Estudiante;

public class Insert {

	public Insert() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// CARRERAS
		Carrera c1 = new Carrera(1, "Tudai");
		Carrera c2 = new Carrera(2, "Sistemas");
		
		
// ESTUDIANTES

		Estudiante e1 = new Estudiante(1, "Tere", "Hsieh", 23, "F", 11, "Tandil");
		Estudiante e2 = new Estudiante(2, "Nina", "Encinosa", 23, "F", 123, "Tandil");
		Estudiante e3 = new Estudiante(3, "Fede", "Fuhr", 23, "M", 234, "Tandil");
		Estudiante e4 = new Estudiante(4, "Martin", "Massimo", 23, "M", 345, "Tandil");

		EstudianteController estudiantes = new EstudianteController();
//		estudiantes.insert(e1);
//		estudiantes.insert(e2);
//		estudiantes.insert(e3);
//		estudiantes.insert(e4);
		
		
		System.out.println(estudiantes.getEstudianteDNI(123));

	}

}
