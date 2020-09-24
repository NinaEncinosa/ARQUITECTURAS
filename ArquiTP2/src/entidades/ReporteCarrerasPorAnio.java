package entidades;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import controller.CarreraController;

public class ReporteCarrerasPorAnio {
	
	private List<ReporteGraduadosCarrerasPorAnio> graduados;
	
	private List<ReporteInscriptosCarrerasPorAnio> inscriptos;
	
	public ReporteCarrerasPorAnio(List<ReporteGraduadosCarrerasPorAnio> graduados,
			List<ReporteInscriptosCarrerasPorAnio> inscriptos) {
		super();
		CarreraController c1 = new CarreraController();
		this.graduados = c1.getGraduadosPorCarrera();
		this.inscriptos = c1.getInscriptosPorCarrera();
	}

	public void getReporte(){ 
		for (ReporteGraduadosCarrerasPorAnio object : graduados) {
			graduados.add(object);
		}
	}
	
	//funcion de mergear las listas
	
//	System.out.println("");
//	System.out.println("Carreras ordenadas alfabeticamente y por anio, traer su cantidad de inscriptos");
//	List<ReporteInscriptosCarrerasPorAnio> lista2= c1.getInscriptosPorCarrera();
//	for (ReporteInscriptosCarrerasPorAnio object : lista2) {
//		System.out.println(object);
//	}

}

