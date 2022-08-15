package com.luisops.capitulo2.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UsuarioDTO {

	@Size(min=3, max = 20)
	private String usuario;
	
	@NotNull
	@NotBlank
	private String clave;
	private String nombreCompleto;
	private byte[] foto;
	
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}	
	public UsuarioDTO(String usuario, String clave, String nombreCompleto) {
		this.usuario = usuario;
		this.clave = clave;
		this.nombreCompleto = nombreCompleto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}
