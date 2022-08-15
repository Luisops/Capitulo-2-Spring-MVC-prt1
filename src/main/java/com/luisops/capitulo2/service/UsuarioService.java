package com.luisops.capitulo2.service;

import java.util.List;

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
	
	public List<UsuarioDTO> getListaUsuarios(){
		return usuarioDAO.getListaUsuarios();
	}
	
	public void insertarUsuario(UsuarioDTO usuario) {
		usuarioDAO.insertarUsuario(usuario);
	}
	
	public void eliminarUsuario(String codigo) {
		usuarioDAO.eliminarUsuario(codigo);
	}
	
	public UsuarioDTO getUsuario(String codigo) {
		return usuarioDAO.getUsuario(codigo);
	}
	
	public void modificarUsuario(UsuarioDTO usuario) {
		usuarioDAO.modificarUsuario(usuario);
	}
}
