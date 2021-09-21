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

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="asignacion_estudiante_curso")
public class AsignacionEstudianteCurso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_asignacion_estudiante_curso;
	
	@ManyToOne
	@JoinColumn(name="id_estudiante", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "asignacionEstudianteCurso"))
	Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name="id_curso", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "asignacionCursoEstudiante"))
	Curso curso;

	public Integer getId() {
		return id_asignacion_estudiante_curso;
	}

	public void setId(Integer id_asignacion_estudiante_curso) {
		this.id_asignacion_estudiante_curso = id_asignacion_estudiante_curso;
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

}
