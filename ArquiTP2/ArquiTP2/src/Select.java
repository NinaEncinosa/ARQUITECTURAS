import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.CarreraController;
import controller.EstudianteController;
import controller.MatriculaController;
import entidades.Carrera;
import entidades.Estudiante;
import entidades.InfoCarrera;
import entidades.ReporteCarrerasPorAnio;
import entidades.ReporteGraduadosCarrerasPorAnio;
import entidades.ReporteInscriptosCarrerasPorAnio;

public class Select {

	public Select() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		EstudianteController estudiantes = new EstudianteController();
		MatriculaController matricula = new MatriculaController();
		CarreraController carreras = new CarreraController();
		
		/*
		 * C) Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
		 */
		
		System.out.println("");
		System.out.println("C) Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.");
		for (Estudiante estu : estudiantes.getEstudiantesSortDNI()) {
			System.out.println(estu);
		}

		/*
		 * D) Recuperar un estudiante, en base a su número de libreta universitaria. 
		 */
		
		System.out.println("");
		System.out.println("D) Recuperar un estudiante, en base a su número de libreta universitaria.");
		Estudiante e1 = estudiantes.getEstudianteLegajo(1);
		System.out.println(e1);
		
		/*
		 * E) Recuperar todos los estudiantes, en base a su género.
		 */
		
		System.out.println("");
		System.out.println("E) Recuperar todos los estudiantes, en base a su género.");
		String genero = "Masculino";
		System.out.println("Estudiantes de genero " + genero);
		for (Estudiante estu1 : estudiantes.getEstudianteGenero(genero)) {
			System.out.println(estu1);
		}
		
		/*
		 * F) Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
		 */
		System.out.println("");
		System.out.println("F) Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.");
		for (Carrera carrera : carreras.getCarrerasPorInscriptos()) {
		System.out.println(carrera);
		}
		
		/*
		 * G) Recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
		 */
		System.out.println("");
		System.out.println("G) Recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia");
		String carrera = "Sistemas";
		String residencia = "Caldera";
		System.out.println("Busqueda en ciudad de residencia '" + residencia +"' estudiantes que cursen '"+ carrera +"' :");
		System.out.println("");
		//System.out.println("Estudiante de " + residencia + "que estudia en " + carrera);
		for (Estudiante estudiante : estudiantes.getEstudiantesCarreraResidencia(carrera, residencia)) {
			System.out.println(estudiante);
		}
		
		/*
		 * Generar un reporte de las carreras, que para cada carrera incluya información de los
		   inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
		   los años de manera cronológica.
		 */
		System.out.println("");
		System.out.println("3) Generar un reporte de las carreras, que para cada carrera incluya información de los\r\n" + 
				" inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar\r\n" + 
				" los años de manera cronológica");
		CarreraController c1 = new CarreraController();
		List<ReporteGraduadosCarrerasPorAnio> lista= c1.getGraduadosPorCarrera();
		List<ReporteInscriptosCarrerasPorAnio> lista2= c1.getInscriptosPorCarrera();
		ReporteCarrerasPorAnio r = new ReporteCarrerasPorAnio(lista,lista2);
		
		List<InfoCarrera> report = r.getReporte();
		for (InfoCarrera object : report) {
			System.out.println(object);
		}
			
		
	}
}
