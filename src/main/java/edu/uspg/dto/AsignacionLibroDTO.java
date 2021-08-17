package edu.uspg.dto;

import java.util.List;

import edu.uspg.model.Asignacion;
import edu.uspg.model.Libro;

public class AsignacionLibroDTO {

	private Asignacion asignacion;
	List<Libro> lstLibros;
	
	
	public Asignacion getAsignacion() {
		return asignacion;
	}
	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
	public List<Libro> getLstLibros() {
		return lstLibros;
	}
	public void setLstLibros(List<Libro> lstLibros) {
		this.lstLibros = lstLibros;
	}

	
	
}
