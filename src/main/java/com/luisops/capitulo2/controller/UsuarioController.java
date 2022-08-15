package com.luisops.capitulo2.controller;

//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
			mv = new ModelAndView("usuarioLista", "lista",usuarioServicio.getListaUsuarios());
		}
		return mv;
	}
	
	@RequestMapping("usuarioCrear")
	public ModelAndView crearUsuario() {
		return new ModelAndView("usuarioDatos","usuarioBean", new UsuarioDTO());
	}
	
	@RequestMapping("usuarioGrabar")
	public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean") UsuarioDTO usuario, 
			BindingResult resulta){
		ModelAndView mv= null;
		if(resulta.hasErrors()) {
			mv= new ModelAndView("usuarioDatos","usuarioBean",usuario);
		}
		else {
			usuarioServicio.insertarUsuario(usuario);
			mv = new ModelAndView("usuarioLista", "lista",usuarioServicio.getListaUsuarios());
		}
		
		return mv;
	}	
	
}
