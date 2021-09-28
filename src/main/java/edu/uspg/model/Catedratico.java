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
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Catedratico")
@Entity
@Table(name="catedratico")
public class Catedratico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_catedratico;
	
	@ApiModelProperty(notes = "nombre debe tener al menos 3 caracteres")
	@Size(min = 3, max= 30, message="nombre minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 30)
	String nombre;


	@ApiModelProperty(notes = "El correo debe tener al menos 4")
	@Size(min = 4, max = 75, message = "nombres minimo 4 caracteres")
	@Column(name = "correo_personal", nullable = false, length = 75, unique=true)
	String correo_personal;
	
	@ApiModelProperty(notes = "El dpi tiene 13 digitos")
	@Column(name = "dpi", nullable = false, length = 13)
	String dpi;
	
	@ApiModelProperty(notes = "La Jornada es M=Matutina y N=Nocturna")
	@Column(name = "jornada", nullable = false, length = 1)
	String jornada;

	/*editado en clase*/
	
	@ApiModelProperty(notes = "La Edad del Catedratico es:")
	Integer edad;
	
	@ManyToOne
	@JoinColumn(name="id_facultad", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "jornadaEstudiante"))
	Facultad facultad;
	
	public Integer getId() {
		return id_catedratico;
	}

	public void setId(Integer id_catedratico) {
		this.id_catedratico = id_catedratico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
}
