package edu.uspg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class EstudianteConsulta {
	@Id
	Integer id_estudiante;
	String carnet;
	String correo_personal;
	String dpi;
	String jornada;
	String nombre;
	Integer id_facultad;
	String facultad;
	public Integer getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public String getCorreo_personal() {
		return correo_personal;
	}
	public void setCorreo_personal(String correo_personal) {
		this.correo_personal = correo_personal;
	}
	public String getDpi() {
		return dpi;
	}
	public void setDpi(String dpi) {
		this.dpi = dpi;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId_facultad() {
		return id_facultad;
	}
	public void setId_facultad(Integer id_facultad) {
		this.id_facultad = id_facultad;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
}

