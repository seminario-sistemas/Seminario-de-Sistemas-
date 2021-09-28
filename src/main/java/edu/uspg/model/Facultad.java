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

@ApiModel(description = "Información del Facultad")
@Entity
@Table(name="facultad")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_facultad;
	
	@ApiModelProperty(notes = "El nombre de la facultad debe tener como mínimo 10 caracteres")
	@Size(min = 10, max= 45, message="El nombre de la facultad debe tener como mínimo 10 caracteres")
	@Column(name = "nombre", nullable = false, length = 45, unique=true)
	String nombre;
	
	public Integer getId() {
		return id_facultad;
	}
	public void setId(Integer id_facultad) {
		this.id_facultad = id_facultad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
