package edu.uspg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AsignacionLibroPK.class)
public class AsignacionLibro {

	@Id
	private Asignacion asignacion;
	@Id
	private Libro libro;
	
	
	public Asignacion getAsignacion() {
		return asignacion;
	}
	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	
	
	
}
