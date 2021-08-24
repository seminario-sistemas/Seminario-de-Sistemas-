package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Horario")
@Entity
@Table(name = "horario")
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_horario;

	@ApiModelProperty(notes = "Hora de inicio de la clase en formato de 24 hrs")
	@Column(name = "hora_inicio", nullable = false)
	Integer hora_inicio;

	@ApiModelProperty(notes = "Minuto en que inicia la clase")
	@Column(name = "minuto_inicio", nullable = false)
	Integer minuto_inicio;
	
	@ApiModelProperty(notes = "Hora de fin de la clase en formato de 24 hrs")
	@Column(name = "hora_fin", nullable = false)
	Integer hora_fin;

	@ApiModelProperty(notes = "Minuto en que finaliza la clase")
	@Column(name = "minuto_fin", nullable = false)
	Integer minuto_fin;

	@ApiModelProperty(notes = "El día de la semana L,M,X,J,V,S,D")
	@Column(name = "dia", nullable = false, length = 1)
	String dia;
	
	@ApiModelProperty(notes = "La Jornada es M=Matutina y N=Nocturna")
	@Column(name = "jornada", nullable = false, length = 1)
	String jornada;
	
	@ApiModelProperty(notes = "eL Estado del horario esA=Activo e I=Inactivo")
	@Column(name = "estado", nullable = false, length = 1)
	String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id_horario;
	}

	public void setId(Integer id_horario) {
		this.id_horario = id_horario;
	}

	public Integer getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Integer hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Integer getMinuto_inicio() {
		return minuto_inicio;
	}

	public void setMinuto_inicio(Integer minuto_inicio) {
		this.minuto_inicio = minuto_inicio;
	}

	public Integer getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Integer hora_fin) {
		this.hora_fin = hora_fin;
	}

	public Integer getMinuto_fin() {
		return minuto_fin;
	}

	public void setMinuto_fin(Integer minuto_fin) {
		this.minuto_fin = minuto_fin;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
}
