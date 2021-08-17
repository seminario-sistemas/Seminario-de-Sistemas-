package edu.uspg.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="asignacion_detalle")
public class AsignacionDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idAsignacionDetalle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_asignacion", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "asignacionDetalle_asignacion"))
	Asignacion asignacion;
	
	@ManyToOne
	@JoinColumn(name="id_curso", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "asignacionDetalle_curso"))
	Cursos curso;

	
	
	public Asignacion getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}

	public Integer getIdAsignacionDetalle() {
		return idAsignacionDetalle;
	}

	public void setIdAsignacionDetalle(Integer idAsignacionDetalle) {
		this.idAsignacionDetalle = idAsignacionDetalle;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
	
	
	
}
