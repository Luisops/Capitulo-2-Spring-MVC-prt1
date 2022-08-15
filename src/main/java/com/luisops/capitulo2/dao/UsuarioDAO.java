package com.luisops.capitulo2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.luisops.capitulo2.model.UsuarioDTO;

@Repository
public class UsuarioDAO {

	private List<UsuarioDTO> listaUsuarios;
	
	public UsuarioDAO() {
		listaUsuarios = new ArrayList<>();
		listaUsuarios.add(new UsuarioDTO("Jose", "1235", "Jose Perez"));
		listaUsuarios.add(new UsuarioDTO("Juan", "1235", "Juan Perez"));
		listaUsuarios.add(new UsuarioDTO("Carlo", "1235", "Carlo Perez"));	
	}
	
	
	
	public List<UsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}

	public void insertarUsuario(UsuarioDTO usuario) {
		listaUsuarios.add(usuario);
	}


	public UsuarioDTO validarLogin(UsuarioDTO usuario) {
		if(usuario.getUsuario().equalsIgnoreCase("user") && usuario.getClave().equals("12345")) {
			usuario.setNombreCompleto("Nombre completo del usuario");
		}else {
			usuario = null;
		}
		return usuario;
	}
	
	public void eliminarUsuario(String codigo) {
		for(int i = 0; i < listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i).getUsuario().equalsIgnoreCase(codigo)) {
				listaUsuarios.remove(i);
				break;
			}
		}
	}
	
	public UsuarioDTO getUsuario(String codigo) {
		UsuarioDTO rpta = null;
			for(UsuarioDTO usuario: listaUsuarios) {
				if(usuario.getUsuario().equalsIgnoreCase(codigo)) {
					rpta = usuario;
					break;
				}
			}
		return rpta;
	}
	
	public void modificarUsuario(UsuarioDTO usuario) {
		for(UsuarioDTO listaUsuario: listaUsuarios) {
			if(listaUsuario.getUsuario().equalsIgnoreCase(usuario.getUsuario())) {
				listaUsuario.setClave(usuario.getClave());
				listaUsuario.setNombreCompleto(usuario.getNombreCompleto());
			}
		}
	}
	
}
