package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Usuario")
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_usuario;

	@ApiModelProperty(notes = "Nombre de usuario debe tener al menos 8")
	@Size(min = 8, max = 30, message = "nombres minimo 8 caracteres")
	@Column(name = "usuario", nullable = false, length = 30, unique=true)
	String usuario;

	@ApiModelProperty(notes = "El correo debe tener al menos 4")
	@Size(min = 4, max = 75, message = "nombres minimo 4 caracteres")
	@Column(name = "correo", nullable = false, length = 75, unique=true)
	String correo;

	@ApiModelProperty(notes = "La contraseña debe tener almenos 10 caractere, incluir numeros, minúsculas, mayúsculas y símbolos")
	@Size(min = 10, max = 45, message = "La contraseña debe tener almenos 10 caractere, incluir numeros, minúsculas, mayúsculas y símbolos")
	@Column(name = "clave", nullable = false, length = 45, unique=true)
	String clave;
	
	@ApiModelProperty(notes = "El nuermo de tener 8 digitos y un máximo de 20 digitos")
	@Size(min = 8, max = 20, message = "El numero debe tener al menos 8 digitos")
	@Column(name = "numero_telefono", nullable = false, length = 20)
	String numero_telefono;
	
	@ApiModelProperty(notes = "Este id depende del rol que tenga podría ser un coordinador, estudiante o catedratico")
	@Column(name = "id_rol", nullable = false)
	Integer id_rol;
	
	public Integer getId() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
//ACA EMPEZÓ LA MODIFICACIÓN 
	
	public String getNumero_telefono() {
		return numero_telefono;
	}

	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

}
