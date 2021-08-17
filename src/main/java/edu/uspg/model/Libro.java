package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idLibro;
	
	@Column(name = "nombre",
			nullable = false,
			length = 50)
	String nombre;

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLibro == null) ? 0 : idLibro.hashCode());
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
		Libro other = (Libro) obj;
		if (idLibro == null) {
			if (other.idLibro != null)
				return false;
		} else if (!idLibro.equals(other.idLibro))
			return false;
		return true;
	}
	
	
	
	
}
