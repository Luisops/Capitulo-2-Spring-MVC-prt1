package com.luisops.capitulo2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luisops.capitulo2.model.UsuarioDTO;
import com.luisops.capitulo2.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioServicio;
	
	@RequestMapping("loginMostrar")
	public String loginMostrar(){
		return "login";
	}
	
	/*POR METODO request.getParameterT
	 * @RequestMapping("loginAccion") 
	 * public ModelAndView loginAccion(HttpServletRequest request) {
	 * ModelAndView mv = new ModelAndView(); UsuarioDTO usuarioValida = new UsuarioDTO();
	 * usuarioValida.setUsuario(request.getParameter("txtUsuario"));
	 * usuarioValida.setClave(request.getParameter("txtClave"));
	 * UsuarioDTO ue = usuarioServicio.validarLogin(usuarioValida); 
	 * if(ue == null) 
	 * { mv = new ModelAndView("login", "msgError", "Usuario y clave no existe. Vuelva a intentar!"); 
	 * }else 
	 * { mv = new ModelAndView("saludo", "mensaje","Bienvenido"+ ue.getNombreCompleto()); }
	 * return mv; 
	 * }
	 */

	//Data Binding
	@RequestMapping("loginAccion")
	public ModelAndView loginAccion(UsuarioDTO usuarioValida) {
		ModelAndView mv = new ModelAndView();
		
		UsuarioDTO ue = usuarioServicio.validarLogin(usuarioValida);
		if(ue == null) {
			mv = new ModelAndView("login", "msgError", "Usuario y clave no existe. Vuelva a intentar!");
		}else {
			mv = new ModelAndView("saludo", "mensaje","Bienvenido"+  ue.getNombreCompleto());
		}
		return mv;
	}
	
}
