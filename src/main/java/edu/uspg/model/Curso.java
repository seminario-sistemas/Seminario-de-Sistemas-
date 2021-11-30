package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Curso")
@Entity
@Table(name = "curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_curso;

	@ApiModelProperty(notes = "Nombre de curso debe tener al menos 8")
	@Size(min = 8, max = 50, message = "nombres minimo 8 caracteres")
	@Column(name = "nombre", nullable = false, length = 50)
	String nombre;
	
	@ApiModelProperty(notes = "Es el código de classroom")
	@Column(name = "codigo", nullable = false, unique=true)
	String codigo;
	
	@ApiModelProperty(notes = "La Sección es una letra del abecedario")
	@Column(name = "seccion", nullable = false, length = 1)
	String seccion;
	
	@ApiModelProperty(notes = "La Sala es el url de la sala de meet")
	@Column(name = "sala", nullable = false, length = 75)
	String sala;
	
	@ApiModelProperty(notes = "Cantidad de sesiones del curso")
	@Column(name = "sesiones", nullable = false)
	Integer sesiones;
	
	public Integer getId() {
		return id_curso;
	}

	public void setId(Integer id_curso) {
		this.id_curso = id_curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Integer getSesiones() {
		return sesiones;
	}

	public void setSesiones(Integer sesiones) {
		this.sesiones = sesiones;
	}

}
