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

	@ApiModelProperty(notes = "Hora de inicio de la clase en formato de 24 hrs y fecha del 1/1/1997")
	@Column(name = "hora_inicio", nullable = false)
	String hora_inicio;
	
	@ApiModelProperty(notes = "Hora de fin de la clase en formato de 24 hrs 1/1/1997")
	@Column(name = "hora_fin", nullable = false)
	String hora_fin;
	
	@ApiModelProperty(notes = "El día de la semana L,M,X,J,V,S,D")
	@Column(name = "dia", nullable = false, length = 1)
	String dia;
	
	@ApiModelProperty(notes = "La Jornada es M=Matutina y N=Nocturna")
	@Column(name = "jornada", nullable = false, length = 1)
	String jornada;
	
	@ApiModelProperty(notes = "eL Estado del horario esA=Activo e I=Inactivo")
	@Column(columnDefinition = " char(1) not null default 'A' ")
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

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
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
