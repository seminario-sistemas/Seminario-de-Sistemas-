package edu.uspg.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AsignacionLibroPK implements Serializable{

	@ManyToOne
	@JoinColumn(name = "id_asignacion")
	private Asignacion asignacion;
	
	@ManyToOne
	@JoinColumn(name = "id_libro")
	private Libro libro;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignacion == null) ? 0 : asignacion.hashCode());
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignacionLibroPK other = (AsignacionLibroPK) obj;
		if (asignacion == null) {
			if (other.asignacion != null)
				return false;
		} else if (!asignacion.equals(other.asignacion))
			return false;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		return true;
	}
	
	//objetoA -> 1
	//objetoB -> 1
	//objetoA == objetoB | true | false
	
	
	
}
