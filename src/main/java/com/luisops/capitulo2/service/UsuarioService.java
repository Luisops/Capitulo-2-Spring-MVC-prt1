package com.luisops.capitulo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisops.capitulo2.dao.UsuarioDAO;
import com.luisops.capitulo2.model.UsuarioDTO;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public UsuarioDTO validarLogin(UsuarioDTO usuario) {
		return usuarioDAO.validarLogin(usuario);
	}
}
