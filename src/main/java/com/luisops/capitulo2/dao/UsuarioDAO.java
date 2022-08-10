package com.luisops.capitulo2.dao;

import org.springframework.stereotype.Repository;

import com.luisops.capitulo2.model.UsuarioDTO;

@Repository
public class UsuarioDAO {

	public UsuarioDTO validarLogin(UsuarioDTO usuario) {
		if(usuario.getUsuario().equalsIgnoreCase("user") && usuario.getClave().equals("12345")) {
			usuario.setNombreCompleto("Nombre completo del usuario");
		}else {
			usuario = null;
		}
		return usuario;
	}
}
