package edu.uspg.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="asignacion_horario_curso")
public class AsignacionHorarioCurso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_asignacion_horario_curso;
	
	@ManyToOne
	@JoinColumn(name="id_horario", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "asignacionHorarioCurso"))
	Horario horario;
	
	@ManyToOne
	@JoinColumn(name="id_curso", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "asignacionCursoHorario"))
	Curso curso;

	public Integer getId() {
		return id_asignacion_horario_curso;
	}

	public void setId(Integer id_asignacion_horario_curso) {
		this.id_asignacion_horario_curso = id_asignacion_horario_curso;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}	
}
