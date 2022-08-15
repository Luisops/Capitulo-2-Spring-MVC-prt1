package com.luisops.capitulo2.controller;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.luisops.capitulo2.model.UsuarioDTO;
import com.luisops.capitulo2.service.UsuarioService;

@Controller
@SessionAttributes("contador")
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
			mv.addObject("contador", 0);
		}
		return mv;
	}
	
	@RequestMapping("usuarioCrear")
	public ModelAndView crearUsuario() {
		ModelAndView mv = new ModelAndView("usuarioDatos","usuarioBean", new UsuarioDTO());
		mv.addObject("accion", "Insertar");
		return mv;
	}
	
	@RequestMapping("usuarioGrabar")
	public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean") UsuarioDTO usuario, 
			BindingResult resulta,ModelMap modelo, @RequestParam("accion") String accion){
		ModelAndView mv= null;
		if(resulta.hasErrors()) {
			mv= new ModelAndView("usuarioDatos","usuarioBean",usuario);
		}
		else {
			mv = new ModelAndView("usuarioLista", "lista",usuarioServicio.getListaUsuarios());
			if(accion.equalsIgnoreCase("Insertar")) {
				usuarioServicio.insertarUsuario(usuario);
				int contador = (int)modelo.get("contador");
				contador++;
				mv.addObject("contador",contador);
			}else {
				usuarioServicio.modificarUsuario(usuario);
			}
		
		}
		
		return mv;
	}	
	
	@RequestMapping("usuarioEliminar")
	public ModelAndView usuarioEliminar(@RequestParam("codigoUsuario") String codigoUsuario) {
		usuarioServicio.eliminarUsuario(codigoUsuario);
		return new ModelAndView("usuarioLista","lista",usuarioServicio.getListaUsuarios());
	}
	
	@RequestMapping("usuarioModificar")
	public ModelAndView usuarioModificar(@RequestParam("codigoUsuario") String codigoUsuario) {
		UsuarioDTO usuario = usuarioServicio.getUsuario(codigoUsuario);
		ModelAndView mv = new ModelAndView("usuarioDatos","usuarioBean", usuario);
			mv.addObject("accion", "Modificar");
		return mv;
	}
	
	@RequestMapping("fotoMostrar")
	public String fotoMostrar(HttpServletRequest request, Model modelo) {
		modelo.addAttribute("usuario", usuarioServicio.getUsuario(request.getParameter("codigoUsuario")));		
		return "fotoUsuario";
	}
	
	@RequestMapping("fotoGrabar")
	public ModelAndView fotoGrabar(@RequestParam("archivo") CommonsMultipartFile archivo, @RequestParam("codigoUsuario") String codigoUsuario){
		UsuarioDTO usuario = usuarioServicio.getUsuario(codigoUsuario);
		usuario.setFoto(archivo.getBytes());
		return new ModelAndView("usuarioLista","lista",usuarioServicio.getListaUsuarios());		
	}
	
}
