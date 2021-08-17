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

@ApiModel(description = "Información del Alumno")
@Entity
@Table(name="alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@ApiModelProperty(notes = "nombres debe tener al menos 3 caracteres")
	@Size(min = 3, max= 30, message="nombres minimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 30)
	String nombres;
	
	@Size(min = 3, max= 30, message="apellidos minimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 30)
	String apellidos;
	
	@Column(name = "correo", nullable = false, length = 50)
	String correo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}	
	
	
	
}
