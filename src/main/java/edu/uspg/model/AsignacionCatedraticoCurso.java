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
@Table(name="asignacion_catedratico_curso")
public class AsignacionCatedraticoCurso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_asignacion_catedratico_curso;
	
	@ManyToOne
	@JoinColumn(name="id_catedratico", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "asignacionCatedraticoCurso"))
	Catedratico catedratico;
	
	@ManyToOne
	@JoinColumn(name="id_curso", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "asignacionCursoCatedratico"))
	Curso curso;

	public Integer getId() {
		return id_asignacion_catedratico_curso;
	}

	public void setId(Integer id_asignacion_catedratico_curso) {
		this.id_asignacion_catedratico_curso = id_asignacion_catedratico_curso;
	}

	public Catedratico getCatedratico() {
		return catedratico;
	}

	public void setCatedratico(Catedratico catedratico) {
		this.catedratico = catedratico;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}	
}
