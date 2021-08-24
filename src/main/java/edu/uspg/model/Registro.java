package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Registro")
@Entity
@Table(name = "registro")

public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_registro;
	
	@ApiModelProperty(notes = "La Jornada es M=Matutina y N=Nocturna")
	@Column(name = "jornada", nullable = false, length = 1)
	String jornada;

	@ManyToOne
	@JoinColumn(name="id_estudiante", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "registroEstudiante"))
	Estudiante estudiante;

	@ManyToOne
	@JoinColumn(name="id_curso", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "registroCurso"))
	Curso curso;
	
	@ApiModelProperty(notes = "La Asistencia del estudiante es P=Presente, T= Tarde, J= Ausencia Justificada y I= Ausencia Injustificada")
	@Column(name = "asistencia_estudiante", nullable = false, length = 1)
	String asistencia_estudiante;

	@ApiModelProperty(notes = "La confirmación del catedratico es P=Presente, T= Tarde, J= Ausencia Justificada y I= Ausencia Injustificada")
	@Column(name = "confirmacion_catedratico", nullable = false, length = 1)
	String confirmacion_catedratico;

	@ApiModelProperty(notes = "La observaciones_catedratico son opcionales")
	@Column(name = "observaciones_catedratico", nullable = true, length = 500)
	String observaciones_catedratico;

	@ApiModelProperty(notes = "La observaciones_estudiante son opcionales")
	@Column(name = "observaciones_estudiante", nullable = true, length = 500)
	String observaciones_estudiante;

	public Integer getId() {
		return id_registro;
	}

	public void setId(Integer id_registro) {
		this.id_registro = id_registro;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getAsistencia_estudiante() {
		return asistencia_estudiante;
	}

	public void setAsistencia_estudiante(String asistencia_estudiante) {
		this.asistencia_estudiante = asistencia_estudiante;
	}

	public String getConfirmacion_catedratico() {
		return confirmacion_catedratico;
	}

	public void setConfirmacion_catedratico(String confirmacion_catedratico) {
		this.confirmacion_catedratico = confirmacion_catedratico;
	}

	public String getObservaciones_catedratico() {
		return observaciones_catedratico;
	}

	public void setObservaciones_catedratico(String observaciones_catedratico) {
		this.observaciones_catedratico = observaciones_catedratico;
	}

	public String getObservaciones_estudiante() {
		return observaciones_estudiante;
	}

	public void setObservaciones_estudiante(String observaciones_estudiante) {
		this.observaciones_estudiante = observaciones_estudiante;
	}
	
}
