package com.luisops.capitulo2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaludoController {
	
	//CON MODEL
	/*
	 * @RequestMapping("saludo") 
	 * public String saludar(Model modelo) {
	 * modelo.addAttribute("mensaje", "Bienvenido desde el controlador"); 
	 * return  "saludo"; 
	 * }
	 */
	//CON MODEL AND VIEW
	/*
	 * @RequestMapping("saludo") public ModelAndView saludar() { ModelAndView mv =
	 * new ModelAndView(); mv.addObject("mensaje",
	 * "Bienvenido desde el controlador MV"); mv.setViewName("saludo"); return mv; }
	 */ 
	
	//CON MODEL AND VIEW CON MENOS LINEAS
		@RequestMapping("saludo") 
		public ModelAndView saludar() {
		return new ModelAndView("saludo","mensaje", "Bienvenido desde el controlador MV en una sola linea"); 
		} 
	
}
