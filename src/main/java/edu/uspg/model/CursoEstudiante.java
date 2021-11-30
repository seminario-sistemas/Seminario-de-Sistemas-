package edu.uspg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
public class CursoEstudiante {
	@Id
	Integer id_estudiante;
	String estudiante;
	Integer id_curso;
	String curso;
	String dia_semana;
	Integer numero_dia;
	Integer hora_inicio;
	Integer hora_fin;
	Integer id_catedratico;
	String catedratico;
	
	public Integer getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public String getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}
	public Integer getId_curso() {
		return id_curso;
	}
	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDia_semana() {
		return dia_semana;
	}
	public void setDia_semana(String dia_semana) {
		this.dia_semana = dia_semana;
	}
	public Integer getNumero_dia() {
		return numero_dia;
	}
	public void setNumero_dia(Integer numero_dia) {
		this.numero_dia = numero_dia;
	}
	public Integer getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Integer hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Integer getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(Integer hora_fin) {
		this.hora_fin = hora_fin;
	}
	public void setId_catedratico(Integer id_catedratico) {
		this.id_catedratico = id_catedratico;
	}
	public Integer getId_catedratico() {
		return id_catedratico;
	}
	public void setCatedratico(String catedratico) {
		this.catedratico = catedratico;
	}
	public String getCatedratico() {
		return catedratico;
	}
}
