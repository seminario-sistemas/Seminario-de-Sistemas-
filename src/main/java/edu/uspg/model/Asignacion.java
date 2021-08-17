package edu.uspg.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name="asignacion")
public class Asignacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idAsignacion;
	
	@ManyToOne
	@JoinColumn(name="id", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "asignacion_alumno"))
	private Alumno alumno;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha;
	
	@OneToMany(mappedBy="asignacion",
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE,
					CascadeType.REMOVE},
			 fetch = FetchType.LAZY,
			 orphanRemoval = true
			)
	private List<AsignacionDetalle> asignacionDetalle;
	
	

	public Integer getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(Integer idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public List<AsignacionDetalle> getAsignacionDetalle() {
		return asignacionDetalle;
	}

	public void setAsignacionDetalle(List<AsignacionDetalle> asignacionDetalle) {
		this.asignacionDetalle = asignacionDetalle;
	}

	public Integer getId() {
		return idAsignacion;
	}

	public void setId(Integer idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAsignacion == null) ? 0 : idAsignacion.hashCode());
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
		Asignacion other = (Asignacion) obj;
		if (idAsignacion == null) {
			if (other.idAsignacion != null)
				return false;
		} else if (!idAsignacion.equals(other.idAsignacion))
			return false;
		return true;
	}
	
	
	
}
